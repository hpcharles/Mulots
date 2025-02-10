// Analyseur grammatical (parser)

options
{
    mangleLiteralPrefix = "TK_" ;
}
{
    import java.lang.String ;
    import java.util.Enumeration ;
    import java.util.Hashtable ;
    import java.util.Vector ;
}
class MulotParser 
    extends 
        Parser ;
options
{
    k = 3 ;
    tokdef = "MulotTokenTypes.txt" ;
}
{
    // Constantes couleurs.
    public final static int WHITE     = 0 ;
    public final static int BLACK     = 1 ;
    public final static int BLUE      = 2 ;
    public final static int CYAN      = 3 ;
    public final static int DARKGRAY  = 4 ;
    public final static int GRAY      = 5 ;
    public final static int LIGHTGRAY = 6 ;
    public final static int GREEN     = 7 ;
    public final static int MAGENTA   = 8 ;
    public final static int ORANGE    = 9 ;
    public final static int PINK      = 10 ;
    public final static int RED       = 11 ;
    public final static int YELLOW    = 12 ;

    // Constantes types.
    public final static int ENTIER  = 0 ;
    public final static int MULOT   = 1 ;
    public final static int VIDE    = 2 ;
    public final static int BOOLEEN = 3 ;

    // Constantes status de symboles.
    public final static int VARIABLE  = 0 ;
    public final static int PARAMETRE = 1 ;

    // Constantes de saut de boucle.
    public final static int SORTIEPOUR = 5 ;
    public final static int CONDITIONPOUR = 7 ;
    public final static int INCREMENTPOUR = 1 ;

    // Constantes de saut de tantque.
    public final static int SORTIETANTQUE    = 1 ;
    public final static int CONDITIONTANTQUE = 3 ;

    // Constantes instruction atomiques.
    public final static int ADD  = 0 ;
    public final static int SUB  = 1 ;
    public final static int MUL  = 2 ;
    public final static int DIV  = 3 ;
    public final static int MOD  = 4 ;
    public final static int LEVE = 5 ;
    public final static int BAIS = 6 ;
    public final static int TOUR = 7 ;
    public final static int AVAN = 8 ;
    public final static int CALL = 9 ;
    public final static int RET  = 21 ;
    public final static int NEWM = 10 ;
    public final static int PUSO = 11 ;
    public final static int PUSI = 12 ;
    public final static int POP  = 13 ;
    public final static int EQ   = 14 ;
    public final static int NQ   = 15 ;
    public final static int LT   = 16 ;
    public final static int GT   = 17 ;
    public final static int LE   = 18 ;
    public final static int GE   = 19 ;
    public final static int JMP  = 20 ;
    public final static int JBP  = 22 ;
    public final static int AND  = 23 ;
    public final static int OR   = 24 ;
    public final static int NOT  = 25 ;
    public final static int STOP = 26 ;
    public final static int GETI = 27 ;

    // Messages d'erreur.
//    public final static String SPRG_DEFINED = 
//        "Procedure or function already defined" ;
//    public final static String FCT_NORETURN = 
//        "Function without 'retourne'" ;
//    public final static String RET_BADTYPE = 
//        "Bad type returned by function" ;
//    public final static String ASSIGN_BADTYPE = 
//        "Types not match in assignation" ;
//    public final static String SYMBOLE_NOTEXIST = 
//        "Identifier not exist" ;
//    public final static String SYMBOLE_BADTYPE = 
//        "Bad type for identifier" ;
//    public final static String PARAMETRE_BADTYPE = 
//        "Bad type for parameter" ;
//    public final static String SYMBOLE_DEFINED = 
//        "Identifier already defined" ;
//    public final static String ASSIGN_PARAMETRE = 
//        "Parameter assignation" ;
//    public final static String SPRG_NOTEXIST = 
//        "Procedure ou function not exist" ;
//    public final static String CONDITION_BADTYPE = 
//        "Bad type for condition" ;
//    public final static String OPERATION_BADTYPE = 
//        "Bad type for operation" ;
//    public final static String PARAMETRE_BADNUMBER = 
//        "Bad number of parameters" ;
//    public final static String SYMBOLE_MAYNOTEXIST = 
//        "Identifier may not have been initialised" ;
    public final static String SPRG_DEFINED = 
        "Procedure ou fonction deja definie" ;
    public final static String FCT_NORETURN = 
        "Fonction sans 'retourne'" ;
    public final static String RET_BADTYPE = 
        "Type de retour incorrect" ;
    public final static String ASSIGN_BADTYPE = 
        "Types incorrect dans une affectation" ;
    public final static String SYMBOLE_NOTEXIST = 
        "Identifiant inconnu" ;
    public final static String SYMBOLE_BADTYPE = 
        "identifiant de type incorrect" ;
    public final static String PARAMETRE_BADTYPE = 
        "parametre de type incorrect" ;
    public final static String SYMBOLE_DEFINED = 
        "Identifiant deja defini" ;
    public final static String ASSIGN_PARAMETRE = 
        "Affectation d'un parametre" ;
    public final static String SPRG_NOTEXIST = 
        "Procedure ou fonction inconnue" ;
    public final static String CONDITION_BADTYPE = 
        "Type incorrect pour une expression booleenne" ;
    public final static String OPERATION_BADTYPE = 
        "Type incorrect pour une expression arithmetique" ;
    public final static String PARAMETRE_BADNUMBER = 
        "Nombre de parametres incorrect" ;
    public final static String SYMBOLE_MAYNOTEXIST = 
        "Identifiant pouvant ne pas etre initialise" ;
}

