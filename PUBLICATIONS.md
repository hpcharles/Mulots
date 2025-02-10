# Apprentissage de la programmation à l'aide de MULOT

## 1. Mulot un langage de programmation destiné a l'apprentissage


## 2. Résumé 

Pour les débutants sans expérience en algorithmie ou programmation, aborder directement un langage de programmation complet peut s’avérer difficile. La compréhension des mécanismes et des concepts fondamentaux peut être abstraite, ce qui freine leur apprentissage.

Mulot a été conçu pour pallier cette difficulté. Ce langage éducatif ne cherche pas à remplacer les langages traditionnels, mais plutôt à servir de passerelle vers eux. Mulot permet aux apprenants de comprendre, de manière simple et visuelle, les principes de base de la programmation. Il constitue ainsi une introduction progressive avant de passer à des langages plus complexes, comme le C.

En quelques cours, Mulot aide les étudiants à visualiser le fonctionnement des algorithmes tout en rendant leur apprentissage concret et engageant. Une fois les bases acquises, ses limites peuvent être exploitées pour amorcer une transition naturelle vers des outils plus avancés, favorisant ainsi un apprentissage structuré et progressif.

## 3. Introduction

Apprendre à programmer en utilisant un langage de programmation complet peut être une tâche intimidante, en particulier pour les débutants qui n'ont aucune expérience préalable en algorithmie ou en informatique. Les concepts de base, tels que les variables, les boucles ou les fonctions, peuvent sembler abstraits, et la transition entre l'écriture du code et l'observation de ses effets n'est pas toujours intuitive. Ce manque de lien immédiat entre le code et son exécution peut décourager les apprenants, rendant leur progression plus lente et moins engageante.

C'est pour répondre à ce problème que Mulot a été créé. Mulot n’a pas vocation à remplacer les langages de programmation traditionnels. Son objectif est de servir de tremplin, une étape introductive qui aide les apprenants à comprendre les principes fondamentaux de la programmation de manière simple, visuelle et ludique. En plaçant l'accent sur des concepts essentiels à travers des résultats graphiques immédiats, Mulot offre une approche pédagogique qui rend les algorithmes tangibles.

Par exemple, l’apprentissage de Mulot peut constituer une introduction idéale à des langages plus complexes comme le C. Quelques cours sur Mulot suffisent pour initier les étudiants à la logique algorithmique, tout en illustrant graphiquement les mécanismes sous-jacents. Une fois ces bases assimilées, les limitations intrinsèques de Mulot peuvent être exploitées pour motiver la transition vers des langages professionnels, favorisant ainsi un apprentissage progressif et cohérent.

En somme, Mulot vise à réduire la barrière d’entrée dans la programmation, en aidant les débutants à développer une compréhension intuitive des concepts clés avant de se plonger dans des langages plus rigoureux.

## 4. État de l'art

Mulot est un langage de programmation éducatif tel que Scratch ou Logo
ou Blockly. Néanmoins, contrairement à Scratch et Blockly qui utilise
une représentation graphique sous forme de bloc pour les algorithmes,
Mulot utilise une syntaxe textuel simple pour apprendre à
l'utilisateur le principe d'écriture d'un programme comme en C. De
plus, contrairement à Logo la syntaxe de Mulot ressemble à la syntaxe
des langages moderne. Mulot vient combler la limite des approches
actuelles en facilitant la transition vers des langages de
programmation réels tels que le C ou Java. Pour conclure, Mulot possède les
avantages de la simplicité de prise en main comme scratch ou Blockly,
permet un retour graphique tout comme ces homologues, mais permet une
transition simple vers de vrais langages.

## 5. Fonctionnement du langage

### Présentation du langage

