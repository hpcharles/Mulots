import java.awt.BorderLayout ;
import java.awt.Button ;
import java.awt.FlowLayout ;
import java.awt.Frame ;
import java.awt.Graphics ;
import java.awt.Image ;
import java.awt.Panel ;
import java.awt.Point ;
import java.awt.ScrollPane ;
import java.awt.TextArea ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.ByteArrayOutputStream ;
import java.io.DataInputStream ;
import java.io.InputStream ;
import java.io.PrintStream ; 
import java.io.StringBufferInputStream ;
import java.lang.String ;
import java.util.Stack ;
import java.util.Vector ;

/**
 * Ce panneau gère l'interface des mulots. L'interface comprend différentes 
 * zones : <BR>
 * une zone d'édition pour saisir les instructions, <BR>
 * une zone d'affichage pour les erreurs et <BR>
 * une zone d'affichage des mulots, cette zone peut &ecirc;tre 'détachée' du panneau au
 * moyen d'une frame pour des raisons de visibilité. <BR>
 * L'interface comprend en plus différents boutons permettant d'exécuter les 
 * instructions, d'effacer la zone graphique, de charger un 
 * fichier d'instructions, de sauvegarder les instructions dans un fichier, de
 * param&egrave;trer l'application ou bien de la quitter.
 *
 * @author Erwan Prioul
 * $Revision: 1.8 $:$RCSfile: MulotPanel.java,v $
 */
