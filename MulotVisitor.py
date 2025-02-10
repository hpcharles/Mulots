# Generated from Mulot.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MulotParser import MulotParser
else:
    from MulotParser import MulotParser

# This class defines a complete generic visitor for a parse tree produced by MulotParser.

class MulotVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by MulotParser#program.
    def visitProgram(self, ctx:MulotParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#functionDeclaration.
    def visitFunctionDeclaration(self, ctx:MulotParser.FunctionDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#argumentList.
    def visitArgumentList(self, ctx:MulotParser.ArgumentListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#argument.
    def visitArgument(self, ctx:MulotParser.ArgumentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#types.
    def visitTypes(self, ctx:MulotParser.TypesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#stat.
    def visitStat(self, ctx:MulotParser.StatContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#objectCallStatement.
    def visitObjectCallStatement(self, ctx:MulotParser.ObjectCallStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#functionCallStatement.
    def visitFunctionCallStatement(self, ctx:MulotParser.FunctionCallStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#objectCreation.
    def visitObjectCreation(self, ctx:MulotParser.ObjectCreationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#exprList.
    def visitExprList(self, ctx:MulotParser.ExprListContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#assignementStatement.
    def visitAssignementStatement(self, ctx:MulotParser.AssignementStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#pourStatement.
    def visitPourStatement(self, ctx:MulotParser.PourStatementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#parenthèsePriority.
    def visitParenthèsePriority(self, ctx:MulotParser.ParenthèsePriorityContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#actionCall.
    def visitActionCall(self, ctx:MulotParser.ActionCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#lowPriorityOperator.
    def visitLowPriorityOperator(self, ctx:MulotParser.LowPriorityOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#highPriorityOperator.
    def visitHighPriorityOperator(self, ctx:MulotParser.HighPriorityOperatorContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MulotParser#expr.
    def visitExpr(self, ctx:MulotParser.ExprContext):
        return self.visitChildren(ctx)



del MulotParser