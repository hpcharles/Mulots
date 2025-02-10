/**
 * Programme : instructions de la représentation intermédiaire et tables des
 * symboles. Une instance de cette classe est retournée par l'analyseur
 * grammatical (parser). On peut ensuite déclencher l'exécution du
 * programme à partir de la représentation intermédiaire. <BR>
 * Cette classe conserve, la représentation intermédiaire et la table des
 * symboles établies lors de l'analyse grammaticale.
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
     * Initialisation, on prépare la représentation intermédiare et la
     * table des symboles.
     */
    public Programme ()
    {
        _RI = new Code (null, null) ;
        _visible = new EnvironnementP (null, VIDE, null) ;
    }

    /**
     * Retourne la représentation intermédiaire du programme.
     *
     * @return la représentation intermédiaire.
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