// Definition d'un programme Mulot.
// Genere le code (representation intermediaire) qui sera execute s'il 
// n'y a pas d'erreur.
program returns [Programme prg]
{
    Hashtable h ;

    h = new Hashtable () ;
    prg = new Programme () ;
}
    : TK_Mulot 
      (
        sousProgramme [prg.getRI (), prg.getVisible ()]
      )* 
      corps [false, prg.getRI (), prg.getVisible (), h]
      TK_Tolum EOF
    ;

// Definition d'un sousprogramme (procedure ou fonction)
sousProgramme [Code c, EnvironnementP e]
    : procedure [c, e]
    | fonction [c, e]
    ;

// Definition d'une procedure.
// On fait une verification sur le nom (pas de doublon).
// On cree ensuite un nouveau code et un nouvel environnement pour
// la procedure.
procedure  [Code c, EnvironnementP e]
{
    Code cs ;
    EnvironnementP es ;
    Hashtable h ;

    h = new Hashtable () ;
}
    : TK_Proc 
      i:ID 
        {
            if (e.definedSPrg (i.getText ()))
                System.err.println (
                    SPRG_DEFINED +
                    " : " +
                    i.getText () +
                    " (" +
                    i.getLine () + 
                    ")") ;
            cs = new Code (i.getText (), c) ;
            c.addSPrg (cs) ;
            es = new EnvironnementP (i.getText (), VIDE, e) ;
            e.addSPrg (es) ;
        }
      LPAREN 
      listeDeclaration [cs, es]
      RPAREN
      (
        sousProgramme [cs, es]
      )*
      corps [false, cs, es, h]
      TK_Corp
    ;

// Definition d'une fonction.
// On fait une verification sur le nom (pas de doublon).
// On cree ensuite un nouveau code et un nouvel environnement pour
// la fonction. On verifie finalement que la fonction a bien une
// instruction de retour.
fonction [Code c, EnvironnementP e]
{
    Code cs ;
    EnvironnementP es ;
    int t ;
    Hashtable h ;
    boolean ret ;

    h = new Hashtable () ;
}
    : TK_Fonc 
      i:ID 
        {
            if (e.definedSPrg (i.getText ()))
                System.err.println (
                    SPRG_DEFINED +
                    " : " +
                    i.getText () +
                    " (" +
                    i.getLine () + 
                    ")") ;
            cs = new Code (i.getText (), c) ;
            c.addSPrg (cs) ;
            es = new EnvironnementP (i.getText (), VIDE, e) ;
            e.addSPrg (es) ;
        }
      LPAREN 
      listeDeclaration [cs, es]
      RPAREN 
      ASSIGN 
      t = type
        {
            es.setTypeRetour (t) ;
        }
      (
        sousProgramme [cs, es]
      )*
      ret = corps [true, cs, es, h]
      TK_Cnof 
      {
          if (! ret)
              System.err.println (
                  FCT_NORETURN +
                  " : " +
                  i.getText () +
                  " (" +
                  i.getLine () + 
                  ")") ;
      }
    ;

// Definition d'un corps de programme ou de bloc, meme si en mulot les
// blocs n'existent pas.
corps [boolean enableReturn, Code c, EnvironnementP e, Hashtable h] 
    returns [boolean ret]
{
    boolean r, r2 ;
    
    ret = r = false ;
}
    : (
        r2 = instruction [enableReturn, c, e, h] { r = r || r2 ; }
      )+
      { ret = r ; }
    ;

