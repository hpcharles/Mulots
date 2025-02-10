import java.lang.String ;

/**
 * Représentation d'une instruction de la représentation intermédiaire.
 * Il y a 26 instructions différentes librement inspiré de celles de
 * l'assembleur. On distingue deux types d'instructions, celles qui ont
 * un paramètre et celle qui n'en ont pas (les paramètres sont soient des
 * entiers, soient des identifiants). Dans les deux cas, les instructions
 * ont recours à une pile de données. Selon l'instruction, on peut
 * s'attendre à ce qu'un certain nombre d'éléments soient dans la pile.
 *
 * @author Erwan Prioul
 * $RCSfile: Instruction.java,v $:$Revision: 1.2 $
 */
public class Instruction
    implements
        MulotSrc
{
    protected int    _codeInstruction ;
    protected int    _entier ;
    protected String _identifiant ;
    
    /**
     * Création d'une instruction sans paramètre direct (ADD, SUB, MUL...).
     *
     * @param codeInstruction une des 26 instructions.
     */
    public Instruction (int codeInstruction)
    {
        _codeInstruction = codeInstruction ;
    }
    
    /**
     * Création d'une instruction avec un paramètre direct de type entier
     * (JMP, JBP, PUSI...).
     *
     * @param codeInstruction une des 26 instructions.
     * @param entier valeur du paramètre.
     */
    public Instruction (int codeInstruction, int entier)
    {
        _codeInstruction = codeInstruction ;
        _entier = entier ;
    }
    
    /**
     * Création d'une instruction avec un paramètre direct de type identifiant
     * (POP, PUSO...).
     *
     * @param codeInstruction une des 26 instructions.
     * @param identifiant chaîne représentant le nom d'un symbole.
     */
    public Instruction (int codeInstruction, String identifiant)
    {
        _codeInstruction = codeInstruction ;
        _identifiant = new String (identifiant) ;
    }
    
    /**
     * Donne l'instruction (ADD, SUB, POP, JMP...).
     *
     * @return un entier représentant l'instruction.
     */
    public int getCodeInstruction ()
    {
        return _codeInstruction ;
    }        
    
    /**
     * Donne la valeur du paramètre de type entier.
     *
     * @return le paramètre entier.
     */
    public int getEntier ()
    {
        return _entier ;
    }        
    
    /**
     * Donne le nom du parametre identifiant.
     *
     * @return l'identifiant.
     */
    public String getIdentifiant ()
    {
        return _identifiant ;
    }        
}
