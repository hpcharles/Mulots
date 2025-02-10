import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Label ;
import java.awt.Panel ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

/**
 * Boîte de dialogue pour l'affichage de messages d'erreur. 
 *
 * @author Erwan Prioul
 * $RCSfile: MsgBox.java,v $:$Revision: 1.5 $
 */
public class MsgBox 
    extends 
        FrameDialog
    implements 
        ActionListener
{
    private Button _ok ;

    /**
     * Création de la boîte de dialogue. Cette bo&icirc;te ne contient que du texte et
     * un bouton permettant de fermer la fenêtre.
     *
     * @param parent Frame qui supporte la bo&icirc;te.
     * @param msg message à afficher.
     */
    public MsgBox (String msg)
    {
      super ("Message");
      Panel p, q ;
      Label l ;
        
        p = new Panel () ;
        p.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (msg) ;
        l.setAlignment (Label.CENTER) ;
        p.add ("North", l) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        _ok = new Button ("Ok") ;
        _ok.addActionListener (this) ;
        q.add (_ok) ;
        p.add ("South", q) ;
        add (p) ;
	pack();
        this.setResizable (false) ;
	show ();
    }

    /**
     * Affectation d'une action à un évènement. Dans le cas présent, seul le 
     * bouton est à l'écoute des évènements. Cliquer sur celui-ci ferme la 
     * fenêtre.
     *
     * @param e évènement rélévé par l'un des objets à l'écoute.
     */
    public void actionPerformed (ActionEvent e)
    {
      bye ();
    }
}
