from enum import Enum
from MulotGui import MulotWidget
from PyQt5.QtCore import Qt, QLine
from PyQt5.QtGui import QColor
import math

class Color(Enum):
    RED = 1
    GREEN = 2
    BLUE = 3
    WHITE = 4
    BLACK = 5
    YELLOW = 6

    def __str__(self):
        return f'{self.name}'



class Types(Enum):
    int = 1,
    Mulot = 2,


class Operator(Enum):
    mul = 1
    div = 2
    sub = 3
    add = 4

class Mulot():

    def __init__(self,x : int,y : int, color : Color,angle : int):
        self.x = x
        self.y = y
        self.color = color
        self.angle = angle % 360
        self.appuis = 1



    def setColor(self,color : Color):
        self.color = color

    def setAngle(self,angle : int):
        self.angle = angle

    def setX(self,x : int):
        self.x = x

    def setY(self,y : int):
        self.y = y



    def avance(self,Mulotwidget : MulotWidget,value : int):
        angle_radians = math.radians(-self.angle)
        xPrime = self.x + value * math.cos(angle_radians)
        yPrime = self.y + value * math.sin(angle_radians)
        Mulotwidget.pen.setColor(QColor(self.color.name))
        qline = QLine(int(self.x), int(self.y),int(xPrime), int(yPrime))
        self.x = xPrime
        self.y = yPrime
        if self.appuis == 1:
            Mulotwidget.draw(qline,self.appuis)
            Mulotwidget.update()


    def leve(self):
        self.appuis = 0

    def baisse(self):
        self.appuis = 1

    def tourne(self,value : int):
        self.angle = (self.angle + value) % 360

    def __str__(self):
        return f'x : ,{self.x}, y : ,{self.y}, color : ,{self.color}, angle : {self.angle}, appuis : ,{self.appuis}'
