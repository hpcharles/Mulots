from Mulot import *




class symbolTable():
    def __init__(self):
        self.symbolNames = []
        self.symbolValues = []


    def setValue(self,name, value):
        if name in self.symbolNames:
            self.symbolValues[self.symbolNames.index(name)] = value
        self.symbolNames.append(name)
        self.symbolValues.append(value)

    def getValue(self,name):
        # print(f"name is {name}")
        if name in self.symbolNames:
            # print(f"name is {name}")
            return self.symbolValues[self.symbolNames.index(name)]
        raise NameError(f" {name} is use bot never initialise")

    def getLen(self):
        return len(self.symbolNames)

    def pop(self,number : int):
        for i in range(0,number):
            self.symbolNames.pop()
            self.symbolValues.pop()

    def printTable(self):
        for name in self.symbolNames:
             print(name)
        for value in self.symbolValues:
             print(value)