// Definition d'une instruction :
// . affectation
// . attente
// . appel de sousprogrammes ou notation pointee
// . boucle Pour
// . boucle TantQue
// . structure conditionnelle Si
// . retourne, pour les fonctions uniquement.
instruction [boolean enableReturn, Code c, EnvironnementP e, Hashtable h]
    returns [boolean ret]
{
    Instruction instruction ;
    int t ;
    
    ret = false ;
}
    : assignation [c, e, h] SEMI
    | TK_pause LPAREN RPAREN SEMI
      {
          instruction = new Instruction (STOP) ;
          c.addInstruction (instruction) ;
      }
    | action [c, e]
    | boucle [enableReturn, c, e, h]
    | tantque [enableReturn, c, e, h]
    | conditionnelle [enableReturn, c, e, h]
    | {enableReturn}? TK_return expression [c, e] SEMI
      {
          ret = true ;
          
          t = c.getTypeLastInstruction (e) ;
          if (t != e.getTypeRetour ())
              System.err.println (
                  RET_BADTYPE +
                  " : " +
                  (ENTIER == t ? 
                      "entier" : 
                      (MULOT == t ? "Mulot" : "---")) +
                  " au lieu de " + 
                  (ENTIER == e.getTypeRetour () ? "entier" : "Mulot")) ;
          else
          {
              instruction = new Instruction (RET) ;
              c.addInstruction (instruction) ;
          }        
      }
    ;

// Definition d'une affectation.
// On verifie que la partie de gauche n'est pas definie ou est du
// meme type que la partie de droite. La partie de droite doit renvoyer
// quelque chose.
assignation [Code c, EnvironnementP e, Hashtable h]
{
    int t ;
    Symbole s ;
    Instruction instruction ;
}
    : i:ID ASSIGN expression [c, e]
      {
          t = c.getTypeLastInstruction (e) ;
          if ((BOOLEEN == t) || (VIDE == t))
              System.err.println (
                  ASSIGN_BADTYPE +
                  " : " +
                  i.getText () +
                  " (" +
                  i.getLine () + 
                  ")") ;
          else
          {
              if (e.definedSymbole (i.getText ()))
              {
                  s = e.getSymbole (i.getText ()) ;
                  if (PARAMETRE == s.getStatut ())
                      System.err.println (
                          ASSIGN_PARAMETRE +
                          " : " +
                          i.getText () +
                          " (" +
                          i.getLine () + 
                          ")") ;
                  else
                      if (s.getType () != t) 
                          System.err.println (
                             ASSIGN_BADTYPE +
                             " : " +
                             i.getText () +
                             " (" +
                             i.getLine () + 
                             ")") ;
                      else
                      {
                          instruction = new Instruction (POP, i.getText ()) ;
                          c.addInstruction (instruction) ;
                      }
              }
              else
              {
                  s = new Symbole (i.getText (), t, VARIABLE) ;
                  e.addSymbole (s) ;
                  instruction = new Instruction (POP, i.getText ()) ;
                  c.addInstruction (instruction) ;
              }
              h.put (s.getNom (), s) ;
          }
      }
    ;

// Definiton d'une 'action' (appel de sousprogramme ou notation pointee).
// Pour la notation pointee, on verifie que la partie de gauche est du type
// MULOT et que les parametres sont suffisants et du bon type.
action [Code c, EnvironnementP e]
{
    Symbole s ;
    Instruction instruction ;
}
    : i:ID POINT TK_baisse LPAREN RPAREN SEMI
      {
          if (!e.existSymbole (i.getText ()))
              System.err.println (
                  SYMBOLE_NOTEXIST +
                  " : " +
                  i.getText () +
                  " (" +
                  i.getLine () + 
                  ")") ;
          else
          {
              s = e.getSymbole (i.getText ()) ;
              if (s.getType () != MULOT)
                  System.err.println (
                      SYMBOLE_BADTYPE +
                      " : " +
                      i.getText () +
                      " (" +
                      i.getLine () + 
                      ")") ;
              else
              {
                  instruction = new Instruction (BAIS, i.getText ()) ;
                  c.addInstruction (instruction) ;
              }
          }
      }
    | i1:ID POINT TK_leve LPAREN RPAREN SEMI
      {
          if (!e.existSymbole (i1.getText ()))
              System.err.println (
                  SYMBOLE_NOTEXIST +
                  " : " +
                  i1.getText () +
                  " (" +
                  i1.getLine () + 
                  ")") ;
          else
          {
              s = e.getSymbole (i1.getText ()) ;
              if (s.getType () != MULOT)
                  System.err.println (
                      SYMBOLE_BADTYPE +
                      " : " +
                      i1.getText () +
                      " (" +
                      i1.getLine () + 
                      ")") ;
              else
              {
                  instruction = new Instruction (LEVE, i1.getText ()) ;
                  c.addInstruction (instruction) ;
              }
          }
      }
    | i2:ID POINT TK_avance LPAREN 
      expression [c, e] 
      {
          if (ENTIER != c.getTypeLastInstruction (e))
              System.err.println (
                  PARAMETRE_BADTYPE +
                  " : entier attendu" +
                  " (" +
                  i2.getLine () + 
                  ")") ;
      }
      RPAREN SEMI
      {
          if (!e.existSymbole (i2.getText ()))
              System.err.println (
                  SYMBOLE_NOTEXIST +
                  " : " +
                  i2.getText () +
                  " (" +
                  i2.getLine () + 
                  ")") ;
          else
          {
              s = e.getSymbole (i2.getText ()) ;
              if (s.getType () != MULOT)
                  System.err.println (
                      SYMBOLE_BADTYPE +
                      " : " +
                      i2.getText () +
                      " (" +
                      i2.getLine () + 
                      ")") ;
              else
              {
                      instruction = new Instruction (AVAN, i2.getText ()) ;
                      c.addInstruction (instruction) ;
              }
          }
      }
    | i3:ID POINT TK_tourne LPAREN 
      expression [c, e] 
      {
          if (ENTIER != c.getTypeLastInstruction (e))
              System.err.println (
                  PARAMETRE_BADTYPE +
                  " : entier attendu" +
                  " (" +
                  i3.getLine () + 
                  ")") ;
      }
      RPAREN SEMI
      {
          if (!e.existSymbole (i3.getText ()))
              System.err.println (
                  SYMBOLE_NOTEXIST +
                  " : " +
                  i3.getText () +
                  " (" +
                  i3.getLine () + 
                  ")") ;
          else
          {
              s = e.getSymbole (i3.getText ()) ;
              if (s.getType () != MULOT)
                  System.err.println (
                      SYMBOLE_BADTYPE +
                      " : " +
                      i3.getText () +
                      " (" +
                      i3.getLine () + 
                      ")") ;
              else
              {
                      instruction = new Instruction (TOUR, i3.getText ()) ;
                      c.addInstruction (instruction) ;
              }
          }
      }
    | appelSousProgramme [c, e] SEMI
    ;

