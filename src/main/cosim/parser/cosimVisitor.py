# Generated from main/cosim/parser/cosim.g4 by ANTLR 4.9.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .cosimParser import cosimParser
else:
    from cosimParser import cosimParser

# This class defines a complete generic visitor for a parse tree produced by cosimParser.

class cosimVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by cosimParser#program.
    def visitProgram(self, ctx:cosimParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#declare.
    def visitDeclare(self, ctx:cosimParser.DeclareContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#include_stmt.
    def visitInclude_stmt(self, ctx:cosimParser.Include_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#var_declare.
    def visitVar_declare(self, ctx:cosimParser.Var_declareContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#func_declare.
    def visitFunc_declare(self, ctx:cosimParser.Func_declareContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#stmt.
    def visitStmt(self, ctx:cosimParser.StmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#assign_stmt.
    def visitAssign_stmt(self, ctx:cosimParser.Assign_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#assign_body.
    def visitAssign_body(self, ctx:cosimParser.Assign_bodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#assign_lhs.
    def visitAssign_lhs(self, ctx:cosimParser.Assign_lhsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#if_stmt.
    def visitIf_stmt(self, ctx:cosimParser.If_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#while_stmt.
    def visitWhile_stmt(self, ctx:cosimParser.While_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#for_stmt.
    def visitFor_stmt(self, ctx:cosimParser.For_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#brk_stmt.
    def visitBrk_stmt(self, ctx:cosimParser.Brk_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#cont_stmt.
    def visitCont_stmt(self, ctx:cosimParser.Cont_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#ret_stmt_func.
    def visitRet_stmt_func(self, ctx:cosimParser.Ret_stmt_funcContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#ret_void_func.
    def visitRet_void_func(self, ctx:cosimParser.Ret_void_funcContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#call_stmt.
    def visitCall_stmt(self, ctx:cosimParser.Call_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#compound_stmt.
    def visitCompound_stmt(self, ctx:cosimParser.Compound_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#printf_stmt.
    def visitPrintf_stmt(self, ctx:cosimParser.Printf_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#scanf_stmt.
    def visitScanf_stmt(self, ctx:cosimParser.Scanf_stmtContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#stmt_list.
    def visitStmt_list(self, ctx:cosimParser.Stmt_listContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp_bool.
    def visitExp_bool(self, ctx:cosimParser.Exp_boolContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp_int.
    def visitExp_int(self, ctx:cosimParser.Exp_intContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp_real.
    def visitExp_real(self, ctx:cosimParser.Exp_realContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp_str.
    def visitExp_str(self, ctx:cosimParser.Exp_strContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp.
    def visitExp(self, ctx:cosimParser.ExpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp1.
    def visitExp1(self, ctx:cosimParser.Exp1Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp2.
    def visitExp2(self, ctx:cosimParser.Exp2Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp3.
    def visitExp3(self, ctx:cosimParser.Exp3Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exp4.
    def visitExp4(self, ctx:cosimParser.Exp4Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#operands.
    def visitOperands(self, ctx:cosimParser.OperandsContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#primary_exp.
    def visitPrimary_exp(self, ctx:cosimParser.Primary_expContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#call_exp.
    def visitCall_exp(self, ctx:cosimParser.Call_expContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#params_list.
    def visitParams_list(self, ctx:cosimParser.Params_listContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#ids_list_with_type.
    def visitIds_list_with_type(self, ctx:cosimParser.Ids_list_with_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#ids_list.
    def visitIds_list(self, ctx:cosimParser.Ids_listContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#exps_list.
    def visitExps_list(self, ctx:cosimParser.Exps_listContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#data_types.
    def visitData_types(self, ctx:cosimParser.Data_typesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#compound_types.
    def visitCompound_types(self, ctx:cosimParser.Compound_typesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#primitive_types.
    def visitPrimitive_types(self, ctx:cosimParser.Primitive_typesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#literal.
    def visitLiteral(self, ctx:cosimParser.LiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#number.
    def visitNumber(self, ctx:cosimParser.NumberContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by cosimParser#boolean_literal.
    def visitBoolean_literal(self, ctx:cosimParser.Boolean_literalContext):
        return self.visitChildren(ctx)



del cosimParser