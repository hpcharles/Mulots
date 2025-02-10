/*
 * ANTLR-generated file resulting from grammar MulotLexer.g
 * 
 * Terence Parr, MageLang Institute
 * with John Lilley, Empathy Software
 * ANTLR Version 2.2.3; 1996,1997
 */
import java.io.InputStream;
import java.util.Hashtable;
import antlr.CharScannerNoBacktrackingNoInteractive;
import antlr.CharBufferNoBacktrackingNoInteractive;
import antlr.Token;
import antlr.CommonToken;
import antlr.ScannerException;
import antlr.Tokenizer;
import antlr.ANTLRHashString;
import antlr.collections.impl.BitSet;
public class MulotLexer extends antlr.CharScannerNoBacktrackingNoInteractive implements MulotTokenTypes, Tokenizer
 {
public MulotLexer(InputStream in) {
	this(new CharBufferNoBacktrackingNoInteractive(in));
}
public MulotLexer(CharBufferNoBacktrackingNoInteractive cb) {
	super(cb);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("Corp", this), new Integer(7));
	literals.put(new ANTLRHashString("GREEN", this), new Integer(35));
	literals.put(new ANTLRHashString("Tolum", this), new Integer(5));
	literals.put(new ANTLRHashString("TantQue", this), new Integer(13));
	literals.put(new ANTLRHashString("Sinon", this), new Integer(17));
	literals.put(new ANTLRHashString("MAGENTA", this), new Integer(36));
	literals.put(new ANTLRHashString("Proc", this), new Integer(6));
	literals.put(new ANTLRHashString("pause", this), new Integer(26));
	literals.put(new ANTLRHashString("a", this), new Integer(25));
	literals.put(new ANTLRHashString("LIGHTGRAY", this), new Integer(34));
	literals.put(new ANTLRHashString("GRAY", this), new Integer(33));
	literals.put(new ANTLRHashString("return", this), new Integer(10));
	literals.put(new ANTLRHashString("DARKGRAY", this), new Integer(32));
	literals.put(new ANTLRHashString("Mulot", this), new Integer(4));
	literals.put(new ANTLRHashString("int", this), new Integer(20));
	literals.put(new ANTLRHashString("PINK", this), new Integer(38));
	literals.put(new ANTLRHashString("ORANGE", this), new Integer(37));
	literals.put(new ANTLRHashString("WHITE", this), new Integer(28));
	literals.put(new ANTLRHashString("saisieEntier", this), new Integer(27));
	literals.put(new ANTLRHashString("tourne", this), new Integer(24));
	literals.put(new ANTLRHashString("Is", this), new Integer(18));
	literals.put(new ANTLRHashString("RED", this), new Integer(39));
	literals.put(new ANTLRHashString("Alors", this), new Integer(16));
	literals.put(new ANTLRHashString("Tnat", this), new Integer(14));
	literals.put(new ANTLRHashString("Si", this), new Integer(15));
	literals.put(new ANTLRHashString("new", this), new Integer(19));
	literals.put(new ANTLRHashString("YELLOW", this), new Integer(40));
	literals.put(new ANTLRHashString("avance", this), new Integer(23));
	literals.put(new ANTLRHashString("BLACK", this), new Integer(29));
	literals.put(new ANTLRHashString("Ruop", this), new Integer(12));
	literals.put(new ANTLRHashString("Fonc", this), new Integer(8));
	literals.put(new ANTLRHashString("Cnof", this), new Integer(9));
	literals.put(new ANTLRHashString("BLUE", this), new Integer(30));
	literals.put(new ANTLRHashString("leve", this), new Integer(22));
	literals.put(new ANTLRHashString("CYAN", this), new Integer(31));
	literals.put(new ANTLRHashString("baisse", this), new Integer(21));
	literals.put(new ANTLRHashString("Pour", this), new Integer(11));
caseSensitiveLiterals = true;
}

