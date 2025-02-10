import java.io.File ;
import java.io.RandomAccessFile ;
import java.util.Vector ;

/**
 * Gestion des param&egrave;tres de l'application.
 *
 * @author Erwan Prioul
 * $RCSfile: Parameters.java,v $:$Revision: 1.2 $
 */
public class Parameters 
    implements
        MulotSrc
{
    private Vector _params ;
    
    /**
     * Initialise les param&egrave;tres par des valeurs pa d&eacute;faut.
     */
    public Parameters ()
    {
        _params = new Vector () ;
        this.init () ;
    }
    
    /**
     * Donne le nombre de lignes de la zone d'&eacute;dition.
     *
     * @return le nombre de lignes de la zone d'&eacute;dition.
     */
    public int getLigneEd ()
    {
        return ((Integer) _params.elementAt (0)).intValue () ;
    }
    
    /**
     * Donne le nombre de lignes de la zone d'erreur.
     *
     * @return le nombre de lignes de la zone d'erreur.
     */
    public int getLigneMsg ()
    {
        return ((Integer) _params.elementAt (1)).intValue () ;
    }
    
    /**
     * Donne le nombre de colonnes.
     *
     * @return le nombre de colonnes.
     */
    public int getColonne ()
    {
        return ((Integer) _params.elementAt (2)).intValue () ;
    }
    
    /**
     * Donne la largeur du terrain de jeu pour mulots.
     *
     * @return la largeur du terrain de jeu pour mulots.
     */
    public int getZoneX ()
    {
        return ((Integer) _params.elementAt (3)).intValue () ;
    }
    
    /**
     * Donne la hauteur du terrain de jeu pour mulots.
     *
     * @return la hauteur du terrain de jeu pour mulots.
     */
    public int getZoneY ()
    {
        return ((Integer) _params.elementAt (4)).intValue () ;
    }
    
    /**
     * Donne la largeur d'affichage du terrain de jeu pour mulots.
     *
     * @return la largeur d'affichage du terrain de jeu pour mulots.
     */
    public int getAffX ()
    {
        return ((Integer) _params.elementAt (5)).intValue () ;
    }
    
    /**
     * Donne la hauteur d'affichage du terrain de jeu pour mulots.
     *
     * @return la hauteur d'affichage du terrain de jeu pour mulots.
     */
    public int getAffY ()
    {
        return ((Integer) _params.elementAt (6)).intValue () ;
    }
    
    /**
     * Donne la couleur en Mulot du terrain de jeu pour mulots.
     *
     * @return la couleur en Mulot du terrain de jeu pour mulots.
     */
    public int getIndexColor ()
    {
        return ((Integer) _params.elementAt (7)).intValue () ;
    }
    
    /**
     * Donne le d&eacute;lai d'attente entre chaque rafraichissement.
     *
     * @return le d&eacute;lai d'attente entre chaque rafraichissement.
     */
    public int getWait ()
    {
        return ((Integer) _params.elementAt (8)).intValue () ;
    }
    
    /**
     * Donne la configuration de l'affichage : <BR>
     * TWOWINDOWS : une fen&ecirc;tre pour l'&eacute;diteur et une autre pour le 
     * terrain de jeu pour mulots.<BR>
     * ONEWINDOWSEAST : une fen&ecirc;tre pour le tout, le terrain de jeu pour 
     * mulots &eacute;tant &agrave; droite.<BR>
     * ONEWINDOWSSOUTH : une fen&ecirc;tre pour le tout, le terrain de jeu pour 
     * mulots &eacute;tant en bas.
     *
     * @return la configuration de l'affichage.
     */
    public int getWindows ()
    {
        return ((Integer) _params.elementAt (9)).intValue () ;
    }
    
    /**
     * D&eacute;termine le nombre de lignes de la zone d'&eacute;dition.
     *
     * @param value le nombre de lignes de la zone d'&eacute;dition.
     */
    public void setLigneEd (int value)
    {
        _params.setElementAt (new Integer (value), 0) ;
    }
    
    /**
     * D&eacute;termine le nombre de lignes de la zone d'erreur.
     *
     * @param value le nombre de lignes de la zone d'erreur.
     */
    public void setLigneMsg (int value)
    {
        _params.setElementAt (new Integer (value), 1) ;
    }
    
    /**
     * D&eacute;termine le nombre de colonnes.
     *
     * @param value le nombre de colonnes.
     */
    public void setColonne (int value)
    {
        _params.setElementAt (new Integer (value), 2) ;
    }
    
    /**
     * D&eacute;termine la largeur du terrain de jeu pour mulots.
     *
     * @param value la largeur du terrain de jeu pour mulots.
     */
    public void setZoneX (int value)
    {
        _params.setElementAt (new Integer (value), 3) ;
    }
    
    /**
     * D&eacute;termine la hauteur du terrain de jeu pour mulots.
     *
     * @param value la hauteur du terrain de jeu pour mulots.
     */
    public void setZoneY (int value)
    {
        _params.setElementAt (new Integer (value), 4) ;
    }
    
    /**
     * D&eacute;termine la largeur d'affichage du terrain de jeu pour mulots.
     *
     * @param value la largeur d'affichage du terrain de jeu pour mulots.
     */
    public void setAffX (int value)
    {
        _params.setElementAt (new Integer (value), 5) ;
    }
    
    /**
     * D&eacute;termine la hauteur d'affichage du terrain de jeu pour mulots.
     *
     * @param value la hauteur d'affichage du terrain de jeu pour mulots.
     */
    public void setAffY (int value)
    {
        _params.setElementAt (new Integer (value), 6) ;
    }
    
    /**
     * D&eacute;termine la couleur en Mulot du terrain de jeu pour mulots.
     *
     * @param value la couleur en Mulot du terrain de jeu pour mulots.
     */
    public void setIndexColor (int value)
    {
        _params.setElementAt (new Integer (value), 7) ;
    }
    
    /**
     * D&eacute;termine le d&eacute;lai d'attente entre chaque rafraichissement.
     *
     * @param value le d&eacute;lai d'attente entre chaque rafraichissement.
     */
    public void setWait (int value)
    {
        _params.setElementAt (new Integer (value), 8) ;
    }
    
    /**
     * D&eacute;termine la configuration de l'affichage : <BR>
     * TWOWINDOWS : une fen&ecirc;tre pour l'&eacute;diteur et une autre pour le 
     * terrain de jeu pour mulots.<BR>
     * ONEWINDOWSEAST : une fen&ecirc;tre pour le tout, le terrain de jeu pour 
     * mulots &eacute;tant &agrave; droite.<BR>
     * ONEWINDOWSSOUTH : une fen&ecirc;tre pour le tout, le terrain de jeu pour 
     * mulots &eacute;tant en bas.
     *
     * @param value la configuration de l'affichage.
     */
    public void setWindows (int value)
    {
        _params.setElementAt (new Integer (value), 9) ;
    }
    
    /**
     * Place les valeurs par d&eacute;faut dans les param&egrave;tres.
     */
    public void raz ()
    {
        _params.setElementAt (new Integer (WRITTINGROWS), 0) ;
        _params.setElementAt (new Integer (MESSAGEROWS), 1) ;
        _params.setElementAt (new Integer (COLUMNS), 2) ;
        _params.setElementAt (new Integer (WIDTH), 3) ;
        _params.setElementAt (new Integer (HEIGHT), 4) ;
        _params.setElementAt (new Integer (WIDTHVS), 5) ;
        _params.setElementAt (new Integer (HEIGHTVS), 6) ;
        _params.setElementAt (new Integer (COULEURFOND), 7) ;
        _params.setElementAt (new Integer (ATTENTE), 8) ;
        _params.setElementAt (new Integer (WINDOWS), 9) ;
    }

    /**
     * V&eacute;rifie les param&egrave;tres, si une valeur est incorrecte, elle 
     * est remplac&eacute;e par la valeur par d&eacute;faut.
     */
    public void check ()
    {
        int i ;
        
        if (0 >= (((Integer) _params.elementAt (0)).intValue ()))
            _params.setElementAt (new Integer (WRITTINGROWS), 0) ;
        if (0 >= (((Integer) _params.elementAt (1)).intValue ()))
            _params.setElementAt (new Integer (MESSAGEROWS), 1) ;
        if (0 >= (((Integer) _params.elementAt (2)).intValue ()))
            _params.setElementAt (new Integer (COLUMNS), 2) ;
        if (0 >= (((Integer) _params.elementAt (3)).intValue ()))
            _params.setElementAt (new Integer (WIDTH), 3) ;
        if (0 >= (((Integer) _params.elementAt (4)).intValue ()))
            _params.setElementAt (new Integer (HEIGHT), 4) ;
        if (0 >= (((Integer) _params.elementAt (5)).intValue ()))
            _params.setElementAt (new Integer (WIDTHVS), 5) ;
        if (0 >= (((Integer) _params.elementAt (6)).intValue ()))
            _params.setElementAt (new Integer (HEIGHTVS), 6) ;
        i = ((Integer) _params.elementAt (7)).intValue () ;
        if ((0 > i) || (NBCOLOR <= i))
            _params.setElementAt (new Integer (COULEURFOND), 7) ;
        if (0 > (((Integer) _params.elementAt (8)).intValue ()))
            _params.setElementAt (new Integer (ATTENTE), 8) ;
        i = ((Integer) _params.elementAt (9)).intValue () ;
        if ((0 > i) || (3 < i))
            _params.setElementAt (new Integer (WINDOWS), 9) ;
    }
    
    /**
     * Ecrit les param&egrave;tres dans le fichier de ressources. 
     */
    public void setParameters ()
    {
        RandomAccessFile f ;
        int i ;
        
        try 
        {
            f = new RandomAccessFile (FICHIERPARAMETRE, "rw") ;
            f.seek (0) ;
            for (i = 0 ; i < _params.size () ; i ++)
                f.writeInt (((Integer) _params.elementAt (i)).intValue ()) ;
            f.close () ;
        }
        catch (Exception e) {}
    }
    
    /**
     * R&eacute;cup&egrave;re les param&egrave;tres du fichier de ressources,
     * s'il existe. Sinon, utilise les valeurs pas d&eacute;faut.
     */
    public void getParameters ()
    {
        File fexists ;
        RandomAccessFile f ;
        int i ;
        
        try 
        {
            fexists = new File (FICHIERPARAMETRE) ;
            if (fexists.exists ())
            {
                f = new RandomAccessFile (FICHIERPARAMETRE, "r") ;
                f.seek (0) ;
                for (i = 0 ; i < _params.size () ; i ++)
                    _params.setElementAt (new Integer (f.readInt ()), i) ;
                f.close () ;
            }
            else
                this.raz () ;
        }
        catch (Exception e) 
        {
            this.raz () ;
        }
    }
        
    /**
     * Cr&eacute;e et llace les valeurs par d&eacute;faut dans les 
     * param&egrave;tres.
     */
    private void init ()
    {
        _params.addElement (new Integer (WRITTINGROWS)) ;
        _params.addElement (new Integer (MESSAGEROWS)) ;
        _params.addElement (new Integer (COLUMNS)) ;
        _params.addElement (new Integer (WIDTH)) ;
        _params.addElement (new Integer (HEIGHT)) ;
        _params.addElement (new Integer (WIDTHVS)) ;
        _params.addElement (new Integer (HEIGHTVS)) ;
        _params.addElement (new Integer (COULEURFOND)) ;
        _params.addElement (new Integer (ATTENTE)) ;
        _params.addElement (new Integer (WINDOWS)) ;
    }
} 
