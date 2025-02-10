// Analyseur lexical (lexer).

options
{
    mangleLiteralPrefix = "TK_" ;
}

class MulotLexer extends Lexer ;
options
{
    k = 2 ;
    // Les mots reserves.
    tokenVocabulary = Mulot ;
    literal = "Mulot" ;
    literal = "Tolum" ;
    literal = "Proc" ;
    literal = "Corp" ;
    literal = "Fonc" ;
    literal = "Cnof" ;
    literal = "return" ;
    literal = "Pour" ;
    literal = "Ruop" ;
    literal = "TantQue" ;
    literal = "Tnat" ;
    literal = "Si" ;
    literal = "Alors" ;
    literal = "Sinon" ;
    literal = "Is" ;
    literal = "new" ;
    literal = "int" ;
    literal = "baisse" ;
    literal = "leve" ;
    literal = "avance" ;
    literal = "tourne" ;
    literal = "a" ;
    literal = "pause" ;
    literal = "saisieEntier" ;
    literal = "WHITE" ;
    literal = "BLACK" ;
    literal = "BLUE" ;
    literal = "CYAN" ;
    literal = "DARKGRAY" ;
    literal = "GRAY" ;
    literal = "LIGHTGRAY" ;
    literal = "GREEN" ;
    literal = "MAGENTA" ;
    literal = "ORANGE" ;
    literal = "PINK" ;
    literal = "RED" ;
    literal = "YELLOW" ;
}

// Les 'blancs' a ignorer.
WS
    : (' '
    | '\t'
    | '\r'
    | '\n' { newline () ; }) { _ttype = Token.SKIP ; }
    ;

// Les commentaires.
COMMENTAIRE
    : "--" (~'\n')* '\n' { _ttype = Token.SKIP ; newline () ; }
    ;

// Parenthese ouvrante.
LPAREN
options
{
    paraphrase = "'('" ;
}
    : '('
    ;

// Parenthese fermante.
RPAREN
options
{
    paraphrase = "')'" ;
}
    : ')'
    ;

// Affectation.
ASSIGN
options
{
    paraphrase = "'='" ;
}
    : '='
    ;

// Terminateur.
SEMI
options
{
    paraphrase = "';'" ;
}
    : ';'
    ;

// Separateur (liste).
COMMA
options
{
    paraphrase = "','" ;
}
    : ','
    ;

// Point, pour les notations pointees.
POINT
options
{
    paraphrase = "'.'" ;
}
    : '.'
    ;

// Addition ou plus unaire.
PLUS
options
{
    paraphrase = "'+'" ;
}
    : '+' 
    ;

// Soustraction ou moins unaire.
MOINS
options
{
    paraphrase = "'-'" ;
}
    : '-' 
    ;

// Multiplication.
ETOILE
options
{
    paraphrase = "'*'" ;
}
    : '*' 
    ;

// Division.
DIVISION
options
{
    paraphrase = "'/'" ;
}
    : '/' 
    ;

// Modulo.
MODULO
options
{
    paraphrase = "'%'" ;
}
    : '%'
    ;

// Difference.
DIFF 
options
{
    paraphrase = "'!='" ;
}
    : '!''='
    ;

// Egalite.
EGALITE
options
{
    paraphrase = "'=='" ;
}
    : '=''='
    ;

// Superieur ou egal.
SUPEQ
options
{
    paraphrase = "'>='" ;
}
    : '>''='
    ;

// Inferieur ou egal.
INFEQ
options
{
    paraphrase = "'<='" ;
}
    : '<''='
    ;

// Superieur.
SUP
options
{
    paraphrase = "'>'" ;
}
    : '>' 
    ;

// Inferieur.
INF
options
{
    paraphrase = "'<'" ;
}
    : '<'
    ;

// ET logique.
ET
options
{
    paraphrase = "'&&'" ;
}
    : '&''&'
    ;

// OU logique.
OU
options
{
    paraphrase = "'||'" ;
}
    : '|''|'
    ;

// NON logique.
NON
options
{
    paraphrase = "'!'" ;
}
    : '!'
    ;

// Entier.
INT
options
{
    paraphrase = "an int" ;
}
    : ('0'..'9')+
    ;

// Identificateur.
ID
options
{
    testLiterals = true ;
    paraphrase = "an identifier" ;
}
    : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
    ;