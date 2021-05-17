from graphviz import Digraph
import re
import os
import sys,os
from antlr4 import *
from queue import LifoQueue
from antlr4.error.ErrorListener import ConsoleErrorListener,ErrorListener
if not './main/cosim/parser/' in sys.path:
    sys.path.append('./main/cosim/parser/')
if os.path.isdir('../target/main/cosim/parser') and not '../target/main/cosim/parser/' in sys.path:
    sys.path.append('../target/main/cosim/parser/')
if not './main/cosim/astgen/' in sys.path:
    sys.path.append('./main/cosim/astgen/')
if not './main/cosim/utils/' in sys.path:
    sys.path.append('./main/cosim/utils/')  
from cosimLexer import cosimLexer    
from cosimParser import cosimParser   
from ASTGeneration import ASTGeneration
os.environ["PATH"]+=os.pathsep+'D:/anhkiet/graphviz/Graphviz/bin/'
Lexer = cosimLexer
Parser = cosimParser
filename = "./testAst.txt"
content=open("./testAst.txt", "r").read()
file = open(filename,"w")
file.write(content)
file.close()
input=FileStream(filename)
dot =Digraph(comment='The Round Table')
lexer = Lexer(input)
tokens = CommonTokenStream(lexer)
parser = Parser(tokens)
tree = parser.program()
asttree = ASTGeneration().visit(tree)
print(asttree)
print('////////////////')
arr=[]
func_count=0
stmt_list_count=0
return_stmt_func=0
for_stmt=0
assign_stmt=0
while_stmt=0
return_void_stmt=0
if_stmt=0
print_string=0
printf_stmt=0
scanf_stmt=0
break_stmt=0
continue_stmt=0
call_stmt=0
binary_op=0
unary_op=0
expr=0
expr1=0
expr2=0
expr3=0
expr4=0
loop_count=0
map_linked=""
#count for stmts in parent i for_stmt
def count_for_stmt(i):
    arr=[]
    stack=[]
    stack.append(i)
    arr.append(i)
    while len(stack)>0:
        stmt=stack.pop()
        for x in stmt.child()[4]:
            if type(x).__name__=="For":
                stack.append(x)
                arr.append(x)
    return len(arr)
#count for stmts in parent i while_stmt
def count_while_stmt(i):
    arr=[]
    stack=[]
    stack.append(i)
    arr.append(i)
    while len(stack)>0:
        stmt=stack.pop()
        for x in stmt.child()[1]:
            if type(x).__name__=="While":
                stack.append(x)
                arr.append(x)
    return len(arr)
def count_if_stmt(i):
    arr=[]
    stack=[]
    stack.append(i)
    arr.append(i)
    while len(stack)>0:
        stmt=stack.pop()
        for x in stmt.child()[1]:
            if type(x).__name__=="If":
                stack.append(x)
                arr.append(x)
        for x in stmt.child()[2]:
            if type(x).__name__=="If":
                stack.append(x)
                arr.append(x)
    return len(arr)
