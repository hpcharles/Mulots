import java.lang.Integer ;
import java.lang.String ;
import java.util.Hashtable ;
import java.util.Vector ;

/**
 * Environnement des symboles et des sous-programmes, utilis�
 * uniquement pour v�rifier les concordances de type, l'existence
 * des symboles et leur visibilit�. Un environnement contient un nom
 * pour l'identifier, un type de retour (ENTIER, MULOT ou VIDE), une
 * table de hashage de symboles, une table de hashage de sousprogrammes,
 * une liste de param�tre et un environnement d'accueil. Un sousprogramme est 
 * une autre instance d'un objet de cette classe, d'o� le nom, c'est celui de 
 * la fonction ou proc�dure. La liste de param�tre est juste une liste de types
 * ordonn�e. Cela permet de contr�ler les appels aux sousprogrammes.
 * Les tables de hashage permettent de retrouver rapidement les
 * symboles ou sousprogrammes. <BR>
 * Concernant la visibilit�, depuis un environnement, on peut 'voir' tous
 * les symboles et sousprogrammes de l'environnement p�re. Par contre, le 
 * p�re ne peut pas 'voir' les symboles et sousprogrammes d'un environnement
 * fils.
 *
 * @author Erwan Prioul
 * $RCSfile: EnvironnementP.java,v $:$Revision: 1.2 $
 */
public class EnvironnementP
    implements
        MulotSrc
{
    protected String         _nom ;
    protected int            _typeRetour ;
    protected Vector         _parametres ;
    protected Hashtable      _symboles ;
    protected Hashtable      _sousProgrammes ;
    protected EnvironnementP _pere ;

    /**
     * Cr�ation d'un environnement � partir d'un nom, d'un type et d'un
     * environnement p�re. Le nom est celui d'une fonction ou d'une proc�dure
     * qui va �tre analys�e. Pour le programme principal, ce nom n'a aucune
     * signification (g�n�ralement null). Le type est le type de retour de
     * la fonction (MULOT ou ENTIER). Pour une proc�dure ou le programme 
     * principal on met VIDE. L'environnement p�re est celui � partir duquel
     * on peut acc�der � la fonction ou proc�dure courante. Gr�ce � la 
     * connaissance du 'p�re', on peut conna�tre les symboles globaux ou
     * les proc�dures ou fonctions de m�me niveau.
     *
     * @param nom nom du sousprogramme.
     * @param typeRetour ENTIER, MULOT ou VIDE.
     * @param pere environnement d'accueil.
     */
    public EnvironnementP (
        String nom,
        int    typeRetour,
        EnvironnementP pere)
    {
        _nom = nom ;
        _typeRetour = typeRetour ;
        _parametres = new Vector () ;
        _symboles = new Hashtable () ;
        _sousProgrammes = new Hashtable () ;
        _pere = pere ;
    }

    /**
     * Donne le nom de l'environnement.
     *
     * @return le nom de l'environnement.
     */
    public String getNom ()
    {
        return _nom ;
    }

    /**
     * Donne le type de retour.
     *
     * @return ENTIER, MULOT ou VIDE.
     */
    public int getTypeRetour ()
    {
        return _typeRetour ;
    }    

    /**
     * D�finit le type de retour.
     *
     * @param typeRetour ENTIER, MULOT ou VIDE.
     */
    public void setTypeRetour (int typeRetour)
    {
        _typeRetour = typeRetour ;
    }    

    /**
     * Donne l'environnement p�re.
     *
     * @return l'environnement p�re.
     */
    public EnvironnementP getPere ()
    {
        return _pere ;
    }
    
    /**
     * Ajoute un param�tre (un type de param�tre).
     *
     * @param type ENTIER, MULOT ou VIDE.
     */
    public void addParametre (int type) 
    {
        _parametres.addElement (new Integer (type)) ;
    }
    
    /**
     * Donne le nombre de param�tres.
     *
     * @return le nombre de param�tres.
     */
    public int getNombreParametre ()
    {
        return _parametres.size () ;
    }
    
    /**
     * Donne le type d'un param�tre en fonction de sa position.
     *
     * @param i position d'un param�tre.
     * @return ENTIER, MULOT ou VIDE (si la position est incorrecte).
     */
    public int getTypeParametre (int i)
    {
        if (i >= _parametres.size ())
            return VIDE ;
        return ((Integer) _parametres.elementAt (i)).intValue () ;
    }

    /**
     * Ajoute un symbole � la table des symboles.
     *
     * @param s symbole � ajouter.
     */
    public void addSymbole (Symbole s) 
    {
        _symboles.put (s.getNom (), s) ;
    }
    
    /**
     * V�rifie si un symbole est atteignable, y compris dans l'environnement
     * p�re, � partir de son nom.
     *
     * @param nom nom du symbole � rechercher.
     * @return <CODE>true</CODE> si le symbole est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean existSymbole (String nom)
    {
        return ((null != _symboles.get (nom)) || 
            ((null != _pere) && (_pere.existSymbole (nom)))) ;
    }
    
    /**
     * V�rifie si un symbole est d�fini localement (en cas d'affectation) � 
     * partir de son nom.
     *
     * @param nom nom du symbole � rechercher.
     * @return <CODE>true</CODE> si le symbole est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSymbole (String nom)
    {
        return (null != _symboles.get (nom)) ;
    }
    
    /**
     * R�cup�ration d'un symbole � partir de son nom, il faut d'abord v�rifier
     * son existence !!!
     *
     * @param nom nom du symbole.
     * @return le symbole d�sir� ou null en cas d'erreur...
     */
    public Symbole getSymbole (String nom)
    {
        Symbole s ;
        
        s = (Symbole) _symboles.get (nom) ;
        if (null == s)
            if (null != _pere)
                s = _pere.getSymbole (nom) ;
        return s ;
    }
    
    /**
     * Ajoute un sousprogramme � la table des symboles.
     *
     * @param s sousprogramme � ajouter.
     */
    public void addSPrg (EnvironnementP s)
    {
        _sousProgrammes.put (s.getNom (), s) ;
    }
    
    /**
     * V�rifie si un sousprogramme est atteignable, y compris dans 
     * l'environnement p�re, � partir de son nom.
     *
     * @param nom nom du sousprogramme � rechercher.
     * @return <CODE>true</CODE> si le sousprogramme est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean existSPrg (String nom)
    {
        return ((null != _sousProgrammes.get (nom)) || 
            ((null != _pere) && (_pere.existSPrg (nom)))) ;
    }

    /**
     * V�rifie si un sousprogramme est d�fini localement (en cas 
     * de d�finition) � 
     * partir de son nom.
     *
     * @param nom nom du sousprogramme � rechercher.
     * @return <CODE>true</CODE> si le sousprogramme est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSPrg (String nom)
    {
        return (null != _sousProgrammes.get (nom)) ;
    }
    
    /**
     * R�cup�ration d'un sousprogramme � partir de son nom, il faut d'abord 
     * v�rifier son existence !!!
     *
     * @param nom nom du sousprogramme.
     * @return le sousprogramme d�sir� ou null en cas d'erreur...
     */
    public EnvironnementP getSPrg (String nom)
    {
        EnvironnementP s ;
        
        s = (EnvironnementP) _sousProgrammes.get (nom) ;
        if (null == s)
            if (null != _pere)
                s = _pere.getSPrg (nom) ;
        return s ;
    }
}
