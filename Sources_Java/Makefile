.SUFFIXES: .g .java .class

.g.java:
	java antlr.Tool $<

all: lexer parser lereste

lexer: MulotLexer.java

parser: MulotParser.java

lereste:
	javac *.java
jar:
	jar cvf Mulots.jar *.class
clean:
	-rm *.class
	-rm MulotParser.java MulotLexer.java 
	-rm MulotTokenTypes.txt MulotParserTokenTypes.txt
	-rm MulotTokenTypes.java MulotParserTokenTypes.java