def visualize_exp(parent,exp):
    global binary_op
    global unary_op
    global func_count
    global map_linked
    global assign_stmt
    global return_stmt_func
    if(type(exp).__name__=="UnaryOp"):
        dot.edge(parent, "UnaryOp"+str(unary_op))
        dot.edge("UnaryOp"+str(unary_op), "SIGN "+str(exp.child()[0])+"(<Unary "+str(unary_op)+">)")
        dot.edge("UnaryOp"+str(unary_op), "VALUE "+str(exp.child()[1])+"(<Unary "+str(unary_op)+">)")
        unary_op+=1
    elif(type(exp).__name__=="BinaryOp"):
        right_node_terminal=[]
        initial=binary_op
        sign=exp.child()[0]
        left=exp.child()[1]
        right=exp.child()[2]
        dot.edge(parent, "BinaryOp"+str(binary_op))
        map_linked+=(parent+"BinaryOp"+str(binary_op))
        dot.edge("BinaryOp"+str(binary_op), str(sign)+'(<BinaryOp '+str(binary_op)+'>)')
        map_linked+=("BinaryOp"+str(binary_op)+str(sign)+'('+str(binary_op)+')')
        if(type(left).__name__!="BinaryOp"):
            dot.edge("BinaryOp"+str(binary_op), str(left)+'(<BinaryOp '+str(binary_op)+'>)')
            map_linked+=("BinaryOp"+str(binary_op)+str(left)+'('+str(binary_op)+')')
        if(type(right).__name__!="BinaryOp"):
            right_node_terminal.append(("BinaryOp"+str(binary_op),str(right)+'(<BinaryOp '+str(binary_op)+'>)'))
            map_linked+=("BinaryOp"+str(binary_op)+str(right)+'('+str(binary_op)+')')
        stackL = []
        stackR = []
        if(type(left).__name__=="BinaryOp"):
            stackL.append(left)
            while(len(stackL)>0):
                t=stackL.pop()
                if(type(t).__name__=="BinaryOp"):
                    stackL.append(t.child()[0])
                    stackL.append(t.child()[2])
                    stackL.append(t.child()[1])
                    binary_op+=1
                    parent=-1
                    while(map_linked.count("BinaryOp"+str(binary_op+parent))==4):
                        parent-=1
                    dot.edge("BinaryOp"+str(binary_op+parent), "BinaryOp"+str(binary_op))
                    map_linked+=("BinaryOp"+str(binary_op+parent)+"BinaryOp"+str(binary_op))
                    dot.edge("BinaryOp"+str(binary_op), str(t.child()[0])+' (<BinaryOp '+str(binary_op)+'>)')
                    map_linked+=("BinaryOp"+str(binary_op)+str(t.child()[0])+'('+str(binary_op)+')')
                    if type(t.child()[1]).__name__!="BinaryOp":
                        dot.edge("BinaryOp"+str(binary_op), str(t.child()[1])+'(<BinaryOp '+str(binary_op)+'>)')
                        map_linked+=("BinaryOp"+str(binary_op)+str(t.child()[1])+'('+str(binary_op)+')')
                    if type(t.child()[2]).__name__!="BinaryOp":
                        right_node_terminal.append(("BinaryOp"+str(binary_op),str(t.child()[2])+'(<BinaryOp '+str(binary_op)+'>)'))
                        map_linked+=("BinaryOp"+str(binary_op)+str(t.child()[2])+'('+str(binary_op)+')')
        count_right=0
        if(type(right).__name__=="BinaryOp"):
            stackR.append(right)
            while(len(stackR)>0):
                t=stackR.pop()
                if(type(t).__name__=="BinaryOp"):
                    stackR.append(t.child()[0])
                    stackR.append(t.child()[2])
                    stackR.append(t.child()[1])
                    binary_op+=1
                    if count_right==0:
                        dot.edge("BinaryOp"+str(initial), "BinaryOp"+str(binary_op))
                        #dot.edge("BinaryOp"+str(binary_op), str(t.child()[0])+'('+str(binary_op)+')')
                        count_right+=1
                    else:
                        dot.edge("BinaryOp"+str(binary_op-1), "BinaryOp"+str(binary_op))
                    dot.edge("BinaryOp"+str(binary_op), str(t.child()[0])+'(<BinaryOp '+str(binary_op)+'>)')
                    if type(t.child()[1]).__name__!="BinaryOp":
                        dot.edge("BinaryOp"+str(binary_op), str(t.child()[1])+'(<BinaryOp '+str(binary_op)+'>)')
                    if type(t.child()[2]).__name__!="BinaryOp":
                        dot.edge("BinaryOp"+str(binary_op), str(t.child()[2])+'(<BinaryOp '+str(binary_op)+'>)')
        print(len(right_node_terminal))
        for x in right_node_terminal:
            dot.edge(x[0],x[1])
        binary_op+=1
    else:
        if 'Assign' in parent:
            dot.edge(parent, "Value_literal("+str(exp)+')'+'(<Assign '+str(assign_stmt+1)+'>)')
        else:
            dot.edge(parent, "Value_literal("+str(exp)+')'+'(<Return '+str(return_stmt_func+1)+'>)')
