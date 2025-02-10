from symbolTable import *
from procTable import *
from MulotLexer import MulotLexer
from MulotParser import MulotParser
from MulotVisitor import MulotVisitor
from MulotErrorListener import MulotErrorListener


class MulotExecutor (MulotVisitor):

    def __init__ (self, sourceProg, canvas,errorBox):
        l = MulotLexer(InputStream(sourceProg))
        s = CommonTokenStream(l)
        p = MulotParser(s)
        l.removeErrorListeners()
        p.removeErrorListeners()
        parserErrorListener = MulotErrorListener("Parser",errorBox)
        lexerErrorListener = MulotErrorListener("Lexer",errorBox)

        l.addErrorListener(lexerErrorListener)
        p.addErrorListener(parserErrorListener)
        self.tableSymbol = symbolTable()
        self.tableProc = procTable()
        self.possibleCall = ['avance','leve','baisse','tourne','setY','setX','setAngle','setColor']
        self.canvas = canvas
        sTree = p.program()
        if (lexerErrorListener.alreadyCalled() == True):
            cursor = errorBox.textCursor()
            cursor.movePosition(cursor.End)
            errorBox.setTextCursor(cursor)
            errorBox.appendPlainText("due to error during lexing execution canceled")
            return
        if (parserErrorListener.alreadyCalled() == True):
            cursor = errorBox.textCursor()
            cursor.movePosition(cursor.End)
            errorBox.setTextCursor(cursor)
            errorBox.appendPlainText("due to error during parsing execution canceled")
            return
        try:
            self.tree = self.visit(sTree)
        except RuntimeError as e:
            print(f"Caught a RuntimeError : {e}")

        #print (self.tree)
        #self.tableSymbol.printTable()
        #print (self.tableProc)

    # Visit a parse tree produced by MulotParser#program.
    def visitProgram(self, ctx:MulotParser.ProgramContext):
        for proc in ctx.functionDeclaration():
            self.visitFunctionDeclaration(proc)
        for stat in ctx.stat():
            self.visitStat(stat)



    # Visit a parse tree produced by MulotParser#functionDeclaration.
    def visitFunctionDeclaration(self, ctx:MulotParser.FunctionDeclarationContext):
        self.tableProc.addProc(ctx.getChild(1).getText(),ctx)


    # Visit a parse tree produced by MulotParser#argumentList.
    def visitArgumentList(self, ctx:MulotParser.ArgumentListContext):
        name = []
        for arg in ctx.argument():
            name.append(self.visitArgument(arg))
        return name


    # Visit a parse tree produced by MulotParser#argument.
    def visitArgument(self, ctx:MulotParser.ArgumentContext):
        ID = ctx.getChild(1).getText()
        return str(ID)


    # Visit a parse tree produced by MulotParser#types.
    def visitTypes(self, ctx:MulotParser.TypesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#stat.
    def visitStat(self, ctx:MulotParser.StatContext):
        return self.visitChildren(ctx)

    def visitActionCall(self, ctx:MulotParser.ActionCallContext):
        return ctx.getChild(0).getText()

    # Visit a parse tree produced by MulotParser#objectCallStatement.
    def visitObjectCallStatement(self, ctx:MulotParser.ObjectCallStatementContext):
        IDcaller = ctx.getChild(0).getText()
        IDfunction = self.visitActionCall(ctx.getChild(2))
        mulot = self.tableSymbol.getValue(IDcaller)
        tuple = self.visitExprList(ctx.getChild(4))
        if IDfunction in self.possibleCall:
            if IDfunction == 'avance':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected");
                error = False
                try:
                    value = self.tableSymbol.getValue(str(tuple[0]))
                except Exception as e:
                    error = True
                if error==False:
                    mulot.avance(self.canvas,int(value))
                else:
                    mulot.avance(self.canvas,int(tuple[0]))
            elif IDfunction == 'leve':
                if len(tuple) != 0:
                    raise ValueError (f"bad number of argument for {IDcaller}.{IDfunction} needed 0 argument and {len(tuple)} detected")
                mulot.leve()
            elif IDfunction == 'baisse':
                if len(tuple) != 0:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 0 argument and {len(tuple)} detected")
                mulot.baisse()
            elif IDfunction == 'tourne':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected")
                mulot.tourne(int(tuple[0]))
            elif IDfunction == 'setY':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected")
                mulot.setY(int(tuple[0]))
            elif IDfunction == 'setX':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected")
                mulot.setX(int(tuple[0]))
            elif IDfunction == 'setColor':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected")
                mulot.setColor(Color(tuple[0]))
            elif IDfunction == 'setAngle':
                if len(tuple) != 1:
                    raise ValueError(f"bad number of argument for {IDcaller}.{IDfunction} needed 1 argument and {len(tuple)} detected")
                mulot.setAngle(int(tuple[0]))
            else:
                raise NameError(f"Function {IDfunction} does not exist")

    # Visit a parse tree produced by MulotParser#functionCallStatement.
    def visitFunctionCallStatement(self, ctx:MulotParser.FunctionCallStatementContext):
        proc = self.tableProc.getProc(ctx.getChild(0).getText())
        newTable = symbolTable()
        oldTable = self.tableSymbol

        arguments = self.visitArgumentList(proc.getChild(3))
        exprs = self.visitExprList(ctx.getChild(2))
        self.tableSymbol = newTable
        if len(exprs) != len(arguments):
            raise ValueError(f"Bad number of arguments insert in {proc}")
        for i in range(0,len(exprs)):
            self.tableSymbol.setValue(arguments[i],exprs[i])
        for stat in proc.stat():
            self.visitStat(stat)

        self.tableSymbol = oldTable



    # Visit a parse tree produced by MulotParser#objectCreation.
    def visitObjectCreation(self, ctx:MulotParser.ObjectCreationContext):
        ID = ctx.getChild(0).getText()
        tuple = self.visitExprList(ctx.getChild(5))
        size = len(tuple)
        if size == 0:
            self.tableSymbol.setValue(str(ID),Mulot(0,0,Color(5),0))
        elif size == 2:
            self.tableSymbol.setValue(str(ID),Mulot(tuple[0],tuple[1],Color(5),0))
        elif size == 3:
            self.tableSymbol.setValue(str(ID),Mulot(tuple[0],tuple[1],tuple[2],0))
        elif size == 4:
            self.tableSymbol.setValue(str(ID),Mulot(tuple[0],tuple[1],tuple[2],tuple[3]))



    # Visit a parse tree produced by MulotParser#exprList.
    def visitExprList(self, ctx:MulotParser.ExprListContext):
        list = []
        for expr in ctx.expr():
            list.append(self.visit(expr))

        return list


    # Visit a parse tree produced by MulotParser#pourStatement.
    def visitPourStatement(self, ctx:MulotParser.PourStatementContext):
        len = self.tableSymbol.getLen()
        value = self.visitAssignementStatement(ctx.getChild(1))
        toReach = self.visitExpr(ctx.getChild(3))
        while(value <= toReach):
            for stat in ctx.stat():
                self.visitStat(stat)
            value = value +1
            toReach = self.visitExpr(ctx.getChild(3))
        self.tableSymbol.pop(self.tableSymbol.getLen() - len)


    # Visit a parse tree produced by MulotParser#parenthèsePriority.
    def visitParenthesePriority(self, ctx:MulotParser.ParenthèsePriorityContext):
        return self.visitExpr(ctx.getChild(1));



    # Visit a parse tree produced by MulotParser#assignementStatement.
    def visitAssignementStatement(self, ctx:MulotParser.AssignementStatementContext):
        ID = ctx.ID()
        ctx = ctx.getChild(2)
        value = self.visitExpr(ctx)
        self.tableSymbol.setValue(str(ID),value)
        return value





    # Visit a parse tree produced by MulotParser#lowPriotyOperator.
    def visitLowPriorityOperator(self, ctx:MulotParser.LowPriorityOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#highPriorityOperator.
    def visitHighPriorityOperator(self, ctx:MulotParser.HighPriorityOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#expr.
    def visitExpr(self, ctx:MulotParser.ExprContext):
        childCount = ctx.getChildCount()
        if childCount == 1:
            # assignement terminal Node INT or ID
            ID = ctx.ID()
            if ID != None: #expr : ID
                if str(ID) in Color._member_names_:
                    return Color[f'{ID}']
                return self.tableSymbol.getValue(str(ID))
            INT = ctx.INT()
            if INT != None:
                return int(str(INT))
            token = ctx.getChild(0).getChild(0).getText()
            if token == '(':
                calculatePriority = self.visitParenthesePriority(ctx.getChild(0))
                return int(calculatePriority)
                #parenthèsis priority
        elif childCount == 2:
            token = ctx.getChild(0).getText()
            if token == '-':
                negativeNumber = self.visitExpr(ctx.getChild(1))
                return -negativeNumber
                # negative expr
            if token == '(':
                calculatePriority = self.visitParenthesePriority(ctx)
                return int(calculatePriority)
                #parenthèsis priority
        elif childCount == 3:
            token = ctx.getChild(1).getText()
            if token == '+' or token == '-':
                calcul2 = self.visitExpr(ctx.getChild(2))
                calcul = self.visitExpr(ctx.getChild(0))
                if token == '+':
                    return int(calcul+calcul2)
                if token == '-':
                    a = int(calcul-calcul2);
                    return a
            if token == '*' or token == '/':
                calcul2 = self.visitExpr(ctx.getChild(2))
                calcul = self.visitExpr(ctx.getChild(0))
                if token == '*':
                    return int(calcul)*int(calcul2)

                if token == '/':
                    return int(calcul/calcul2)

        return self.visitChildren(ctx)
