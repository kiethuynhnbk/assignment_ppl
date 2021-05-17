
grammar cosim;



options {
	language=Java;
}


/** 
 * 2 Program Structure
 */
program:include_stmt+ declare+ EOF ;
//
declare:(var_declare | func_declare | assign_stmt);
//
//
include_stmt: HASH INCLUDE LT (MATH|STDIO|STDBOOL) GT;


// 2.1 Variable declaration
var_declare: (ids_list_with_type SEMI)+;

//2.2 Function declaration
func_declare: (data_types|VOID) ID LP params_list? RP compound_stmt ;

// 2.3 Procedure declaration





/** 
 * 6 Statements and Control Flow
 */
stmt
	: compound_stmt
	| if_stmt 
	| while_stmt | for_stmt
	| brk_stmt | cont_stmt | ret_stmt_func
	| assign_stmt
	| call_stmt
    |ret_void_func
	|printf_stmt
	|scanf_stmt
	;


// Assignment
// a :=  b[3] :=  c()[5] := 5
// a := (b[3] := (c()[5] := 5))
// lhs := (lhs := (lhs := exp))
assign_stmt: assign_body SEMI;

assign_body: assign_lhs ASSIGN exp ;

assign_lhs:ids_list|ids_list_with_type|CONST ids_list_with_type ;



// Flow
if_stmt: IF LP exp_bool RP compound_stmt (ELSE compound_stmt)?;

// Loop
while_stmt: WHILE exp_bool compound_stmt ;

for_stmt: FOR LP assign_body SEMI ID ( EQ | NEQ | GT | LT | GTE | LTE ) exp SEMI ID (SUB_SELF|ADD_SELF)  RP compound_stmt ;


// Stop
brk_stmt: BREAK SEMI ;

cont_stmt: CONTINUE SEMI ;

//ret_stmt: ret_stmt_func | ret_stmt_proc ;


ret_stmt_func: RETURN exp SEMI ;
ret_void_func: RETURN SEMI;

// Call
call_stmt: call_exp SEMI;

// Complex
compound_stmt: LCB stmt_list RCB ;
//input output stmt
printf_stmt:PRINTF LP (STRING_LITERAL COMMA exps_list|STRING_LITERAL) RP SEMI;
scanf_stmt:SCANF LP STRING_LITERAL COMMA ('&'ID)(COMMA'&'ID)* RP SEMI;

//
//stmt_list
stmt_list	 : stmt+;





/**
 * 7 Built-in Functions 
 */




/** 
 * 5 Expressions
 */
exp_bool: exp;

exp_int: exp;

exp_real: exp;

exp_str: exp;

// exp
// 	: operands
// 	| <assoc=right> (NOT | SUB) exp
// 	| exp ( DIV | MUL | MOD | DIV_INT | AND ) exp
// 	| exp ( ADD | SUB | OR ) exp
// 	| operands ( EQ | NEQ | GT | LT | GTE | LTE ) operands
// 	| exp ( op_and_then | op_or_else ) exp
// 	;

exp: exp ( AND | OR ) exp1 | exp1;

exp1: exp2 ( EQ | NEQ | GT | LT | GTE | LTE ) exp2 | exp2 ;

exp2: exp2 ( ADD | SUB | OR ) exp3 | exp3;

exp3: exp3 ( DIV | MUL | AND | MOD ) exp4 | exp4;

exp4: (NOT | SUB) exp4 | operands  ;


operands
	: literal
	| ID
	| call_exp
	| LP exp RP
	|call_stmt
	;

//postfix_array_exp: LSB exp RSB ;

primary_exp: literal | ID ;

call_exp: ID LP exps_list? RP;

//index_exp: operands postfix_array_exp ;

/**
 * Utilities
 */
params_list: ids_list_with_type (COMMA ids_list_with_type)*;

ids_list_with_type: data_types ids_list;

ids_list: ID (COMMA ID)* ;

exps_list: exp (COMMA exp)* ;



data_types: primitive_types | compound_types;

compound_types: primitive_types LSB INTEGER_LITERAL  RSB ;