def visualize_return_func_stmt(parent,i):
    global return_stmt_func
    dot.edge(parent, "Return_func_stmt"+str(return_stmt_func))
    exp=i.child()
    visualize_exp("Return_func_stmt"+str(return_stmt_func),exp)
    return_stmt_func+=1
def visualize_printf_stmt(parent,i):
    global func_count
    global printf_stmt
    dot.edge(parent, "PrintfStmt"+str(printf_stmt))
    param=str(i.child()[0])+'('+str(printf_stmt)+')'
    dot.edge("PrintfStmt"+str(printf_stmt), param)
    dot.edge("PrintfStmt"+str(printf_stmt), "exp_list"+'('+str(printf_stmt)+')')
    for exp in i.child()[1]:
        visualize_exp("exp_list"+'('+str(printf_stmt)+')',exp)
    printf_stmt+=1
#visualize_scanf_stmt(i)
def visualize_scanf_stmt(parent,i):
    global func_count
    global scanf_stmt
    dot.edge(parent, "ScanfStmt"+str(scanf_stmt))
    param=str(i.child()[0])+'('+str(scanf_stmt)+')'
    pointer=''.join(str(c)+',' for c in i.child()[1])
    pointer=pointer[:-1]
    pointer=pointer+'('+str(scanf_stmt)+')'
    dot.edge("ScanfStmt"+str(scanf_stmt), param)
    dot.edge("ScanfStmt"+str(scanf_stmt),pointer)
    scanf_stmt+=1
#visulaize_printf_string
def visualize_printf_string(parent,i):
    global func_count
    global print_string
    dot.edge(parent, "PrintfString"+str(print_string))
    param=str(i.child())+'('+str(print_string)+')'
    dot.edge("PrintfString"+str(print_string), param)
    print_string+=1
def visualize_if_stmt(parent,i,recur):
    global func_count
    global if_stmt
    initial=if_stmt
    if recur>=1:
        if_stmt+=1
    ##1
    dot.edge(parent, "If_stmt"+str(if_stmt))
    expr=(i.child()[0])
    visualize_exp("If_stmt"+str(if_stmt), expr)
    dot.edge("If_stmt"+str(if_stmt), "thenStmt"+str(if_stmt))
    dot.edge("If_stmt"+str(if_stmt), "elseStmt"+str(if_stmt))
    for child in i.child()[1]:
        if(type(child).__name__=="Return_stmt_func"):
            if(recur==0):
                visualize_return_func_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_return_func_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_return_func_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="Assign"):
            if(recur==0):
                visualize_assign_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_assign_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_assign_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="Return_void_func"):
            if(recur==0):
                visualize_return_void_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_return_void_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_return_void_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="Break"):
            if(recur==0):
                visualize_break_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_break_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_break_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="Continue"):
            if(recur==0):
                visualize_continue_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_continue_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_continue_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="PrintfString"):
            if(recur==0):
                visualize_printf_string('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_printf_string('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_printf_string('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="ScanfStmt"):
            if(recur==0):
                visualize_scanf_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_scanf_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_scanf_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="PrintfStmt"):
            if(recur==0):
                visualize_printf_stmt('thenStmt'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_printf_stmt('thenStmt'+str(if_stmt-count),child)
                else:
                    visualize_printf_stmt('thenStmt'+str(if_stmt),child)
        elif(type(child).__name__=="For"):
            if(recur==0):
                visualize_for_stmt('thenStmt'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_for_stmt('thenStmt'+str(if_stmt-count),child,0)
                else:
                    visualize_for_stmt('thenStmt'+str(if_stmt),child,0)
        elif(type(child).__name__=="While"):
            if(recur==0):
                visualize_while_stmt('thenStmt'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_while_stmt('thenStmt'+str(if_stmt-count),child,0)
                else:
                    visualize_while_stmt('thenStmt'+str(if_stmt),child,0)
        elif(type(child).__name__=="If"):
            if(recur==0 ):
                thenStmt='thenStmt'+str(initial)
                visualize_if_stmt(thenStmt,child,1)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                if front==True:
                    visualize_if_stmt('thenStmt'+str(if_stmt-count),child,if_stmt)
                else:
                    visualize_if_stmt('thenStmt'+str(if_stmt),child,if_stmt)

    #dot.edge("thenStmt"+str(if_stmt), str(x))
    for child in i.child()[2]:
        if(type(child).__name__=="Return_stmt_func"):
            if(recur==0):
                visualize_return_func_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_return_func_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="Assign"):
            if(recur==0):
                visualize_assign_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_assign_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="Return_void_func"):
            if(recur==0):
                visualize_return_void_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_return_void_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="PrintfString"):
            if(recur==0):
                visualize_printf_string('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_printf_string('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="Break"):
            if(recur==0):
                visualize_break_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_break_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="Continue"):
            if(recur==0):
                visualize_continue_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_continue_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="ScanfStmt"):
            if(recur==0):
                visualize_scanf_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_scanf_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="PrintfStmt"):
            if(recur==0):
                visualize_printf_stmt('elseStmt'+str(initial),child)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_printf_stmt('elseStmt'+str(if_stmt-count), child)
        elif(type(child).__name__=="For"):
            if(recur==0):
                visualize_for_stmt('elseStmt'+str(initial),child,0)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_for_stmt('elseStmt'+str(if_stmt-count), child,0)
        elif(type(child).__name__=="While"):
            if(recur==0):
                visualize_while_stmt('elseStmt'+str(initial),child,0)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_while_stmt('elseStmt'+str(if_stmt-count), child,0)
        elif(type(child).__name__=="If"):
            if(recur==0):
                visualize_if_stmt('elseStmt'+str(initial),child,1)
            else:
                count=0
                for x in (i.child()[1]):
                        if type(x).__name__=="If":
                            count=count+count_if_stmt(x)
                idx=0
                for x in range(len(i.child()[2])):
                    if (i.child()[2])[x] is child:
                        idx=x
                        break
                front=False
                if idx>=1:
                    for x in (i.child()[2])[0:idx]:
                        if type(x).__name__=="If":
                            front=True
                            count=count+count_if_stmt(x)
                visualize_if_stmt('elseStmt'+str(if_stmt-count), child,if_stmt)
    #dot.edge("elseStmt"+str(if_stmt), str(y))
    if recur<1:
        if_stmt+=1
