/* Copyright (c) 1998 Henri-Pierre Charles. Tous droits reserves */
/*
   NOM
     FrameDialog
   UTILITE
     Une Frame/Dialog pour passer autour des pb de Dialog sous
     environnement Unix en fonction des WM
   NOTES
     $Revision: 1.2 $
   HISTOIRE
          hpc - Oct 28, 1998: Created.
     $Log: FrameDialog.java,v $
     Revision 1.2  1998/11/05 14:48:12  R1
     Gestion des boutons. rien d'important mais c'est pour qu'il y ait un peu de
     cohérence...

     Revision 1.1  1998/10/28 15:37:45  hpc
     Ajout

     Revision 1.1  1998/10/28 15:26:59  hpc
     Ajout
 */
import java.awt.Frame;

class FrameDialog extends Frame
{
  public FrameDialog (String titre)
  {
    super (titre);
  }

  /** Efface la fenetre, rend les ressources, et libere les threads en
      attente*/
  void bye()
  {
    setVisible (false);
    dispose () ;
    libere ();
  } /* bye */

  /** Liberation du verrou qui bloque le thread en attente de la
   * saisie */
  public synchronized void libere ()
  {
    //    System.out.println("Libere");
    notify ();
  }

  /** Bloquage en attente de la saisie */
  public synchronized void attente ()
  {
    try
      {
	wait ();
      }
    catch (Exception e)
      {
	System.out.println(e);
      }
  }
}
