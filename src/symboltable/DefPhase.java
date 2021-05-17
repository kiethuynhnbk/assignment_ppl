/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class DefPhase extends cosimBaseListener {
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    Map<String,Collection> data=new LinkedHashMap<String,Collection>();

    GlobalScope globals;
    Scope currentScope; // define symbols in this scope
    public void enterProgram(cosimParser.ProgramContext ctx) {
        globals = new GlobalScope();
        currentScope = globals;
    }
	
    public void exitProgram(cosimParser.ProgramContext ctx) {
        data.put("GLOBAL",(globals.getSymbols().values()));
        System.out.println(globals);
    }

    public void enterFunc_declare(cosimParser.Func_declareContext ctx) {
        String name = ctx.ID().getText();
        int typeTokenType = ctx.data_types().start.getType();
        BuiltInTypeSymbol type = CheckSymbols.getType(typeTokenType);
		
        // push new scope by making new one that points to enclosing scope
        FunctionSymbol function = new FunctionSymbol(name, type, currentScope);
        currentScope.define(function); // Define function in current scope
        saveScope(ctx, function);      // Push: set function's parent to current
        currentScope = function;       // Current scope is now function scope
    }

    void saveScope(ParserRuleContext ctx, Scope s) { scopes.put(ctx, s); }

    public void exitFunc_declare(cosimParser.Func_declareContext ctx) {
        String name=currentScope.getScopeName();
        System.out.println(name);
        data.put(name,(currentScope.getSymbols().values()));
        //System.out.println(x);
        System.out.println(currentScope);
        //currentScope.sym
        currentScope = currentScope.getEnclosingScope(); // pop scope
    }
    public Map<String,Collection> getData()
    {
        return this.data;
    }

    public void enterCompound_stmt(cosimParser.Compound_stmtContext ctx) {

    }

    public void exitCompound_stmt(cosimParser.Compound_stmtContext ctx) {

    }

    public void exitFormalParameter(cosimParser.Params_listContext ctx) {

    }

    public void exitVarDecl(cosimParser.Var_declareContext ctx) {
    }
    public void enterIds_list_with_type(cosimParser.Ids_list_with_typeContext ctx)
    {
        cosimParser.Data_typesContext type=ctx.data_types();
        cosimParser.Ids_listContext li=ctx.ids_list();
        List<org.antlr.v4.runtime.tree.TerminalNode> names=li.ID();
        for(int i=0;i<names.size();i++)
        {
            String name=names.get(i).getText();
            Symbol var=currentScope.resolve(name);
            if(var==null)
            {
                defineVar(type,names.get(i).getSymbol());
            }
            else
            {
                CheckSymbols.error(names.get(i).getSymbol(), "redeclare variable "+name);
            }
        }
    }
    void defineVar(cosimParser.Data_typesContext typeCtx, Token nameToken) {
        int typeTokenType = typeCtx.start.getType();
        Type type = CheckSymbols.getType(typeTokenType);
        VariableSymbol var = new VariableSymbol(nameToken.getText(), type);
        currentScope.define(var); // Define symbol in current scope
    }
}
//var_declare: (ids_list_with_type SEMI)+;
//assign_lhs:ids_list|ids_list_with_type ;