def visualize_while_stmt(parent,i,recur):
    global func_count
    global while_stmt
    initial=while_stmt
    if(recur>=1):
        while_stmt+=1
    #1#2
    dot.edge(parent, "While_stmt"+'('+str(while_stmt)+')')
    expr=i.child()[0]
    visualize_exp("While_stmt"+'('+str(while_stmt)+')',expr)
    dot.edge("While_stmt"+'('+str(while_stmt)+')',"While_body"+str(while_stmt))
    for child in i.child()[1]:
        if(type(child).__name__=="Return_stmt_func"):
            if(recur==0):
                visualize_return_func_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_return_func_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_return_func_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="Assign"):
            if(recur==0):
                visualize_assign_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_assign_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_assign_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="Return_void_func"):
            if(recur==0):
                visualize_return_void_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_return_void_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_return_void_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="While"):
            if(recur==0 ):
                loop='While_body'+str(initial)
                visualize_while_stmt(loop,child,1)
            else:
               # loop='Loop'+str(for_stmt)
               # visualize_for_stmt(loop,child,for_stmt)
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_for_stmt('While_body'+str(while_stmt-count),child,while_stmt)
                else:
                    visualize_for_stmt('While_body'+str(while_stmt),child,for_stmt)
        elif(type(child).__name__=="PrintfString"):
            if(recur==0):
                visualize_printf_string('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_printf_string('While_body'+str(while_stmt-count),child)
                else:
                    visualize_printf_string('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="ScanfStmt"):
            if(recur==0):
                visualize_scanf_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_scanf_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_scanf_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="PrintfStmt"):
            if(recur==0):
                visualize_printf_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_printf_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_printf_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="Break"):
            if(recur==0):
                visualize_break_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_break_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_break_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="Continue"):
            if(recur==0):
                visualize_continue_stmt('While_body'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_continue_stmt('While_body'+str(while_stmt-count),child)
                else:
                    visualize_continue_stmt('While_body'+str(while_stmt),child)
        elif(type(child).__name__=="If"):
            if(recur==0):
                visualize_if_stmt('While_body'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_if_stmt('While_body'+str(while_stmt-count),child,0)
                else:
                    visualize_if_stmt('While_body'+str(while_stmt),child,0)
        elif(type(child).__name__=="For"):
            if(recur==0):
                visualize_for_stmt('While_body'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[1])):
                    if (i.child()[1])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[1])[0:idx]:
                        if type(x).__name__=="While":
                            front=True
                            count=count+count_while_stmt(x)
                if front==True:
                    visualize_for_stmt('While_body'+str(while_stmt-count),child,0)
                else:
                    visualize_for_stmt('While_body'+str(while_stmt),child,0)
    if recur<1:
        while_stmt+=1

