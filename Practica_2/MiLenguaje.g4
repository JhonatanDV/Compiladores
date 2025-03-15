grammar MiLenguaje;

// Regla principal del programa
program : statement+ EOF ;

// Definición de sentencias
statement 
    : assignmentStmt ';'    // Asignación
    | whileStmt             // Estructura while
    ;

// Asignación
assignmentStmt : ID '=' expression ;

// Estructura while
whileStmt : 'while' '(' condition ')' block ;

// Bloque de código
block : '{' statement* '}' ;

// Condición
condition : expression relationalOp expression ;

// Operadores relacionales
relationalOp : '<' | '>' | '<=' | '>=' | '==' | '!=' ;

// Expresiones
expression
    : term (('+' | '-') term)*
    ;

term
    : factor (('*' | '/') factor)*
    ;

factor
    : INT
    | ID
    | '(' expression ')'
    ;

// Tokens
ID : [a-zA-Z]+ ;              // Identificadores
INT : [0-9]+ ;                // Enteros
WS : [ \t\r\n]+ -> skip ;     // Espacios en blanco
