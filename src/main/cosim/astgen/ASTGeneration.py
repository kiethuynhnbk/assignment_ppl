from cosimVisitor import cosimVisitor
from cosimParser import cosimParser
from AST import *

class ASTGeneration(cosimVisitor):
    def visitProgram(self, ctx:cosimParser.ProgramContext):
        declList = []
        includeList=[]
        l=ctx.include_stmt()
        for include in l:
            include_stmt=self.visitInclude_stmt(include)
            includeList.append(include_stmt)
        for x in ctx.declare():
            decl = self.visitDeclare(x)
            if isinstance(decl, list):
                declList.extend(decl if decl else [])
            else:
                declList.append(decl)
        includeList.extend(declList)
        return Program(includeList)
    def visitInclude_stmt(self,ctx:cosimParser.Include_stmtContext):
        lib=''
        if ctx.MATH():
            lib= 'math'
        elif ctx.STDIO():
            lib= 'stdio'
        else:
            lib= 'stdbool'
        return Include(lib)

    def visitDeclare(self, ctx:cosimParser.DeclareContext):
        return self.visitChildren(ctx)


    def visitVar_declare(self, ctx:cosimParser.Var_declareContext):
        varDeclList = []
        for x in ctx.ids_list_with_type():
            varDeclList.extend(self.visitIds_list_with_type(x))
        return [VarDecl(id, dataType) for (id, dataType) in varDeclList]


    def visitFunc_declare(self, ctx:cosimParser.Func_declareContext):
        name = Id(ctx.ID().getText())
        param = self.visit(ctx.params_list()) if ctx.params_list() else []
        if ctx.data_types():
            returnType = self.visit(ctx.data_types())
        elif ctx.VOID():
            returnType ='Void'
        body = self.visit(ctx.compound_stmt())
        return FuncDecl(name, param, body, returnType)

    def visitStmt(self, ctx:cosimParser.StmtContext):
        return self.visitChildren(ctx)


    def visitAssign_stmt(self, ctx:cosimParser.Assign_stmtContext):
        return self.visit(ctx.assign_body())


    def visitAssign_body(self, ctx:cosimParser.Assign_bodyContext):
        lhs = self.visit(ctx.assign_lhs())
        exp = self.visit(ctx.exp())
        return Assign(lhs,exp)


    def visitAssign_lhs(self, ctx:cosimParser.Assign_lhsContext):
        if ctx.ids_list():
            return self.visit(ctx.ids_list())
        else:
            return self.visit(ctx.ids_list_with_type())

    def visitIf_stmt(self, ctx:cosimParser.If_stmtContext):
        expr = self.visit(ctx.exp_bool())
        c1=self.visit(ctx.compound_stmt(0))
        if not isinstance(c1, list): c1 = [c1]
        if ctx.compound_stmt(1):
            elseStmt = self.visit(ctx.compound_stmt(1))
            if not isinstance(elseStmt, list): elseStmt = [elseStmt]
            return If(expr,c1,elseStmt)
        return If(expr,c1,[])
        


    def visitWhile_stmt(self, ctx:cosimParser.While_stmtContext):
        exp = self.visit(ctx.exp_bool())
        stmtsList = self.visit(ctx.compound_stmt())
        if not isinstance(stmtsList, list): stmtsList = [stmtsList]
        return While(exp, stmtsList)


    def visitFor_stmt(self, ctx:cosimParser.For_stmtContext):
        id = Id(ctx.ID(0).getText())
        expr1 = self.visit(ctx.assign_body())
        expr2 = self.visit(ctx.exp())
        loop = self.visit(ctx.compound_stmt())
        up = False if ctx.SUB_SELF() else True
        if not isinstance(loop, list): loop = [loop]
        return For(id, expr1, expr2, up, loop)



    def visitBrk_stmt(self, ctx:cosimParser.Brk_stmtContext):
        return Break()


    def visitCont_stmt(self, ctx:cosimParser.Cont_stmtContext):
        return Continue()

    def visitRet_void_func(self, ctx:cosimParser.Ret_void_funcContext):
        return Return_void_func()

    def visitRet_stmt_func(self, ctx:cosimParser.Ret_stmt_funcContext):
        return Return_stmt_func(self.visit(ctx.exp()))


    # Visit a parse tree produced by MPParser#call_stmt.Not Sure/////////////////////////////////////////
    def visitCall_stmt(self, ctx:cosimParser.Call_stmtContext):
        callExp = self.visit(ctx.call_exp())
        method = callExp.method
        param = callExp.param
        return CallStmt(method, param)


    # Visit a parse tree produced by MPParser#compound_stmt.
    def visitCompound_stmt(self, ctx:cosimParser.Compound_stmtContext):
        return self.visit(ctx.stmt_list()) if ctx.stmt_list() else []
    def visitPrintf_stmt(self,ctx:cosimParser.Printf_stmtContext):
        if ctx.exps_list()==None:
            return PrintfString(ctx.STRING_LITERAL())
        else:
            return PrintfStmt(ctx.STRING_LITERAL(),self.visit(ctx.exps_list()))
    def visitScanf_stmt(self,ctx:cosimParser.Scanf_stmtContext):
        arr=[Id(id.getText()) for id in ctx.ID()]
        return ScanfStmt(ctx.STRING_LITERAL(),arr)
    def visitStmt_list(self, ctx:cosimParser.Stmt_listContext):
        stmtsList = []
        for i in ctx.stmt():
            j = self.visitStmt(i)
            if isinstance(j, list): stmtsList.extend(j if j else [])
            else: stmtsList.append(j)
        return stmtsList
    # Visit a parse tree produced by MPParser#exp_bool.
    def visitExp_bool(self, ctx:cosimParser.Exp_boolContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MPParser#exp_int.
    def visitExp_int(self, ctx:cosimParser.Exp_intContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MPParser#exp_real.
    def visitExp_real(self, ctx:cosimParser.Exp_realContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MPParser#exp_str.
    def visitExp_str(self, ctx:cosimParser.Exp_strContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MPParser#exp.///////////
    def visitExp(self, ctx:cosimParser.ExpContext):
        if ctx.getChildCount() == 1: # exp1
            return self.visit(ctx.exp1())
        left = self.visit(ctx.exp())
        right = self.visit(ctx.exp1())
        op = '&&' if ctx.AND() else '|'
        return BinaryOp(op, left, right)


    # Visit a parse tree produced by MPParser#exp1.
    def visitExp1(self, ctx:cosimParser.Exp1Context):
        if ctx.getChildCount() == 1: # exp2
            return self.visit(ctx.exp2(0))
        left = self.visit(ctx.exp2(0))
        right = self.visit(ctx.exp2(1))
        op = ctx.getChild(1).getText()
        return BinaryOp(op, left, right)


    # Visit a parse tree produced by MPParser#exp2.
    def visitExp2(self, ctx:cosimParser.Exp2Context):
        if ctx.getChildCount() == 1: # exp3
            return self.visit(ctx.exp3())
        left = self.visit(ctx.exp2())
        right = self.visit(ctx.exp3())
        op = ctx.getChild(1).getText()
        return BinaryOp(op, left, right)



    # Visit a parse tree produced by MPParser#exp3.
    def visitExp3(self, ctx:cosimParser.Exp3Context):
        if ctx.getChildCount() == 1: # exp4
            return self.visit(ctx.exp4())
        left = self.visit(ctx.exp3())
        right = self.visit(ctx.exp4())
        op = ctx.getChild(1).getText()
        return BinaryOp(op, left, right)


    # Visit a parse tree produced by MPParser#exp4.
    def visitExp4(self, ctx:cosimParser.Exp4Context):
        if ctx.getChildCount() == 1:
            return self.visit(ctx.operands())
        op = ctx.NOT().getText() if ctx.NOT() else ctx.SUB().getText()
        body = self.visit(ctx.exp4())
        return UnaryOp(op, body)


    # Visit a parse tree produced by MPParser#operands.
    def visitOperands(self, ctx:cosimParser.OperandsContext):
        if ctx.getChildCount() == 1:
            # literal, ID, call_exp
            if ctx.ID(): return Id(ctx.ID().getText())
            if ctx.literal(): return self.visit(ctx.literal())
            return self.visit(ctx.call_exp())
        if ctx.LP():
            # LP exp RP
            return self.visit(ctx.exp())
        arr = self.visit(ctx.operands())
        idx = self.visit(ctx.postfix_array_exp())
        return ArrayCell(arr, idx)


    # Visit a parse tree produced by MPParser#postfix_array_exp.
    #def visitPostfix_array_exp(self, ctx:MPParser.Postfix_array_expContext):
    #    return self.visit(ctx.exp())


    # Visit a parse tree produced by MPParser#primary_exp.
    #def visitPrimary_exp(self, ctx:MPParser.Primary_expContext):
    #    return ctx.ID().getText() if ctx.ID() else self.visit(ctx.literal())


    # Visit a parse tree produced by MPParser#call_exp.
    def visitCall_exp(self, ctx:cosimParser.Call_expContext):
        method = Id(ctx.ID().getText())
        param = self.visit(ctx.exps_list()) if ctx.exps_list() else []
        return CallExpr(method, param)


    # Visit a parse tree produced by MPParser#index_exp.
    #def visitIndex_exp(self, ctx:MPParser.Index_expContext):
    #    arr = self.visit(ctx.operands())
    #    idx = self.visit(ctx.postfix_array_exp())
    #    return ArrayCell(arr, idx)


    # Visit a parse tree produced by MPParser#params_list.
    def visitParams_list(self, ctx:cosimParser.Params_listContext):
        varDeclList = []
        for x in ctx.ids_list_with_type():
            varDeclList.extend(self.visitIds_list_with_type(x))
        return [VarDecl(id, dataType) for (id, dataType) in varDeclList]


    # Visit a parse tree produced by MPParser#ids_list_with_type.
    def visitIds_list_with_type(self, ctx:cosimParser.Ids_list_with_typeContext):
        ids_list = self.visit(ctx.ids_list())
        dataType = self.visit(ctx.data_types())
        return [[id , dataType] for id in ids_list]


    # Visit a parse tree produced by MPParser#ids_list.
    def visitIds_list(self, ctx:cosimParser.Ids_listContext):
        return [Id(id.getText()) for id in ctx.ID()]


    # Visit a parse tree produced by MPParser#exps_list.
    def visitExps_list(self, ctx:cosimParser.Exps_listContext):
        return [self.visitExp(x) for x in ctx.exp()]





    # Visit a parse tree produced by MPParser#data_types.
    def visitData_types(self, ctx:cosimParser.Data_typesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MPParser#compound_types.
    def visitCompound_types(self, ctx:cosimParser.Compound_typesContext):
        lower = self.visit(ctx.number(0))
        upper = self.visit(ctx.number(1))
        eleType = self.visit(ctx.primitive_types())
        return ArrayType(lower, upper, eleType)


    # Visit a parse tree produced by MPParser#primitive_types.
    def visitPrimitive_types(self, ctx:cosimParser.Primitive_typesContext):
        if ctx.INT(): return IntType()
        if ctx.DOUBLE(): return DoubleType()
        if ctx.STRING(): return StringType()
        if ctx.BOOL(): return BoolType()


    # Visit a parse tree produced by MPParser#literal.
    def visitLiteral(self, ctx:cosimParser.LiteralContext):
        if ctx.INTEGER_LITERAL():
            return IntLiteral(int(ctx.INTEGER_LITERAL().getText()))
        if ctx.REAL_LITERAL():
            return DoubleLiteral(float(ctx.REAL_LITERAL().getText()))
        if ctx.STRING_LITERAL():
            return StringLiteral(ctx.STRING_LITERAL().getText())
        return self.visit(ctx.boolean_literal())


    # Visit a parse tree produced by MPParser#number.
    def visitNumber(self, ctx:cosimParser.NumberContext):
        if ctx.INTEGER_LITERAL():
            val = int(ctx.INTEGER_LITERAL().getText())
        else:
            val=float(ctx.REAL_LITERAL().getText())
        if ctx.SUB(): val = -val
        return val


    # Visit a parse tree produced by MPParser#boolean_literal.
    def visitBoolean_literal(self, ctx:cosimParser.Boolean_literalContext):
        val = True if ctx.TRUE() else False
        return BoolLiteral(val)