public Token nextToken() {
	Token _rettoken=null;
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for error handling
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				mWS(true);
				_rettoken=_returnToken;
				break;
			}
			case '(':
			{
				mLPAREN(true);
				_rettoken=_returnToken;
				break;
			}
			case ')':
			{
				mRPAREN(true);
				_rettoken=_returnToken;
				break;
			}
			case ';':
			{
				mSEMI(true);
				_rettoken=_returnToken;
				break;
			}
			case ',':
			{
				mCOMMA(true);
				_rettoken=_returnToken;
				break;
			}
			case '.':
			{
				mPOINT(true);
				_rettoken=_returnToken;
				break;
			}
			case '+':
			{
				mPLUS(true);
				_rettoken=_returnToken;
				break;
			}
			case '*':
			{
				mETOILE(true);
				_rettoken=_returnToken;
				break;
			}
			case '/':
			{
				mDIVISION(true);
				_rettoken=_returnToken;
				break;
			}
			case '%':
			{
				mMODULO(true);
				_rettoken=_returnToken;
				break;
			}
			case '&':
			{
				mET(true);
				_rettoken=_returnToken;
				break;
			}
			case '|':
			{
				mOU(true);
				_rettoken=_returnToken;
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mINT(true);
				_rettoken=_returnToken;
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':  case '_':  case 'a':
			case 'b':  case 'c':  case 'd':  case 'e':
			case 'f':  case 'g':  case 'h':  case 'i':
			case 'j':  case 'k':  case 'l':  case 'm':
			case 'n':  case 'o':  case 'p':  case 'q':
			case 'r':  case 's':  case 't':  case 'u':
			case 'v':  case 'w':  case 'x':  case 'y':
			case 'z':
			{
				mID(true);
				_rettoken=_returnToken;
				break;
			}
			default:
				if ((LA(1)=='-') && (LA(2)=='-')) {
					mCOMMENTAIRE(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='!') && (LA(2)=='=')) {
					mDIFF(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='=') && (LA(2)=='=')) {
					mEGALITE(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='>') && (LA(2)=='=')) {
					mSUPEQ(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='<') && (LA(2)=='=')) {
					mINFEQ(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='=')) {
					mASSIGN(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='-')) {
					mMOINS(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='>')) {
					mSUP(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='<')) {
					mINF(true);
					_rettoken=_returnToken;
				}
				else if ((LA(1)=='!')) {
					mNON(true);
					_rettoken=_returnToken;
				}
			else {
				if (LA(1)!=EOF_CHAR) throw new ScannerException("no viable alt for char: "+(char)LA(1),getLine());_returnToken = makeToken(Token.EOF_TYPE);
			}
			}
			_ttype = _returnToken.getType();
			_ttype = testLiteralsTable(_ttype);
			if ( _ttype!=Token.SKIP ) {
				_returnToken.setType(_ttype);
				return _returnToken;
			}
		}
		catch (ScannerException e) {
			consume();
			reportError(e);
		}
	}
}

	public final void mWS(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case ' ':
		{
			match(' ');
			break;
		}
		case '\t':
		{
			match('\t');
			break;
		}
		case '\r':
		{
			match('\r');
			break;
		}
		case '\n':
		{
			match('\n');
			newline () ;
			break;
		}
		default:
		{
			throw new ScannerException("no viable alt for char: "+(char)LA(1),getLine());
		}
		}
		}
		_ttype = Token.SKIP ;
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMENTAIRE(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENTAIRE;
		int _saveIndex;
		
		match("--");
		{
		_loop5:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
				matchNot('\n');
			}
			else {
				break _loop5;
			}
			
		} while (true);
		}
		match('\n');
		_ttype = Token.SKIP ; newline () ;
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mLPAREN(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mRPAREN(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mASSIGN(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASSIGN;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mSEMI(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMA(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mPOINT(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = POINT;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mPLUS(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mMOINS(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MOINS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mETOILE(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ETOILE;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mDIVISION(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVISION;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mMODULO(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MODULO;
		int _saveIndex;
		
		match('%');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mDIFF(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIFF;
		int _saveIndex;
		
		match('!');
		match('=');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mEGALITE(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EGALITE;
		int _saveIndex;
		
		match('=');
		match('=');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mSUPEQ(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SUPEQ;
		int _saveIndex;
		
		match('>');
		match('=');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mINFEQ(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INFEQ;
		int _saveIndex;
		
		match('<');
		match('=');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mSUP(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SUP;
		int _saveIndex;
		
		match('>');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mINF(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INF;
		int _saveIndex;
		
		match('<');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mET(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ET;
		int _saveIndex;
		
		match('&');
		match('&');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mOU(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OU;
		int _saveIndex;
		
		match('|');
		match('|');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mNON(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NON;
		int _saveIndex;
		
		match('!');
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mINT(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT;
		int _saveIndex;
		
		{
		int _cnt28=0;
		_loop28:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				matchRange('0','9');
			}
			else {
				if ( _cnt28>=1 ) { break _loop28; } else {throw new ScannerException("no viable alt for char: "+(char)LA(1),getLine());}
			}
			
			_cnt28++;
		} while (true);
		}
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	public final void mID(boolean _createToken) throws ScannerException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
		{
			throw new ScannerException("no viable alt for char: "+(char)LA(1),getLine());
		}
		}
		}
		{
		_loop32:
		do {
			switch ( LA(1)) {
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':
			{
				matchRange('a','z');
				break;
			}
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':
			{
				matchRange('A','Z');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				matchRange('0','9');
				break;
			}
			default:
			{
				break _loop32;
			}
			}
		} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}

	
	private static final long _tokenSet_0_data_[] = { 8935140986393207296L, 1729382250602037246L, 0L, 0L };
	public static final BitSet _tokenSet_0 = new BitSet(_tokenSet_0_data_);
	
	}
