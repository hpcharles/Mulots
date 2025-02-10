import java.lang.String ;

/**
 * Elément de la pile d'exécution : entier ou Mulot...
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
     * Initialisation d'un élément de pile à partir de son type (ENTIER, 
     * BOOLEEN ou MULOT) et de la valeur associée (objet Integer ou Mulot).
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
     * Donne le type d'un élément.
     *
     * @return ENTIER, BOOLEEN ou MULOT.
     */
    public int getType ()
    {
        return _type ;
    }

    /**
     * Donne la valeur de l'élément. En utilisant getType (), on peut faire
     * le cast approprié.
     *
     * @return un objet Integer, Boolean ou Mulot.
     */
    public Object getValeur ()
    {
        return _valeur ;
    }
}
