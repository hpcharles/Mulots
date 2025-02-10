#!/usr/bin/env python3

from antlr4 import InputStream, CommonTokenStream
from antlr4.error.ErrorListener import ErrorListener
from MulotLexer import MulotLexer
from MulotParser import MulotParser
from MulotVisitor import MulotVisitor
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtCore import Qt, QLine
from MulotExecutor import *
import time

class MulotWidget(QLabel):

    def __init__(self,qApp, parent=None, size = (680, 480)):
        super().__init__(parent)
        self.size = size
        self.setFixedSize(self.size[0], self.size[1])
        self.canvas = QPixmap(self.size[0], self.size[1])
        self.canvas.fill(Qt.gray)
        self.setPixmap(self.canvas)
        self.qApp = qApp
        self.pen = QPen()
        self.pen.setColor(QColor('blue'))
        self.pen.setWidth(5)
        self.pen.setCapStyle(Qt.RoundCap)
        self.pen.setJoinStyle(Qt.RoundJoin)

    def draw(self, line,appuis):
        p = QPainter(self.pixmap())
        p.setPen (self.pen)
        p.drawLine (line)
        p.end()
        self.update()
        self.show()
        self.qApp.processEvents()
        if appuis == 1:
            time.sleep(0.3)

    def clear(self):
        self.setPixmap(self.canvas)

class MulotWindow(QDialog):
    """ Main QT application window
    Inspiration from :
    * https://github.com/pyqt/examples/tree/_?tab=readme-ov-file
    * https://github.com/pyqt/examples/tree/_/src/02%20PyQt%20Widgets
    """
    def __init__(self, qApp, programName, fileName, size):
        super(MulotWindow, self).__init__()
        self.text   = QPlainTextEdit()    # Text editor
        self.error  = QPlainTextEdit()    # Error window
        self.mulot  = MulotWidget(qApp, size=size)  # Graphical result
        self.buttons = QGroupBox() 	# Action buttons
        self.fileName = fileName
        if fileName != None:
            try:
                with open(self.fileName, 'r', encoding='utf-8') as file:
                    content = file.read()
                    self.text.setPlainText(content)
            except Exception as e:
                self.error.setPlainText(f"Error loading file: {e}")

        exitButton = QPushButton("Exit")
        exitButton.clicked.connect(self.exitEvent)
        saveButton = QPushButton("Save")
        loadButton = QPushButton("Load")
        clearButton = QPushButton("Clear")
        runButton  = QPushButton("Run")
        runButton.clicked.connect(self.execMulot)
        clearButton.clicked.connect(self.clear)
        saveButton.clicked.connect(self.actionSaveFile)
        loadButton.clicked.connect(self.loadFile)
        bLayout = QHBoxLayout()
        bLayout.addWidget(exitButton)
        bLayout.addWidget(saveButton)
        bLayout.addWidget(loadButton)
        bLayout.addWidget(clearButton)
        bLayout.addWidget(runButton)

        self.buttons.setLayout(bLayout)

        qLayout = QGridLayout()                  # Layout the widgets
        qLayout.addWidget(self.text,    0, 0)    #
        qLayout.addWidget(self.mulot,   0, 1)    #
        qLayout.addWidget(self.buttons, 1, 0, 1, 2) # X = 0,
        qLayout.addWidget(self.error,   2, 0, 1, 2) # X = 0,
        self.setLayout(qLayout)

    def actionSaveFile(self):
        if self.fileName:
            self.saveFile(self.fileName)
        else:
            self.save_file_as()

    def save_file_as(self):
        # Open file dialog to save the content to a new file
        options = QFileDialog.Options()
        file_path, _ = QFileDialog.getSaveFileName(self, "Save File As", "", "Mulot files (*.mulot)", options=options)
        if not file_path.endswith(".mulot"):
            file_path += ".mulot"
        if file_path:
            self.saveFile(self.fileName)
            self.fileName = file_path

    def saveFile(self, fileName):
        try:
            with open(fileName, 'w', encoding='utf-8') as file:
                file.write(self.text.toPlainText())
        except Exception as e:
            self.error.setPlainText(f"Error saving file: {e}")

    def loadFile(self):
        options = QFileDialog.Options()
        options |= QFileDialog.ReadOnly
        file_path, _ = QFileDialog.getOpenFileName(self, "Select a file", "", "Mulot files (*.mulot)",options=options)
        if file_path:
            try:
                with open(file_path, 'r', encoding='utf-8') as file:
                    content = file.read()
                    self.fileName = file_path
                    self.text.setPlainText(content)
            except Exception as e:
                self.error.setPlainText(f"Error loading file: {e}")

    def exitEvent(self):
        if not self.text.document().isModified():
            sys.exit()
        answer = QMessageBox.question(self, None,
            "You have unsaved changes. Save before closing?",
            QMessageBox.Save | QMessageBox.Discard | QMessageBox.Cancel)
        if answer & QMessageBox.Save:
            self.actionSaveFile()
        elif answer & QMessageBox.Cancel:
            return
        sys.exit()


    def closeEvent(self, e):
        if not self.text.document().isModified():
            return
        answer = QMessageBox.question(self, None,
            "You have unsaved changes. Save before closing?",
            QMessageBox.Save | QMessageBox.Discard | QMessageBox.Cancel)
        if answer & QMessageBox.Save:
            self.actionSaveFile()
        elif answer & QMessageBox.Cancel:
            e.ignore()

    def execMulot(self): # execute the mulot code
        self.error.clear()
        self.buttons.setEnabled(0)
        try:
            m = MulotExecutor (self.text.toPlainText(),self.mulot,self.error);
        except Exception as e:
            self.error.setPlainText(f"Caught a RuntimeError : {e}");
        self.buttons.setEnabled(1)

    def clear(self):
        self.mulot.clear()

if __name__ == "__main__":
    import argparse, sys

    p = argparse.ArgumentParser ("Interpreteur Mulot")
    p.add_argument("-s", "--size",  nargs = 1,  default=["640x480"], help="Window size ")
    p.add_argument("-t",  "--title", nargs = 1, default=["Mulot interpreter"], help="Window title ")
    p.add_argument("-f", "--file",   nargs = 1, default=[None],                help="Input File Name ")
    a = p.parse_args()

    qApp = QApplication([])
    qApp.setApplicationName(a.title[0])
    qApp.processEvents()
    strSize = a.size[0].split('x')
    intSize = [int(num) for num in strSize]
    mulotWindow = MulotWindow(qApp, a.title[0], a.file[0], intSize)
    mulotWindow.show()
    sys.exit(qApp.exec())
