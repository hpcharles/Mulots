import java.awt.Frame ;

/**
 * Exécution des mulots en tant qu'application.
 *
 * @author Erwan Prioul
 * $RCSfile: MlTappli.java,v $:$Revision: 1.2 $
 */
public class MlTappli 
    implements
        MulotSrc
{
    /**
     * Initialisation de l'application.
     */
    public static void main (String [] args)
    {
        MulotPanel panel ;
        Frame f ;
        Parameters params ;

        params = new Parameters () ;
        params.getParameters () ;

        f = new Frame (MULOTTITLE) ;
        panel = new MulotPanel (f, params) ;
        f.add (panel) ;
        f.pack () ;
        f.setResizable (false) ;
        f.show () ;        
    }
} 
