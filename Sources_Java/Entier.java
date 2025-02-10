import java.lang.Integer ;

/**
 * Gestion de valeurs entières.
 *
 * @author Erwan Prioul
 * $RCSfile: Entier.java,v $:$Revision: 1.2 $
 */
public class Entier
{
    private int _value ;

    /**
     * Initialisation.
     */
    public Entier ()
    {
    }

    /**
     * Détermine une nouvelle valeur.
     *
     * @param value nouvelle valeur.
     */
    public void setValue (int value)
    {
        _value = value ;
    }

    /**
     * Renvoi la valeur sous forme Integer.
     *
     * @return l'entier sous forme Integer.
     */
    public Integer toInteger ()
    {
        return new Integer (_value) ;
    }
}
