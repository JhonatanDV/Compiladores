# Práctica 1: Evaluación de Expresiones con Variables y Prioridad de Operaciones

Este proyecto implementa un evaluador de expresiones aritméticas que permite asignaciones de múltiples variables, respetando la prioridad de operadores y analizando la estructura del código mediante tokens y árboles de análisis sintáctico.

## Estructura del Proyecto

- `Calculator.g4`: Archivo de gramática ANTLR4
- `CalculatorEvaluator.java`: Clase que evalúa las expresiones
- `Calculator.java`: Clase principal para ejecutar el evaluador
- `input.txt`: Archivo de ejemplo con expresiones

## Comandos Utilizados

### Generación de código a partir de la gramática

```bash
antlr4 Calculator.g4
javac *.java
```

### Ejecución del programa

```bash
java Calculator input.txt
```

### Para obtener solo los tokens

```bash
antlr4 Calculator.g4
javac *.java
java org.antlr.v4.gui.TestRig Calculator program -tokens input.txt
```

### Para visualizar el árbol sintáctico

```bash
antlr4 Calculator.g4
javac *.java
java org.antlr.v4.gui.TestRig Calculator program -tree input.txt
```

## Resultados Obtenidos

### Tokens Generados

```
6 : a
7 : =
8 : 10
10 : ;
6 : b
7 : =
8 : 5
3 : +
6 : a
5 : *
8 : 2
10 : ;
6 : c
7 : =
1 : (
6 : b
4 : -
8 : 3
2 : )
6 : /
8 : 2
10 : ;
-1 : <EOF>
```

### Árbol de Análisis Sintáctico

```
(program 
  (statement 
    (assignment a = 
      (expr 10)) ;) 
  (statement 
    (assignment b = 
      (expr 
        (expr 5) + 
        (expr 
          (expr a) * 
          (expr 2)))) ;) 
  (statement 
    (assignment c = 
      (expr 
        (expr ( 
          (expr 
            (expr b) - 
            (expr 3)) )) / 
        (expr 2))) ;) <EOF>)
```

### Resultados de la Evaluación

```
a = 10
b = 25
c = 11
```

## Cuestionario Desarrollado

### Pregunta 1: ¿Cómo se representan los operadores `+`, `-`, `*` y `/` en los tokens generados?
* a) Como identificadores
* b) Como operadores aritméticos específicos
* c) Como palabras clave reservadas
* d) No se generan como tokens

**Respuesta correcta: b) Como operadores aritméticos específicos**

Justificación: En nuestra gramática `Calculator.g4`, definimos tokens específicos para cada operador aritmético (`ADD: '+'`, `SUB: '-'`, `MUL: '*'`, `DIV: '/'`). Cuando el lexer procesa el código fuente, identifica estos símbolos y los clasifica como tokens específicos de operadores aritméticos, con tipos distintos. En la salida de tokens, se ven representados por sus respectivos códigos de token (como 3 para `+`, 4 para `-`, 5 para `*`, 6 para `/`).

### Pregunta 2: ¿Qué estructura sigue el árbol de análisis sintáctico generado por ANTLR4 para la expresión `b = 5 + a * 2;`?
* a) `b` es el nodo raíz y las operaciones se agrupan en niveles inferiores según su prioridad.
* b) `5 + a * 2` se resuelve de izquierda a derecha sin prioridad.
* c) No hay diferencia en el orden de evaluación de los operadores.
* d) `*` se evalúa antes que `+`, organizando el árbol en función de la precedencia.

**Respuesta correcta: d) `*` se evalúa antes que `+`, organizando el árbol en función de la precedencia.**

Justificación: Al examinar el árbol de análisis sintáctico para `b = 5 + a * 2;`, podemos observar que se respeta la precedencia de operadores. La multiplicación (`*`) tiene mayor precedencia que la suma (`+`), por lo que `a * 2` forma un subárbol que luego se combina con `5`. Esto se refleja en la estructura del árbol donde `*` aparece en un nivel más profundo, indicando que debe evaluarse antes.

### Pregunta 3: ¿Por qué es importante visualizar los tokens y el árbol de análisis en el proceso de compilación?
* a) Para entender cómo el compilador traduce las instrucciones.
* b) Para optimizar el código generado.
* c) Para verificar que la gramática está bien definida.
* d) Todas las anteriores.

**Respuesta correcta: d) Todas las anteriores.**

Justificación: La visualización de tokens y árboles de análisis sintáctico proporciona múltiples beneficios: permite entender cómo el compilador interpreta y descompone las instrucciones del código fuente, ayuda a identificar patrones que podrían beneficiarse de optimizaciones, y permite confirmar que la gramática definida está procesando el código como se esperaba, sin ambigüedades o errores. Todos estos aspectos son importantes en el proceso de compilación y el desarrollo de lenguajes.

### Pregunta 4: ¿Cómo se representan los operadores en el árbol de análisis sintáctico?
**Respuesta:** Los operadores se representan como nodos intermedios en el árbol que conectan las expresiones. Por ejemplo, en `5 + a * 2`, el operador `+` conecta `5` con la subexpresión `a * 2`. Esto refleja la precedencia de operadores, donde la multiplicación (`*`) se evalúa antes que la suma (`+`).

### Pregunta 5: ¿Qué reglas de la gramática determinan la prioridad de operaciones?
**Respuesta:** La prioridad de operaciones se determina por el orden de las reglas en la gramática. En nuestra gramática, la regla para multiplicación/división (`MulDiv`) aparece antes que la regla para suma/resta (`AddSub`), lo que otorga mayor precedencia a las operaciones de multiplicación y división.

### Pregunta 6: ¿Cómo maneja la gramática las asignaciones consecutivas?
**Respuesta:** La gramática maneja las asignaciones consecutivas mediante la regla `program: statement+ EOF;`, donde el símbolo `+` indica que puede haber una o más declaraciones. Cada declaración es una asignación seguida de un punto y coma.

### Pregunta 7: ¿Qué componentes de la gramática permiten la evaluación de expresiones con paréntesis?
**Respuesta:** La evaluación de expresiones con paréntesis se logra mediante la regla `expr: LPAREN expr RPAREN # Parens`. Esta regla permite que las expresiones entre paréntesis sean evaluadas primero, respetando así la precedencia que imponen los paréntesis en las operaciones matemáticas.