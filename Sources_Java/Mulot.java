import java.awt.Color ;
import java.awt.Graphics ;
import java.awt.Point ;
import java.awt.Polygon ;
import java.util.Observable ;
import java.util.Observer ;

/**
 * Gestion de mulots. Les mulots sont librement inspir�s des tortues du Logo.
 * Cela signifie qu'un mulot peut �tre dirig� par des primitives simples
 * au nombre de quatre : avance, tourne, leve, baisse. Ces primitives 
 * permettent de dessiner. Les mulots sont une �volution des tortues. La
 * diff�rence majeure est que les mulots ont chacun une couleur propre.
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
     * D�finit un mulot lev�, point� vers le bas (270�), noir et centr�.
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
     * D�finit un mulot lev�, point� vers le bas (270�) et noir. Le mulot
     * est positionn� selon les coordonn�es fournies.
     *
     * @param x abscisse du mulot.
     * @param y ordonn�e du mulot.
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
     * D�finit un mulot lev� et point� vers le bas (270�). Le mulot
     * est positionn� selon les coordonn�es fournies et est de la couleur
     * donn�e.
     *
     * @param x abscisse du mulot.
     * @param y ordonn�e du mulot.
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
     * D�finit un mulot lev�. Le mulot
     * est positionn� selon les coordonn�es fournies, est de la couleur
     * donn�e et a l'orientation donn�e.
     *
     * @param x abscisse du mulot.
     * @param y ordonn�e du mulot.
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
     * Fait tourner le mulot dans le sens trigonom�trique selon un angle en 
     * degr�.
     *
     * @param alpha angle de rotation en degr�.
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
     * @param pas distance � parcourir par le mulot.
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
     * Affichage du mulot. Le mulot est dessin� dans une zone graphique. Selon
     * l'�tat du mulot, lev� ou baiss�, son affichage est diff�rent. Quand le
     * mulot est lev�, seul son contour est affich�, par contre s'il est pos�
     * le dessin est plein.
     *
     * @param g zone graphique o� dessiner le mulot.
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
     * prochains d�placements.
     */
    public void baisse ()
    {
        _ossol = true ;
    }

    /**
     * L�ve le mulot. Lorsque le mulot est lev�, il ne laisse aucune trace
     * lorsqu'il se d�place.
     */
    public void leve ()
    {
        _ossol = false ;
    }

    /**
     * Donne les coordonn�es courantes du mulot. 
     *
     * @return coordonn�es du mulot.
     */
    public Point getPosition ()
    {
        return _position ;
    }

    /**
     * Donne les coordonn�es du mulot avant son dernier d�placement. 
     *
     * @return coordonn�es du mulot, � la position pr�c�dente.
     */
    public Point getOrigine ()
    {
        if (null != _origine)
            return _origine ;
        else
            return _position ;
    }

    /**
     * Permet de savoir si le mulot est baiss� ou lev�.
     *
     * @return <CODE>true</CODE> si le mulot est pos� ;
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
     * Permet de d�finir quels sont les observateurs.
     *
     * @return les observateurs.
     */
    public Observable observable ()
    {
        return _observable ;
    }

    /**
     * Cette m�thode est invoqu�e lorsqu'un des objets observ�s � �t�
     * modifi�s. Dans le cas pr�sent, il s'agit de la zone graphique qui
     * informe qu'il est necessaire de redessiner le mulot.
     *
     * @param o observateurs.
     * @param zoneG objet observ�.
     */
    public void update (Observable o, Object zoneG) 
    {
        this.curseur (((ImageMulot) zoneG).getGraphics ()) ;
    }
}
