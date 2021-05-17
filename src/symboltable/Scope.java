import java.util.Map;

public interface Scope {
    public String getScopeName(); // do I have a name?
    public Scope getEnclosingScope(); // am I nested in another?
    public void define(Symbol sym); // define sym in this scope
    public Symbol resolve(String name); // look up name in scop
    public Map<String, Symbol> getSymbols();
    
}
