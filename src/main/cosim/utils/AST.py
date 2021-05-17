from abc import ABC, abstractmethod, ABCMeta
from Visitor import Visitor
class AST(ABC):
    def __eq__(self, other): 
        return self.__dict__ == other.__dict__

    @abstractmethod
    def accept(self, v, param):
        return v.visit(self, param)

class Type(AST):
    __metaclass__ = ABCMeta
    pass

class IntType(Type):
    def __str__(self):
        return "IntType"

    def accept(self, v, param):
        return v.visitIntType(self, param)

class DoubleType(Type):
    def __str__(self):
        return "DoubleType"

    def accept(self, v, param):
        return v.visitRealType(self, param)

class BoolType(Type):
    def __str__(self):
        return "BoolType"

    def accept(self, v, param):
        return v.visitBoolType(self, param)

class StringType(Type):
    def __str__(self):
        return "StringType"

    def accept(self, v, param):
        return v.visitStringType(self, param)

class ArrayType(Type):
    #lower:int
    #upper:int
    #eleType:Type
    def __init__(self, lower, upper, eleType):
        self.lower = lower
        self.upper = upper
        self.eleType = eleType
        
    def __str__(self):
        return "ArrayType(" + str(self.lower) + "," + str(self.upper) + "," + str(self.eleType) + ")"

    def accept(self, v, param):
        return v.visitArrayType(self, param)

class VoidType(Type): 
    def __str__(self):
        return "VoidType()" 

    def accept(self, v, param):
        return v.visitVoidType(self, param)

class Program(AST):
    #decl:list(Decl)(list var_declare,func_declare_var_intinitial)
    #this children
    def __init__(self, decl):
        self.decl = decl
    
    def __str__(self):
        return "Program([" + ','.join(str(i) for i in self.decl) + "])"
        #'{name:"Program",children:[{name:"Decl",children:['+','.join((str(i)for i in(self.decl)))+']}]}'
        #"Program([" + ','.join(str(i) for i in self.decl) + "])"
    def child(self):
        return self.decl
    
    def accept(self, v, param):
        return v.visitProgram(self, param)

class Include():
    def __init__(self,lib):
        self.lib=lib

    def __str__(self):
        return "Lib("+str(self.lib)+")"
    def child(self):
        return self.lib
    def accpet(self,v,param):
        return v.visitInclude(self,param)

class Decl(AST):
    __metaclass__ = ABCMeta
    pass

class VarDecl(Decl):
    #variable:Id
    #varType: Type
    def __init__(self, variable, varType):
        self.variable = variable
        self.varType = varType

    def __str__(self):
        return "VarDecl(" + str(self.variable) + "," + str(self.varType) + ")"
    def child(self):
        return self.variable,self.varType
    def accept(self, v, param):
        return v.visitVarDecl(self, param)

class FuncDecl(Decl):
    #name: Id
    #param: list(VarDecl)
    #returnType: Type => VoidType for Procedure
    #body: list(Stmt)
    def __init__(self, name, param, body, returnType=VoidType()):

        self.name = name
        self.param = param
        self.returnType = returnType
        self.body = body

    def __str__(self):
        return "FuncDecl(" + str(self.name) +               \
        ",[" +  ','.join(str(i) for i in self.param) +      \
        "]," + str(self.returnType) +                       \
        ",[" + ','.join(str(i) for i in self.body) + "])"
        #return "FuncDecl(" + str(self.name) +               \
        #",[" +  ','.join(str(i) for i in self.param) +      \
        #"]," + str(self.returnType) +                       \
        #",[" + ','.join(str(i) for i in self.body) + "])"
    def child(self):
        return self.name,self.param,self.returnType,self.body
    def accept(self, v, param):
        return v.visitFuncDecl(self, param)


class Stmt(AST):
    __metaclass__ = ABCMeta
    pass

class Assign(Stmt):
    #lhs:Expr
    #exp:Expr
    def __init__(self, lhs, exp):
        self.lhs = lhs
        self.exp = exp

    def __str__(self):
        t=""
        if not isinstance(self.lhs, list):
            self.lhs=[self.lhs]
        for x in self.lhs:
            if isinstance(x,list):
                var=VarDecl(x[0],x[1])
                t=t+(var.__str__())+','
            else:
                t=t+(x.__str__())+','
        t=t[:-1]
        #return '{name:AssignStmt,children:['+ t +','+str(self.exp)+']}'
        return "AssignStmt(" + t + "," +  str(self.exp) + ")"
        #return'{name:"AssignStmt",children:['+ t +','+str(self.exp)+']}'
        #"AssignStmt(" + "[" + t + "]" "," +  str(self.exp) + ")"
    def child(self):
        t=""
        if not isinstance(self.lhs, list):
            self.lhs=[self.lhs]
        for x in self.lhs:
            if isinstance(x,list):
                var=VarDecl(x[0],x[1])
                t=t+(var.__str__())+','
            else:
                t=t+(x.__str__())+','
        t=t[:-1]
        return self.lhs,self.exp

    def accept(self, v, param):
        return v.visitAssign(self, param)

