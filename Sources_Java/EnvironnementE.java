import java.lang.Integer ;
import java.util.Hashtable ;

/**
 * Environnement des symboles et des sous-programmes, utilis�
 * lors de l'ex�cution du code. Il n'y a plus de v�rification de types,
 * l'ex�cution est plus rapide. L'environnement contient une table de 
 * hashage de symboles, un compteur et l'environnement p�re. La table
 * de hashage permet de retrouver rapidement un symbole. Le compteur indique
 * l'instruction � ex�cuter. L'environnement p�re est l� pour garantir 
 * l'int�grit� des symboles lors de l'ex�cution d'un programme. <BR>
 * En cas de r�cursivit�, on ex�cute les m�mes instructions mais dans un
 * environnement diff�rement, cela �vite de dupliquer le code. 
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
     * Cr�ation d'un environnement d'ex�cution � partir d'un environnement 
     * p�re (null pour le programme principal).
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
     * Donne le num�ro de l'instruction en cours d'ex�cution.
     *
     * @return le num�ro de l'instruction courante.
     */
    public int getInstructionCourante ()
    {
        return _instructionCourante ;
    }

    /**
     * Incr�mente le compteur d'instruction.
     * 
     * @param increment saut � effectuer (1 en g�n�ral).
     */
    public void incrementInstruction (int increment)
    {
        _instructionCourante += increment ;
    }

    /**
     * Donne l'environnement p�re.
     *
     * @return environnement p�re.
     */
    public EnvironnementE getPere ()
    {
        return _pere ;
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
     * V�rifie l'existence d'un symbole localement.
     *
     * @param nom nom du symbole � chercher.
     * @return <CODE>true</CODE> si le symbole existe ;
     *         <CODE>false</CODE> sinon.
     */
    public boolean definedSymbole (String nom)
    {
        return (null != _symboles.get (nom)) ;
    }
    
    /**
     * Donne un symbole � partir de son nom. Il faut v�rifier l'existence
     * avant !!!
     *
     * @param nom nom du symbole � chercher.
     * @return le symbole d�sir�.
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
