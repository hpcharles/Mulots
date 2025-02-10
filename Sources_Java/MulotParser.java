/*
 * ANTLR-generated file resulting from grammar MulotParser.g
 * 
 * Terence Parr, MageLang Institute
 * with John Lilley, Empathy Software
 * ANTLR Version 2.2.3; 1996,1997
 */
import antlr.Tokenizer;
import antlr.TokenBuffer;
import antlr.LLkParser;
import antlr.Token;
import antlr.ParserException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;

    import java.lang.String ;
    import java.util.Enumeration ;
    import java.util.Hashtable ;
    import java.util.Vector ;

public class MulotParser extends antlr.LLkParser implements MulotParserTokenTypes {

    // Constantes couleurs.
    public final static int WHITE     = 0 ;
    public final static int BLACK     = 1 ;
    public final static int BLUE      = 2 ;
    public final static int CYAN      = 3 ;
    public final static int DARKGRAY  = 4 ;
    public final static int GRAY      = 5 ;
    public final static int LIGHTGRAY = 6 ;
    public final static int GREEN     = 7 ;
    public final static int MAGENTA   = 8 ;
    public final static int ORANGE    = 9 ;
    public final static int PINK      = 10 ;
    public final static int RED       = 11 ;
    public final static int YELLOW    = 12 ;

    // Constantes types.
    public final static int ENTIER  = 0 ;
    public final static int MULOT   = 1 ;
    public final static int VIDE    = 2 ;
    public final static int BOOLEEN = 3 ;

    // Constantes status de symboles.
    public final static int VARIABLE  = 0 ;
    public final static int PARAMETRE = 1 ;

    // Constantes de saut de boucle.
    public final static int SORTIEPOUR = 5 ;
    public final static int CONDITIONPOUR = 7 ;
    public final static int INCREMENTPOUR = 1 ;

    // Constantes de saut de tantque.
    public final static int SORTIETANTQUE    = 1 ;
    public final static int CONDITIONTANTQUE = 3 ;

    // Constantes instruction atomiques.
    public final static int ADD  = 0 ;
    public final static int SUB  = 1 ;
    public final static int MUL  = 2 ;
    public final static int DIV  = 3 ;
    public final static int MOD  = 4 ;
    public final static int LEVE = 5 ;
    public final static int BAIS = 6 ;
    public final static int TOUR = 7 ;
    public final static int AVAN = 8 ;
    public final static int CALL = 9 ;
    public final static int RET  = 21 ;
    public final static int NEWM = 10 ;
    public final static int PUSO = 11 ;
    public final static int PUSI = 12 ;
    public final static int POP  = 13 ;
    public final static int EQ   = 14 ;
    public final static int NQ   = 15 ;
    public final static int LT   = 16 ;
    public final static int GT   = 17 ;
    public final static int LE   = 18 ;
    public final static int GE   = 19 ;
    public final static int JMP  = 20 ;
    public final static int JBP  = 22 ;
    public final static int AND  = 23 ;
    public final static int OR   = 24 ;
    public final static int NOT  = 25 ;
    public final static int STOP = 26 ;
    public final static int GETI = 27 ;

    // Messages d'erreur.
//    public final static String SPRG_DEFINED = 
//        "Procedure or function already defined" ;
//    public final static String FCT_NORETURN = 
//        "Function without 'retourne'" ;
//    public final static String RET_BADTYPE = 
//        "Bad type returned by function" ;
//    public final static String ASSIGN_BADTYPE = 
//        "Types not match in assignation" ;
//    public final static String SYMBOLE_NOTEXIST = 
//        "Identifier not exist" ;
//    public final static String SYMBOLE_BADTYPE = 
//        "Bad type for identifier" ;
//    public final static String PARAMETRE_BADTYPE = 
//        "Bad type for parameter" ;
//    public final static String SYMBOLE_DEFINED = 
//        "Identifier already defined" ;
//    public final static String ASSIGN_PARAMETRE = 
//        "Parameter assignation" ;
//    public final static String SPRG_NOTEXIST = 
//        "Procedure ou function not exist" ;
//    public final static String CONDITION_BADTYPE = 
//        "Bad type for condition" ;
//    public final static String OPERATION_BADTYPE = 
//        "Bad type for operation" ;
//    public final static String PARAMETRE_BADNUMBER = 
//        "Bad number of parameters" ;
//    public final static String SYMBOLE_MAYNOTEXIST = 
//        "Identifier may not have been initialised" ;
    public final static String SPRG_DEFINED = 
        "Procedure ou fonction deja definie" ;
    public final static String FCT_NORETURN = 
        "Fonction sans 'retourne'" ;
    public final static String RET_BADTYPE = 
        "Type de retour incorrect" ;
    public final static String ASSIGN_BADTYPE = 
        "Types incorrect dans une affectation" ;
    public final static String SYMBOLE_NOTEXIST = 
        "Identifiant inconnu" ;
    public final static String SYMBOLE_BADTYPE = 
        "identifiant de type incorrect" ;
    public final static String PARAMETRE_BADTYPE = 
        "parametre de type incorrect" ;
    public final static String SYMBOLE_DEFINED = 
        "Identifiant deja defini" ;
    public final static String ASSIGN_PARAMETRE = 
        "Affectation d'un parametre" ;
    public final static String SPRG_NOTEXIST = 
        "Procedure ou fonction inconnue" ;
    public final static String CONDITION_BADTYPE = 
        "Type incorrect pour une expression booleenne" ;
    public final static String OPERATION_BADTYPE = 
        "Type incorrect pour une expression arithmetique" ;
    public final static String PARAMETRE_BADNUMBER = 
        "Nombre de parametres incorrect" ;
    public final static String SYMBOLE_MAYNOTEXIST = 
        "Identifiant pouvant ne pas etre initialise" ;

protected MulotParser(TokenBuffer tokenBuf, int k) {
	super(tokenBuf,k);
	tokenNames = _tokenNames;
}

public MulotParser(TokenBuffer tokenBuf) {
	this(tokenBuf,3);
}

protected MulotParser(Tokenizer lexer, int k) {
	super(lexer,k);
	tokenNames = _tokenNames;
}

public MulotParser(Tokenizer lexer) {
	this(lexer,3);
}

