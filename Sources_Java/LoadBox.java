import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.Dialog ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Label ;
import java.awt.Panel ;
import java.awt.TextArea ;
import java.awt.TextField ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.File ;
import java.io.RandomAccessFile ;

/**
 * Boîte de dialogue permettant de saisir le nom d'un fichier en vue de son 
 * chargement ou d'une sauvegarde. Cette boîte conserve le nom du dernier 
 * fichier accédé d'un appel à l'autre.
 *
 * @author Erwan Prioul
 * $RCSfile: LoadBox.java,v $:$Revision: 1.6 $
 */
public class LoadBox 
    extends 
	FrameDialog
    implements 
        MulotSrc, 
        ActionListener,
        Runnable
{
    private Button     _ok ;
    private Button     _cancel ;
    private TextField  _url ;
    private TextArea   _edit ;
    private TextArea   _error ;
    private boolean    _load ;


    private Thread     exec ;
    private String     _msg ;

    /**
     * Initialisation de la boîte.
     * 
     * @param edit zone de texte o&ugrave; écrire ou lire les 
     *             données.
     * @param error zone de texte d'erreur.
     */
    public LoadBox (
        TextArea edit,
        TextArea error)
    {
      super ("Gestion de fichiers") ;
      Label l ;
      Panel p, q, r ;
      
      _edit = edit ;
      _error = error ;
      

        l = new Label ("Fichier : ") ;
        _url = new TextField (50) ;
        _url.addActionListener (this) ;
        _ok = new Button ("Ok") ;
        _ok.addActionListener (this) ;
        _cancel = new Button ("Annuler") ;
        _cancel.addActionListener (this) ;
        p = new Panel () ;
        p.setLayout (new BorderLayout (5, 5)) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q.add (_ok) ;
        q.add (_cancel) ;
        p.add ("South", q) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        r = new Panel () ;
        r.setLayout (new BorderLayout (5, 5)) ;
        r.add ("West", l) ;
        r.add ("East", _url) ;
        q.add (r) ;
        p.add ("North", q) ;
        add (p) ;
	pack ();
        this.setResizable (false) ;
	show ();
    }

    /**
     * Ecoute d'événements. Dans le cas d'une annulation, la 
     * boîte est "cachée" sans autre action. En cas de validation, 
     * la lecture ou l'écriture du fichier est tentée. Au moindre 
     * probl&egrave;me, un message s'affiche.
     * 
     * @param événement.
     */
    public void actionPerformed (ActionEvent e)
    {
        String s ;
        File fexists ;
        RandomAccessFile f ;
        MsgBox box ;

        if ((e.getSource () == _ok) || (e.getSource () == _url))
        {
            if (_load)
            {
                try {
                    fexists = new File (_url.getText ()) ;
                    if ((fexists.exists ()) && (fexists.isFile ()))
                    {
                        f = new RandomAccessFile (fexists, "r") ;
                        f.seek (0) ;
                        _edit.setText ("") ;
                        s = f.readLine () ;
                        while (null != s)
                        {
                            if ((0 != s.length ()) &&  ('\r' == s.charAt (s.length () - 1)))
                                _edit.append (
                                    s.substring (0, s.length () - 1) + 
                                    "\n") ;
                            else
                                _edit.append (s + "\n") ;
                            s = f.readLine () ;
                        }
                        f.close () ;
                        _error.setText ("") ;
                        this.setVisible (false) ;
                        libere () ;
                    }
                    else
                    {
                        _msg = new String (
                            "Fichier inexistant ou illisible : " + 
                            _url.getText ()) ;
                        exec = new Thread (this) ;
                        exec.start () ;
                    }
                }
                catch (Exception ex)
                {
                        _msg = new String (
                            "Problème lors de la lecture (" +
                            _url.getText () +
                            ") : " + 
                            ex) ;
                        exec = new Thread (this) ;
                        exec.start () ;
                }
            }
            else
            {
                try {
                    fexists = new File (_url.getText ()) ;
                    if ((fexists.exists ()) && (fexists.isFile ()))
                        fexists.delete () ;
                    f = new RandomAccessFile (fexists, "rw") ;
                    f.seek (0) ;
                    f.writeBytes (_edit.getText ()) ;
                    f.close () ;
                    _error.setText ("") ;
                    this.setVisible (false) ;
                    libere () ;
                }
                catch (Exception ex)
                {
                    _msg = new String (
                        "Sauvegarde impossible : " + 
                        _url.getText ()) ;
                    exec = new Thread (this) ;
                    exec.start () ;
                }
            }
        }
        if (e.getSource () == _cancel)
        {
            this.setVisible (false) ;
            libere () ;
        }
    }
    
    /**
     * Détermine l'état de la boîte : chargement ou sauvegarde.
     * 
     * @param value <CODE>true</CODE> pour une boîte de chargement, 
     *              <CODE>false</CODE> pour une boîte de sauvegarde..
     */
    public void setLoad (boolean value)
    {
        _load = value ;
    }

    public void run ()
    {
        MsgBox box ;

        setEtat (false) ;
        box = new MsgBox (_msg) ;
        box.attente () ;
        setEtat (true) ;
    }

    private void setEtat (boolean valeur)
    {
        _url.setEnabled (valeur) ;
        _cancel.setEnabled (valeur) ;
        _ok.setEnabled (valeur) ;
    }
}