Vous pouvez créer des variables (int ou Mulot) dans toutes les normes
de nommage existantes (Pascal Case, camel Case, snake_case, kebab-case,
UPPERCASE, et toutes les combinaisons possibles de ces cases...) ainsi
que des fonctions nommées exactement comme les variables (NB : il peut
être intéressant pour l'utilisateur d'apprendre grâce à Mulot les
différentes normes de nommages). Jusque-là cela ressemble à un langage
classique, c'est là qu'intervient le Mulot. En effet, dans le langage
Mulot, il est possible de créer des objets Mulot qui vont permettre
différentes interactions avec la fenêtre. Ces actions vont permettre de
realiser des figures ou des dessins la majorité des actions permettre
le déplacement du Mulot. Effectivement le Mulot possède des
coordonnées sur la fenêtre et il se déplace en dessinant (cela dépend
de l'état du Mulot Lever/Baisser). Un programem Mulot se distingue en
deux sections. Première section les déclarations de fonctions (si
l'utilisateur n'utilise pas de fonction alors cette section est
vide). Deuxième Section le code. En effet, dans cette section il
suffit a l'utilisateur d'écrire les lignes de code pour qu'elle soit
interpréter. En parlant d'interprétation le langage Mulot ne peut
tourner uniquement sur l'interpréteur fournit avec ce dépôt car toutes
les interactions du Mulot se font sur cet interpréteur. Il faut
noter que Tout code Mulot commence par ``Mulot`` et termine par ``Tolum``


### Calcul

Les calculs au sein de mulot sont vraiment simples, on peut appliquer
des opérations sur des variables des entiers ou d'autre opérations. Les
priorités des opérations sont les mêmes qu'en mathématiques
classiques. On peut aussi utiliser les parenthèses pour gérer la
priorité des opérations.

Liste d'exemple :
    * 1+2
    * 3/2
    * 15-12
    * -2+4
    * 4*5 
    * Variable*2
    * Variable*(Variable+(4*5))
    * -Variable
    * -12

### Variables

Vous pouvez créer une variable contenant un entier comme ceci :
``Variable = 12;`` (or another expression). Une variable doit forcément
être initialisé lors de sa création, il n'est donc pas possible de
faire : ``Variable;`` pour créer une variable. Il est donc aussi possible
d'initialiser une variable avec un calcul comme ``Variable2 = Variable *
4;`` ou encore ``Variable3 = Variable2 + Name / 5;``

### Commentaire

Il existe des commentaires dans Mulot. Il serait intéressant d'apprendre à l'utilisateur de commenter et de décrire ce que fait son code. 
Il existe deux moyens de commenter : 
* par ligne -- le reste de la ligne est commentée
* par block -* jusqu'à que je croise les 2 caractères inversés je suis un commentaire *- 

### Description Mulot

Le Mulot est un objet qui possède une position dans le plan, une Couleur et un angle. Ces données vont permettre la manipulation du Mulot la couleur permet de définir la couleur qui s'affichera à l'écran lorsque le Mulot dessine en avançant.

### Instanciation de Mulot

Pour créer un Mulot, il existe plusieurs façons de faire, mais la syntaxe reste la même cela dépendra uniquement du nombre d'arguments utilisé.
Il existe 4 façons de créer un Mulot:
* mulot = new Mulot(XPosition,YPosition,COLOR,ANGLE);
* mulot2 = new Mulot(XPosition,YPosition,COLOR);
* mulot3 = new Mulot(XPosition,YPosition);
* mulot4 = new Mulot();

La première permet de choisir la position du Mulot sa couleur et son angle de départ. La deuxième ne comprend pas l'angle et set un angle par défaut de 0. La troisième ne comprend pas l'angle et la couleur, elle set un angle par défaut a 0 et la couleur à BLACK (noir). Et la dernière permet de créer un Mulot a une positionX=0, une positionY=0 de couleur BLACK avec un angle de 0.

### Utilisation Mulot

Il existe 8 fonctions de l'objet Mulot qui permette de le manipuler. 

#### avance

Avance permet de faire bouger le Mulot d'une certaine distance en fonction de l'angle. La syntaxe est : mulot.avance(expression);.
Liste d'exemple d'utilisation de avance :
* mulot.avance(10); mulot va avancer de 10 
* mulot.avance(10*2+4); mulot va avancer de 24
* mulot.avance(Variable); mulot va avancer de la valeur de Variable
* mulot.avance(Variable*2*10); mulot va avancer de la valeur de variable * 20 + 4

#### tourne

Tourne permet de modifier l'angle actuel du Mulot en fonction de l'angle actuel. la syntaxe est : mulot.tourne(expression);. Lors du calcul l'angle est toujours modulo à 360 pour ne jamais dépasser 360.

Liste d'exemple d'utilisation de ``tourne`` :

* mulot.tourne(10); --mulot va ajouter 10 a son angle
* mulot.tourne(10*2+4); -- mulot va ajouter 24 a son angle
* mulot.tourne(Variable); -- mulot va ajouter la valeur de Variable a son angle
* mulot.tourne(Variable*2*10); -- mulot va ajouter la valeur de variable * 20 + 4 a son angle

#### leve

Leve permet d'indiquer au Mulot que même s'il avance il ne doit pas dessiner. Utilisation : ``mulot.leve();``

#### baisse

Baisse permet d'indiquer au Mulot de recommencer à dessiner lorsqu'il avance. Utilisation : ``mulot.baisse();``

#### setX

setX permet de changer la valeur de positionX pour une nouvelle. La syntaxe est : ``mulot.setX(expression);``
Liste d'exemple d'utilisation de setX:
* mulot.setX(10); --mulot va prendre une positionX de 10
* mulot.setX(10*2+4); -- mulot va prendre une positionX de 24
* mulot.setX(Variable); -- mulot va prendre une positionX de la valeur de la variable
* mulot.setX(Variable*2*10); -- mulot va prendre une positionX de la valeur de la variable *20 + 4

#### setY

setY permet de changer la valeur de positionY pour une nouvelle. La syntaxe est : ``mulot.setY(expression);``
Liste d'exemple d'utilisation de setY:
* mulot.setY(10); --mulot va prendre une positionY de 10 
* mulot.setY(10*2+4); -- mulot va prendre une positionY de 24
* mulot.setY(Variable); -- mulot va prendre une positionY de la valeur de la variable
* mulot.setY(Variable*2*10); -- mulot va prendre une positionY de la valeur de la variable *20 + 4

#### setAngle

setAngle permet de changer la valeur de l'angle pour une nouvelle. La syntaxe est : ``mulot.setAngle(expression);``
Liste d'exemple d'utilisation de setAngle:
* mulot.setAngle(10); --mulot va prendre un angle de 10
* mulot.setAngle(10*2+4); -- mulot va prendre un angle de 24
* mulot.setAngle(Variable); -- mulot va prendre un angle de la valeur de la variable
* mulot.setAngle(Variable*2*10); -- mulot va prendre une angle de la valeur de la variable *20 + 4

#### setColor

setColor permet de changer la couleur du Mulot pour une nouvelle. La syntaxe est : mulot.setColor(Color);
Liste des couleurs existantes :
* RED -- mulot dessine désormais en rouge
* GREEN -- mulot dessine désormais en vert
* BLUE -- mulot dessine désormais en bleu
* WHITE -- mulot dessine désormais en blanc
* BLACK -- mulot dessine désormais en noir
* YELLOW -- mulot dessine désormais en jaune

### Boucle 

Dans le langage Mulot, il est possible de faire des boucles ``Pour``
afin d'éviter la redondance. La syntaxe des boucles : ``Pour Variable =
Number a expression`` . Ensuite se trouve le code à répéter à chaque
tour de boucle et a la fin de la boucle le mot clé ``Ruop``.

Exemple :

```
Pour i = 0 a 3
        t.avance(100);
        t.tourne(90);
Ruop    
```

### Fonction

Dans le langage Mulot, il est possible de créer des fonctions pour éviter la redondance du code et factoriser le code la définition des fonctions doit forcément se trouver avant le début du code. En effet l'exécution commence après les déclarations de fonction. Une fonction commence par le mot clé Proc suivi du nom que l'on souhaite lui donner. Ensuite va se trouver de la liste des paramètres. Une fois cela fait on peux rentrer le code que l'on veut dans la fonction et il sera utilisé lors de l'appel de fonction.

Exemple de fonction :

```
    Proc Square(int taille, Mulot m)
        Pour i = 0 a 3
            m.avance(taille);
            m.tourne(90);
        Ruop
    Corp
```

### Utilisation de fonction

Une fois qu'une fonction a été définie, on peut désormais l'appeler. Pour l'appeler la syntaxe est ``nomFonction(listeArgument);`` Si on reprend notre précédent exemple avec la fonction Square : 

```
taille = 100;
m = new Mulot();
Square(taille,m);
```

### Code complet d'exemple

```
Mulot
Proc Square(int taille, Mulot m)
    Pour i = 0 a 3
        m.avance(taille);
        m.tourne(90);
    Ruop
Corp

N = 480;
monMulot = new Mulot(80, 480, RED);
Pour i  = 0 a 8
    Square(N, monMulot);
    monMulot.avance(N / 2);
    monMulot.tourne(45);
    N = N*141/200;
Ruop
Tolum
```

## 6. Fonctionnement de l'interpréteur

Dans cette section, nous allons présenter l'interpréteur utilisé pour Mulot.

### Zone de texte

A gauche de l'interpréteur, on peut voir la zone de texte où l'utilisateur va écrire son code.

### Messages d'erreur

Lors de l'exécution ou de l'analyse syntaxique, il peut y avoir des erreurs ces erreurs seront retourner dans la zone de texte en base.

### Zone de dessin

La partie dessin est la zone de droite. En effet, les mulots se
baladent dans le plan de cette zone et vont tracer des dessins dans
cette zone.

### Boutons

Sur l'interpréteur, l'utilisateur à accès à 5 Boutons qui vont
faciliter son apprentissage. Nous allons décrire ces 5 boutons dans
cette section.

#### Exit

Tout d'abord le bouton le plus simple, le ``Exit``. Il permet de quitter l'interpréteur de manière absolue (sans pop up indicatif).

#### Load

Le bouton Load permet de charger un fichier Mulot pour l'intégrer dans la zone de texte.

#### Save

Le bouton Save a deux cas d'utilisation.

*Si vous avez précédemment chargé un fichier à l'aide du bouton ``Load`` et que vous appuyez sur le bouton ``Save``, toutes les modifications seront sauvegardées dans le fichier précédemment chargé. 
* Sinon; vous aurez un menu pour créer un fichier avec le nom souhaiter dans le dossier de votre choix et sauvegarder le contenu de la zone de texte dans le fichier.

#### Clear

Le bouton ``clear`` permet de remettre par défaut la zone de démonstration (tout en gris).

#### Run

Pour finir le bouton ``Run`` permet tout simplement d'exécuter le code présent dans la zone de texte.


## 7. Apprentissage de la programmation

Dans cette section, nous verrons comment l'apprentissage de Mulot peut être agencé au sein d'un module ou d'une matière. Nous décrirons différentes étapes pour faire comprendre au mieux la programmation.

### Variables

Tout d'abord, il faut commencer par l'utilisation de Variable, comment la définir et comment l'utiliser. Commencez d'abord par créer quelque variable et expliquer théoriquement ce qu'elle contienne. Ensuite, expliquez comment les utiliser pour les mettre dans d'autre variable.
Exemple:
```
    --variable avec entier
        var = 4;
    -- variable avec autre variable
        var2 = var;
```
### Calcul

Pour faire suite à cela, vous pouvez montrer que l'on peut stocker
dans des variables des calculs et expliquez les fonctionnements des
calculs et des priorités.

Liste d'exemple:
```
    -- calcul stocké dans une variable
    var = 4*2+5;
    -- calcul utilisant des parenthèses stocké dans une variable
    var2 = 4*(2+5);
    -- calcul stocké dans une variable utilisant des variables et des parenthèses.
    var3 = (var+var2)*(var+var2);

```

### Mulot

Maintenant, on va faire intervenir un peu de résultat graphique. 
Commencer par montrer à l'utilisateur les différentes manières de créer un Mulot : 

```
-- Création des objets
mulot = new Mulot(100,100,GREEN);
mulott = new Mulot();
mulottt = new Mulot(250,250,RED,60);        
```

Il va falloir commencer à maitriser l'objet principal qu'est le Mulot. Cela va se faire à travers l'apprentissage des 8 actions qui le compose. 

```
-- fonction
mulot.avance(140);
mulott.avance(90);
mulottt.avance(-50*4);
mulottt.tourne(120);
mulottt.leve();
mulottt.avance(60);
mulottt.baisse();
mulottt.setColor(BLUE);
mulottt.avance(90);
mulottt.setX(250);
mulottt.setY(250);
mulottt.setAngle(0);
mulottt.setColor(GREEN);
mulottt.avance(200);
```

#### Carre

Apprenez à l'utilisateur à dessiner un carré en se servant de la
méthode avance et tourne le Mulot doit être revenu à sa position
 de départ. Son code devra ressembler a quelque chose comme cela
:

```
Mulot
    mulottt = new Mulot(250,250,RED,60);  
    taille = 50;
    mulottt.avance(taille);
    mulottt.tourne(90);
    mulottt.avance(taille);
    mulottt.tourne(90);
    mulottt.avance(taille);
    mulottt.tourne(90);
    mulottt.avance(taille);
    mulottt.tourne(90);
Tolum
```

#### Multiple Carre 

Demander à l'utilisateur de créer des carrés de taille precisée à des
positions precisée et avec des angles precisé et des couleurs precisé
avec un seul Mulot.

Voila les carré demander : 
* Carre positionX=50 positionY=100 Couleur=BLEU Angle=0 taille=100
* Carre positionX=300 positionY=100 Couleur=VERT Angle=20 taille=50
* Carre positionX=580 positionY=100 Couleur=RED Angle=45 taille=25
* Carre positionX=300 positionY=350 Couleur=YELLOW Angle=45 taille=100

```
Mulot
	-- Carre positionX=50 positionY=100 Couleur=BLEU Angle=0 taille=100
	m = new Mulot(50,100,BLUE,0);
    	taille = 100;
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
	
	-- Carre positionX=300 positionY=100 Couleur=VERT Angle=20 taille=50
	taille = 50;
	m.setX(300);
	m.setColor(GREEN);
	m.setAngle(20);
	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    

	-- Carre positionX=580 positionY=100 Couleur=RED Angle=45 taille=25
	taille = 25;
	m.setAngle(45);
	m.setX(580);
	m.setColor(RED);
	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    

	-- Carre positionX=300 positionY=350 Couleur=YELLOW Angle=45 taille=100
	taille = 100;
	m.setAngle(45);
	m.setX(300);
	m.setY(350);
	m.setColor(YELLOW);
	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);
    	m.tourne(90);
    	m.avance(taille);


Tolum
```

### Boucle

Maintenant, il faut refactoriser le code multiple carre, mais en utilisant une boucle pour éviter la redondance du code. Il faut montrer a l'utilisateur la puissance d'éviter la redondance du code.

```
Mulot
	-- Carre positionX=50 positionY=100 Couleur=BLEU Angle=0 taille=100
	m = new Mulot(50,100,BLUE,0);
	taille = 100;
	Pour i = 0 a 3
		m.avance(taille);
		m.tourne(90);
	Ruop
	
	-- Carre positionX=300 positionY=100 Couleur=VERT Angle=20 taille=50
	taille = 50;
	m.setX(300);
	m.setColor(GREEN);
	m.setAngle(20);
    Pour i = 0 a 3
		m.avance(taille);
		m.tourne(90);
	Ruop
    

	-- Carre positionX=580 positionY=100 Couleur=RED Angle=45 taille=25
	taille = 25;
	m.setAngle(45);
	m.setX(580);
	m.setColor(RED);
    Pour i = 0 a 3
		m.avance(taille);
		m.tourne(90);
	Ruop
    

	-- Carre positionX=300 positionY=350 Couleur=YELLOW Angle=45 taille=100
	taille = 100;
	m.setAngle(45);
	m.setX(300);
	m.setY(350);
	m.setColor(YELLOW);
    Pour i = 0 a 3
		m.avance(taille);
		m.tourne(90);
	Ruop


Tolum
```

### Projet sans fonction

Ce que je vous propose, est de faire un projet dont le but sera d'écrire un code permettant de dessiner sur la zone de dessin 2 structure de losanges imbriqués (photo du losange). Cela permettra à votre utilisateur d'apprendre l'utilisation de boucle imbriqué. 

```
Mulot
taille = 480; -- variable pour le calcul 
monMulot = new Mulot(80, 480, RED);
monMulot.baisse();
Pour i  = 0 a 8
	Pour i = 0 a 3
		monMulot.avance(taille);
		monMulot.tourne(90);
	Ruop
	monMulot.avance(taille / 2);
	monMulot.tourne(45);
	taille = taille*141/200; -- donnee cette ligne a l'utilisateur si il se retrouve bloqué a cause des mathématiques lié a la geometrie d'un losange
Ruop
monMulot.leve();
monMulot.avance(100);
Tolum
```

### Fonction

Pour expliquer comment utiliser des fonctions, il faut apprendre à l'utilisateur à modifier son précedent projet en subdivisant les taches en fonction. L'objectif est de créer une fonction avec l'entièreté de son code pour ne pas avoir à re-écrire deux fois le code permettant la création de cette structure. L'utilisateur peut aussi essayer de créer une fonction qui dessine un carré à une position un certain angle dans une couleur précise pour faciliter le code des Multiple carre.

### Losanges refactorisé 
```
Mulot
-- Cette procedure dessine
-- un carre dont on donne 
-- la taille en parametre
Proc Carre (Mulot t, int taille)
Pour i = 0 a 3
	t.avance(taille);
	t.tourne(90);
Ruop
Corp
taille = 480;
monMulot = new Mulot(80, 480, RED);
monMulot.baisse();
Pour i  = 0 a 8
	Carre(monMulot, taille);
	monMulot.avance(taille / 2);
	monMulot.tourne(45);
	taille = taille*141/200;
Ruop
monMulot.leve();
monMulot.avance(100);
Tolum

```
### Multiple carre refactorisé

```
Mulot
Proc Carre (Mulot t, int taille,int positionX, int positionY,int angle)
	t.setX(positionX);
	t.setY(positionY);
	t.setAngle(angle);
Pour i = 0 a 3
	t.avance(taille);
	t.tourne(90);
Ruop
Corp

-- creation du Mulot 
	m = new Mulot(50,100,BLUE,0);
	-- Carre positionX=50 positionY=100 Couleur=BLEU Angle=0 taille=100
	Carre(m,100,50,100,0);
	-- Carre positionX=300 positionY=100 Couleur=VERT Angle=20 taille=50
	m.setColor(GREEN);
	Carre(m,50,300,100,20);
	-- Carre positionX=580 positionY=100 Couleur=RED Angle=45 taille=25
	m.setColor(RED);
	Carre(m,25,580,100,45);
	-- Carre positionX=300 positionY=350 Couleur=YELLOW Angle=45 taille=100
	m.setColor(YELLOW);
	Carre(m,100,300,350,45);
Tolum
```

Quel à été l'interêt de ces refactorisation ?

Ensuite re exécuter le projet en montrant que la fonction permet d'éviter la redondance

### Transition

Maintenant il vous faut faire la transition vers des langages
plus complexes tels que C ou Java pour cela après ce module sur
Mulot montrer leur tout ce qui n'est pas possible à faire avec
Mulot. Sélection de code via des ``if else switch``. Construction de
tableau de valeurs. 

Et une fois leur avoir montré ça, vous leur montrez les équivalents à
tout ce qu'ils ont fait avec Mulot dans le langage dans lequel vous
voulez faire la transition tout en leur apprenant les nouveaux concepts
if tableau etc.

## 8. Conclusion et Perspectives

Pour conclure Mulot était un projet très enrichissant, j'espère qu'il
pourra être utile pour des gens qui n'arrive pas à intégrer les
concepts de programmation ou qui ont toujours été repoussés par la
programmation. Mulot est aussi utile pour apprendre le domaine de la
compilation comme je l'ai moi-même fait (MELOTTE Quentin) pour
apprendre ANTLR ainsi que le concept d'interprétation.

