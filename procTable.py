from MulotParser import *

class procTable():

    def __init__(self):
        self.procName = []
        self.procPointer = []


    def addProc(self,name : str, ctx : MulotParser.FunctionDeclarationContext):
        self.procName.append(name)
        self.procPointer.append(ctx)

    def getProc(self, name : str) -> MulotParser.FunctionDeclarationContext:
        # print("getProc name is :",name)
        if name not in self.procName:
            raise NameError(f"called {name} but name never declared")
        return self.procPointer[self.procName.index(name)]


    def __str__(self):
        return f'{self.procName.__str__()} and {self.procPointer.__str__()}'