// Definition d'une boucle Pour.
// On verifie que la variable de boucle n'est pas definie ou est du type
// ENTIER. On verifie egalement le type de la condition d'arret (ENTIER).
// On encadre le corps de la boucle par des instructions de sauts.
boucle [boolean enableReturn, Code c, EnvironnementP e, Hashtable h]
{
    Instruction instruction ;
    Code cb ;
    EnvironnementP eb ;
    int t, nbInstruction ;
    Symbole s, s2 ; 
    Hashtable h1 ;
    Enumeration enum ;

    h1 = new Hashtable () ;
}
    : TK_Pour 
      i:ID 
      ASSIGN 
      expression [c, e]
      {
          t = c.getTypeLastInstruction (e) ;
          if (ENTIER != t)
              System.err.println (
                  SYMBOLE_BADTYPE +
                  " : " +
                  i.getText () +
                  " (" +
                  i.getLine () + 
                  ")") ;
          else
          {
              if (e.definedSymbole (i.getText ()))
              {
                  s = e.getSymbole (i.getText ()) ;
                  if (PARAMETRE == s.getStatut ())
                      System.err.println (
                          ASSIGN_PARAMETRE +
                          " : " +
                          i.getText () +
                          " (" +
                          i.getLine () + 
                          ")") ;
                  else
                      if (s.getType () != t) 
                          System.err.println (
                              ASSIGN_BADTYPE +
                              " : " +
                              (ENTIER == s.getType () ? "entier" : "Mulot") +
                              " expected" +
                              " (" +
                              i.getLine () + 
                              ")") ;
                      else
                      {
                          instruction = new Instruction (POP, i.getText ()) ;
                          c.addInstruction (instruction) ;
                      }
              }
              else
              {
                  s = new Symbole (i.getText (), t, VARIABLE) ;
                  e.addSymbole (s) ;
                  instruction = new Instruction (POP, i.getText ()) ;
                  c.addInstruction (instruction) ;
              }
              h.put (s.getNom (), s) ;
          }
      }
      TK_a
      {
          nbInstruction = c.getNombreInstructions () ;
          instruction = new Instruction (PUSO, i.getText ()) ;
          c.addInstruction (instruction) ;
      }
      expression [c, e]
      {
          nbInstruction = c.getNombreInstructions () - nbInstruction ;
          t = c.getTypeLastInstruction (e) ;
          if (ENTIER != t)
              System.err.println (
                  ASSIGN_BADTYPE +
                  " : entier attendu" +
                  " (" +
                  i.getLine () + 
                  ")") ;
          cb = new Code (null, null) ;
          eb = new EnvironnementP (null, VIDE, e) ;
      }
      corps [enableReturn, cb, eb, h1]
      TK_Ruop
      {
          enum = h1.elements () ;
          while (enum.hasMoreElements ())
          {
              s = (Symbole) enum.nextElement () ;
              s2 = (Symbole) h.get (s.getNom ()) ;
              if (null == s2)
                  s.setFlou () ;
              h.put (s.getNom (), s) ;
          }
          instruction = new Instruction (GT) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (
              JBP, 
              cb.getNombreInstructions () + SORTIEPOUR) ; 
          c.addInstruction (instruction) ;
          c.addInstructions (cb.getInstructions ()) ;
          instruction = new Instruction (PUSO, i.getText ()) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (PUSI, INCREMENTPOUR) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (ADD) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (POP, i.getText ()) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (
              JMP, 
              -(nbInstruction + cb.getNombreInstructions () + CONDITIONPOUR)) ;
          c.addInstruction (instruction) ;
      }
    ;

