/**
 * Gestion des angles g�om�triques. Cette classe permet de manipuler des angles 
 * en degr� selon le sens trigonom�trique.
 *
 * @author Erwan Prioul
 * $RCSfile: Angle.java,v $:$Revision: 1.2 $
 */
public class Angle
{
    private final static double _MAX = 360 ;

    public final static int BAS = 270 ;

    private double _alpha ;

    /**
     * Construction de l'angle � partir de la donn�e fournie.
     *
     * @param alpha valeur initiale de l'angle.
     */
    public Angle (int alpha)
    {
        _alpha = alpha % _MAX ;
    }

    /**
     * Construction de l'angle � partir d'un angle existant.
     *
     * @param alpha angle existant.
     */
    public Angle (Angle alpha)
    {
        _alpha = alpha._alpha ;
    }

    /**
     * Donne la valeur de l'angle en radian.
     *
     * @return valeur de l'angle en radian.
     */
    public double getValeur ()
    {
        return (_alpha * Math.PI) / (_MAX / 2) ;
    }

    /**
     * Modifie l'angle par rotation. La valeur de l'angle est modfi�e
     * en fonction de la valeur fournie.
     *
     * @param alpha valeur de la rotation en degr�.
     */
    public void rotate (int alpha)
    {
        _alpha = (_alpha + alpha) % _MAX ;
    }
}
