# Práctica 2: Implementación de Estructura de Control `while` y Análisis de Tokens

## Comandos Utilizados

### Generación de los parser y lexer
```bash
antlr4 MiLenguaje.g4
javac MiLenguaje*.java
```

### Análisis de tokens
```bash
grun MiLenguaje program -tokens ejemplo.txt
```

### Generación del árbol sintáctico
```bash
grun MiLenguaje program -tree ejemplo.txt
```

### Comandos Git
```bash
git add .
git commit -m "Práctica 2 finalizada"
git push -u origin main
```

## Resultados Obtenidos

### Tokens para la estructura `while`
Al ejecutar el comando para generar tokens, se obtuvieron los siguientes resultados para la estructura while:

```
[@0,8:12='while',<'while'>,1:0]
[@1,14:14='(',<'('>,1:6]
[@2,15:15='x',<ID>,1:7]
[@3,17:17='<',<'<'>,1:9]
[@4,19:19='5',<INT>,1:11]
[@5,20:20=')',<')'>,1:12]
[@6,22:22='{',<'{'>,1:14]
[@7,28:28='x',<ID>,2:4]
[@8,30:30='=',<'='>,2:6]
[@9,32:32='x',<ID>,2:8]
[@10,34:34='+',<'+'>,2:10]
[@11,36:36='1',<INT>,2:12]
[@12,37:37=';',<';'>,2:13]
[@13,39:39='}',<'}'>,3:0]
```

### Árbol de análisis sintáctico
Al ejecutar el comando para generar el árbol, se obtuvo la siguiente estructura:

```
(program
  (statement
    (assignmentStmt x = (expression (term (factor 0)))) ;)
  (statement
    (whileStmt while (
      (condition (expression (term (factor x))) < (expression (term (factor 5)))) )
      (block {
        (statement
          (assignmentStmt x = (expression (term (factor x)) + (term (factor 1)))) ;)
      })))
)
```

## Cuestionario

1. ¿Qué tokens se generan para la estructura `while (x < 5) { x = x + 1; }`?

   **Respuesta: a) `WHILE`, `(`, `ID`, `<`, `INT`, `)`, `{`, `ID`, `=`, `ID`, `+`, `INT`, `}`**

   Justificación: Según el análisis de tokens realizado, cada componente de la estructura while se identifica correctamente como un token individual. La palabra reservada "while" se reconoce como un token específico, los paréntesis generan sus propios tokens, la variable x se reconoce como ID, el número 5 como INT, y los operadores (<, =, +) también generan tokens individuales.

2. ¿Cómo se organiza la estructura `while` en el árbol de análisis sintáctico?

   **Respuesta: c) `while` es el nodo raíz y su condición y cuerpo son nodos secundarios.**

   Justificación: En el árbol generado, podemos observar que la estructura while se representa como un nodo "whileStmt" que contiene la palabra clave "while", seguido de nodos secundarios que representan la condición (entre paréntesis) y el bloque de código (entre llaves). La condición y el cuerpo del bucle son claramente nodos hijos del nodo principal "while".

3. ¿Qué ocurre si en la gramática se omiten las llaves `{}` en la estructura `while`?

   **Respuesta: b) Se genera un error de sintaxis.**

   Justificación: En la gramática definida, hemos especificado que un "whileStmt" debe contener un "block", y un "block" está definido explícitamente con llaves (`{` `}`). Si se omiten las llaves, el parser no podrá reconocer correctamente la estructura del bloque según nuestra gramática actual, generando un error de sintaxis. Para permitir estructuras sin llaves, tendríamos que modificar la gramática específicamente.