// Definition d'une boucle TantQue.
tantque [boolean enableReturn, Code c, EnvironnementP e, Hashtable h]
{
    Instruction instruction ;
    Code ct ;
    EnvironnementP et ;
    int t, nbInstruction ;
    Symbole s, s2 ; 
    Hashtable h1 ;
    Enumeration enum ;

    h1 = new Hashtable () ;
}
    : TK_TantQue
      LPAREN
      {
          nbInstruction = c.getNombreInstructions () ;
      } 
      expression [c, e]
      {
          t = c.getTypeLastInstruction (e) ;
          if (BOOLEEN != t)
              System.err.println (
                  CONDITION_BADTYPE +
                  " : booleen attendu") ;

          nbInstruction = c.getNombreInstructions () - nbInstruction ;
          ct = new Code (null, null) ;
          et = new EnvironnementP (null, VIDE, e) ;
      }
      RPAREN
      corps [enableReturn, ct, et, h1]
      TK_Tnat
      {
          enum = h1.elements () ;
          while (enum.hasMoreElements ())
          {
              s = (Symbole) enum.nextElement () ;
              s2 = (Symbole) h.get (s.getNom ()) ;
              if (null == s2)
                  s.setFlou () ;
              h.put (s.getNom (), s) ;
          }
          instruction = new Instruction (NOT) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (
              JBP, 
              ct.getNombreInstructions () + SORTIETANTQUE) ;
          c.addInstruction (instruction) ;
          c.addInstructions (ct.getInstructions ()) ;
          instruction = new Instruction (
              JMP, 
              -(
                  nbInstruction + 
                  ct.getNombreInstructions () + 
                  CONDITIONTANTQUE)) ;
          c.addInstruction (instruction) ;
      }
    ;

// Definition de la structure conditionnelle Si.
// On verifie la concordance des types de la condition.
// On encadre les instructions par des instructions de saut.
conditionnelle [boolean enableReturn, Code c, EnvironnementP e, Hashtable h]
{
    Code cc, cc1 ;
    Instruction instruction = null ;
    boolean sinon ;
    int saut ;
    Hashtable h1 ;
    Hashtable h2 ;
    Enumeration enum ;
    Symbole s, s2, s3 ;

    sinon = false ;
    cc = new Code (null, null) ;
    cc1 = new Code (null, null) ;
    h1 = new Hashtable () ;
    h2 = new Hashtable () ;
}
    : TK_Si 
      LPAREN 
      expression [c, e] 
      {
          if (BOOLEEN != c.getTypeLastInstruction (e))
              System.err.println (
                  CONDITION_BADTYPE +
                  " : booleen attendu") ;
      }
      RPAREN 
      TK_Alors
      corps [enableReturn, cc, e, h1]
      (
        TK_Sinon 
        corps [enableReturn, cc1, e, h2]
        {
            sinon = true ;
        }
      )?
      TK_Is
      {
          if (sinon)
          {
              enum = h1.elements () ;
              while (enum.hasMoreElements ())
              {
                  s = (Symbole) enum.nextElement () ;
                  s2 = (Symbole) h2.get (s.getNom ()) ;
                  s3 = (Symbole) h.get (s.getNom ()) ;
                  if ((null == s2) && (null == s3))
                      s.setFlou () ;
                  h.put (s.getNom (), s) ;
              }
              enum = h2.elements () ;
              while (enum.hasMoreElements ())
              {
                  s = (Symbole) enum.nextElement () ;
                  s2 = (Symbole) h1.get (s.getNom ()) ;
                  s3 = (Symbole) h.get (s.getNom ()) ;
                  if ((null == s2) && (null == s3))
                  {
                      s.setFlou () ;
                      h.put (s.getNom (), s) ;
                  }
              }
          }
          else
          {
              enum = h1.elements () ;
              while (enum.hasMoreElements ())
              {
                  s = (Symbole) enum.nextElement () ;
                  s2 = (Symbole) h.get (s.getNom ()) ;
                  if (null == s2)
                      s.setFlou () ;
                  h.put (s.getNom (), s) ;
              }
          }

          saut = cc.getNombreInstructions () ;
          if (sinon)
              saut ++ ;
          instruction = new Instruction (NOT) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (JBP, saut) ;
          c.addInstruction (instruction) ;
          c.addInstructions (cc.getInstructions ()) ;
          if (sinon)
          {
              instruction = new Instruction (
                  JMP, 
                  cc1.getNombreInstructions ()) ;
              c.addInstruction (instruction) ;
              c.addInstructions (cc1.getInstructions ()) ;
          }  
      }
    ;

