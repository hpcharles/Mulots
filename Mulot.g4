// -*- antlr -*-
grammar Mulot;

// program is in 2 part. One part with all the function declaration. And one part with the code that will be executed in first place and who will call the function.
program: 'Mulot' ?(functionDeclaration*) stat* 'Tolum';


functionDeclaration: 'Proc' ID '(' argumentList ')' stat* 'Corp' ;

// form of list of argument
argumentList : (argument (',' argument)*)? ;

// argument for fonction declaration
argument : types ID ;

// not really use in the interpretor but for educational purposes
types : 'int'
      | 'Mulot';

stat: pourStatement
    | assignementStatement ';'
    | functionCallStatement ';'
    | objectCallStatement ';'
    | objectCreation ';'
    ;

objectCallStatement: ID '.' actionCall '(' exprList ')';


functionCallStatement: ID '(' exprList ')' ;

// The way to create a Mulot with id the name of the Mulot variable
objectCreation: ID '=' 'new' 'Mulot' '(' exprList ')';

// expression List to pass in a function
exprList: (expr (',' expr)*)? ;


// assignement value to variable
assignementStatement: ID '=' expr;


// For loop format
pourStatement: 'Pour' assignementStatement 'a' expr stat* 'Ruop' ;

// to priorise an expression
parenthèsePriority: '(' expr ')';

// ALL available function for the Mulot object
actionCall:
	  'avance'
	| 'leve'
	| 'baisse'
	| 'tourne'
	| 'setY'
	| 'setX'
	| 'setColor'
	| 'setAngle';



lowPriorityOperator:
      '+'
    | '-'
    ;

highPriorityOperator:
      '*'
    | '/'
    ;



// expression
expr: '-' expr
    | left=expr highPriorityOperator right=expr // due to his position in the parse rule high priority will be chosen rather than the low priority operation
    | left=expr lowPriorityOperator right=expr
    | parenthèsePriority
    | INT
    | ID
    ;




// To comment not only in line but with block like :
/*
-*
 * commentary
 *-
*/
BlockComment
    : '-*' .*? '*-' -> skip
    ;


INT: [0-9]+                      ; // number
ID: [a-zA-Z_][a-zA-Z0-9_]*      ; //variable or function name
WS: [ \t\n\r\f]+ -> skip         ; // skip all whitespace
COMMENT: '--' ~[\r\n]* -> skip   ; // line commentary