primitive_types: INT | DOUBLE | STRING | BOOL;

//op_and_then: AND ;

//op_or_else: OR ;

literal
	: INTEGER_LITERAL
	| REAL_LITERAL
	| STRING_LITERAL
	| boolean_literal
	;

number: SUB? INTEGER_LITERAL ;
// Domain Values
boolean_literal: TRUE | FALSE ;

/** Lexers Declaration */

/**
 * Keywords
 */
INCLUDE: I N C L U D E;
//libs
STDIO: S T D I O DOT H;
MATH: M A T H DOT H;
STDBOOL: S T D B O O L DOT H;
// Value
TRUE : T R U E ;
FALSE: F A L S E ;

// Flow Statement
IF  : I F ;
ELSE: E L S E ;

// Loop Statement
FOR   : F O R ;
WHILE : W H I L E ;

// Stop Statement
RETURN  : R E T U R N ;
BREAK   : B R E A K ;
CONTINUE: C O N T I N U E ;

// Primitive Types
INT : I N T ;
STRING : S T R I N G ;
DOUBLE: D O U B L E ;
BOOL: B O O L ;
VOID: V O I D;
// Compound Types
ARRAY: A R R A Y ;
//Constant
CONST: C O N S T;


/**
 * Operators
 */
NOT:'!';
AND:'&&';
OR :'|';
ADD_SELF:'++';
SUB_SELF:'--';
//
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD:'%';


ASSIGN:'=';

EQ:'==';
LTE: '<=';
GTE: '>=';
NEQ: '!=';
LT : '<' ;
GT : '>' ;


LP: '('; // Left Parenthesis
RP: ')'; // Right Parenthesis
LCB: '{'; // Left Curly Bracket
RCB: '}'; // Right Curly Bracket
LSB: '['; // Left Square Bracket
RSB: ']'; // Right Square Bracket
HASH: '#';

SEMI: ';'; // Semicolon
COMMA: ','; // Comma
COLON: ':'; // Colon
DOT: '.';
//INPUT OUTPUT
PRINTF:P R I N T F;
SCANF:S C A N F;


STRING_LITERAL: '"' STR_CHAR* '"'
	
	;


REAL_LITERAL
	: DIGIT+ DOT (DIGIT | EXPONENT)* // 1 | 1.5 | 1.e-4
	| DIGIT* DOT DIGIT+ EXPONENT? // (1).5(e-4)
	| DIGIT+ EXPONENT // 12e-5
	;


// Integer should be after Real
// INTEGER_LITERAL : [1-9][0-9]* | '0';
INTEGER_LITERAL : DIGIT+ ;


fragment EXPONENT: [eE] SUB? DIGIT+ ;

fragment DIGIT: [0-9] ;

fragment SIGN: [+-] ;




ID:[a-z][A-Za-z0-9_]* ;



// Skip comments
Comment1:'//' .*? [\n]->skip;
Comment2:'/*' ~[*/].*? '*/'->skip;
Comment3:'/*' ~[*/].*? [\n\t\b\r]* '*/'->skip;




// Skip spaces, tabs, newlines
WS : [ \t\r\n\f]+ -> skip ; 











fragment STR_CHAR: ~[\b\t\n\f\r"'\\] | ESC_SEQ ;

fragment ESC_SEQ: '\\' [btnfr"'\\] ;

fragment ESC_ILLEGAL: '\\' ~[btnfr"'\\] | ~'\\' ;







fragment A: [a];
fragment B: [b];
fragment C: [c];
fragment D: [d];
fragment E: [e];
fragment F: [f];
fragment G: [g];
fragment H: [h];
fragment I: [i];
fragment J: [j];
fragment K: [k];
fragment L: [l];
fragment M: [m];
fragment N: [n];
fragment O: [o];
fragment P: [p];
fragment Q: [q];
fragment R: [r];
fragment S: [s];
fragment T: [t];
fragment U: [u];
fragment V: [v];
fragment W: [w];
fragment X: [x];
fragment Y: [y];
fragment Z: [z];