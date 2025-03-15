grammar Calculator;

program: statement+ EOF;

statement: assignment SEMICOLON;

assignment: ID ASSIGN expr;

expr: expr (MUL | DIV) expr    # MulDiv
    | expr (ADD | SUB) expr    # AddSub
    | LPAREN expr RPAREN       # Parens
    | ID                       # Variable
    | NUMBER                   # Literal
    ;

// Tokens
ID: [a-zA-Z]+;
NUMBER: [0-9]+;
ASSIGN: '=';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';
SEMICOLON: ';';
WS: [ \t\r\n]+ -> skip;