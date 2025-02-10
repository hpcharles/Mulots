import java.util.Observable ;
import java.util.Observer ;

/**
 * Surcharge de la classe Observable pour rendre deux méthodes publiques :
 * clearChanged () et setChanged ().
 *
 * @author Erwan Prioul
 * $RCSfile: Observe.java,v $:$Revision: 1.2 $
*/
public class Observe
    extends
        Observable
{
    public void clearChanged ()
    {
        super.clearChanged () ;
    }

    public void setChanged ()
    {
        super.setChanged () ;
    }
}