class If(Stmt):
    #expr:Expr
    #thenStmt:list(Stmt)
    #elseStmt:list(Stmt)
    def __init__(self, expr, Stmt , elseStmt=[]):
        self.expr = expr
        self.Stmt = Stmt
        self.elseStmt = elseStmt

    def __str__(self):
        return "If(" + str(self.expr) + ",[" + ','.join(str(i) for i in self.Stmt) + "],[" +  ','.join(str(i) for i in self.elseStmt)  + "])"
        #return'{name:If,children:[{name:Stmt,children:['+','.join((str(i)for i in(self.Stmt)))+']},{name:ElseStmt,children:['+','.join((str(i)for i in(self.elseStmt)))+']}]}' 
        #"If(" + str(self.expr) + ",[" + ','.join(str(i) for i in self.Stmt) + "],[" +  ','.join(str(i) for i in self.elseStmt)  + "])"
    def child(self):
        return self.expr,self.Stmt,self.elseStmt
    def accept(self, v, param):
        return v.visitIf(self, param)

class While(Stmt):
    #sl:list(Stmt)
    #exp: Expr
    def __init__(self, exp,sl):
        self.sl = sl
        self.exp = exp

    def __str__(self):
        #return'{name:While,children:['+str(self.exp)+','+'{name:Sl,children:['+','.join((str(i)for i in(self.sl)))+']}]}'
        return "While(" + str(self.exp) + ",[" + ','.join(str(i) for i in self.sl) + "])" 
    def child(self):
        return self.exp,self.sl
    def accept(self, v, param):
        return v.visitWhile(self, param)

class For(Stmt):
    #id:Id
    #expr1,expr2:Expr
    #loop:list(Stmt)
    #up:Boolean #True => increase; False => decrease
    def __init__(self, id, expr1, expr2,up,loop):
        self.id = id
        self.expr1 = expr1
        self.expr2 = expr2
        self.up = up
        self.loop = loop

    def __str__(self):
        #return'{name:For,children:['+str(self.id)+','+str(self.expr1)+','+str(self.expr2)+','+('{name:Increase}'if self.up else'{name:Decrease}')+','+'{name:Loop,children:['+','.join((str(i)for i in(self.loop)))+']}]}' 
        return "For(" + str(self.id) + "" + str(self.expr1) + "," + str(self.expr2) + "," + str(self.up) + ',[' + ','.join(str(i) for i in self.loop) + "])"
    def child(self):
        return self.id,self.expr1,self.expr2,self.up,self.loop
    def accept(self, v, param):
        return v.visitFor(self, param)

class Break(Stmt):
    def __str__(self):
        #return'{name:Break}' 
        return "Break"

    def accept(self, v, param):
        return v.visitBreak(self, param)
    
class Continue(Stmt):
    def __str__(self):
        return "Continue"

    def accept(self, v, param):
        return v.visitContinue(self, param)

class Return_stmt_func(Stmt):
    #expr:Expr
    def __init__(self, expr = None):
        self.expr = expr

    def __str__(self):
        #return'{name:Return,children:['+('{name:None'if self.expr is None else'{name:Expr,children:['+str(self.expr)+']}')+']}' 
        return "Return(" + ("None" if (self.expr is None) else str(self.expr) ) + ")"
    def child(self):
        return self.expr
    def accept(self, v, param):
        return v.visitReturn(self, param)
class Return_void_func(Stmt):
    #expr:Expr
    def __init__(self, ):
        pass

    def __str__(self):
        #return'{name:Return,children:['+('{name:None'if self.expr is None else'{name:Some,children:['+str(self.expr)+']}')+']}'
        return "Return(" + "None Type"  + ")" + ")"
    def child(self):
        return "None"
    def accept(self, v, param):
        return v.visitReturn(self, param)
class CallStmt(Stmt):
    #method:Id
    #param:list(Expr)
    def __init__(self, method, param):
        self.method = method
        self.param = param

    def __str__(self):
        #return'{name:CallStmt,children:['+str(self.method)+','+'{name:Param,children:['+','.join((str(i)for i in(self.param)))+']}]}'
        return "CallStmt(" + str(self.method) + ",[" +  ','.join(str(i) for i in self.param) + "])"
    def child(self):
        return self.method,self.param
    def accept(self, v, param):
        return v.visitCallStmt(self, param)
class PrintfString(Stmt):
    def __init__(self, param):
        self.param = param

    def __str__(self):
        #return'{name:CallStmt,children:['+str(self.method)+','+'{name:Param,children:['+','.join((str(i)for i in(self.param)))+']}]}'
        return "PrintfString(" + str(self.param) +")"
    def child(self):
        return self.param
    def accept(self, v, param):
        return v.visitPrinf_stmt(self, param)
