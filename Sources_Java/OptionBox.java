import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.Checkbox ;
import java.awt.CheckboxGroup ;
import java.awt.Choice ;
import java.awt.Dialog ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.GridLayout ;
import java.awt.Label ;
import java.awt.Panel ;
import java.awt.TextArea ;
import java.awt.TextField ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

/**
 * Bo&icirc;te de dialogue permettant le param&egrave;trage de l'application.
 *
 * @author Erwan Prioul
 * $RCSfile: OptionBox.java,v $:$Revision: 1.5 $
 */
public class OptionBox
    extends 
        FrameDialog
    implements 
        MulotSrc, 
        ActionListener
{
    private Button        _ok ;
    private Button        _cancel ;
    private TextField     _nblignesed ;
    private TextField     _nblignesmsg ;
    private TextField     _nbcolonnes ;
    private TextField     _largeurzone ;
    private TextField     _hauteurzone ;
    private TextField     _largeuraff ;
    private TextField     _hauteuraff ;
    private TextField     _attente ;
    private Choice        _couleur ;
    private CheckboxGroup _cbgrp ;
    private Parameters    _parametres ;

    /**
     * Initialisation de la bo&icirc;te de dialogue.
     */
    public OptionBox ()
    {
        super ("Paramétrage") ;
        
        Label l ;
        Panel p, q, r, s, t ;
        Checkbox cb ;
        Couleur c ;

        _parametres = new Parameters () ;
        _parametres.getParameters () ;
        
        p = new Panel () ;
        p.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q = new Panel () ;
        q.setLayout (new BorderLayout (5, 5)) ;
        r = new Panel () ;
        r.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        l = new Label (
            "N.B. : les changements seront effectifs à la prochaine exécution " +
            "de l'application.") ;
        l.setAlignment (Label.CENTER) ;
        r.add (l) ;       
        q.add ("South", r) ;
        r = new Panel () ;
        r.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        _ok = new Button ("Valider") ;
        _ok.addActionListener (this) ;
        r.add (_ok) ;
        _cancel = new Button ("Annuler") ;
        _cancel.addActionListener (this) ;
        r.add (_cancel) ;
        q.add ("Center", r) ;
        r = new Panel () ;
        r.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        t = new Panel () ;
        t.setLayout (new GridLayout (13, 1, 5, 5)) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (NBLIGNESEDITEUR) ;
        s.add ("West", l) ;
        _nblignesed = new TextField (5) ;
        _nblignesed.setText (String.valueOf (_parametres.getLigneEd ())) ;
        s.add ("East", _nblignesed) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (NBLIGNESMSG) ;
        s.add ("West", l) ;
        _nblignesmsg = new TextField (5) ;
        _nblignesmsg.setText (String.valueOf (_parametres.getLigneMsg ())) ;
        s.add ("East", _nblignesmsg) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (NBCOLONNES) ;
        s.add ("West", l) ;
        _nbcolonnes = new TextField (5) ;
        _nbcolonnes.setText (String.valueOf (_parametres.getColonne ())) ;
        s.add ("East", _nbcolonnes) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (LGZONE) ;
        s.add ("West", l) ;
        _largeurzone = new TextField (5) ;
        _largeurzone.setText (String.valueOf (_parametres.getZoneX ())) ;
        s.add ("East", _largeurzone) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (HTZONE) ;
        s.add ("West", l) ;
        _hauteurzone = new TextField (5) ;
        _hauteurzone.setText (String.valueOf (_parametres.getZoneY ())) ;
        s.add ("East", _hauteurzone) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (LGAFF) ;
        s.add ("West", l) ;
        _largeuraff = new TextField (5) ;
        _largeuraff.setText (String.valueOf (_parametres.getAffX ())) ;
        s.add ("East", _largeuraff) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (HTAFF) ;
        s.add ("West", l) ;
        _hauteuraff = new TextField (5) ;
        _hauteuraff.setText (String.valueOf (_parametres.getAffY ())) ;
        s.add ("East", _hauteuraff) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (LIBATTENTE) ;
        s.add ("West", l) ;
        _attente = new TextField (5) ;
        _attente.setText (String.valueOf (_parametres.getWait ())) ;
        s.add ("East", _attente) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        l = new Label (LIBCOULEURFOND) ;
        s.add ("West", l) ;
        _couleur = new Choice () ;
        c = new Couleur () ;
        while (! c.isEnd ())
            _couleur.addItem (c.nextColor ()) ;
        _couleur.select (_parametres.getIndexColor ()) ;
        s.add ("East", _couleur) ;
        t.add (s) ;
        l = new Label (AFFICHAGE) ;
        t.add (l) ;
        _cbgrp = new CheckboxGroup () ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        cb = new Checkbox (
            AFFTYPE1, 
            _cbgrp, 
            (TWOWINDOWS == _parametres.getWindows ())) ;
        s.add ("West", cb) ;
        l = new Label (LIBAFFTYPE1) ;
        s.add ("Center", l) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        cb = new Checkbox (
            AFFTYPE2, 
            _cbgrp, 
            (ONEWINDOWEAST == _parametres.getWindows ())) ;
        s.add ("West", cb) ;
        l = new Label (LIBAFFTYPE2) ;
        s.add ("Center", l) ;
        t.add (s) ;
        s = new Panel () ;
        s.setLayout (new BorderLayout (5, 5)) ;
        cb = new Checkbox (
            AFFTYPE3, 
            _cbgrp, 
            (ONEWINDOWSOUTH == _parametres.getWindows ())) ;
        s.add ("West", cb) ;
        l = new Label (LIBAFFTYPE3) ;
        s.add ("Center", l) ;
        t.add (s) ;
        r.add (t) ;
        q.add ("North", r) ;
        p.add (q) ;
        add (p) ;
	pack ();
        this.setResizable (false) ;
	show ();
    }

    /**
     * Ecoute d'&eacute;v&eacute;nements. En cas de validation, on proc&egrave;de 
     * &agrave; une v&eacute;rification des donn&eacute;es puis &agrave; leur 
     * sauvegarde.
     * 
     * @param &eacute;v&eacute;nement.
     */
    public void actionPerformed (ActionEvent e)
    {
        Couleur c ;
        
        if (e.getSource () == _ok)
        {
            c = new Couleur () ;
            try {
                _parametres.setLigneEd (
                    (new Integer (_nblignesed.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setLigneMsg (
                    (new Integer (_nblignesmsg.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setColonne (
                    (new Integer (_nbcolonnes.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setZoneX (
                    (new Integer (_largeurzone.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setZoneY (
                    (new Integer (_hauteurzone.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setAffX (
                    (new Integer (_largeuraff.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setAffY (
                    (new Integer (_hauteuraff.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setWait (
                    (new Integer (_attente.getText ())).intValue ()) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setIndexColor (c.getValue (_couleur.getSelectedItem ())) ;
            }
            catch (Exception ex) { }
            try {
                _parametres.setWindows (
                    (new Integer ((_cbgrp.getSelectedCheckbox ()).getLabel ())).intValue ()) ;
            }
            catch (Exception ex) { }
            _parametres.check () ;
            _parametres.setParameters () ;
        }
	bye ();
    }
}
