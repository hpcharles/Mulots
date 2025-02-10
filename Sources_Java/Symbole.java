import java.lang.String ;

/**
 * Repr�sentation d'une variable dans la table des symboles. Cette  
 * repr�sentation permet de conna�tre diff�rentes informations sur un
 * symbole : nom, type, le statut (variable ou param�tre) et la valeur.
 * Il y a une diff�rence entre une variable et un param�tre : un param�tre ne
 * peut pas �tre dans la partie gauche d'une affectation.
 *
 * @author Erwan Prioul
 * $RCSfile: Symbole.java,v $:$Revision: 1.2 $
 */
public class Symbole
    implements
        MulotSrc
{
    protected String  _nom ;
    protected int     _type ;
    protected int     _statut ;
    protected Object  _valeur ;
    protected boolean _flou ;
    
    /**
     * Initialisation d'un symbole � partir de son nom, son type et son
     * statut. Cette repr�sentation, sans la valeur associ�e au symbole,
     * permet les v�rification de types lors de l'analyse grammaticale.
     *
     * @param nom nom du symbole.
     * @param type type du symbole : ENTIER ou MULOT.
     * @param statut statut du symbole : PARAMETRE ou VARIABLE
     */
    public Symbole (String nom, int type, int statut)
    {
        _nom = new String (nom) ;
        _statut = statut ;
        _type = type ;
        _flou = false ;
    }
    
    /**
     * Initialisation d'un symbole � partir de son nom, son type et sa
     * valeur. Cette repr�sentation est utilis�e lors de l'ex�cution du 
     * programme.
     *
     * @param nom nom du symbole.
     * @param type type du symbole : ENTIER ou MULOT.
     * @param valeur valeur du symbole : objet Mulot ou Integer.
     */
    public Symbole (String nom, int type, Object valeur)
    {
        _nom = new String (nom) ;
        _type = type ;
        _valeur = valeur ;
        _flou = false ;
    }

    /**
     * Retourne le type du symbole.
     *
     * @return MULOT ou ENTIER, types autoris�s pour les symboles.
     */
    public int getType ()
    {
        return _type ;
    }
        
    /**
     * Retourne le nom du symbole.
     *
     * @return nom du symbole.
     */
    public String getNom ()
    {
        return new String (_nom) ;
    }
    
    /**
     * Retourne la valeur du symbole. En utilisant getType (), on peut faire
     * le cast appropri� pour r�cup�rer correctement l'objet.
     *
     * @return valeur associ�e au symbole.
     */
    public Object getValeur ()
    {
        return _valeur ;
    }
    
    /**
     * Retourne le statut du symbole.
     *
     * @return PARAMETRE ou VARIABLE.
     */
    public int getStatut ()
    {
        return _statut ;
    }

    /**
     * D�termine la valeur du symbole.
     *
     * @param valeur du symbole : objet Mulot ou Integer.
     */
    public void setValeur (Object valeur)
    {
        _valeur = valeur ;
    }

    /**
     * Le symbole peut-il ne pas avoir �t� initialis� (dans une clause d'un
     * Si par exemple) ?
     *
     * @return <CODE>true</CODE> si le symbole est incertain ;
     *         <CODE>false</CODE> sinon.
     */
    public boolean isFlou ()
    {
        return _flou ;
    }
    
    /**
     * Dit que le symbole est incertain.
     */
    public void setFlou ()
    {
        _flou = true ;
    }
}
