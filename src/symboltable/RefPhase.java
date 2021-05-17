/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;



public class RefPhase extends cosimBaseListener {
    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope; // resolve symbols starting in this scope

    public RefPhase(GlobalScope globals, ParseTreeProperty<Scope> scopes) {
        this.scopes = scopes;
        this.globals = globals;
    }
    public void enterProgram(cosimParser.ProgramContext ctx) {
        currentScope = globals;
    }

    public void enterFunc_declare(cosimParser.Func_declareContext ctx) {
        currentScope = scopes.get(ctx);
    }
    public void exitFunc_declare(cosimParser.Func_declareContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }
	
    public void enterCompound_stmt(cosimParser.Compound_stmtContext ctx) {
        //currentScope = scopes.get(ctx);
    }
    public void exitIds_list(cosimParser.Ids_listContext ctx)
    {
        List<org.antlr.v4.runtime.tree.TerminalNode> l=ctx.ID();
        int num=l.size();
        for(int i=0;i<num;i++)
        {
            org.antlr.v4.runtime.tree.TerminalNode node=l.get(i);
            String name=node.getText();
            Symbol var=currentScope.resolve(name);
            if ( var==null ) {
                CheckSymbols.error(node.getSymbol(), "no such variable: "+name);
            }
            if ( var instanceof FunctionSymbol ) {
                CheckSymbols.error(node.getSymbol(), name+" is not a variable");
            }


        }
    }
    public void exitCompound_stmt(cosimParser.Compound_stmtContext ctx) {
       // currentScope = currentScope.getEnclosingScope();
    }

    public void exitVar_declare(cosimParser.Var_declareContext ctx) {
        //List<MPParser.Ids_list_with_typeContext> ids=ctx.ids_list_with_type();
       // int t=ids.size();
       // for(int i=0;i<t;i++)
       // {
           // MPParser.Ids_list_with_typeContext current=ids.get(i);
           // MPParser.Ids_listContext li=current.ids_list();
            //List<org.antlr.v4.runtime.tree.TerminalNode> names=li.ID();
            //for(int j=0;j<names.size();j++)
            //{
            //    String name=names.get(i).getText();
            //    Symbol var = currentScope.resolve(name);
            //    if ( var==null ) {
             //       CheckSymbols.error(ctx.ids_list_with_type(i).ids_list().ID().get(j).getSymbol(), "no such variable: "+name);
             //   }
              ////  if ( var instanceof FunctionSymbol ) {
                //    CheckSymbols.error(ctx.ids_list_with_type(i).ids_list().ID().get(j).getSymbol(), name+" is not a variable");
               // }
          //  }
       // }
    }

    public void exitCall_exp(cosimParser.Call_expContext ctx) {
        // can only handle f(...) not expr(...)
        String funcName = ctx.ID().getText();
        Symbol meth = currentScope.resolve(funcName);
        if ( meth==null ) {
            CheckSymbols.error(ctx.ID().getSymbol(), "no such function: "+funcName);
        }
        if ( meth instanceof VariableSymbol ) {
            CheckSymbols.error(ctx.ID().getSymbol(), funcName+" is not a function");
        }
    }
}