import java.lang.String ;

/**
 * Repr�sentation d'une instruction de la repr�sentation interm�diaire.
 * Il y a 26 instructions diff�rentes librement inspir� de celles de
 * l'assembleur. On distingue deux types d'instructions, celles qui ont
 * un param�tre et celle qui n'en ont pas (les param�tres sont soient des
 * entiers, soient des identifiants). Dans les deux cas, les instructions
 * ont recours � une pile de donn�es. Selon l'instruction, on peut
 * s'attendre � ce qu'un certain nombre d'�l�ments soient dans la pile.
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
     * Cr�ation d'une instruction sans param�tre direct (ADD, SUB, MUL...).
     *
     * @param codeInstruction une des 26 instructions.
     */
    public Instruction (int codeInstruction)
    {
        _codeInstruction = codeInstruction ;
    }
    
    /**
     * Cr�ation d'une instruction avec un param�tre direct de type entier
     * (JMP, JBP, PUSI...).
     *
     * @param codeInstruction une des 26 instructions.
     * @param entier valeur du param�tre.
     */
    public Instruction (int codeInstruction, int entier)
    {
        _codeInstruction = codeInstruction ;
        _entier = entier ;
    }
    
    /**
     * Cr�ation d'une instruction avec un param�tre direct de type identifiant
     * (POP, PUSO...).
     *
     * @param codeInstruction une des 26 instructions.
     * @param identifiant cha�ne repr�sentant le nom d'un symbole.
     */
    public Instruction (int codeInstruction, String identifiant)
    {
        _codeInstruction = codeInstruction ;
        _identifiant = new String (identifiant) ;
    }
    
    /**
     * Donne l'instruction (ADD, SUB, POP, JMP...).
     *
     * @return un entier repr�sentant l'instruction.
     */
    public int getCodeInstruction ()
    {
        return _codeInstruction ;
    }        
    
    /**
     * Donne la valeur du param�tre de type entier.
     *
     * @return le param�tre entier.
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
