/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CheckSymbols {
    public static BuiltInTypeSymbol getType(int tokenType) {
        BuiltInTypeSymbol t1=new BuiltInTypeSymbol("void");
        BuiltInTypeSymbol t2=new BuiltInTypeSymbol("int");
        BuiltInTypeSymbol t3=new BuiltInTypeSymbol("double");
        BuiltInTypeSymbol t5=new BuiltInTypeSymbol("invalid");
        BuiltInTypeSymbol t4=new BuiltInTypeSymbol("String");
        BuiltInTypeSymbol t6=new BuiltInTypeSymbol("Bool");
        switch ( tokenType ) {
            case cosimParser.VOID :   return t1;
            case cosimParser.INT :    return t2;
            case cosimParser.DOUBLE : return t3;
            case cosimParser.STRING:  return t4;
            case cosimParser.BOOL:    return t6;
        }
        return t5;
    }

    public static void error(Token t, String msg) {
        System.err.printf("line %d:%d %s\n", t.getLine(), t.getCharPositionInLine(),
                          msg);
    }

    public void process(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) {
            is = new FileInputStream(inputFile);
        }
        ANTLRInputStream input = new ANTLRInputStream(is);
        cosimLexer lexer = new cosimLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        cosimParser parser = new cosimParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.program();
        // show tree in text form
//        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase def = new DefPhase();
        walker.walk((ParseTreeListener) def, tree);
        // create next phase and feed symbol table info from def to ref phase
        RefPhase ref = new RefPhase(def.globals, def.scopes);
        walker.walk(ref, tree);
        Map<String,Collection>backup=def.getData();
        int numscope=backup.size();
        DefaultTableModel tableModel = new DefaultTableModel(0, 2);
        tableModel.addRow(new Object[]{"Scope name","Variable and type"});
        Object[] list2 = ((Collection) backup.values()).toArray();
        for (String name: backup.keySet()) {
            String key = name.toString();
            String value = backup.get(name).toString();
            //Object[] row = { key, value };
            tableModel.addRow(new Object[]{key,value});
        }
        JFrame f=new JFrame();
        f.setTitle("Symbol Table");
        //String[] columnames={"Scope name","variable"};
        //String data[][]={};
        JTable j=new JTable(tableModel);
        
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        //for(int i=0;i<numscope;i++)
       // {
       //     String name=backup.
        //}
        //System.out.println(list2[0].toString());
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new CheckSymbols().process(args);
    }
}