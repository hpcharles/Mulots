import java.lang.String ;

/**
 * El�ment de la pile d'ex�cution : entier ou Mulot...
 *
 * @author Erwan Prioul
 * $RCSfile: ElementPile.java,v $:$Revision: 1.2 $
 */
public class ElementPile
    implements
        MulotSrc
{
    protected int    _type ;
    protected Object _valeur ;

    /**
     * Initialisation d'un �l�ment de pile � partir de son type (ENTIER, 
     * BOOLEEN ou MULOT) et de la valeur associ�e (objet Integer ou Mulot).
     *
     * @param type ENTIER, BOOLEEN ou MULOT.
     * @param valeur Integer, Boolean ou Mulot.   
     */
    public ElementPile (int type, Object valeur)
    {
        _type = type ;
        _valeur = valeur ;
    }

    /**
     * Donne le type d'un �l�ment.
     *
     * @return ENTIER, BOOLEEN ou MULOT.
     */
    public int getType ()
    {
        return _type ;
    }

    /**
     * Donne la valeur de l'�l�ment. En utilisant getType (), on peut faire
     * le cast appropri�.
     *
     * @return un objet Integer, Boolean ou Mulot.
     */
    public Object getValeur ()
    {
        return _valeur ;
    }
}
