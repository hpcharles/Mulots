import java.awt.Color ;
import java.awt.Graphics ;
import java.awt.Point ;
import java.awt.Polygon ;
import java.util.Observable ;
import java.util.Observer ;

/**
 * Gestion de mulots. Les mulots sont librement inspirés des tortues du Logo.
 * Cela signifie qu'un mulot peut être dirigé par des primitives simples
 * au nombre de quatre : avance, tourne, leve, baisse. Ces primitives 
 * permettent de dessiner. Les mulots sont une évolution des tortues. La
 * différence majeure est que les mulots ont chacun une couleur propre.
 *
 * @author Erwan Prioul
 * $RCSfile: Mulot.java,v $:$Revision: 1.2 $
 */
public class Mulot 
    implements 
        Observer,
        MulotSrc
{
    private Color _peau ;
    private Point _origine = null ;
    private Point _position ;
    private Angle _alpha ;
    private boolean _ossol ;
    private Observe _observable ;

    /**
     * Définit un mulot levé, pointé vers le bas (270°), noir et centré.
     */
    public Mulot ()
    {
        _ossol = false ;
        _alpha = new Angle (180 - Angle.BAS) ;
        _peau = Color.black ;
        _position = new Point (MulotSrc.WIDTH / 2, MulotSrc.HEIGHT / 2) ;
        _observable = new Observe () ;
    }

    /**
     * Définit un mulot levé, pointé vers le bas (270°) et noir. Le mulot
     * est positionné selon les coordonnées fournies.
     *
     * @param x abscisse du mulot.
     * @param y ordonnée du mulot.
     */
    public Mulot (int x, int y)
    {
        _ossol = false ;
        _alpha = new Angle (180 - Angle.BAS) ;
        _peau = Color.black ;
        _position = new Point (x, y) ;
        _observable = new Observe () ;
    }

    /**
     * Définit un mulot levé et pointé vers le bas (270°). Le mulot
     * est positionné selon les coordonnées fournies et est de la couleur
     * donnée.
     *
     * @param x abscisse du mulot.
     * @param y ordonnée du mulot.
     * @param peau couleur du mulot.
     */
    public Mulot (int x, int y, Color peau)
    {
        _ossol = false ;
        _alpha = new Angle (180 - Angle.BAS) ;
        _peau = peau ;
        _position = new Point (x, y) ;
        _observable = new Observe () ;
    }

    /**
     * Définit un mulot levé. Le mulot
     * est positionné selon les coordonnées fournies, est de la couleur
     * donnée et a l'orientation donnée.
     *
     * @param x abscisse du mulot.
     * @param y ordonnée du mulot.
     * @param peau couleur du mulot.
     * @param alpha angle du mulot.
     */
    public Mulot (int x, int y, Color peau, int alpha)
    {
        _ossol = false ;
        _alpha = new Angle (180 - alpha) ;
        _peau = peau ;
        _position = new Point (x, y) ;
        _observable = new Observe () ;
    }

    /**
     * Fait tourner le mulot dans le sens trigonométrique selon un angle en 
     * degré.
     *
     * @param alpha angle de rotation en degré.
     */
    public void tourne (int alpha)
    {
        _alpha.rotate (-alpha) ;
        _observable.setChanged () ;
        _observable.notifyObservers (this) ;
    }

    /**
     * Fait avancer le mulot tout droit, selon son orientation.
     *
     * @param pas distance à parcourir par le mulot.
     */
    public void avance (int pas)
    {
        _origine = new Point () ;
        _origine.x = _position.x ;
        _origine.y = _position.y ;
        _position.x -= (int) (pas * Math.cos (_alpha.getValeur ())) ;
        _position.y -= (int) (pas * Math.sin (_alpha.getValeur ())) ;
        _observable.setChanged () ;
        _observable.notifyObservers (this) ;
    }

    /**
     * Affichage du mulot. Le mulot est dessiné dans une zone graphique. Selon
     * l'état du mulot, levé ou baissé, son affichage est différent. Quand le
     * mulot est levé, seul son contour est affiché, par contre s'il est posé
     * le dessin est plein.
     *
     * @param g zone graphique où dessiner le mulot.
     */
    public void curseur (Graphics g)
    {
        Polygon p ;
        Angle a ;

        p = new Polygon () ;
        a = new Angle (_alpha) ;
        a.rotate (90) ;
        p.addPoint (
            (int) (_position.x - ((double) 5) * Math.cos (a.getValeur ())),
            (int) (_position.y - ((double) 5) * Math.sin (a.getValeur ()))) ;
        p.addPoint (
            (int) (_position.x - 
                ((double) 10) * Math.cos (_alpha.getValeur ())),
            (int) (_position.y - 
                ((double) 10) * Math.sin (_alpha.getValeur ()))) ;
        a.rotate (180) ;
        p.addPoint (
            (int) (_position.x - ((double) 5) * Math.cos (a.getValeur ())),
            (int) (_position.y - ((double) 5) * Math.sin (a.getValeur ()))) ;
        g.setColor (_peau) ;
        if (_ossol)
            g.fillPolygon (p) ;
        else
            g.drawPolygon (p) ;
    }

    /**
     * Baisse le mulot. En baissant le mulot, il laissera une trace de ses 
     * prochains déplacements.
     */
    public void baisse ()
    {
        _ossol = true ;
    }

    /**
     * Lève le mulot. Lorsque le mulot est levé, il ne laisse aucune trace
     * lorsqu'il se déplace.
     */
    public void leve ()
    {
        _ossol = false ;
    }

    /**
     * Donne les coordonnées courantes du mulot. 
     *
     * @return coordonnées du mulot.
     */
    public Point getPosition ()
    {
        return _position ;
    }

    /**
     * Donne les coordonnées du mulot avant son dernier déplacement. 
     *
     * @return coordonnées du mulot, à la position précédente.
     */
    public Point getOrigine ()
    {
        if (null != _origine)
            return _origine ;
        else
            return _position ;
    }

    /**
     * Permet de savoir si le mulot est baissé ou levé.
     *
     * @return <CODE>true</CODE> si le mulot est posé ;
     *         <CODE>false</CODE> sinon.
     */
    public boolean isOnFloor ()
    {
        return _ossol ;
    }

    /**
     * Donne la couleur du mulot.
     *
     * @return la couleur du mulot.
     */
    public Color getColor ()
    {
        return _peau ;
    }

    /**
     * Permet de définir quels sont les observateurs.
     *
     * @return les observateurs.
     */
    public Observable observable ()
    {
        return _observable ;
    }

    /**
     * Cette méthode est invoquée lorsqu'un des objets observés à été
     * modifiés. Dans le cas présent, il s'agit de la zone graphique qui
     * informe qu'il est necessaire de redessiner le mulot.
     *
     * @param o observateurs.
     * @param zoneG objet observé.
     */
    public void update (Observable o, Object zoneG) 
    {
        this.curseur (((ImageMulot) zoneG).getGraphics ()) ;
    }
}
