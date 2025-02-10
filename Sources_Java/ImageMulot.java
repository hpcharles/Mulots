import java.awt.Color ;
import java.awt.Component ;
import java.awt.Dimension ;
import java.awt.Graphics ;
import java.awt.Image ;
import java.awt.Panel ;
import java.awt.Point ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.event.ComponentEvent ;
import java.awt.event.ComponentAdapter ;
import java.lang.Thread ;
import java.util.Observable ;
import java.util.Observer ;

/**
 * Définit un panneau pour l'affichage des mulots. Cette surcharge permet de
 * contraindre le panneau à une certaine dimension.
 *
 * @author Erwan Prioul
 * $RCSfile: ImageMulot.java,v $:$Revision: 1.3 $
 */
public class ImageMulot
    extends
        Panel
    implements
        Observer,
        MulotSrc
{
    private Image     _image = null ;
    private Dimension _dim ;
    private Observe   _observable ;
    private Color     _couleurFond ;
    private int       _delai ;

    /**
     * Construction du panneau. Les dimensions du panneau sont définies à
     * partir des données fournies. On donne également la couleur de fond
     * de la zone graphique et le nombre de millisecondes entre chaque
     * rafraichissement.
     *
     * @param largeur largeur du panneau.
     * @param hauteur hauteur du panneau.
     * @param couleurFond couleur de fond.
     * @param delai nombre de millisecondes d'attentes.
     */
    public ImageMulot (int largeur, int hauteur, int couleurFond, int delai)
    {
        Couleur c ;
        
        c = new Couleur () ;
        _dim = new Dimension (largeur, hauteur) ;
        _observable = new Observe () ;
        _couleurFond = c.getColor (couleurFond) ;
        _delai = delai ;
//    	addComponentListener (new ComponentAdapter ()
//    			      {
//    				  public void componentResized (ComponentEvent e)
//    				      {
//    					  retaille ();
//    				      }
//    			      });
    }

    /**
     * Donne les dimensions du panneau.
     *
     * @return les dimensions du panneau.
     */
    public Dimension getPreferredSize ()
    {
        return _dim ;
    } 
    /** 
     * Retaille une nouvelle image lorsque l'utilisateur la redimensionne
     */
    void retaille ()
    {
	Dimension d = getSize ();
	Image newImage = createImage (d.width, d.height) ;
	Graphics g = newImage.getGraphics ();
	g.drawImage (_image, 0, 0, this);
	_image = newImage;
    }
    /**
     * Méthode invoquée lorsqu'un des objets observés est modifié, en 
     * l'occurrence, un mulot qui a bougé.
     *
     * @param o observateurs.
     * @param mulot mulot qui informe qu'il a été modifié.
     */
    public void update (Observable o, Object mulot) 
    {
        Graphics g ;
        Point a , b ;

        if (null == _image)
            _image = this.createImage (_dim.width, _dim.height) ;
            g = _image.getGraphics () ;
        if (((Mulot) mulot).isOnFloor ())
        {
            g.setColor (((Mulot) mulot).getColor ()) ;
            a = ((Mulot) mulot).getOrigine () ;
            b = ((Mulot) mulot).getPosition () ;
            g.drawLine (a.x, a.y, b.x, b.y) ;
        }
        g = this.getGraphics () ;
        g.drawImage (_image, 0, 0, this) ;
        _observable.setChanged () ;
        _observable.notifyObservers (this) ;
        try 
        {
           Thread.sleep (_delai) ;
        }
        catch (Exception e)
        {
        }
    }

    /**
     * Efface la zone graphique. La zone graphique est remplie avec la couleur
     * de fond ce qui donne pour effet "d'effacer" la zone.
     */
    public void clearDrawingArea ()
    {
        Graphics g ;

        g = _image.getGraphics () ; 
        g.setColor (_couleurFond) ;
        g.fillRect (0, 0, _dim.width, _dim.height) ;
        g = this.getGraphics () ;
        g.drawImage (_image, 0, 0, this) ;
        this.repaint () ;
    }

    /**
     * Rafraichissement de l'affichage : on affiche les tracés et les mulots. 
     *
     * @param g zone graphique
     */
    public void paint (Graphics g)
    {
        Graphics graph ;

        if (null == _image)
        {
            _image = this.createImage (_dim.width, _dim.height) ; 
            this.clearDrawingArea () ;
        }
        else
        {
            graph = this.getGraphics () ;
            graph.drawImage (_image, 0, 0, this) ;
        }
        _observable.setChanged () ;
        _observable.notifyObservers (this) ;
    }

    /**
     * Permet de définir les observateurs.
     *
     * @return les observateurs.
     */
    public Observable observable ()
    {
        return _observable ;
    }

    /**
     * 'Supprime' les observateurs. Cela évite de conserver des mulots d'une
     * exécution à l'autre.
     */
    public void initObservers ()
    {
        _observable = new Observe () ;
    }
} 
