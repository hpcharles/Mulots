import java.awt.Color ;

/**
 * Correspondance des couleurs définies pour les mulots (entier) et celle
 * de java (Color).
 *
 * @author Erwan Prioul
 * $RCSfile: Couleur.java,v $:$Revision: 1.2 $
 */
public class Couleur
    implements
        MulotSrc
{
    private int       _indice ;
    private Color []  _tColor ;
    private String [] _tString ;
    
    /**
     * Constructeur de base.
     */
    public Couleur ()
    {
        int i ;
        
        _indice = 0 ;
        _tColor = new Color [NBCOLOR] ;
        _tString = new String [NBCOLOR] ;

        for (i = 0 ; i < NBCOLOR ; i ++)
        {
            switch (i)
            {
            case WHITE     :
                _tColor [i] = Color.white ;
                _tString [i] = LIBWHITE ;
                break ;
            case BLACK     :
                _tColor [i] = Color.black ;
                _tString [i] = LIBBLACK ;
                break ;
            case BLUE      :
                _tColor [i] = Color.blue ;
                _tString [i] = LIBBLUE ;
                break ;
            case CYAN      :
                _tColor [i] = Color.cyan ;
                _tString [i] = LIBCYAN ;
                break ;
            case DARKGRAY  :
                _tColor [i] = Color.darkGray ;
                _tString [i] = LIBDARKGRAY ;
                break ;
            case GRAY      :
                _tColor [i] = Color.gray ;
                _tString [i] = LIBGRAY ;
                break ;
            case LIGHTGRAY :
                _tColor [i] = Color.lightGray ;
                _tString [i] = LIBLIGHTGRAY ;
                break ;
            case GREEN     :
                _tColor [i] = Color.green ;
                _tString [i] = LIBGREEN ;
                break ;
            case MAGENTA   :
                _tColor [i] = Color.magenta ;
                _tString [i] = LIBMAGENTA ;
                break ;
            case ORANGE    :
                _tColor [i] = Color.orange ;
                _tString [i] = LIBORANGE ;
                break ;
            case PINK      :
                _tColor [i] = Color.pink ;
                _tString [i] = LIBPINK ;
                break ;
            case RED       :
                _tColor [i] = Color.red ;
                _tString [i] = LIBRED ;
                break ;
            case YELLOW    :
                _tColor [i] = Color.yellow ;
                _tString [i] = LIBYELLOW ;
                break ;
            }
        }
    }

    /**
     * Statue sur la position de l'indice des couleurs.
     *
     * @return <CODE>true</CODE> si la derni&egrave;re couleur est atteinte, 
     * <CODE>false</CODE> sinon.
     */
    public boolean isEnd ()
    {
        return NBCOLOR <= _indice ;
    }
    
    /**
     * Donne la repr&eacute;sentation en cha&icirc;ne de la couleur courante et 
     * passe &agrave; la suivante.
     *
     * @return la repr&eacute;sentation en cha&icirc;ne de la couleur courante.
     */
    public String nextColor ()
    {
        String s ;
        
        _indice ++ ;
        if (NBCOLOR < _indice)
            return new String ("") ;
        return _tString [_indice - 1] ;
    }
    
    /**
     * Replace l'indice &agrave; zero.
     */
    public void raz ()
    {
        _indice = 0 ;
    }
    
    /**
     * Donne la correspondance enti&egrave;re d'une couleur Mulot &agrave; 
     * partir de la repr&eacute;sentation en cha&icirc;ne.
     *
     * @param color une couleur mulot sous forme de cha&icirc;ne (String)
     * @return une couleur Mulot (entier)
     */
    public int getValue (String color)
    {
        int i ;
        
        i = getIndice (color) ;
        if (NBCOLOR <= i)
            return WHITE ;
        return i ;
    }
    
    /**
     * Donne la couleur java correspondant &agrave; une couleur Mulot...
     *
     * @param color une couleur mulot (entier)
     * @return une couleur java (Color)
     */
    public Color getColor (int color)
    {
        if (NBCOLOR <= color)
            return _tColor [0] ;
        return _tColor [color] ;
    }

    /**
     * Donne la couleur java correspondant &agrave; une couleur Mulot...
     *
     * @param color une couleur mulot sous forme de cha&icirc;ne (String)
     * @return une couleur java (Color)
     */
    public Color getColor (String color)
    {
        return getColor (getIndice (color)) ;
    }

    /**
     * Donne la correspondance enti&egrave;re d'une couleur Mulot &agrave; 
     * partir de la repr&eacute;sentation en cha&icirc;ne.
     *
     * @param color une couleur mulot sous forme de cha&icirc;ne (String)
     * @return une couleur Mulot (entier)
     */
    private int getIndice (String color)
    {
        int i ;
        
        i = 0 ;
        while ((NBCOLOR > i) && (! _tString [i].equals (color)))
            i ++ ;
        return i ;
    }
}
