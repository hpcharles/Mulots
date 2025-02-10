import java.lang.Integer ;
import java.lang.String ;
import java.util.Hashtable ;
import java.util.Vector ;

/**
 * Environnement des symboles et des sous-programmes, utilisé
 * uniquement pour vérifier les concordances de type, l'existence
 * des symboles et leur visibilité. Un environnement contient un nom
 * pour l'identifier, un type de retour (ENTIER, MULOT ou VIDE), une
 * table de hashage de symboles, une table de hashage de sousprogrammes,
 * une liste de paramètre et un environnement d'accueil. Un sousprogramme est 
 * une autre instance d'un objet de cette classe, d'où le nom, c'est celui de 
 * la fonction ou procédure. La liste de paramètre est juste une liste de types
 * ordonnée. Cela permet de contrôler les appels aux sousprogrammes.
 * Les tables de hashage permettent de retrouver rapidement les
 * symboles ou sousprogrammes. <BR>
 * Concernant la visibilité, depuis un environnement, on peut 'voir' tous
 * les symboles et sousprogrammes de l'environnement père. Par contre, le 
 * père ne peut pas 'voir' les symboles et sousprogrammes d'un environnement
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
     * Création d'un environnement à partir d'un nom, d'un type et d'un
     * environnement père. Le nom est celui d'une fonction ou d'une procédure
     * qui va être analysée. Pour le programme principal, ce nom n'a aucune
     * signification (généralement null). Le type est le type de retour de
     * la fonction (MULOT ou ENTIER). Pour une procédure ou le programme 
     * principal on met VIDE. L'environnement père est celui à partir duquel
     * on peut accèder à la fonction ou procédure courante. Grâce à la 
     * connaissance du 'père', on peut connaître les symboles globaux ou
     * les procédures ou fonctions de même niveau.
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
     * Définit le type de retour.
     *
     * @param typeRetour ENTIER, MULOT ou VIDE.
     */
    public void setTypeRetour (int typeRetour)
    {
        _typeRetour = typeRetour ;
    }    

    /**
     * Donne l'environnement père.
     *
     * @return l'environnement père.
     */
    public EnvironnementP getPere ()
    {
        return _pere ;
    }
    
    /**
     * Ajoute un paramètre (un type de paramètre).
     *
     * @param type ENTIER, MULOT ou VIDE.
     */
    public void addParametre (int type) 
    {
        _parametres.addElement (new Integer (type)) ;
    }
    
    /**
     * Donne le nombre de paramètres.
     *
     * @return le nombre de paramètres.
     */
    public int getNombreParametre ()
    {
        return _parametres.size () ;
    }
    
    /**
     * Donne le type d'un paramètre en fonction de sa position.
     *
     * @param i position d'un paramètre.
     * @return ENTIER, MULOT ou VIDE (si la position est incorrecte).
     */
    public int getTypeParametre (int i)
    {
        if (i >= _parametres.size ())
            return VIDE ;
        return ((Integer) _parametres.elementAt (i)).intValue () ;
    }

    /**
     * Ajoute un symbole à la table des symboles.
     *
     * @param s symbole à ajouter.
     */
    public void addSymbole (Symbole s) 
    {
        _symboles.put (s.getNom (), s) ;
    }
    
    /**
     * Vérifie si un symbole est atteignable, y compris dans l'environnement
     * père, à partir de son nom.
     *
     * @param nom nom du symbole à rechercher.
     * @return <CODE>true</CODE> si le symbole est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean existSymbole (String nom)
    {
        return ((null != _symboles.get (nom)) || 
            ((null != _pere) && (_pere.existSymbole (nom)))) ;
    }
    
    /**
     * Vérifie si un symbole est défini localement (en cas d'affectation) à 
     * partir de son nom.
     *
     * @param nom nom du symbole à rechercher.
     * @return <CODE>true</CODE> si le symbole est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSymbole (String nom)
    {
        return (null != _symboles.get (nom)) ;
    }
    
    /**
     * Récupération d'un symbole à partir de son nom, il faut d'abord vérifier
     * son existence !!!
     *
     * @param nom nom du symbole.
     * @return le symbole désiré ou null en cas d'erreur...
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
     * Ajoute un sousprogramme à la table des symboles.
     *
     * @param s sousprogramme à ajouter.
     */
    public void addSPrg (EnvironnementP s)
    {
        _sousProgrammes.put (s.getNom (), s) ;
    }
    
    /**
     * Vérifie si un sousprogramme est atteignable, y compris dans 
     * l'environnement père, à partir de son nom.
     *
     * @param nom nom du sousprogramme à rechercher.
     * @return <CODE>true</CODE> si le sousprogramme est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean existSPrg (String nom)
    {
        return ((null != _sousProgrammes.get (nom)) || 
            ((null != _pere) && (_pere.existSPrg (nom)))) ;
    }

    /**
     * Vérifie si un sousprogramme est défini localement (en cas 
     * de définition) à 
     * partir de son nom.
     *
     * @param nom nom du sousprogramme à rechercher.
     * @return <CODE>true</CODE> si le sousprogramme est atteignable ; 
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSPrg (String nom)
    {
        return (null != _sousProgrammes.get (nom)) ;
    }
    
    /**
     * Récupération d'un sousprogramme à partir de son nom, il faut d'abord 
     * vérifier son existence !!!
     *
     * @param nom nom du sousprogramme.
     * @return le sousprogramme désiré ou null en cas d'erreur...
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
