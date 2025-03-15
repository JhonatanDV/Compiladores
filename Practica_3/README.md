Práctica 3: Implementación de una Estructura for y Análisis de Tokens y Árbol Sintáctico
Descripción
Esta práctica extiende la gramática ANTLR4 para incluir estructuras de control for, permitiendo la ejecución repetitiva de sentencias basadas en un rango de valores. Se analiza la estructura mediante tokens y árboles de análisis sintáctico.
Archivos

MiLenguaje.g4: Gramática ANTLR4 con soporte para estructura for
ejemplo.txt: Archivo de ejemplo con código que utiliza la estructura for

Comandos Utilizados
Generación del parser y lexer
bashCopyantlr4 MiLenguaje.g4
javac MiLenguaje*.java
Análisis de tokens
bashCopyjava org.antlr.v4.gui.TestRig MiLenguaje program -tokens ejemplo.txt
Generación del árbol sintáctico
bashCopyjava org.antlr.v4.gui.TestRig MiLenguaje program -tree ejemplo.txt
Comandos Git
bashCopygit add .
git commit -m "Práctica 3 finalizada"
git push -u origin main
Resultados Obtenidos
Tokens para la estructura for
Al ejecutar el comando para generar tokens, se obtuvieron los siguientes resultados para la estructura for:
Copy[@0,0:2='for',<'for'>,1:0]
[@1,4:4='(',<'('>,1:4]
[@2,5:5='i',<ID>,1:5]
[@3,7:7='=',<'='>,1:7]
[@4,9:9='0',<INT>,1:9]
[@5,10:10=';',<';'>,1:10]
[@6,12:12='i',<ID>,1:12]
[@7,14:14='<',<'<'>,1:14]
[@8,16:17='10',<INT>,1:16]
[@9,18:18=';',<';'>,1:18]
[@10,20:20='i',<ID>,1:20]
[@11,22:22='=',<'='>,1:22]
[@12,24:24='i',<ID>,1:24]
[@13,26:26='+',<'+'>,1:26]
[@14,28:28='1',<INT>,1:28]
[@15,29:29=')',<')'>,1:29]
[@16,31:31='{',<'{'>,1:31]
[@17,37:37='x',<ID>,2:4]
[@18,39:39='=',<'='>,2:6]
[@19,41:41='x',<ID>,2:8]
[@20,43:43='+',<'+'>,2:10]
[@21,45:45='i',<ID>,2:12]
[@22,46:46=';',<';'>,2:13]
[@23,48:48='}',<'}'>,3:0]
Se puede observar que cada componente se identifica correctamente como un token individual. La palabra reservada "for" se reconoce como un token específico, los paréntesis generan sus propios tokens, las variables como "i" y "x" se reconocen como ID, los números como INT, y los operadores (<, =, +) y los delimitadores (;, {, }) también generan tokens individuales.
Árbol de análisis sintáctico
Al ejecutar el comando para generar el árbol, se obtuvo la siguiente estructura:
Copy(program
  (sentencia
    (forStmt for (
      (inicializacion i = (expresion (termino (factor 0)))) ;
      (condicion i < 10) ;
      (actualizacion i = (expresion (termino (factor i)) + (termino (factor 1)))) )
      {
        (sentencia
          (asignacion x = (expresion (termino (factor x)) + (termino (factor i))) ;))
      })))
El árbol muestra claramente cómo se organiza la estructura for. El nodo principal es forStmt, que contiene tres componentes principales en el encabezado (inicialización, condición y actualización) y un bloque de código. La inicialización muestra la asignación inicial i = 0, seguida de la condición i < 10 y la actualización i = i + 1. Dentro del bloque, se encuentra la sentencia x = x + i;.
Cuestionario

¿Qué tokens se generan para la estructura for (i = 0; i < 10; i = i + 1) { x = x + i; }?
Respuesta: a) FOR, (, ID, =, INT, ;, ID, <, INT, ;, ID, =, ID, +, INT, ), {, ID, =, ID, +, ID, }
Justificación: Según el análisis de tokens realizado, cada componente de la estructura for se identifica correctamente como un token individual. La palabra reservada "for" se reconoce como un token específico (aunque en la salida real aparece como 'for'), los paréntesis generan sus propios tokens, las variables se reconocen como ID, los números como INT, y todos los operadores y delimitadores también generan tokens individuales.
¿Cómo se organiza la estructura for en el árbol de análisis sintáctico?
Respuesta: a) for es el nodo raíz y sus componentes (inicialización, condición, actualización y cuerpo) son nodos secundarios.
Justificación: En el árbol generado, podemos observar que la estructura for se representa como un nodo "forStmt" (o simplemente "for" en algunas representaciones) que contiene como nodos hijos la inicialización, la condición, la actualización y el bloque de código que constituye el cuerpo del bucle.
¿Qué ocurre si en la gramática se omiten los ; en la estructura for?
Respuesta: a) Se genera un error de sintaxis.
Justificación: En la gramática definida, hemos especificado que un "forStmt" debe contener la estructura for (inicializacion ; condicion ; actualizacion) { ... } con los punto y coma como separadores obligatorios. Si se omiten los punto y coma, el parser no podrá reconocer correctamente la estructura según nuestra gramática, generando un error de sintaxis.
