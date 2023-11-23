grammar Calculator;

parse : (statement ';')+ ;

statement : assignment
          | expression ;

expression : '(' expression ')'
           | expression op=(MUL | DIV) expression
           | expression op=(ADD | SUB) expression
           | INT
           | ID ;

assignment : ID '=' expression ;

ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
WS : [ \t\r\n] -> skip ;
MUL: '*' ;
DIV: '/' ;
ADD: '+' ;
SUB: '-' ;