// Definition des types (ENTIER ou MULOT).
type returns [int t]
{
    t = VIDE ;
}
    : TK_Mulot { t = MULOT ; }
    | TK_int   { t = ENTIER ; }
    ;

// Definition d'une liste de declaration (definition procedure ou fonction).
// On verifie que les symboles ne sont pas definis.
listeDeclaration [Code c, EnvironnementP e]
{
    Vector instructions ;
    Instruction instruction ;
    Symbole symbole ;
    int t, t2, j ;

    instructions = new Vector () ;

}
    : (
      t = type 
      i:ID 
        {
            if (e.definedSymbole (i.getText ()))
                System.err.println (
                    SYMBOLE_DEFINED +
                    " : " +
                    i.getText () +
                    " (" +
                    i.getLine () + 
                    ")") ;
            else
            {
                instruction = new Instruction (POP, i.getText ()) ;
                instructions.addElement (instruction) ;
                symbole = new Symbole (i.getText (), t, PARAMETRE) ;
                e.addSymbole (symbole) ;
                e.addParametre (t) ;
            }
        }
      (COMMA 
      t2 = type 
      i2:ID
        {
            if (e.definedSymbole (i2.getText ()))
                System.err.println (
                    SYMBOLE_DEFINED +
                    " : " +
                    i2.getText () +
                    " (" +
                    i2.getLine () + 
                    ")") ;
            else
            {
                instruction = new Instruction (POP, i2.getText ()) ;
                instructions.addElement (instruction) ;
                symbole = new Symbole (i2.getText (), t2, PARAMETRE) ;
                e.addSymbole (symbole) ;
                e.addParametre (t2) ;
            }
        }
      )*
      {
          for (j = (instructions.size () - 1) ; j >= 0 ; j --)
              c.addInstruction ((Instruction) instructions.elementAt (j)) ;
      }
      )?
    ;

// Definition d'un appel de sousprogramme.
// On verifie l'existence, en tant que sousprogramme. On verifie la 
// concordance des types des parametres et leur nombre.
appelSousProgramme [Code c, EnvironnementP e]
{
    int parametre ;
    Instruction instruction ;
    EnvironnementP sp ;

    sp = null ;
    parametre = 0 ;
}
    : i:ID 
      {
          if (!e.existSPrg (i.getText ()))
              System.err.println (
                  SPRG_NOTEXIST +
                  " : " +
                  i.getText ()) ;
          else
              sp = e.getSPrg (i.getText ()) ;
      }
      LPAREN 
      (
        expression [c, e] 
        {
            if (null != sp)
            {
                if ((VIDE == sp.getTypeParametre (parametre)) ||
                    (sp.getTypeParametre (parametre) != 
                        c.getTypeLastInstruction (e)))
                    System.err.println (
                        PARAMETRE_BADTYPE +
                        " : " +
                        i.getText () +
                        " (" +
                        i.getLine () + 
                        ")") ;
                parametre ++ ;
            }
        }
        (COMMA 
          expression [c, e]
          {
              if (null != sp)
              {
                  if ((VIDE == sp.getTypeParametre (parametre)) ||
                      (sp.getTypeParametre (parametre) != 
                          c.getTypeLastInstruction (e)))
                      System.err.println (
                          PARAMETRE_BADTYPE +
                          " : " +
                          i.getText () +
                          " (" +
                          i.getLine () + 
                          ")") ;
                  parametre ++ ;
              }
          }
        )*
      )? RPAREN
      {
          if (null != sp)
          {
              if (parametre != sp.getNombreParametre ())
                  System.err.println (
                      PARAMETRE_BADNUMBER +
                      " : " +
                      i.getText () +
                      " (" +
                      i.getLine () + 
                      ")") ;
              else
              {
                  instruction = new Instruction (CALL, i.getText ()) ;
                  c.addInstruction (instruction) ;
              }
          }
      }
    ;

