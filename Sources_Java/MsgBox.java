import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Label ;
import java.awt.Panel ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

/**
 * Bo�te de dialogue pour l'affichage de messages d'erreur. 
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
     * Cr�ation de la bo�te de dialogue. Cette bo&icirc;te ne contient que du texte et
     * un bouton permettant de fermer la fen�tre.
     *
     * @param parent Frame qui supporte la bo&icirc;te.
     * @param msg message � afficher.
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
     * Affectation d'une action � un �v�nement. Dans le cas pr�sent, seul le 
     * bouton est � l'�coute des �v�nements. Cliquer sur celui-ci ferme la 
     * fen�tre.
     *
     * @param e �v�nement r�l�v� par l'un des objets � l'�coute.
     */
    public void actionPerformed (ActionEvent e)
    {
      bye ();
    }
}
