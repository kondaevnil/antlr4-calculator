grammar Calculator;

parse : (assignment | expression) ';' ;

expression : '(' expression ')'
           | expression '*' expression
           | expression '+' expression
           | INT
           | ID ;

assignment : ID '=' expression ;

ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
WS : [ \t\r\n] -> skip ;
