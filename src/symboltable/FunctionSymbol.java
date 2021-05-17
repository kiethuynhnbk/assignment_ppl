/***
 * Excerpted from "Language Implementation Patterns",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book information.
***/
import java.util.LinkedHashMap;
import java.util.Map;

public class FunctionSymbol extends Symbol implements Scope {
	Map<String, Symbol> orderedArgs = new LinkedHashMap<String, Symbol>();
    Scope enclosingScope;

    public FunctionSymbol(String name, Type retType, Scope enclosingScope) {
        super(name, retType);
        this.enclosingScope = enclosingScope;
    }

    public Symbol resolve(String name) {
		Symbol s = orderedArgs.get(name);
        if ( s!=null ) return s;
		// if not here, check any enclosing scope
		if ( getEnclosingScope() != null ) {
			return getEnclosingScope().resolve(name);
		}
		return null; // not found
	}
	public Map<String, Symbol> getSymbols()
	{
		return this.orderedArgs;
	}

	public void define(Symbol sym) {
		orderedArgs.put(sym.name, sym);
		sym.scope = this; // track the scope in each symbol
	}
	public Map<String, Symbol> getArgs()
	{
		return this.orderedArgs;
	}

	public Scope getEnclosingScope() { return enclosingScope; }
	public String getScopeName() { return name; }

    public String toString() { return "function"+super.toString()+":"+orderedArgs.values(); }
}
