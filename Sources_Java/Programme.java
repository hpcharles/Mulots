/**
 * Programme : instructions de la repr�sentation interm�diaire et tables des
 * symboles. Une instance de cette classe est retourn�e par l'analyseur
 * grammatical (parser). On peut ensuite d�clencher l'ex�cution du
 * programme � partir de la repr�sentation interm�diaire. <BR>
 * Cette classe conserve, la repr�sentation interm�diaire et la table des
 * symboles �tablies lors de l'analyse grammaticale.
 *
 * @author Erwan Prioul
 * $RCSfile: Programme.java,v $:$Revision: 1.2 $
 */
public class Programme
    implements
        MulotSrc
{
    protected Code           _RI ;
    protected EnvironnementP _visible ;

    /**
     * Initialisation, on pr�pare la repr�sentation interm�diare et la
     * table des symboles.
     */
    public Programme ()
    {
        _RI = new Code (null, null) ;
        _visible = new EnvironnementP (null, VIDE, null) ;
    }

    /**
     * Retourne la repr�sentation interm�diaire du programme.
     *
     * @return la repr�sentation interm�diaire.
     */
    public Code getRI ()
    {
        return _RI ;
    }

    /**
     * Retourne la table des symboles.
     *
     * @return la table des symboles.
     */
    public EnvironnementP getVisible ()
    {
        return _visible ;
    }
}