def visualize_for_stmt(parent,i,recur):
    global func_count
    global for_stmt
    initial=for_stmt
    if(recur>=1):
        for_stmt+=1
    #1#2
    dot.edge(parent, "For_stmt"+str(for_stmt))
    vari=str(i.child()[0])
    expr1=(i.child()[1])
    expr2=(i.child()[2])
    up=str(i.child()[3])
    dot.edge("For_stmt"+str(for_stmt),vari+str(for_stmt))
    #visualize_assign_stmt("For_stmt"+str(for_stmt),expr1)
    visualize_assign_stmt("For_stmt"+str(for_stmt),expr1)
    visualize_exp("For_stmt"+str(for_stmt),expr2)
    dot.edge("For_stmt"+str(for_stmt),up+str(for_stmt))
    dot.edge("For_stmt"+str(for_stmt),"Loop"+str(for_stmt))
    for child in i.child()[4]:
        if(type(child).__name__=="Return_stmt_func"):
            if(recur==0):
                visualize_return_func_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_return_func_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_return_func_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="Assign"):
            if(recur==0):
                visualize_assign_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_assign_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_assign_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="Return_void_func"):
            if(recur==0):
                visualize_return_void_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_return_void_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_return_void_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="While"):
            if(recur==0):
                visualize_while_stmt('Loop'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_while_stmt('Loop'+str(for_stmt-count),child,0)
                else:
                    visualize_while_stmt('Loop'+str(for_stmt),child,0)
        elif(type(child).__name__=="PrintfString"):
            if(recur==0):
                visualize_printf_string('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_printf_string('Loop'+str(for_stmt-count),child)
                else:
                    visualize_printf_string('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="ScanfStmt"):
            if(recur==0):
                visualize_scanf_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_scanf_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_scanf_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="PrintfStmt"):
            if(recur==0):
                visualize_printf_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_printf_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_printf_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="Break"):
            if(recur==0 ):
                visualize_break_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_break_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_break_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="Continue"):
            if(recur==0 ):
                visualize_continue_stmt('Loop'+str(initial),child)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_continue_stmt('Loop'+str(for_stmt-count),child)
                else:
                    visualize_continue_stmt('Loop'+str(for_stmt),child)
        elif(type(child).__name__=="If"):
            if(recur==0):
                visualize_if_stmt('Loop'+str(initial),child,0)
            else:
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_if_stmt('Loop'+str(for_stmt-count),child,0)
                else:
                    visualize_if_stmt('Loop'+str(for_stmt),child,0)
        elif(type(child).__name__=="For"):
            if(recur==0 ):
                loop='Loop'+str(initial)
                visualize_for_stmt(loop,child,1)
            else:
               # loop='Loop'+str(for_stmt)
               # visualize_for_stmt(loop,child,for_stmt)
                idx=0
                for x in range(len(i.child()[4])):
                    if (i.child()[4])[x] is child:
                        idx=x
                        break
                front=False
                count=0
                if idx>=1:
                    for x in (i.child()[4])[0:idx]:
                        if type(x).__name__=="For":
                            front=True
                            count=count+count_for_stmt(x)
                if front==True:
                    visualize_for_stmt('Loop'+str(for_stmt-count),child,for_stmt)
                else:
                    visualize_for_stmt('Loop'+str(for_stmt),child,for_stmt)
    if recur<1:
        for_stmt+=1
