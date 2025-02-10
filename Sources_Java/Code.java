import java.awt.Color ;
import java.awt.Frame ;
import java.lang.String ;
import java.util.Hashtable ;
import java.util.Stack ;
import java.util.Vector ;

/**
 * Représentation intermédiaire. Cette classe stocke les instructions atomiques
 * d'un programme, écrit en Mulot par exemple... Un code contient un nom (celui
 * de la fonction ou de la procédure), une table de hashage de sousprogrammes,
 * une liste d'instruction et le code père. Le code père sert aux appels des
 * fonctions ou procédures de mêmes niveau ou plus globales.
 *
 * @author Erwan Prioul
 * $RCSfile: Code.java,v $:$Revision: 1.3 $
 */
public class Code
    implements
        MulotSrc 
{
    protected String    _nom ;
    protected Hashtable _sousProgrammes ;
    protected Vector    _instructions ;
    protected Code      _pere ;

    /** 
     * Initialisation d'un code à partie d'un nom de sousprogramme (null pour
     * le programme principal) et d'un code père (null pour le programme
     * principal).
     * 
     * @param nom nom du sousprogramme.
     * @param pere code d'accueil.
     */
    public Code (String nom, Code pere)
    {
        _nom = nom ;
        _pere = pere ;
        _instructions = new Vector () ;
        _sousProgrammes = new Hashtable () ;
    }

    /**
     * Donne le nom du sousprogramme.
     *
     * @return le nom du sousprogramme.
     */
    public String getNom ()
    {
        return _nom ;
    }

    /**
     * Donne le code père.
     *
     * @return code d'accueil.
     */
    public Code getPere ()
    {
        return _pere ;
    }

    /**
     * Donne la liste des instructions du code.
     *
     * @return une liste d'instruction.
     */
    public Vector getInstructions ()
    {
        return _instructions ;
    }

    /**
     * Donne le nombre d'instructions.
     *
     * @return nombre d'instructions.
     */
    public int getNombreInstructions ()
    {
        return _instructions.size () ;
    }

    /**
     * Ajoute un sousprogramme (avec son code).
     *
     * @param s sousprogramme à ajouter.
     */
    public void addSPrg (Code s)
    {
        _sousProgrammes.put (s.getNom (), s) ;
    }

    /**
     * Donne un sousprogramme à partir de son nom.
     *
     * @param nom nom du sousprogramme à rechercher.
     * @return le sousprogramme désiré.
     */
    public Code getSPrg (String nom)
    {
        Code s ;
        
        s = (Code) _sousProgrammes.get (nom) ;
        if (null == s)
            if (null != _pere)
                s = _pere.getSPrg (nom) ;
        return s ;
    }

    /**
     * Ajoute UNE instruction.
     *
     * @param instruction instruction à ajouter.
     */
    public void addInstruction (Instruction instruction)
    {
        _instructions.addElement (instruction) ;
    }

    /**
     * Ajoute DES instructions à partir d'une liste.
     *
     * @param instructions instructions à ajouter.
     */
    public void addInstructions (Vector instructions)
    {
        int i ;

        for (i = 0 ; i < instructions.size () ; i ++)
            _instructions.addElement (
                (Instruction) instructions.elementAt (i)) ;
    }

    /**
     * Donne le type de données (ENTIER, MULOT, BOOLEEN ou VIDE) retourné par la
     * dernière instruction. Pour cela on a besoin de l'environnement 
     * d'analyse grammaticale pour vérifier les symboles, si besoin.
     *
     * @param e environnement d'analyse grammaticale.
     * @return ENTIER, MULOT, BOOLEEN ou VIDE.
     */
    public int getTypeLastInstruction (EnvironnementP e)
    {
        int t ;
        Instruction instruction ;

        if (0 == _instructions.size ())
            return VIDE ;
        instruction = (Instruction) _instructions
            .elementAt (_instructions.size () - 1) ;
        switch (instruction.getCodeInstruction ())
        {
        case PUSI :
        case ADD  :
        case MUL  :
        case DIV  :
        case SUB  :
        case MOD  :
        case GETI :
            t = ENTIER ;
            break ;
        case PUSO :
            t = e.getSymbole (instruction.getIdentifiant ()).getType () ;
            break ;
        case CALL :
            t = e.getSPrg (instruction.getIdentifiant ()).getTypeRetour () ;
            break ;
        case NEWM :
            t = MULOT ;
            break ;
        case AND  :
        case OR   :
        case NOT  :
        case EQ   :
        case NQ   :
        case GT   :
        case LT   :
        case GE   :
        case LE   :
            t = BOOLEEN ;
            break ;
        case JMP  :
        case JBP  :
        case RET  :
        case TOUR :
        case AVAN :
        case BAIS :
        case LEVE :
        case POP  :
        case STOP :
        default :
            t = VIDE ;
        }
        return t ;
    }

    /**
     * Exécute les instructions du code à partir d'une pile de données, d'un
     * environnement d'exécution. On a aussi besoin de la zone graphique pour
     * que les mulots 'sachent' où s'afficher.
     *
     * @param pile pile de données. Elle est unique toute au long de  
     *             l'exécution.
     * @param e environnement d'exécution. Contient entre autres le 
     *          compteur d'instructions.
     * @param zoneG zone graphique, 'terrain de jeu' des mulots.
     * @return <CODE>true</CODE> si tout s'est correctement d&eacute;roul&eacute;,
     *         <CODE>false</CODE> sinon.
     */
    public boolean execute (
        Stack pile, 
        EnvironnementE e, 
        ImageMulot zoneG, 
        Frame parent) 
    {
        int pc ;
        ElementPile a, b, c, x, y, g ;
        Symbole s = null ;
        Instruction i ;
        Code sprg ;
        EnvironnementE senv ;
        Mulot m = null ;
        Couleur couleur ;
        WaitBox wbox ;
        GetIntBox gbox ;
        Entier saisie ;

        couleur = new Couleur () ;
        pc = e.getInstructionCourante () ;
        while ((pc >= 0) && (pc < _instructions.size ()))
        {
            i = (Instruction) _instructions.elementAt (pc) ;
            switch (i.getCodeInstruction ())
            {
            case ADD  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    ENTIER,
                    new Integer (
                        ((Integer) a.getValeur ()).intValue () +
                        ((Integer) b.getValeur ()).intValue ())) ;
                pile.push (c) ;
                break ;
            case SUB  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    ENTIER,
                    new Integer (
                        ((Integer) a.getValeur ()).intValue () -
                        ((Integer) b.getValeur ()).intValue ())) ;
                pile.push (c) ;
                break ;
            case MUL  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    ENTIER,
                    new Integer (
                        ((Integer) a.getValeur ()).intValue () *
                        ((Integer) b.getValeur ()).intValue ())) ;
                pile.push (c) ;
                break ;
            case DIV  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                if (0 != (((Integer) b.getValeur ()).intValue ()))
                {
                    c = new ElementPile (
                        ENTIER,
                        new Integer (
                            ((Integer) a.getValeur ()).intValue () /
                            ((Integer) b.getValeur ()).intValue ())) ;
                    pile.push (c) ;
                }
                else
                    return false ;
                break ;
            case MOD  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    ENTIER,
                    new Integer (
                        ((Integer) a.getValeur ()).intValue () %
                        ((Integer) b.getValeur ()).intValue ())) ;
                pile.push (c) ;
                break ;
            case LEVE :
                s = e.getSymbole (i.getIdentifiant ()) ;
                ((Mulot) s.getValeur ()).leve () ;
                break ;
            case BAIS :
                s = e.getSymbole (i.getIdentifiant ()) ;
                ((Mulot) s.getValeur ()).baisse () ;
                break ;
            case TOUR :
                a = (ElementPile) pile.pop () ;
                s = e.getSymbole (i.getIdentifiant ()) ;
                ((Mulot) s.getValeur ()).tourne (
                    ((Integer) a.getValeur ()).intValue ()) ;
                break ;
            case AVAN :
                a = (ElementPile) pile.pop () ;
                s = e.getSymbole (i.getIdentifiant ()) ;
                ((Mulot) s.getValeur ()).avance (
                    ((Integer) a.getValeur ()).intValue ()) ;
                break ;
            case CALL :
                sprg = this.getSPrg (i.getIdentifiant ()) ;
                senv = new EnvironnementE (e) ;
                if (! sprg.execute (pile, senv, zoneG, parent))
                    return false ;
                break ;
            case RET  :
                e.incrementInstruction (_instructions.size ()) ;
                break ;
            case NEWM :
                a = (ElementPile) pile.pop () ;
                switch (((Integer) a.getValeur ()).intValue ())
                {
                case 0 :
                    m = new Mulot () ;
                    break ;
                case 2 :
                    y = (ElementPile) pile.pop () ;
                    x = (ElementPile) pile.pop () ;
                    m = new Mulot (
                        ((Integer) x.getValeur ()).intValue (),
                        ((Integer) y.getValeur ()).intValue ()) ;
                    break ;
                case 3 :
                    c = (ElementPile) pile.pop () ;
                    y = (ElementPile) pile.pop () ;
                    x = (ElementPile) pile.pop () ;
                    m = new Mulot (
                        ((Integer) x.getValeur ()).intValue (),
                        ((Integer) y.getValeur ()).intValue (),
                        couleur.getColor (
                            ((Integer) c.getValeur ()).intValue ())) ;
                    break ;
                case 4 :
                    g = (ElementPile) pile.pop () ;
                    c = (ElementPile) pile.pop () ;
                    y = (ElementPile) pile.pop () ;
                    x = (ElementPile) pile.pop () ;
                    m = new Mulot (
                        ((Integer) x.getValeur ()).intValue (),
                        ((Integer) y.getValeur ()).intValue (),
                        couleur.getColor (((Integer) c.getValeur ()).intValue ()),
                        ((Integer) g.getValeur ()).intValue ()) ;
                    break ;
                }
                m.observable ().addObserver (zoneG) ;
                zoneG.observable ().addObserver (m) ;
                b = new ElementPile (MULOT, m) ;
                pile.push (b) ;
                break ;
            case PUSO :
                s = e.getSymbole (i.getIdentifiant ()) ;
                a = new ElementPile (
                    s.getType (),
                    s.getValeur ()) ;
                pile.push (a) ;
                break ;
            case PUSI :
                a = new ElementPile (ENTIER, new Integer (i.getEntier ())) ;
                pile.push (a) ;
                break ;
            case POP  :
                a = (ElementPile) pile.pop () ;
                if (e.definedSymbole (i.getIdentifiant ()))
                {
                    s = e.getSymbole (i.getIdentifiant ()) ;
                    s.setValeur (a.getValeur ()) ;
                }
                else
                {
                    s = new Symbole (
                        i.getIdentifiant (), 
                        a.getType (), 
                        a.getValeur ()) ;
                    e.addSymbole (s) ;
                }
                break ;
            case EQ   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) ==
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case NQ   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) != 
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case LT   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) <
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case GT   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) >
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case LE   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) <= 
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case GE   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Integer) a.getValeur ()).intValue ()) >= 
                        (((Integer) b.getValeur ()).intValue ()))) ;
                pile.push (c) ;
                break ;
            case AND  :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Boolean) a.getValeur ()).booleanValue ()) &&
                        (((Boolean) b.getValeur ()).booleanValue ()))) ;
                pile.push (c) ;
                break ;
            case OR   :
                b = (ElementPile) pile.pop () ;
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        (((Boolean) a.getValeur ()).booleanValue ()) ||
                        (((Boolean) b.getValeur ()).booleanValue ()))) ;
                pile.push (c) ;
                break ;
            case NOT  :
                a = (ElementPile) pile.pop () ;
                c = new ElementPile (
                    BOOLEEN,
                    new Boolean (
                        !(((Boolean) a.getValeur ()).booleanValue ()))) ;
                pile.push (c) ;
                break ;
            case JBP  :
                a = (ElementPile) pile.pop () ;
                if (((Boolean) a.getValeur ()).booleanValue ())
                    e.incrementInstruction (i.getEntier ()) ;
                break ;
            case JMP  :
                e.incrementInstruction (i.getEntier ()) ;
                break ;
            case STOP :
                wbox = new WaitBox (parent) ;
		wbox.attente ();
                break ;
            case GETI :
                saisie = new Entier () ;
                gbox = new GetIntBox (parent, saisie) ;
		// Attente de la saisie
		gbox.attente ();
                a = new ElementPile (ENTIER, saisie.toInteger ()) ;
                pile.push (a) ;
            }
            e.incrementInstruction (INCREMENT_INSTRUCTION) ;
            pc = e.getInstructionCourante () ;
        }
        return true ;
    }
}
