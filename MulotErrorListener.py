from antlr4 import *
from MulotLexer import *
from MulotParser import *
from antlr4.error.ErrorListener import ErrorListener


class MulotErrorListener(ErrorListener):

    def __init__(self,name,textBox):
        self.textBox = textBox;
        self.called = False;
        self.name = name;

    def syntaxError(self,recognizer,offendingSymbol, line, column, msg, e):
        cursor = self.textBox.textCursor()
        self.called = True;
#        print(f"called is {self.called}")
        cursor.movePosition(cursor.End);
        self.textBox.setTextCursor(cursor)
        self.textBox.appendPlainText(self.name + " : Error on line "+ str(line) + " column " + str(column) + " " + msg)

    def alreadyCalled(self):
        return self.called;
