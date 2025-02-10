
FILESTEST = TestExample/Carre.mulot TestExample/Lotissement.mulot	\
TestExample/Echiquier.mulot TestExample/Maison.mulot				\
TestExample/Fleur.mulot TestExample/petit.mulot						\
TestExample/Losanges.mulot
JDIR = /usr/share/java
GRUN = java -cp .:${JDIR}/antlr4.jar:${JDIR}/antlr4-runtime.jar:${JDIR}/treelayout.jar org.antlr.v4.gui.TestRig

RUN = pygrun Mulot -t -k program
FILES = MulotLexer.py MulotLexer.tokens MulotLexer.interp	\
MulotParser.py MulotVisitor.py Mulot.interp Mulot.tokens

PYTHONSUCCESSLIST=Regression/SUCESS/Test1.mulot ..
PYTHONFAILLIST=Regression/FAIL/Test1.mulot ..

all:
	${MAKE} build

build: ${FILES}

regression:
	./Regression -success ${PYTHONSUCCESSLIST}
	./Regression -fail    ${PYTHONFAILLIST}

${FILES} : Mulot.g4
	antlr4 Mulot.g4  -Dlanguage=Python3 -no-listener -visitor

watch: visu arbre

visu:
	make clean
	antlr4 Mulot.g4
	javac -cp ${JDIR}/antlr4-runtime.jar Mulot*.java

arbre:
	make showtree MULOTPROG=TestExample/Assignement.mulot

showtree:
	${GRUN} Mulot program ${GRUNOPT}  -gui < ${MULOTPROG}

test: build
	${RUN} TestExample/petit.mulot
	${RUN} TestExample/Carre.mulot
	${RUN} TestExample/Fleur.mulot
	${RUN} TestExample/Maison.mulot
	${RUN} TestExample/Echiquier.mulot
	${RUN} TestExample/Losanges.mulot
	${RUN} TestExample/Lotissement.mulot
	${RUN} TestExample/Assignement.mulot
	${RUN} TestExample/name.mulot
	${RUN} TestExample/Multiplecarre.mulot
	${RUN} TestExample/sierpinski.mulot 
	${RUN} TestExample/Sierpinski.mulot




symbolTest: build
	python3 MulotGui.py -f ./TestExample/Assignement.mulot

spTest: build
	python3 MulotGui.py -f ./TestExample/sierpinski.mulot


clean:
	-rm -f ${FILES}
	-rm -f *.class
	-rm -f MulotBaseListener.java	MulotLexer.java  MulotListener.java  MulotParser.java