// Definition des couleurs.
couleur [Code c]
{
    int couleur ;
    Instruction instruction ;
}
    : ( TK_WHITE { couleur = WHITE ; }
      | TK_BLACK { couleur = BLACK ; }
      | TK_BLUE { couleur = BLUE ; }
      | TK_CYAN { couleur = CYAN ; }
      | TK_DARKGRAY { couleur = DARKGRAY ; }
      | TK_GRAY { couleur = GRAY ; }
      | TK_LIGHTGRAY { couleur = LIGHTGRAY ; }
      | TK_GREEN { couleur = GREEN ; }
      | TK_MAGENTA { couleur = MAGENTA ; }
      | TK_ORANGE { couleur = ORANGE ; }
      | TK_PINK { couleur = PINK ; }
      | TK_RED { couleur = RED ; }
      | TK_YELLOW { couleur = YELLOW ; }
      ) 
      {
          instruction = new Instruction (PUSI, couleur) ;
          c.addInstruction (instruction) ;
      }
    ;

// Definition d'une expression.
expression [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    boolean fait ;

    instruction = null ;
    t = - 1 ;
    fait = false ;
}
    : exprAnd [c, e] 
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        OU
        exprAnd [c, e]
        {
            if ((! fait) && (t != BOOLEEN))
            {
                System.err.println (
                    CONDITION_BADTYPE +
                    " : booleen attendu") ;
                fait = true ;
            }
            if (BOOLEEN != c.getTypeLastInstruction (e))
                System.err.println (
                    CONDITION_BADTYPE +
                    " : booleen attendu") ;

            instruction = new Instruction (OR) ;
            c.addInstruction (instruction) ;
        }
      )* 
    ;

// Definition d'une expression booleenne a base de ET logiques.
exprAnd [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    boolean fait ;

    instruction = null ;
    t = - 1 ;
    fait = false ;
}
    : exprEqual [c, e]
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        ET
        exprEqual [c, e]
        {
            if ((! fait) && (t != BOOLEEN))
            {
                System.err.println (
                    CONDITION_BADTYPE +
                    " : booleen attendu") ;
                fait = true ;
            }
            if (BOOLEEN != c.getTypeLastInstruction (e))
                System.err.println (
                    CONDITION_BADTYPE +
                    " : booleen attendu") ;

            instruction = new Instruction (AND) ;
            c.addInstruction (instruction) ;
        }
      )* 
    ;

exprEqual [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    int opCond ;

    instruction = null ;
    t = - 1 ;
    opCond = -1 ;
}
    : exprRelation [c, e] 
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        ( EGALITE { opCond = EGALITE ; }
        | DIFF    { opCond = DIFF ; }
        )
        exprRelation [c, e]
        {
            if (t != ENTIER)
                System.err.println (
                    CONDITION_BADTYPE +
                    " : entier attendu") ;
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    CONDITION_BADTYPE +
                    " : entier attendu") ;

            switch (opCond)
            {
            case EGALITE :
                instruction = new Instruction (EQ) ;
                break ;
            case DIFF :
                instruction = new Instruction (NQ) ;
                break ;
            }
            c.addInstruction (instruction) ;
        }
      )?
    ;

exprRelation [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    int opCond ;

    instruction = null ;
    t = - 1 ;
    opCond = -1 ;
}
    : exprAdditive [c, e]
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        ( SUP     { opCond = SUP ; }
        | INF     { opCond = INF ; }
        | SUPEQ   { opCond = SUPEQ ; }
        | INFEQ   { opCond = INFEQ ; }
        ) 
        exprAdditive [c, e]
        {
            if (t != ENTIER)
                System.err.println (
                    CONDITION_BADTYPE +
                    " : entier attendu") ;
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    CONDITION_BADTYPE +
                    " : entier attendu") ;

            switch (opCond)
            {
            case SUP :
                instruction = new Instruction (GT) ;
                break ;
            case INF :
                instruction = new Instruction (LT) ;
                break ;
            case SUPEQ :
                instruction = new Instruction (GE) ;
                break ;
            case INFEQ :
                instruction = new Instruction (LE) ;
                break ;
            }
            c.addInstruction (instruction) ;
        }
      )?
    ;

exprAdditive [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    int op ;
    boolean fait ;

    instruction = null ;
    t = - 1 ;
    fait = false ;
    op = -1 ;
}
    : sousExpression [c, e] 
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        ( PLUS  { op = PLUS ; }
        | MOINS { op = MOINS ; }
        ) 
        sousExpression [c, e]
        {
            if ((! fait) && (t != ENTIER))
            {
                System.err.println (
                    OPERATION_BADTYPE +
                    " : entier attendu") ;
                fait = true ;
            }
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    OPERATION_BADTYPE +
                    " : entier attendu") ;

            switch (op)
            {
            case PLUS :
                instruction = new Instruction (ADD) ;
                break ;
            case MOINS :
                instruction = new Instruction (SUB) ;
                break ;
            }
            c.addInstruction (instruction) ;
        }
      )*
    ;

