import java.awt.Color ;

/**
 * Constantes nécessaires à la définition de la tables des
 * symboles et de la représentation intermédiaire. On trouve également la liste
 * couleur utilisable dans les programmes Mulot. Et aussi quelques constantes
 * pour définir les dimensions des certains composants. Ces dernières 
 * constantes sont les valeurs par défaut des paramètres de l'application.
 *
 * @author Erwan Prioul
 * $RCSfile: MulotSrc.java,v $:$Revision: 1.2 $
 */
public interface MulotSrc
{
    public final static String MULOTTITLE = "Mulot v2.32" ;

    public final static String FICHIERPARAMETRE = "Mulot.rc" ;

    public final static int TWOWINDOWS     = 1 ;
    public final static int ONEWINDOWEAST  = 2 ;
    public final static int ONEWINDOWSOUTH = 3 ;

    public final static int WRITTINGROWS = 25 ;
    public final static int MESSAGEROWS  = 5 ;
    public final static int COLUMNS      = 40 ;
    public final static int WIDTH        = 600 ;
    public final static int HEIGHT       = 600 ;
    public final static int WIDTHVS      = 300 ;
    public final static int HEIGHTVS     = 300 ;
    public final static int COULEURFOND  = 0 ;
    public final static int ATTENTE      = 50 ;
    public final static int WINDOWS      = TWOWINDOWS ;

    public final static int NBCOLOR = 13 ;

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
    
    public final static String LIBWHITE     = "Blanc" ;
    public final static String LIBBLACK     = "Noir" ;
    public final static String LIBBLUE      = "Bleu" ;
    public final static String LIBCYAN      = "Cyan" ;
    public final static String LIBDARKGRAY  = "Gris foncé" ;
    public final static String LIBGRAY      = "Gris" ;
    public final static String LIBLIGHTGRAY = "Gris clair" ;
    public final static String LIBGREEN     = "Vert" ;
    public final static String LIBMAGENTA   = "Magenta" ;
    public final static String LIBORANGE    = "Orange" ;
    public final static String LIBPINK      = "Rose" ;
    public final static String LIBRED       = "Rouge" ;
    public final static String LIBYELLOW    = "Jaune" ;

    public final static String NBLIGNESEDITEUR = 
        "Nombre de lignes pour la zone d'édition :  " ;
    public final static String NBLIGNESMSG     = 
        "Nombre de lignes pour la zone d'erreur :   " ;
    public final static String NBCOLONNES      = 
        "Nombres de colonnes :                      " ;
    public final static String LGZONE          = 
        "Largeur du terrain de jeu pour mulots :    " ;
    public final static String HTZONE          = 
        "Hauteur du terrain de jeu pour mulots :    " ;
    public final static String LGAFF           = 
        "Largeur de l'affichage du terrain de jeu : " ;
    public final static String HTAFF           = 
        "Hauteur de l'affichage du terrain de jeu : " ;
    public final static String LIBATTENTE      = 
        "Delai entre chaque rafraîchissement (ms) : " ;
    public final static String LIBCOULEURFOND  = 
        "Couleur du terrain de jeu pour mulots : " ;
    public final static String AFFICHAGE       = 
        "Type d'affichage :" ;
    public final static String AFFTYPE1        = 
        "1" ;
    public final static String LIBAFFTYPE1     = 
        "- une fenêtre pour l'éditeur et une autre pour le terrain de jeu" ;
    public final static String AFFTYPE2        = 
        "2" ;
    public final static String LIBAFFTYPE2     = 
        "- une seule fenêtre, terrain de jeu à droite de l'éditeur" ;
    public final static String AFFTYPE3        = 
        "3" ;
    public final static String LIBAFFTYPE3     = 
        "- une seule fenêtre, terrain de jeu en dessous de l'éditeur" ;
    
    public final static String DIVISIONBYZERO =
        "Erreur : division par zéro." ;

    public final static int ENTIER  = 0 ;
    public final static int MULOT   = 1 ;
    public final static int BOOLEEN = 3 ;
    public final static int VIDE    = 2 ;
    
    public final static int VARIABLE  = 0 ;
    public final static int PARAMETRE = 1 ;

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

    public final static int INCREMENT_INSTRUCTION  = 1 ;
}