def visualize_break_stmt(parent,i):
    global func_count
    global break_stmt
    dot.edge(parent, "Break"+'('+str(break_stmt)+')')
    break_stmt+=1
def visualize_continue_stmt(parent,i):
    global func_count
    global continue_stmt
    dot.edge(parent, "Continue"+'('+str(continue_stmt)+')')
    continue_stmt+=1
def visualize_return_void_stmt(parent,i):
    global func_count
    global return_void_stmt
    dot.edge(parent, "Return(None)"+'('+str(return_void_stmt)+')')
    return_void_stmt+=1
##visualize_assign_stmt
def visualize_assign_stmt(parent,i):
    global func_count
    global assign_stmt
    global unary_op
    global binary_op
    global map_linked
    dot.edge(parent, "Assign_stmt"+'('+str(assign_stmt)+')')
    type_name=''
    lhs=''
    for x in i.child()[0]:
        type_name=(type(x).__name__)
        break
    if(type_name=="Id"):
        lhs=(''.join(str(c)+';' for c in i.child()[0]))
    else:
        lhs=''.join(str(c[0])+','+str(c[1])+';' for c in i.child()[0])
    dot.edge("Assign_stmt"+'('+str(assign_stmt)+')', lhs+'(assign_stmt<'+str(assign_stmt)+'>)')
    visualize_exp("Assign_stmt"+'('+str(assign_stmt)+')',i.child()[1])
    assign_stmt+=1
def visualize_call_stmt(parent,i):
    global func_count
    global call_stmt
    dot.edge(parent, "CallStmt"+str(call_stmt))
    param=str(i.child()[0])+'('+str(call_stmt)+')'
    pointer=''.join(str(c)+',' for c in i.child()[1])
    pointer=pointer[:-1]
    pointer=pointer+'('+str(call_stmt)+')'
    dot.edge("CallStmt"+str(call_stmt), param)
    dot.edge("CallStmt"+str(call_stmt),pointer)
    call_stmt+=1
############################MAIN##########################
for x in asttree.child():
    if type(x).__name__=="Include":
        print(x.child())
        dot.edge('program','Lib('+x.child()+')')
    elif type(x).__name__=="FuncDecl":
        dot.edge('program','Func_decl'+str(func_count))
        dot.edge('Func_decl'+str(func_count),str(x.child()[0]))
        dot.edge('Func_decl'+str(func_count),''.join(str(i) for i in x.child()[1])+str(func_count))
        dot.edge('Func_decl'+str(func_count),str(x.child()[2])+str(func_count))
        dot.edge('Func_decl'+str(func_count),'stmt_list'+str(func_count))
        for i in x.child()[3]:
            if(type(i).__name__=="Return_stmt_func"):
                visualize_return_func_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="For"):
                visualize_for_stmt('stmt_list'+str(func_count),i,0)
            elif(type(i).__name__=="Assign"):
                visualize_assign_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="If"):
                    #return self.expr,self.Stmt,self.elseStmt
                visualize_if_stmt('stmt_list'+str(func_count),i,0)
            elif(type(i).__name__=="While"):
                visualize_while_stmt('stmt_list'+str(func_count),i,0)
            elif(type(i).__name__=="PrintfString"):
                visualize_printf_string('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="ScanfStmt"):
                visualize_scanf_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="PrintfStmt"):
                visualize_printf_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="Return_void_func"):
                visualize_return_void_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="CallStmt"):
                visualize_call_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="BreakStmt"):
                visualize_break_stmt('stmt_list'+str(func_count),i)
            elif(type(i).__name__=="ContinueStmt"):
                visualize_continue_stmt('stmt_list'+str(func_count),i)
            else:
                dot.edge('stmt_list'+str(func_count),str(i))
        func_count+=1
        stmt_list_count+=1
dot.render('test-output/round-table.gv', view=True)
#for 2 level
#while 2 level
#if 2 level