sousExpression [Code c, EnvironnementP e]
{
    Instruction instruction ;
    int t ;
    int op ;
    boolean fait ;

    instruction = null ;
    t = - 1 ;
    fait = false ;
    op = -1 ;
}
    : terme [c, e] 
      {
          t = c.getTypeLastInstruction (e) ;
      }
      (
        ( ETOILE   { op = ETOILE ; }
        | DIVISION { op = DIVISION ; }
        | MODULO   { op = MODULO ; }
        ) 
        terme [c, e]
        {
            if ((! fait) && (t != ENTIER))
            {
                System.err.println (
                    OPERATION_BADTYPE +
                    " : entier attendu") ;
                fait = true ;
            }
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    OPERATION_BADTYPE +
                    " : entier attendu") ;

            switch (op)
            {
            case ETOILE :
                instruction = new Instruction (MUL) ;
                break ;
            case DIVISION :
                instruction = new Instruction (DIV) ;
                break ;
            case MODULO :
                instruction = new Instruction (MOD) ;
                break ;
            }
            c.addInstruction (instruction) ;
        }
      )*
    ;

// Definition d'un terme.
terme [Code c, EnvironnementP e]
{
    Instruction instruction ;
    boolean moins, signe ;

    moins = false ;
    signe = false ;
}
    : ( PLUS  { signe = true ; }
      | MOINS { moins = true ; signe = true ; }
      | 
      ) 
      atom [c, e]
      {
          if (signe && (ENTIER != c.getTypeLastInstruction (e)))
              System.err.println (
                  OPERATION_BADTYPE +
                  " : entier attendu") ;
          if (moins)
          {
              instruction = new Instruction (PUSI, -1) ;
              c.addInstruction (instruction) ;
              instruction = new Instruction (MUL) ;
              c.addInstruction (instruction) ;
          }
      }
    | NON LPAREN expression [c, e] RPAREN
      {
          if (BOOLEEN != c.getTypeLastInstruction (e))
              System.err.println (
                  CONDITION_BADTYPE +
                  " : booleen attendu") ;
          instruction = new Instruction (NOT) ;
          c.addInstruction (instruction) ;
      }
    ;

// Definition d'un atome.
// Pour un identifiant, on verifie son existence.
// Pour la creation d'un mulot, on verifie la concordance des parametres.
atom [Code c, EnvironnementP e]
{
    int t, nbParametre ;
    Symbole s ;
    Instruction instruction ;

    nbParametre = 0 ;
}
    : i:ID
      {
          if (!e.existSymbole (i.getText ()))
              System.err.println (
                  SYMBOLE_NOTEXIST +
                  " : " +
                  i.getText () +
                  " (" +
                  i.getLine () + 
                  ")") ;
          else
          {
              s = e.getSymbole (i.getText ()) ;
              if (s.isFlou ())
                  System.err.println (
                      SYMBOLE_MAYNOTEXIST +
                      " : " +
                      i.getText () +
                      " (" +
                      i.getLine () + 
                      ")") ;
              else
              {
                  instruction = new Instruction (PUSO, i.getText ()) ;
                  c.addInstruction (instruction) ;
              }
          }
      }
    | i2:INT
      {
          instruction = new Instruction (PUSI, Integer
              .valueOf (i2.getText ()).intValue ()) ;
          c.addInstruction (instruction) ;
      }
    | appelSousProgramme [c, e]
    | TK_saisieEntier LPAREN RPAREN
      {
          instruction = new Instruction (GETI) ;
          c.addInstruction (instruction) ;
      }
    | LPAREN expression [c, e] RPAREN
    | TK_new TK_Mulot 
      LPAREN 
      (
        expression [c, e] 
        {
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    PARAMETRE_BADTYPE +
                    " : le premier") ;
        }
        COMMA 
        expression [c, e] 
        { 
            nbParametre = 2 ; 
            if (ENTIER != c.getTypeLastInstruction (e))
                System.err.println (
                    PARAMETRE_BADTYPE +
                    " : le deuxieme") ;
        }
        (
          COMMA 
          couleur [c] 
          { 
              nbParametre = 3 ; 
              if (ENTIER != c.getTypeLastInstruction (e))
                  System.err.println (
                      PARAMETRE_BADTYPE +
                      " : le troisieme") ;
          }
            (
               COMMA 
               expression [c, e] 
               { 
                   nbParametre = 4 ; 
                   if (ENTIER != c.getTypeLastInstruction (e))
                       System.err.println (
                           PARAMETRE_BADTYPE +
                           " : le quatrieme") ;
               }
            )?
        )?
      )? 
      RPAREN
      {
          instruction = new Instruction (PUSI, nbParametre) ;
          c.addInstruction (instruction) ;
          instruction = new Instruction (NEWM) ;
          c.addInstruction (instruction) ;
      }
    ;