	public final Programme  program() throws ParserException {
		Programme prg;
		
		Hashtable h ;
		h = new Hashtable () ;
		prg = new Programme () ;
		
		try {      // for error handling
			match(TK_Mulot);
			{
			_loop3:
			do {
				if ((LA(1)==TK_Proc||LA(1)==TK_Fonc)) {
					sousProgramme(prg.getRI (), prg.getVisible ());
				}
				else {
					break _loop3;
				}
				
			} while (true);
			}
			corps(false, prg.getRI (), prg.getVisible (), h);
			match(TK_Tolum);
			match(Token.EOF_TYPE);
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_0);
		}
		return prg;
	}

	public final void sousProgramme(
		Code c, EnvironnementP e
	) throws ParserException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_Proc:
			{
				procedure(c, e);
				break;
			}
			case TK_Fonc:
			{
				fonction(c, e);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
	}

	public final boolean  corps(
		boolean enableReturn, Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		boolean ret;
		
		boolean r, r2 ;
		ret = r = false ;
		
		try {      // for error handling
			{
			int _cnt13=0;
			_loop13:
			do {
				if ((_tokenSet_2.member(LA(1)))) {
					r2=instruction(enableReturn, c, e, h);
					r = r || r2 ;
				}
				else {
					if ( _cnt13>=1 ) { break _loop13; } else {throw new NoViableAltException(LT(1));}
				}
				
				_cnt13++;
			} while (true);
			}
			ret = r ;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_3);
		}
		return ret;
	}

	public final void procedure(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		Code cs ;
		EnvironnementP es ;
		Hashtable h ;
		h = new Hashtable () ;
		
		try {      // for error handling
			match(TK_Proc);
			i = LT(1);
			match(ID);
			if (e.definedSPrg (i.getText ()))
			System.err.println (
			SPRG_DEFINED +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			cs = new Code (i.getText (), c) ;
			c.addSPrg (cs) ;
			es = new EnvironnementP (i.getText (), VIDE, e) ;
			e.addSPrg (es) ;
			match(LPAREN);
			listeDeclaration(cs, es);
			match(RPAREN);
			{
			_loop7:
			do {
				if ((LA(1)==TK_Proc||LA(1)==TK_Fonc)) {
					sousProgramme(cs, es);
				}
				else {
					break _loop7;
				}
				
			} while (true);
			}
			corps(false, cs, es, h);
			match(TK_Corp);
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
	}

	public final void fonction(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		Code cs ;
		EnvironnementP es ;
		int t ;
		Hashtable h ;
		boolean ret ;
		h = new Hashtable () ;
		
		try {      // for error handling
			match(TK_Fonc);
			i = LT(1);
			match(ID);
			if (e.definedSPrg (i.getText ()))
			System.err.println (
			SPRG_DEFINED +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			cs = new Code (i.getText (), c) ;
			c.addSPrg (cs) ;
			es = new EnvironnementP (i.getText (), VIDE, e) ;
			e.addSPrg (es) ;
			match(LPAREN);
			listeDeclaration(cs, es);
			match(RPAREN);
			match(ASSIGN);
			t=type();
			es.setTypeRetour (t) ;
			{
			_loop10:
			do {
				if ((LA(1)==TK_Proc||LA(1)==TK_Fonc)) {
					sousProgramme(cs, es);
				}
				else {
					break _loop10;
				}
				
			} while (true);
			}
			ret=corps(true, cs, es, h);
			match(TK_Cnof);
			if (! ret)
			System.err.println (
			FCT_NORETURN +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
	}

	public final void listeDeclaration(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		Token  i2 = null;
		Vector instructions ;
		Instruction instruction ;
		Symbole symbole ;
		int t, t2, j ;
		instructions = new Vector () ;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_Mulot:
			case TK_int:
			{
				t=type();
				i = LT(1);
				match(ID);
				if (e.definedSymbole (i.getText ()))
				System.err.println (
				SYMBOLE_DEFINED +
				" : " +
				i.getText () +
				" (" +
				i.getLine () + 
				")") ;
				else
				{
				instruction = new Instruction (POP, i.getText ()) ;
				instructions.addElement (instruction) ;
				symbole = new Symbole (i.getText (), t, PARAMETRE) ;
				e.addSymbole (symbole) ;
				e.addParametre (t) ;
				}
				{
				_loop25:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						t2=type();
						i2 = LT(1);
						match(ID);
						if (e.definedSymbole (i2.getText ()))
						System.err.println (
						SYMBOLE_DEFINED +
						" : " +
						i2.getText () +
						" (" +
						i2.getLine () + 
						")") ;
						else
						{
						instruction = new Instruction (POP, i2.getText ()) ;
						instructions.addElement (instruction) ;
						symbole = new Symbole (i2.getText (), t2, PARAMETRE) ;
						e.addSymbole (symbole) ;
						e.addParametre (t2) ;
						}
					}
					else {
						break _loop25;
					}
					
				} while (true);
				}
				for (j = (instructions.size () - 1) ; j >= 0 ; j --)
				c.addInstruction ((Instruction) instructions.elementAt (j)) ;
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_4);
		}
	}

	public final int  type() throws ParserException {
		int t;
		
		t = VIDE ;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_Mulot:
			{
				match(TK_Mulot);
				t = MULOT ;
				break;
			}
			case TK_int:
			{
				match(TK_int);
				t = ENTIER ;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_1);
		}
		return t;
	}

	public final boolean  instruction(
		boolean enableReturn, Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		boolean ret;
		
		Instruction instruction ;
		int t ;
		ret = false ;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_pause:
			{
				match(TK_pause);
				match(LPAREN);
				match(RPAREN);
				match(SEMI);
				instruction = new Instruction (STOP) ;
				c.addInstruction (instruction) ;
				break;
			}
			case TK_Pour:
			{
				boucle(enableReturn, c, e, h);
				break;
			}
			case TK_TantQue:
			{
				tantque(enableReturn, c, e, h);
				break;
			}
			case TK_Si:
			{
				conditionnelle(enableReturn, c, e, h);
				break;
			}
			default:
				if ((LA(1)==ID) && (LA(2)==ASSIGN)) {
					assignation(c, e, h);
					match(SEMI);
				}
				else if ((LA(1)==ID) && (LA(2)==LPAREN||LA(2)==POINT)) {
					action(c, e);
				}
				else if (((LA(1)==TK_return))&&(enableReturn)) {
					match(TK_return);
					expression(c, e);
					match(SEMI);
					ret = true ;
					t = c.getTypeLastInstruction (e) ;
					if (t != e.getTypeRetour ())
					System.err.println (
					RET_BADTYPE +
					" : " +
					(ENTIER == t ? 
					"entier" : 
					(MULOT == t ? "Mulot" : "---")) +
					" au lieu de " + 
					(ENTIER == e.getTypeRetour () ? "entier" : "Mulot")) ;
					else
					{
					instruction = new Instruction (RET) ;
					c.addInstruction (instruction) ;
					}
				}
			else {
				throw new NoViableAltException(LT(1));
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
		return ret;
	}

	public final void assignation(
		Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		
		Token  i = null;
		int t ;
		Symbole s ;
		Instruction instruction ;
		
		try {      // for error handling
			i = LT(1);
			match(ID);
			match(ASSIGN);
			expression(c, e);
			t = c.getTypeLastInstruction (e) ;
			if ((BOOLEEN == t) || (VIDE == t))
			System.err.println (
			ASSIGN_BADTYPE +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			{
			if (e.definedSymbole (i.getText ()))
			{
			s = e.getSymbole (i.getText ()) ;
			if (PARAMETRE == s.getStatut ())
			System.err.println (
			ASSIGN_PARAMETRE +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			if (s.getType () != t) 
			System.err.println (
			ASSIGN_BADTYPE +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			{
			instruction = new Instruction (POP, i.getText ()) ;
			c.addInstruction (instruction) ;
			}
			}
			else
			{
			s = new Symbole (i.getText (), t, VARIABLE) ;
			e.addSymbole (s) ;
			instruction = new Instruction (POP, i.getText ()) ;
			c.addInstruction (instruction) ;
			}
			h.put (s.getNom (), s) ;
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_6);
		}
	}

	public final void action(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		Token  i1 = null;
		Token  i2 = null;
		Token  i3 = null;
		Symbole s ;
		Instruction instruction ;
		
		try {      // for error handling
			if ((LA(1)==ID) && (LA(2)==POINT) && (LA(3)==TK_baisse)) {
				i = LT(1);
				match(ID);
				match(POINT);
				match(TK_baisse);
				match(LPAREN);
				match(RPAREN);
				match(SEMI);
				if (!e.existSymbole (i.getText ()))
				System.err.println (
				SYMBOLE_NOTEXIST +
				" : " +
				i.getText () +
				" (" +
				i.getLine () + 
				")") ;
				else
				{
				s = e.getSymbole (i.getText ()) ;
				if (s.getType () != MULOT)
				System.err.println (
				SYMBOLE_BADTYPE +
				" : " +
				i.getText () +
				" (" +
				i.getLine () + 
				")") ;
				else
				{
				instruction = new Instruction (BAIS, i.getText ()) ;
				c.addInstruction (instruction) ;
				}
				}
			}
			else if ((LA(1)==ID) && (LA(2)==POINT) && (LA(3)==TK_leve)) {
				i1 = LT(1);
				match(ID);
				match(POINT);
				match(TK_leve);
				match(LPAREN);
				match(RPAREN);
				match(SEMI);
				if (!e.existSymbole (i1.getText ()))
				System.err.println (
				SYMBOLE_NOTEXIST +
				" : " +
				i1.getText () +
				" (" +
				i1.getLine () + 
				")") ;
				else
				{
				s = e.getSymbole (i1.getText ()) ;
				if (s.getType () != MULOT)
				System.err.println (
				SYMBOLE_BADTYPE +
				" : " +
				i1.getText () +
				" (" +
				i1.getLine () + 
				")") ;
				else
				{
				instruction = new Instruction (LEVE, i1.getText ()) ;
				c.addInstruction (instruction) ;
				}
				}
			}
			else if ((LA(1)==ID) && (LA(2)==POINT) && (LA(3)==TK_avance)) {
				i2 = LT(1);
				match(ID);
				match(POINT);
				match(TK_avance);
				match(LPAREN);
				expression(c, e);
				if (ENTIER != c.getTypeLastInstruction (e))
				System.err.println (
				PARAMETRE_BADTYPE +
				" : entier attendu" +
				" (" +
				i2.getLine () + 
				")") ;
				match(RPAREN);
				match(SEMI);
				if (!e.existSymbole (i2.getText ()))
				System.err.println (
				SYMBOLE_NOTEXIST +
				" : " +
				i2.getText () +
				" (" +
				i2.getLine () + 
				")") ;
				else
				{
				s = e.getSymbole (i2.getText ()) ;
				if (s.getType () != MULOT)
				System.err.println (
				SYMBOLE_BADTYPE +
				" : " +
				i2.getText () +
				" (" +
				i2.getLine () + 
				")") ;
				else
				{
				instruction = new Instruction (AVAN, i2.getText ()) ;
				c.addInstruction (instruction) ;
				}
				}
			}
			else if ((LA(1)==ID) && (LA(2)==POINT) && (LA(3)==TK_tourne)) {
				i3 = LT(1);
				match(ID);
				match(POINT);
				match(TK_tourne);
				match(LPAREN);
				expression(c, e);
				if (ENTIER != c.getTypeLastInstruction (e))
				System.err.println (
				PARAMETRE_BADTYPE +
				" : entier attendu" +
				" (" +
				i3.getLine () + 
				")") ;
				match(RPAREN);
				match(SEMI);
				if (!e.existSymbole (i3.getText ()))
				System.err.println (
				SYMBOLE_NOTEXIST +
				" : " +
				i3.getText () +
				" (" +
				i3.getLine () + 
				")") ;
				else
				{
				s = e.getSymbole (i3.getText ()) ;
				if (s.getType () != MULOT)
				System.err.println (
				SYMBOLE_BADTYPE +
				" : " +
				i3.getText () +
				" (" +
				i3.getLine () + 
				")") ;
				else
				{
				instruction = new Instruction (TOUR, i3.getText ()) ;
				c.addInstruction (instruction) ;
				}
				}
			}
			else if ((LA(1)==ID) && (LA(2)==LPAREN)) {
				appelSousProgramme(c, e);
				match(SEMI);
			}
			else {
				throw new NoViableAltException(LT(1));
			}
			
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
	}

	public final void boucle(
		boolean enableReturn, Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		
		Token  i = null;
		Instruction instruction ;
		Code cb ;
		EnvironnementP eb ;
		int t, nbInstruction ;
		Symbole s, s2 ; 
		Hashtable h1 ;
		Enumeration enum ;
		h1 = new Hashtable () ;
		
		try {      // for error handling
			match(TK_Pour);
			i = LT(1);
			match(ID);
			match(ASSIGN);
			expression(c, e);
			t = c.getTypeLastInstruction (e) ;
			if (ENTIER != t)
			System.err.println (
			SYMBOLE_BADTYPE +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			{
			if (e.definedSymbole (i.getText ()))
			{
			s = e.getSymbole (i.getText ()) ;
			if (PARAMETRE == s.getStatut ())
			System.err.println (
			ASSIGN_PARAMETRE +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			if (s.getType () != t) 
			System.err.println (
			ASSIGN_BADTYPE +
			" : " +
			(ENTIER == s.getType () ? "entier" : "Mulot") +
			" expected" +
			" (" +
			i.getLine () + 
			")") ;
			else
			{
			instruction = new Instruction (POP, i.getText ()) ;
			c.addInstruction (instruction) ;
			}
			}
			else
			{
			s = new Symbole (i.getText (), t, VARIABLE) ;
			e.addSymbole (s) ;
			instruction = new Instruction (POP, i.getText ()) ;
			c.addInstruction (instruction) ;
			}
			h.put (s.getNom (), s) ;
			}
			match(TK_a);
			nbInstruction = c.getNombreInstructions () ;
			instruction = new Instruction (PUSO, i.getText ()) ;
			c.addInstruction (instruction) ;
			expression(c, e);
			nbInstruction = c.getNombreInstructions () - nbInstruction ;
			t = c.getTypeLastInstruction (e) ;
			if (ENTIER != t)
			System.err.println (
			ASSIGN_BADTYPE +
			" : entier attendu" +
			" (" +
			i.getLine () + 
			")") ;
			cb = new Code (null, null) ;
			eb = new EnvironnementP (null, VIDE, e) ;
			corps(enableReturn, cb, eb, h1);
			match(TK_Ruop);
			enum = h1.elements () ;
			while (enum.hasMoreElements ())
			{
			s = (Symbole) enum.nextElement () ;
			s2 = (Symbole) h.get (s.getNom ()) ;
			if (null == s2)
			s.setFlou () ;
			h.put (s.getNom (), s) ;
			}
			instruction = new Instruction (GT) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (
			JBP, 
			cb.getNombreInstructions () + SORTIEPOUR) ; 
			c.addInstruction (instruction) ;
			c.addInstructions (cb.getInstructions ()) ;
			instruction = new Instruction (PUSO, i.getText ()) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (PUSI, INCREMENTPOUR) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (ADD) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (POP, i.getText ()) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (
			JMP, 
			-(nbInstruction + cb.getNombreInstructions () + CONDITIONPOUR)) ;
			c.addInstruction (instruction) ;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
	}

	public final void tantque(
		boolean enableReturn, Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		
		Instruction instruction ;
		Code ct ;
		EnvironnementP et ;
		int t, nbInstruction ;
		Symbole s, s2 ; 
		Hashtable h1 ;
		Enumeration enum ;
		h1 = new Hashtable () ;
		
		try {      // for error handling
			match(TK_TantQue);
			match(LPAREN);
			nbInstruction = c.getNombreInstructions () ;
			expression(c, e);
			t = c.getTypeLastInstruction (e) ;
			if (BOOLEEN != t)
			System.err.println (
			CONDITION_BADTYPE +
			" : booleen attendu") ;
			nbInstruction = c.getNombreInstructions () - nbInstruction ;
			ct = new Code (null, null) ;
			et = new EnvironnementP (null, VIDE, e) ;
			match(RPAREN);
			corps(enableReturn, ct, et, h1);
			match(TK_Tnat);
			enum = h1.elements () ;
			while (enum.hasMoreElements ())
			{
			s = (Symbole) enum.nextElement () ;
			s2 = (Symbole) h.get (s.getNom ()) ;
			if (null == s2)
			s.setFlou () ;
			h.put (s.getNom (), s) ;
			}
			instruction = new Instruction (NOT) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (
			JBP, 
			ct.getNombreInstructions () + SORTIETANTQUE) ;
			c.addInstruction (instruction) ;
			c.addInstructions (ct.getInstructions ()) ;
			instruction = new Instruction (
			JMP, 
			-(
			nbInstruction + 
			ct.getNombreInstructions () + 
			CONDITIONTANTQUE)) ;
			c.addInstruction (instruction) ;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
	}

	public final void conditionnelle(
		boolean enableReturn, Code c, EnvironnementP e, Hashtable h
	) throws ParserException {
		
		Code cc, cc1 ;
		Instruction instruction = null ;
		boolean sinon ;
		int saut ;
		Hashtable h1 ;
		Hashtable h2 ;
		Enumeration enum ;
		Symbole s, s2, s3 ;
		sinon = false ;
		cc = new Code (null, null) ;
		cc1 = new Code (null, null) ;
		h1 = new Hashtable () ;
		h2 = new Hashtable () ;
		
		try {      // for error handling
			match(TK_Si);
			match(LPAREN);
			expression(c, e);
			if (BOOLEEN != c.getTypeLastInstruction (e))
			System.err.println (
			CONDITION_BADTYPE +
			" : booleen attendu") ;
			match(RPAREN);
			match(TK_Alors);
			corps(enableReturn, cc, e, h1);
			{
			switch ( LA(1)) {
			case TK_Sinon:
			{
				match(TK_Sinon);
				corps(enableReturn, cc1, e, h2);
				sinon = true ;
				break;
			}
			case TK_Is:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
			match(TK_Is);
			if (sinon)
			{
			enum = h1.elements () ;
			while (enum.hasMoreElements ())
			{
			s = (Symbole) enum.nextElement () ;
			s2 = (Symbole) h2.get (s.getNom ()) ;
			s3 = (Symbole) h.get (s.getNom ()) ;
			if ((null == s2) && (null == s3))
			s.setFlou () ;
			h.put (s.getNom (), s) ;
			}
			enum = h2.elements () ;
			while (enum.hasMoreElements ())
			{
			s = (Symbole) enum.nextElement () ;
			s2 = (Symbole) h1.get (s.getNom ()) ;
			s3 = (Symbole) h.get (s.getNom ()) ;
			if ((null == s2) && (null == s3))
			{
			s.setFlou () ;
			h.put (s.getNom (), s) ;
			}
			}
			}
			else
			{
			enum = h1.elements () ;
			while (enum.hasMoreElements ())
			{
			s = (Symbole) enum.nextElement () ;
			s2 = (Symbole) h.get (s.getNom ()) ;
			if (null == s2)
			s.setFlou () ;
			h.put (s.getNom (), s) ;
			}
			}
			saut = cc.getNombreInstructions () ;
			if (sinon)
			saut ++ ;
			instruction = new Instruction (NOT) ;
			c.addInstruction (instruction) ;
			instruction = new Instruction (JBP, saut) ;
			c.addInstruction (instruction) ;
			c.addInstructions (cc.getInstructions ()) ;
			if (sinon)
			{
			instruction = new Instruction (
			JMP, 
			cc1.getNombreInstructions ()) ;
			c.addInstruction (instruction) ;
			c.addInstructions (cc1.getInstructions ()) ;
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_5);
		}
	}

	public final void expression(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		boolean fait ;
		instruction = null ;
		t = - 1 ;
		fait = false ;
		
		try {      // for error handling
			exprAnd(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			_loop34:
			do {
				if ((LA(1)==OU)) {
					match(OU);
					exprAnd(c, e);
					if ((! fait) && (t != BOOLEEN))
					{
					System.err.println (
					CONDITION_BADTYPE +
					" : booleen attendu") ;
					fait = true ;
					}
					if (BOOLEEN != c.getTypeLastInstruction (e))
					System.err.println (
					CONDITION_BADTYPE +
					" : booleen attendu") ;
					instruction = new Instruction (OR) ;
					c.addInstruction (instruction) ;
				}
				else {
					break _loop34;
				}
				
			} while (true);
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_7);
		}
	}

	public final void appelSousProgramme(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		int parametre ;
		Instruction instruction ;
		EnvironnementP sp ;
		sp = null ;
		parametre = 0 ;
		
		try {      // for error handling
			i = LT(1);
			match(ID);
			if (!e.existSPrg (i.getText ()))
			System.err.println (
			SPRG_NOTEXIST +
			" : " +
			i.getText ()) ;
			else
			sp = e.getSPrg (i.getText ()) ;
			match(LPAREN);
			{
			switch ( LA(1)) {
			case TK_new:
			case TK_saisieEntier:
			case LPAREN:
			case PLUS:
			case MOINS:
			case NON:
			case INT:
			case ID:
			{
				expression(c, e);
				if (null != sp)
				{
				if ((VIDE == sp.getTypeParametre (parametre)) ||
				(sp.getTypeParametre (parametre) != 
				c.getTypeLastInstruction (e)))
				System.err.println (
				PARAMETRE_BADTYPE +
				" : " +
				i.getText () +
				" (" +
				i.getLine () + 
				")") ;
				parametre ++ ;
				}
				{
				_loop29:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						expression(c, e);
						if (null != sp)
						{
						if ((VIDE == sp.getTypeParametre (parametre)) ||
						(sp.getTypeParametre (parametre) != 
						c.getTypeLastInstruction (e)))
						System.err.println (
						PARAMETRE_BADTYPE +
						" : " +
						i.getText () +
						" (" +
						i.getLine () + 
						")") ;
						parametre ++ ;
						}
					}
					else {
						break _loop29;
					}
					
				} while (true);
				}
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
			match(RPAREN);
			if (null != sp)
			{
			if (parametre != sp.getNombreParametre ())
			System.err.println (
			PARAMETRE_BADNUMBER +
			" : " +
			i.getText () +
			" (" +
			i.getLine () + 
			")") ;
			else
			{
			instruction = new Instruction (CALL, i.getText ()) ;
			c.addInstruction (instruction) ;
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_8);
		}
	}

	public final void couleur(
		Code c
	) throws ParserException {
		
		int couleur ;
		Instruction instruction ;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case TK_WHITE:
			{
				match(TK_WHITE);
				couleur = WHITE ;
				break;
			}
			case TK_BLACK:
			{
				match(TK_BLACK);
				couleur = BLACK ;
				break;
			}
			case TK_BLUE:
			{
				match(TK_BLUE);
				couleur = BLUE ;
				break;
			}
			case TK_CYAN:
			{
				match(TK_CYAN);
				couleur = CYAN ;
				break;
			}
			case TK_DARKGRAY:
			{
				match(TK_DARKGRAY);
				couleur = DARKGRAY ;
				break;
			}
			case TK_GRAY:
			{
				match(TK_GRAY);
				couleur = GRAY ;
				break;
			}
			case TK_LIGHTGRAY:
			{
				match(TK_LIGHTGRAY);
				couleur = LIGHTGRAY ;
				break;
			}
			case TK_GREEN:
			{
				match(TK_GREEN);
				couleur = GREEN ;
				break;
			}
			case TK_MAGENTA:
			{
				match(TK_MAGENTA);
				couleur = MAGENTA ;
				break;
			}
			case TK_ORANGE:
			{
				match(TK_ORANGE);
				couleur = ORANGE ;
				break;
			}
			case TK_PINK:
			{
				match(TK_PINK);
				couleur = PINK ;
				break;
			}
			case TK_RED:
			{
				match(TK_RED);
				couleur = RED ;
				break;
			}
			case TK_YELLOW:
			{
				match(TK_YELLOW);
				couleur = YELLOW ;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
			instruction = new Instruction (PUSI, couleur) ;
			c.addInstruction (instruction) ;
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_9);
		}
	}

	public final void exprAnd(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		boolean fait ;
		instruction = null ;
		t = - 1 ;
		fait = false ;
		
		try {      // for error handling
			exprEqual(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			_loop37:
			do {
				if ((LA(1)==ET)) {
					match(ET);
					exprEqual(c, e);
					if ((! fait) && (t != BOOLEEN))
					{
					System.err.println (
					CONDITION_BADTYPE +
					" : booleen attendu") ;
					fait = true ;
					}
					if (BOOLEEN != c.getTypeLastInstruction (e))
					System.err.println (
					CONDITION_BADTYPE +
					" : booleen attendu") ;
					instruction = new Instruction (AND) ;
					c.addInstruction (instruction) ;
				}
				else {
					break _loop37;
				}
				
			} while (true);
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_10);
		}
	}

	public final void exprEqual(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		int opCond ;
		instruction = null ;
		t = - 1 ;
		opCond = -1 ;
		
		try {      // for error handling
			exprRelation(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			switch ( LA(1)) {
			case DIFF:
			case EGALITE:
			{
				{
				switch ( LA(1)) {
				case EGALITE:
				{
					match(EGALITE);
					opCond = EGALITE ;
					break;
				}
				case DIFF:
				{
					match(DIFF);
					opCond = DIFF ;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1));
				}
				}
				}
				exprRelation(c, e);
				if (t != ENTIER)
				System.err.println (
				CONDITION_BADTYPE +
				" : entier attendu") ;
				if (ENTIER != c.getTypeLastInstruction (e))
				System.err.println (
				CONDITION_BADTYPE +
				" : entier attendu") ;
				switch (opCond)
				{
				case EGALITE :
				instruction = new Instruction (EQ) ;
				break ;
				case DIFF :
				instruction = new Instruction (NQ) ;
				break ;
				}
				c.addInstruction (instruction) ;
				break;
			}
			case TK_return:
			case TK_Pour:
			case TK_TantQue:
			case TK_Si:
			case TK_a:
			case TK_pause:
			case RPAREN:
			case SEMI:
			case COMMA:
			case ET:
			case OU:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_11);
		}
	}

	public final void exprRelation(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		int opCond ;
		instruction = null ;
		t = - 1 ;
		opCond = -1 ;
		
		try {      // for error handling
			exprAdditive(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			switch ( LA(1)) {
			case SUPEQ:
			case INFEQ:
			case SUP:
			case INF:
			{
				{
				switch ( LA(1)) {
				case SUP:
				{
					match(SUP);
					opCond = SUP ;
					break;
				}
				case INF:
				{
					match(INF);
					opCond = INF ;
					break;
				}
				case SUPEQ:
				{
					match(SUPEQ);
					opCond = SUPEQ ;
					break;
				}
				case INFEQ:
				{
					match(INFEQ);
					opCond = INFEQ ;
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1));
				}
				}
				}
				exprAdditive(c, e);
				if (t != ENTIER)
				System.err.println (
				CONDITION_BADTYPE +
				" : entier attendu") ;
				if (ENTIER != c.getTypeLastInstruction (e))
				System.err.println (
				CONDITION_BADTYPE +
				" : entier attendu") ;
				switch (opCond)
				{
				case SUP :
				instruction = new Instruction (GT) ;
				break ;
				case INF :
				instruction = new Instruction (LT) ;
				break ;
				case SUPEQ :
				instruction = new Instruction (GE) ;
				break ;
				case INFEQ :
				instruction = new Instruction (LE) ;
				break ;
				}
				c.addInstruction (instruction) ;
				break;
			}
			case TK_return:
			case TK_Pour:
			case TK_TantQue:
			case TK_Si:
			case TK_a:
			case TK_pause:
			case RPAREN:
			case SEMI:
			case COMMA:
			case DIFF:
			case EGALITE:
			case ET:
			case OU:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_12);
		}
	}

	public final void exprAdditive(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		int op ;
		boolean fait ;
		instruction = null ;
		t = - 1 ;
		fait = false ;
		op = -1 ;
		
		try {      // for error handling
			sousExpression(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			_loop47:
			do {
				if ((LA(1)==PLUS||LA(1)==MOINS)) {
					{
					switch ( LA(1)) {
					case PLUS:
					{
						match(PLUS);
						op = PLUS ;
						break;
					}
					case MOINS:
					{
						match(MOINS);
						op = MOINS ;
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1));
					}
					}
					}
					sousExpression(c, e);
					if ((! fait) && (t != ENTIER))
					{
					System.err.println (
					OPERATION_BADTYPE +
					" : entier attendu") ;
					fait = true ;
					}
					if (ENTIER != c.getTypeLastInstruction (e))
					System.err.println (
					OPERATION_BADTYPE +
					" : entier attendu") ;
					switch (op)
					{
					case PLUS :
					instruction = new Instruction (ADD) ;
					break ;
					case MOINS :
					instruction = new Instruction (SUB) ;
					break ;
					}
					c.addInstruction (instruction) ;
				}
				else {
					break _loop47;
				}
				
			} while (true);
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_13);
		}
	}

	public final void sousExpression(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		int t ;
		int op ;
		boolean fait ;
		instruction = null ;
		t = - 1 ;
		fait = false ;
		op = -1 ;
		
		try {      // for error handling
			terme(c, e);
			t = c.getTypeLastInstruction (e) ;
			{
			_loop51:
			do {
				if (((LA(1) >= ETOILE && LA(1) <= MODULO))) {
					{
					switch ( LA(1)) {
					case ETOILE:
					{
						match(ETOILE);
						op = ETOILE ;
						break;
					}
					case DIVISION:
					{
						match(DIVISION);
						op = DIVISION ;
						break;
					}
					case MODULO:
					{
						match(MODULO);
						op = MODULO ;
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1));
					}
					}
					}
					terme(c, e);
					if ((! fait) && (t != ENTIER))
					{
					System.err.println (
					OPERATION_BADTYPE +
					" : entier attendu") ;
					fait = true ;
					}
					if (ENTIER != c.getTypeLastInstruction (e))
					System.err.println (
					OPERATION_BADTYPE +
					" : entier attendu") ;
					switch (op)
					{
					case ETOILE :
					instruction = new Instruction (MUL) ;
					break ;
					case DIVISION :
					instruction = new Instruction (DIV) ;
					break ;
					case MODULO :
					instruction = new Instruction (MOD) ;
					break ;
					}
					c.addInstruction (instruction) ;
				}
				else {
					break _loop51;
				}
				
			} while (true);
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_14);
		}
	}

	public final void terme(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Instruction instruction ;
		boolean moins, signe ;
		moins = false ;
		signe = false ;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TK_new:
			case TK_saisieEntier:
			case LPAREN:
			case PLUS:
			case MOINS:
			case INT:
			case ID:
			{
				{
				switch ( LA(1)) {
				case PLUS:
				{
					match(PLUS);
					signe = true ;
					break;
				}
				case MOINS:
				{
					match(MOINS);
					moins = true ; signe = true ;
					break;
				}
				case TK_new:
				case TK_saisieEntier:
				case LPAREN:
				case INT:
				case ID:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1));
				}
				}
				}
				atom(c, e);
				if (signe && (ENTIER != c.getTypeLastInstruction (e)))
				System.err.println (
				OPERATION_BADTYPE +
				" : entier attendu") ;
				if (moins)
				{
				instruction = new Instruction (PUSI, -1) ;
				c.addInstruction (instruction) ;
				instruction = new Instruction (MUL) ;
				c.addInstruction (instruction) ;
				}
				break;
			}
			case NON:
			{
				match(NON);
				match(LPAREN);
				expression(c, e);
				match(RPAREN);
				if (BOOLEEN != c.getTypeLastInstruction (e))
				System.err.println (
				CONDITION_BADTYPE +
				" : booleen attendu") ;
				instruction = new Instruction (NOT) ;
				c.addInstruction (instruction) ;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1));
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_8);
		}
	}

	public final void atom(
		Code c, EnvironnementP e
	) throws ParserException {
		
		Token  i = null;
		Token  i2 = null;
		int t, nbParametre ;
		Symbole s ;
		Instruction instruction ;
		nbParametre = 0 ;
		
		try {      // for error handling
			switch ( LA(1)) {
			case INT:
			{
				i2 = LT(1);
				match(INT);
				instruction = new Instruction (PUSI, Integer
				.valueOf (i2.getText ()).intValue ()) ;
				c.addInstruction (instruction) ;
				break;
			}
			case TK_saisieEntier:
			{
				match(TK_saisieEntier);
				match(LPAREN);
				match(RPAREN);
				instruction = new Instruction (GETI) ;
				c.addInstruction (instruction) ;
				break;
			}
			case LPAREN:
			{
				match(LPAREN);
				expression(c, e);
				match(RPAREN);
				break;
			}
			case TK_new:
			{
				match(TK_new);
				match(TK_Mulot);
				match(LPAREN);
				{
				switch ( LA(1)) {
				case TK_new:
				case TK_saisieEntier:
				case LPAREN:
				case PLUS:
				case MOINS:
				case NON:
				case INT:
				case ID:
				{
					expression(c, e);
					if (ENTIER != c.getTypeLastInstruction (e))
					System.err.println (
					PARAMETRE_BADTYPE +
					" : le premier") ;
					match(COMMA);
					expression(c, e);
					nbParametre = 2 ; 
					if (ENTIER != c.getTypeLastInstruction (e))
					System.err.println (
					PARAMETRE_BADTYPE +
					" : le deuxieme") ;
					{
					switch ( LA(1)) {
					case COMMA:
					{
						match(COMMA);
						couleur(c);
						nbParametre = 3 ; 
						if (ENTIER != c.getTypeLastInstruction (e))
						System.err.println (
						PARAMETRE_BADTYPE +
						" : le troisieme") ;
						{
						switch ( LA(1)) {
						case COMMA:
						{
							match(COMMA);
							expression(c, e);
							nbParametre = 4 ; 
							if (ENTIER != c.getTypeLastInstruction (e))
							System.err.println (
							PARAMETRE_BADTYPE +
							" : le quatrieme") ;
							break;
						}
						case RPAREN:
						{
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1));
						}
						}
						}
						break;
					}
					case RPAREN:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1));
					}
					}
					}
					break;
				}
				case RPAREN:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1));
				}
				}
				}
				match(RPAREN);
				instruction = new Instruction (PUSI, nbParametre) ;
				c.addInstruction (instruction) ;
				instruction = new Instruction (NEWM) ;
				c.addInstruction (instruction) ;
				break;
			}
			default:
				if ((LA(1)==ID) && (_tokenSet_8.member(LA(2)))) {
					i = LT(1);
					match(ID);
					if (!e.existSymbole (i.getText ()))
					System.err.println (
					SYMBOLE_NOTEXIST +
					" : " +
					i.getText () +
					" (" +
					i.getLine () + 
					")") ;
					else
					{
					s = e.getSymbole (i.getText ()) ;
					if (s.isFlou ())
					System.err.println (
					SYMBOLE_MAYNOTEXIST +
					" : " +
					i.getText () +
					" (" +
					i.getLine () + 
					")") ;
					else
					{
					instruction = new Instruction (PUSO, i.getText ()) ;
					c.addInstruction (instruction) ;
					}
					}
				}
				else if ((LA(1)==ID) && (LA(2)==LPAREN)) {
					appelSousProgramme(c, e);
				}
			else {
				throw new NoViableAltException(LT(1));
			}
			}
		}
		catch (ParserException ex) {
			reportError(ex);
			consume();
			consumeUntil(_tokenSet_8);
		}
	}

	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"Mulot\"",
		"\"Tolum\"",
		"\"Proc\"",
		"\"Corp\"",
		"\"Fonc\"",
		"\"Cnof\"",
		"\"return\"",
		"\"Pour\"",
		"\"Ruop\"",
		"\"TantQue\"",
		"\"Tnat\"",
		"\"Si\"",
		"\"Alors\"",
		"\"Sinon\"",
		"\"Is\"",
		"\"new\"",
		"\"int\"",
		"\"baisse\"",
		"\"leve\"",
		"\"avance\"",
		"\"tourne\"",
		"\"a\"",
		"\"pause\"",
		"\"saisieEntier\"",
		"\"WHITE\"",
		"\"BLACK\"",
		"\"BLUE\"",
		"\"CYAN\"",
		"\"DARKGRAY\"",
		"\"GRAY\"",
		"\"LIGHTGRAY\"",
		"\"GREEN\"",
		"\"MAGENTA\"",
		"\"ORANGE\"",
		"\"PINK\"",
		"\"RED\"",
		"\"YELLOW\"",
		"WS",
		"COMMENTAIRE",
		"'('",
		"')'",
		"'='",
		"';'",
		"','",
		"'.'",
		"'+'",
		"'-'",
		"'*'",
		"'/'",
		"'%'",
		"'!='",
		"'=='",
		"'>='",
		"'<='",
		"'>'",
		"'<'",
		"'&&'",
		"'||'",
		"'!'",
		"an int",
		"an identifier"
	};
	
	private static final long _tokenSet_0_data_[] = { 2L, 0L };
	public static final BitSet _tokenSet_0 = new BitSet(_tokenSet_0_data_);
	private static final long _tokenSet_1_data_[] = { 67153216L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_1 = new BitSet(_tokenSet_1_data_);
	private static final long _tokenSet_2_data_[] = { 67152896L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_2 = new BitSet(_tokenSet_2_data_);
	private static final long _tokenSet_3_data_[] = { 414368L, 0L };
	public static final BitSet _tokenSet_3 = new BitSet(_tokenSet_3_data_);
	private static final long _tokenSet_4_data_[] = { 17592186044416L, 0L };
	public static final BitSet _tokenSet_4 = new BitSet(_tokenSet_4_data_);
	private static final long _tokenSet_5_data_[] = { 67567264L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_5 = new BitSet(_tokenSet_5_data_);
	private static final long _tokenSet_6_data_[] = { 70368744177664L, 0L };
	public static final BitSet _tokenSet_6 = new BitSet(_tokenSet_6_data_);
	private static final long _tokenSet_7_data_[] = { 228698519284736L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_7 = new BitSet(_tokenSet_7_data_);
	private static final long _tokenSet_8_data_[] = { 4611351766993251328L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_8 = new BitSet(_tokenSet_8_data_);
	private static final long _tokenSet_9_data_[] = { 158329674399744L, 0L };
	public static final BitSet _tokenSet_9 = new BitSet(_tokenSet_9_data_);
	private static final long _tokenSet_10_data_[] = { 2306071707732978688L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_10 = new BitSet(_tokenSet_10_data_);
	private static final long _tokenSet_11_data_[] = { 3458993212339825664L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_11 = new BitSet(_tokenSet_11_data_);
	private static final long _tokenSet_12_data_[] = { 3513036407868271616L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_12 = new BitSet(_tokenSet_12_data_);
	private static final long _tokenSet_13_data_[] = { 4593900318437190656L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_13 = new BitSet(_tokenSet_13_data_);
	private static final long _tokenSet_14_data_[] = { 4595589168297454592L, 1L, 0L, 0L };
	public static final BitSet _tokenSet_14 = new BitSet(_tokenSet_14_data_);
	
}
