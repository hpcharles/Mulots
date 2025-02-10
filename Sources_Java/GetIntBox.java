import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.Dialog ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Panel ;
import java.awt.TextField ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

/**
 * Boîte de saisie d'un entier.
 *
 * @author Erwan Prioul
 * $RCSfile: GetIntBox.java,v $:$Revision: 1.4 $
 */
public class GetIntBox 
    extends 
        FrameDialog
    implements 
        MulotSrc, 
        ActionListener
{
    private Button    _ok ;
    private TextField _edit ;
    private Entier    _value ;

    /**
     * Initialisation de la boîte.
     * 
     * @param parent Frame qui supporte la boîte.
     * @param value Entier pour lequel il faut déterminer la valeur.
     */
    public GetIntBox (Frame parent, Entier value)
    {
        super ("Saisie") ;
        
        Panel p, q ;

        _value = value ;
        
        p = new Panel () ;
        p.setLayout (new BorderLayout (5, 5)) ;
        _edit = new TextField ("", 5) ;
        _edit.addActionListener (this) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q.add (_edit) ;
        p.add ("West", q) ;
        _ok = new Button (" Ok ") ;
        _ok.addActionListener (this) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q.add (_ok) ;
        p.add ("Center", q) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q.add (p) ;
        add (q) ;
	pack ();
        this.setResizable (false) ;
	show ();
    }

    /**
     * Ecoute d'événements. Dans le cas présent, il s'agit 
     * de la validation de la saisie. Si la saisie est incorrecte, la valeur 
     * &agrave; déterminer est mise &agrave; 0.
     * 
     * @param événement.
     */
    public void actionPerformed (ActionEvent e)
    {
        int value ;
        
        if ((e.getSource () == _ok) || (e.getSource () == _edit))
        {
            try
            {
                value = (new Integer (_edit.getText ())).intValue () ;
            }
            catch (Exception ex)
            {
                value = 0 ;
            }
            _value.setValue (value) ;
	    bye ();
        }
    }
}
