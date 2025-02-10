import java.lang.Integer ;
import java.util.Hashtable ;

/**
 * Environnement des symboles et des sous-programmes, utilisé
 * lors de l'exécution du code. Il n'y a plus de vérification de types,
 * l'exécution est plus rapide. L'environnement contient une table de 
 * hashage de symboles, un compteur et l'environnement père. La table
 * de hashage permet de retrouver rapidement un symbole. Le compteur indique
 * l'instruction à exécuter. L'environnement père est là pour garantir 
 * l'intégrité des symboles lors de l'exécution d'un programme. <BR>
 * En cas de récursivité, on exécute les mêmes instructions mais dans un
 * environnement différement, cela évite de dupliquer le code. 
 *
 * @author Erwan Prioul
 * $RCSfile: EnvironnementE.java,v $:$Revision: 1.2 $
 */
public class EnvironnementE
    implements
        MulotSrc
{
    protected Hashtable      _symboles ;
    protected int            _instructionCourante ;
    protected EnvironnementE _pere ;

    /**
     * Création d'un environnement d'exécution à partir d'un environnement 
     * père (null pour le programme principal).
     *
     * @param pere environnement d'accueil.
     */
    public EnvironnementE (EnvironnementE pere)
    {
        _pere = pere ;
        _instructionCourante = 0 ;
        _symboles = new Hashtable () ;
    }

    /**
     * Donne le numéro de l'instruction en cours d'exécution.
     *
     * @return le numéro de l'instruction courante.
     */
    public int getInstructionCourante ()
    {
        return _instructionCourante ;
    }

    /**
     * Incrémente le compteur d'instruction.
     * 
     * @param increment saut à effectuer (1 en général).
     */
    public void incrementInstruction (int increment)
    {
        _instructionCourante += increment ;
    }

    /**
     * Donne l'environnement père.
     *
     * @return environnement père.
     */
    public EnvironnementE getPere ()
    {
        return _pere ;
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
     * Vérifie l'existence d'un symbole localement.
     *
     * @param nom nom du symbole à chercher.
     * @return <CODE>true</CODE> si le symbole existe ;
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSymbole (String nom)
    {
        return (null != _symboles.get (nom)) ;
    }
    
    /**
     * Donne un symbole à partir de son nom. Il faut vérifier l'existence
     * avant !!!
     *
     * @param nom nom du symbole à chercher.
     * @return le symbole désiré.
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
}