class PrintfStmt(Stmt):
    #method:Id
    #param:list(Expr)
    def __init__(self, format,param):
        self.format = format
        self.param = param

    def __str__(self):
        #return'{name:CallStmt,children:['+str(self.method)+','+'{name:Param,children:['+','.join((str(i)for i in(self.param)))+']}]}'
        return "PrintfStmt(" + str(self.format) + ",[" +  ','.join(str(i) for i in self.param) + "])"
    def child(self):
        return self.format,self.param
    def accept(self, v, param):
        return v.visitPrintf_stmt(self, param)
class ScanfStmt(Stmt):
    #method:Id
    #param:list(Expr)
    def __init__(self, format,param):
        self.format = format
        self.param = param

    def __str__(self):
        #return'{name:CallStmt,children:['+str(self.method)+','+'{name:Param,children:['+','.join((str(i)for i in(self.param)))+']}]}'
        return "ScanfStmt(" + str(self.format) + ",[" +  ','.join(str(i) for i in self.param) + "])"
    def child(self):
        return self.format,self.param
    def accept(self, v, param):
        return v.visitScanf_stmt(self, param)

class Expr(AST):
    __metaclass__ = ABCMeta
    pass

class BinaryOp(Expr):
    #op:string: AND THEN => andthen; OR ELSE => orelse; other => keep it
    #left:Expr
    #right:Expr
    def __init__(self, op, left, right):
        self.op = op
        self.left = left
        self.right = right

    def __str__(self):
        #return'{name:BinaryOp,children:[{name:'+self.op+'},'+str(self.left)+','+str(self.right)+']}'
        return "BinaryOp(" + self.op + "," + str(self.left) + "," + str(self.right) + ")"
    def child(self):
        return self.op,self.left,self.right
    def accept(self, v, param):
        return v.visitBinaryOp(self, param)

class UnaryOp(Expr):
    #op:string
    #body:Expr
    def __init__(self, op, body):
        self.op = op
        self.body = body

    def __str__(self):
        #return'{name:UnaryOp,children:[{name:'+self.op+'},'+str(self.body)+']}'
        return "UnaryOp(" + self.op + "," + str(self.body) + ")"
    def child(self):
        return self.op,self.body
    def accept(self, v, param):
        return v.visitUnaryOp(self, param)

class CallExpr(Expr):
    #method:Id
    #param:list(Expr)
    def __init__(self, method, param):
        self.method = method
        self.param = param

    def __str__(self):
        #return'{name:CallExpr,children:['+str(self.method)+','+'{name:Param,children:['+','.join((str(i)for i in(self.param)))+']}]}'
        return "CallExpr(" + str(self.method) + ",[" +  ','.join(str(i) for i in self.param) + "])"
    def child(self):
        return self.method,self.param
    def accept(self, v, param):
        return v.visitCallExpr(self, param)

class LHS(Expr):
    __metaclass__ = ABCMeta
    pass

class Id(LHS):
    #name:string
    def __init__(self, name):
        self.name = name

    def __str__(self):
        #return'{name:Id,children:[{name:'+self.name+'}]}'
        return "Id(" + self.name + ")"
    def accept(self, v, param):
        return v.visitId(self, param)

class ArrayCell(LHS):
    #arr:Expr
    #idx:Expr
    def __init__(self, arr, idx):
        self.arr = arr
        self.idx = idx

    def __str__(self):
        return "ArrayCell(" + str(self.arr) + "," + str(self.idx) + ")"

    def accept(self, v, param):
        return v.visitArrayCell(self, param)



class Literal(Expr):
    __metaclass__ = ABCMeta
    pass

class IntLiteral(Literal):
    #value:int
    def __init__(self, value):
        self.value = value

    def __str__(self):
        #return'{name:IntLiteral,children:[{name:'+str(self.value)+'}]}'
        return "IntLiteral(" + str(self.value) + ")"

    def accept(self, v, param):
        return v.visitIntLiteral(self, param)

class DoubleLiteral(Literal):
    #value:float
    def __init__(self, value):
        self.value = value

    def __str__(self):
        #return'{name:FloatLiteral,children:[{name:'+str(self.value)+'}]}'
        return "DoubleLiteral(" + str(self.value) + ")"

    def accept(self, v, param):
        return v.visitDoubleLiteral(self, param)

class StringLiteral(Literal):
    #value:string
    def __init__(self, value):
        self.value = value

    def __str__(self):
        #return'{name:StringLiteral",children:[{name:'+self.value+'}]}'
        return "StringLiteral(" + self.value + ")"

    def accept(self, v, param):
        return v.visitStringLiteral(self, param)

class BoolLiteral(Literal):
    #value:boolean
    def __init__(self, value):
        self.value = value

    def __str__(self):
        #return'{name:BooleanLiteral,children:[{name:'+str(self.value)+'}]}'
        return "BooleanLiteral(" + str(self.value) + ")"

    def accept(self, v, param):
        return v.visitBooleanLiteral(self, param)