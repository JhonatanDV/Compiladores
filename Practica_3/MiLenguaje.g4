grammar MiLenguaje;

// Regla principal del programa
program : sentencia+ EOF ;

// Tipos de sentencias
sentencia
    : asignacion
    | forStmt
    ;

// Asignaciones con `;`
asignacion
    : ID '=' expresion ';' 
    ;

// Regla para `for`
forStmt
    : 'for' '(' inicializacion ';' condicion ';' actualizacion ')' '{' (sentencia)* '}' # ForLoop
    ;

// Inicialización del `for` (Ej: i = 0)
inicializacion
    : ID '=' expresion 
    ;

// Condiciones dentro del `for` (Ej: i < 10)
condicion
    : ID op=('>' | '<' | '==' | '!=') INT  
    ;

// Actualización del `for` (Ej: i = i + 1)
actualizacion
    : ID '=' expresion 
    ;

// Expresiones 
expresion
    : termino (('+' | '-') termino)*
    ;

termino
    : factor (('*' | '/') factor)*
    ;

factor
    : INT
    | ID
    | '(' expresion ')'
    ;

// Tokens
ID : [a-zA-Z][a-zA-Z0-9]* ;  // Identificadores
INT : [0-9]+ ;               // Enteros
WS : [ \t\r\n]+ -> skip ;    // Espacios en blanco (ignorados)