public class MulotPanel 
    extends 
        Panel 
    implements 
        MulotSrc, 
        ActionListener,
        Runnable
{
  private Button     _run, _stop, _clear, _load, _save, _options, _quit ;
  private TextArea   _writtingArea ;
  private TextArea   _messageArea ;
  private ImageMulot _zoneG ;
  private LoadBox    _fileBox = null ;
  private Frame      _parent ;
  private Thread     exec;
  private int        runner;
  private final int  RUNINTERPRETEUR=0, 
                     RUNLOAD=1, 
                     RUNSAVE=2, 
                     RUNOPTION=3;
    /**
     * Construction du panneau. Positionne les différents composants du 
     * panneau.
     *
     * @param parent Frame qui contient ce panneau.
     * @param parametres &eacute;l&eacute;ments de param&eacute;trage.
     */
    public MulotPanel (Frame parent, Parameters parametres)
    {
        Panel p, q, r ;
        Frame f ;
        ScrollPane sp ;
        
        _parent = parent ;
        p = new Panel () ;
        p.setLayout (new BorderLayout (5, 5)) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        _run = new Button ("Run !") ;
        q.add (_run) ;
        _run.addActionListener (this) ;
        _stop = new Button ("Stop !") ;
        q.add (_stop) ;
        _stop.addActionListener (this) ;
	_stop.setEnabled (false);
        _clear = new Button ("Clear") ;
        q.add (_clear) ;
        _clear.addActionListener (this) ;
        _load = new Button ("Load") ;
        q.add (_load) ;
        _load.addActionListener (this) ;
        _save = new Button ("Save") ;
        q.add (_save) ;
        _save.addActionListener (this) ;
        _options = new Button ("Options") ;
        q.add (_options) ;
        _options.addActionListener (this) ;
        _quit = new Button ("Quit") ;
        q.add (_quit) ;
        _quit.addActionListener (this) ;
        p.add ("North", q) ;
        _writtingArea = new TextArea (
            "", 
            parametres.getLigneEd (),
            parametres.getColonne (),
            TextArea.SCROLLBARS_BOTH) ;
        p.add ("Center", _writtingArea) ;
        _messageArea = new TextArea (
            "", 
            parametres.getLigneMsg (),
            parametres.getColonne (),
            TextArea.SCROLLBARS_BOTH) ;
        _messageArea.setEditable(false);
        p.add ("South", _messageArea) ;
        q = new Panel () ;
        q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
        q.add (p) ;
        
        _zoneG = new ImageMulot (
            parametres.getZoneX (), 
            parametres.getZoneY (),
            parametres.getIndexColor (),
            parametres.getWait ()) ;
        sp = new ScrollPane (ScrollPane.SCROLLBARS_AS_NEEDED) ;
        sp.setSize (
            parametres.getAffX (),
            parametres.getAffY () ) ;
        sp.add (_zoneG) ;
        switch (parametres.getWindows ())
        {
        case TWOWINDOWS :
            add (q) ;
            f = new Frame () ;
            f.setTitle ("Terrain de jeu pour mulots") ;
            f.add (sp) ;
            f.pack () ;
            f.show () ;
            break ;
        case ONEWINDOWEAST :
            r = new Panel () ;
            r.setLayout (new BorderLayout (5, 5)) ;
            r.add ("West", q) ;
            r.add ("East", sp) ;
            q = new Panel () ;
            q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
            q.add (r) ;
            add (q) ;
            break ;
        case ONEWINDOWSOUTH :
            r = new Panel () ;
            r.setLayout (new BorderLayout (5, 5)) ;
            r.add ("North", q) ;
            r.add ("South", sp) ;
            q = new Panel () ;
            q.setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5)) ;
            q.add (r) ;
            add (q) ;
            break ;
        }
    }

    /**
     * Redessine la zone graphique. La zone graphique affiche l'image des 
     * tracés et les mulots sont dessinés.
     *
     * @param g zone graphique
     */
    public void paint (Graphics g)
    {
        _zoneG.repaint () ;
    }

  /**
   * Un thread multiple qui permet : - de rendre asynchone
   * l'interprétation d'un programme mulot et donc de rajouter un
   * bouton stop -de rendre asychrone Load Save et Options afin de
   * pouvoir se mettre en attente avec une commande bloquante (void
   * FrameDialog.java) 
   */
  public void run()
  {
    switch (runner)
      {
      case RUNINTERPRETEUR:  	runInterpreteur();	break;
      case RUNLOAD:  		runLoad();	  	break;
      case RUNSAVE:  		runSave();	  	break;
      case RUNOPTION:  		runOptions();	  	break;
      default: 	System.out.println("Valeur invalide");
      }
  } /* run */

  void runOptions()
  {
    OptionBox obox ;
        
    setEtat (false);
    _stop.setEnabled (false) ;
    obox = new OptionBox () ;
    obox.attente ();
    setEtat (true);
  } /* runOptions */

  /*
   * Le thread lors de l'interprétation du programe mulot
   */
  public void runInterpreteur()
  {
        MulotLexer lexer ;
        MulotParser parser ;
        ByteArrayOutputStream z ;
        Programme prg ;
        EnvironnementE envE ;
        Stack pile ;

	setEtat (false);
	_messageArea.setText ("") ;
	z = new ByteArrayOutputStream () ;
	_zoneG.initObservers () ;
	try
	  {
	    lexer = new MulotLexer (
              new StringBufferInputStream (
                _writtingArea.getText ())) ;
	    parser = new MulotParser (lexer) ;
	    System.setErr (new PrintStream (z)) ;
	    prg = parser.program () ;
	    _messageArea.setText (z.toString ()) ;
	    if (z.toString ().equals (""))
	      {
		envE = new EnvironnementE (null) ;
		pile = new Stack () ;
		if (! prg.getRI().execute (pile, envE, _zoneG, _parent))
		  _messageArea.setText (DIVISIONBYZERO) ;
		_zoneG.repaint () ;
	      }
	  }
	catch (Exception ex)
	  {
	    System.err.println ("Exception : " + ex) ;
	    _messageArea.setText (z.toString ()) ;
	  }
	setEtat (true);
  } /* runInterpreteur */

  void runSave()
  {
    setEtat (false);
    _stop.setEnabled (false) ;
    if (null == _fileBox)
      {
	_fileBox = new LoadBox (
				_writtingArea, 
				_messageArea) ;
	_fileBox.setLoad (false) ;
      }
    else
      {
	_fileBox.setLoad (false) ;
	_fileBox.setVisible (true) ;
      }
    _fileBox.attente ();
    setEtat (true);
  } /* runSave */


  void runLoad()
  {
    setEtat (false);
    _stop.setEnabled (false) ;
    if (null == _fileBox)
      {
	_fileBox = new LoadBox (
				_writtingArea, 
				_messageArea) ;
	_fileBox.setLoad (true) ;
      }
    else
      {
	_fileBox.setLoad (true) ;
	_fileBox.setVisible (true) ;
      }
    _fileBox.attente ();
    setEtat (true);
  } /* runLoad */

  /**
   * Rend l'interface active ou non
   */
  private void setEtat(boolean etat)
  {
    _writtingArea.setEnabled (etat) ;
    _messageArea.setEnabled (etat) ;
    _stop.setEnabled (!etat) ;
    _run.setEnabled (etat) ;
    _clear.setEnabled (etat) ;
    _load.setEnabled (etat) ;
    _save.setEnabled (etat) ;
    _options.setEnabled (etat) ;
    _quit.setEnabled (etat) ;
  } /* setEtat */

    /**
     * Association d'une action à un évènement. Seuls les boutons sont à
     * l'écoute des évènements. L'action déclenchée diffère selon le bouton
     * qui récupère l'évènement. <BR>
     * Le bouton d'exécution provoque l'analyse et l'exécution des instructions
     * de la zone éditable. <BR>
     * Le bouton d'effacement 'vide' la zone graphique, seuls les mulots
     * sont affichés, il n'y a plus de tracés. <BR>
     * Le bouton de chargement copie le fichier indiqué dans la zone éditable. <BR>
     * Le bouton de sauvegarde copie les donn&eacute;es de la zone &eacute;ditable 
     * dans un fichier. <BR>
     * Le bouton de param&egrave;trage ouvre la bo&icirc;te de dialogue 
     * appropri&eacute;e. <BR>
     * Le dernier bouton permet de quitter l'application.
     * 
     * @param e évènement écouté.
     */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource () == _run)
        {
	  runner = RUNINTERPRETEUR;
	  exec = new Thread (this);
	  exec.start ();
	}
        if (e.getSource () == _stop)
        {
	  exec.stop ();
	  setEtat (true);
        }
        if (e.getSource () == _load)
        {
	  runner = RUNLOAD;
	  exec = new Thread (this);
	  exec.start ();
        }
        if (e.getSource () == _save)
        {
	  runner = RUNSAVE;
	  exec = new Thread (this);
	  exec.start ();
        }
        if (e.getSource () == _clear)
        {
            _zoneG.initObservers () ;
            _zoneG.clearDrawingArea () ;
        }
        if (e.getSource () == _quit)
            System.exit (0) ;
        if (e.getSource () == _options)
        {
	  runner = RUNOPTION;
	  exec = new Thread (this);
	  exec.start ();
        }
    }
} 
