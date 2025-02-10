import java.awt.Button ;
import java.awt.Dialog ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Panel ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

/**
 * Bo&icirc;te de dialogue simple avec un bouton.
 *
 * @author Erwan Prioul
 * $RCSfile: WaitBox.java,v $:$Revision: 1.4 $
 */
public class WaitBox 
    extends 
        FrameDialog
    implements 
        MulotSrc, 
        ActionListener
{
    private Button _ok ;

    /**
     * Initialisation de la bo&icirc;te.
     * 
     * @param parent Frame qui supporte la bo&icirc;te.
     */
    public WaitBox (Frame parent)
    {
        super ("Pause") ;
        
        Panel p ;
        _ok = new Button ("     Oui     ") ;
        _ok.addActionListener (this) ;
        p = new Panel () ;
        p.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        p.add (_ok) ;
        add (p) ;
	pack ();
        setResizable (false) ;
	show ();
    }

    /**
     * Ecoute d'&eacute;v&eacute;nements.
     * 
     * @param &eacute;v&eacute;nement.
     */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource () == _ok)
        {
	  bye ();
        }
    }
}
