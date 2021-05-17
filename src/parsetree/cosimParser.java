// Generated from cosim.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class cosimParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, INCLUDE=2, STDIO=3, MATH=4, STDBOOL=5, TRUE=6, FALSE=7, IF=8, 
		ELSE=9, FOR=10, WHILE=11, RETURN=12, BREAK=13, CONTINUE=14, INT=15, STRING=16, 
		DOUBLE=17, BOOL=18, VOID=19, ARRAY=20, CONST=21, NOT=22, AND=23, OR=24, 
		ADD_SELF=25, SUB_SELF=26, ADD=27, SUB=28, MUL=29, DIV=30, MOD=31, ASSIGN=32, 
		EQ=33, LTE=34, GTE=35, NEQ=36, LT=37, GT=38, LP=39, RP=40, LCB=41, RCB=42, 
		LSB=43, RSB=44, HASH=45, SEMI=46, COMMA=47, COLON=48, DOT=49, PRINTF=50, 
		SCANF=51, STRING_LITERAL=52, REAL_LITERAL=53, INTEGER_LITERAL=54, ID=55, 
		Comment1=56, Comment2=57, Comment3=58, WS=59;
	public static final int
		RULE_program = 0, RULE_declare = 1, RULE_include_stmt = 2, RULE_var_declare = 3, 
		RULE_func_declare = 4, RULE_stmt = 5, RULE_assign_stmt = 6, RULE_assign_body = 7, 
		RULE_assign_lhs = 8, RULE_if_stmt = 9, RULE_while_stmt = 10, RULE_for_stmt = 11, 
		RULE_brk_stmt = 12, RULE_cont_stmt = 13, RULE_ret_stmt_func = 14, RULE_ret_void_func = 15, 
		RULE_call_stmt = 16, RULE_compound_stmt = 17, RULE_printf_stmt = 18, RULE_scanf_stmt = 19, 
		RULE_stmt_list = 20, RULE_exp_bool = 21, RULE_exp_int = 22, RULE_exp_real = 23, 
		RULE_exp_str = 24, RULE_exp = 25, RULE_exp1 = 26, RULE_exp2 = 27, RULE_exp3 = 28, 
		RULE_exp4 = 29, RULE_operands = 30, RULE_primary_exp = 31, RULE_call_exp = 32, 
		RULE_params_list = 33, RULE_ids_list_with_type = 34, RULE_ids_list = 35, 
		RULE_exps_list = 36, RULE_data_types = 37, RULE_compound_types = 38, RULE_primitive_types = 39, 
		RULE_literal = 40, RULE_number = 41, RULE_boolean_literal = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declare", "include_stmt", "var_declare", "func_declare", 
			"stmt", "assign_stmt", "assign_body", "assign_lhs", "if_stmt", "while_stmt", 
			"for_stmt", "brk_stmt", "cont_stmt", "ret_stmt_func", "ret_void_func", 
			"call_stmt", "compound_stmt", "printf_stmt", "scanf_stmt", "stmt_list", 
			"exp_bool", "exp_int", "exp_real", "exp_str", "exp", "exp1", "exp2", 
			"exp3", "exp4", "operands", "primary_exp", "call_exp", "params_list", 
			"ids_list_with_type", "ids_list", "exps_list", "data_types", "compound_types", 
			"primitive_types", "literal", "number", "boolean_literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'!'", "'&&'", 
			"'|'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'=='", 
			"'<='", "'>='", "'!='", "'<'", "'>'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "'#'", "';'", "','", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "INCLUDE", "STDIO", "MATH", "STDBOOL", "TRUE", "FALSE", "IF", 
			"ELSE", "FOR", "WHILE", "RETURN", "BREAK", "CONTINUE", "INT", "STRING", 
			"DOUBLE", "BOOL", "VOID", "ARRAY", "CONST", "NOT", "AND", "OR", "ADD_SELF", 
			"SUB_SELF", "ADD", "SUB", "MUL", "DIV", "MOD", "ASSIGN", "EQ", "LTE", 
			"GTE", "NEQ", "LT", "GT", "LP", "RP", "LCB", "RCB", "LSB", "RSB", "HASH", 
			"SEMI", "COMMA", "COLON", "DOT", "PRINTF", "SCANF", "STRING_LITERAL", 
			"REAL_LITERAL", "INTEGER_LITERAL", "ID", "Comment1", "Comment2", "Comment3", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "cosim.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cosimParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(cosimParser.EOF, 0); }
		public List<Include_stmtContext> include_stmt() {
			return getRuleContexts(Include_stmtContext.class);
		}
		public Include_stmtContext include_stmt(int i) {
			return getRuleContext(Include_stmtContext.class,i);
		}
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				include_stmt();
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==HASH );
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				declare();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << DOUBLE) | (1L << BOOL) | (1L << VOID) | (1L << CONST) | (1L << ID))) != 0) );
			setState(96);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclareContext extends ParserRuleContext {
		public Var_declareContext var_declare() {
			return getRuleContext(Var_declareContext.class,0);
		}
		public Func_declareContext func_declare() {
			return getRuleContext(Func_declareContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitDeclare(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(98);
				var_declare();
				}
				break;
			case 2:
				{
				setState(99);
				func_declare();
				}
				break;
			case 3:
				{
				setState(100);
				assign_stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Include_stmtContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(cosimParser.HASH, 0); }
		public TerminalNode INCLUDE() { return getToken(cosimParser.INCLUDE, 0); }
		public TerminalNode LT() { return getToken(cosimParser.LT, 0); }
		public TerminalNode GT() { return getToken(cosimParser.GT, 0); }
		public TerminalNode MATH() { return getToken(cosimParser.MATH, 0); }
		public TerminalNode STDIO() { return getToken(cosimParser.STDIO, 0); }
		public TerminalNode STDBOOL() { return getToken(cosimParser.STDBOOL, 0); }
		public Include_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterInclude_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitInclude_stmt(this);
		}
	}

	public final Include_stmtContext include_stmt() throws RecognitionException {
		Include_stmtContext _localctx = new Include_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_include_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(HASH);
			setState(104);
			match(INCLUDE);
			setState(105);
			match(LT);
			setState(106);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STDIO) | (1L << MATH) | (1L << STDBOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(107);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declareContext extends ParserRuleContext {
		public List<Ids_list_with_typeContext> ids_list_with_type() {
			return getRuleContexts(Ids_list_with_typeContext.class);
		}
		public Ids_list_with_typeContext ids_list_with_type(int i) {
			return getRuleContext(Ids_list_with_typeContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(cosimParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(cosimParser.SEMI, i);
		}
		public Var_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterVar_declare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitVar_declare(this);
		}
	}

	public final Var_declareContext var_declare() throws RecognitionException {
		Var_declareContext _localctx = new Var_declareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_declare);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(109);
					ids_list_with_type();
					setState(110);
					match(SEMI);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(114); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declareContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cosimParser.ID, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Data_typesContext data_types() {
			return getRuleContext(Data_typesContext.class,0);
		}
		public TerminalNode VOID() { return getToken(cosimParser.VOID, 0); }
		public Params_listContext params_list() {
			return getRuleContext(Params_listContext.class,0);
		}
		public Func_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterFunc_declare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitFunc_declare(this);
		}
	}

	public final Func_declareContext func_declare() throws RecognitionException {
		Func_declareContext _localctx = new Func_declareContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case STRING:
			case DOUBLE:
			case BOOL:
				{
				setState(116);
				data_types();
				}
				break;
			case VOID:
				{
				setState(117);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(120);
			match(ID);
			setState(121);
			match(LP);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << DOUBLE) | (1L << BOOL))) != 0)) {
				{
				setState(122);
				params_list();
				}
			}

			setState(125);
			match(RP);
			setState(126);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Brk_stmtContext brk_stmt() {
			return getRuleContext(Brk_stmtContext.class,0);
		}
		public Cont_stmtContext cont_stmt() {
			return getRuleContext(Cont_stmtContext.class,0);
		}
		public Ret_stmt_funcContext ret_stmt_func() {
			return getRuleContext(Ret_stmt_funcContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Call_stmtContext call_stmt() {
			return getRuleContext(Call_stmtContext.class,0);
		}
		public Ret_void_funcContext ret_void_func() {
			return getRuleContext(Ret_void_funcContext.class,0);
		}
		public Printf_stmtContext printf_stmt() {
			return getRuleContext(Printf_stmtContext.class,0);
		}
		public Scanf_stmtContext scanf_stmt() {
			return getRuleContext(Scanf_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmt);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				while_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				for_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				brk_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				cont_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				ret_stmt_func();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				assign_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(136);
				call_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(137);
				ret_void_func();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(138);
				printf_stmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(139);
				scanf_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public Assign_bodyContext assign_body() {
			return getRuleContext(Assign_bodyContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			assign_body();
			setState(143);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_bodyContext extends ParserRuleContext {
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(cosimParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Assign_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterAssign_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitAssign_body(this);
		}
	}

	public final Assign_bodyContext assign_body() throws RecognitionException {
		Assign_bodyContext _localctx = new Assign_bodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assign_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			assign_lhs();
			setState(146);
			match(ASSIGN);
			setState(147);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_lhsContext extends ParserRuleContext {
		public Ids_listContext ids_list() {
			return getRuleContext(Ids_listContext.class,0);
		}
		public Ids_list_with_typeContext ids_list_with_type() {
			return getRuleContext(Ids_list_with_typeContext.class,0);
		}
		public TerminalNode CONST() { return getToken(cosimParser.CONST, 0); }
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterAssign_lhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitAssign_lhs(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign_lhs);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				ids_list();
				}
				break;
			case INT:
			case STRING:
			case DOUBLE:
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				ids_list_with_type();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(CONST);
				setState(152);
				ids_list_with_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(cosimParser.IF, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public Exp_boolContext exp_bool() {
			return getRuleContext(Exp_boolContext.class,0);
		}
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public List<Compound_stmtContext> compound_stmt() {
			return getRuleContexts(Compound_stmtContext.class);
		}
		public Compound_stmtContext compound_stmt(int i) {
			return getRuleContext(Compound_stmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(cosimParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(IF);
			setState(156);
			match(LP);
			setState(157);
			exp_bool();
			setState(158);
			match(RP);
			setState(159);
			compound_stmt();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(160);
				match(ELSE);
				setState(161);
				compound_stmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(cosimParser.WHILE, 0); }
		public Exp_boolContext exp_bool() {
			return getRuleContext(Exp_boolContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(WHILE);
			setState(165);
			exp_bool();
			setState(166);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(cosimParser.FOR, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public Assign_bodyContext assign_body() {
			return getRuleContext(Assign_bodyContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(cosimParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(cosimParser.SEMI, i);
		}
		public List<TerminalNode> ID() { return getTokens(cosimParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(cosimParser.ID, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public TerminalNode EQ() { return getToken(cosimParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(cosimParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(cosimParser.GT, 0); }
		public TerminalNode LT() { return getToken(cosimParser.LT, 0); }
		public TerminalNode GTE() { return getToken(cosimParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(cosimParser.LTE, 0); }
		public TerminalNode SUB_SELF() { return getToken(cosimParser.SUB_SELF, 0); }
		public TerminalNode ADD_SELF() { return getToken(cosimParser.ADD_SELF, 0); }
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(FOR);
			setState(169);
			match(LP);
			setState(170);
			assign_body();
			setState(171);
			match(SEMI);
			setState(172);
			match(ID);
			setState(173);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LTE) | (1L << GTE) | (1L << NEQ) | (1L << LT) | (1L << GT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(174);
			exp(0);
			setState(175);
			match(SEMI);
			setState(176);
			match(ID);
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==ADD_SELF || _la==SUB_SELF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(178);
			match(RP);
			setState(179);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Brk_stmtContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(cosimParser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Brk_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brk_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterBrk_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitBrk_stmt(this);
		}
	}

	public final Brk_stmtContext brk_stmt() throws RecognitionException {
		Brk_stmtContext _localctx = new Brk_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_brk_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(BREAK);
			setState(182);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cont_stmtContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(cosimParser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Cont_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cont_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterCont_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitCont_stmt(this);
		}
	}

	public final Cont_stmtContext cont_stmt() throws RecognitionException {
		Cont_stmtContext _localctx = new Cont_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cont_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(CONTINUE);
			setState(185);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ret_stmt_funcContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(cosimParser.RETURN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Ret_stmt_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret_stmt_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterRet_stmt_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitRet_stmt_func(this);
		}
	}

	public final Ret_stmt_funcContext ret_stmt_func() throws RecognitionException {
		Ret_stmt_funcContext _localctx = new Ret_stmt_funcContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ret_stmt_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(RETURN);
			setState(188);
			exp(0);
			setState(189);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ret_void_funcContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(cosimParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Ret_void_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret_void_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterRet_void_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitRet_void_func(this);
		}
	}

	public final Ret_void_funcContext ret_void_func() throws RecognitionException {
		Ret_void_funcContext _localctx = new Ret_void_funcContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ret_void_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(RETURN);
			setState(192);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_stmtContext extends ParserRuleContext {
		public Call_expContext call_exp() {
			return getRuleContext(Call_expContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public Call_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterCall_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitCall_stmt(this);
		}
	}

	public final Call_stmtContext call_stmt() throws RecognitionException {
		Call_stmtContext _localctx = new Call_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_call_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			call_exp();
			setState(195);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public TerminalNode LCB() { return getToken(cosimParser.LCB, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public TerminalNode RCB() { return getToken(cosimParser.RCB, 0); }
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compound_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LCB);
			setState(198);
			stmt_list();
			setState(199);
			match(RCB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Printf_stmtContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(cosimParser.PRINTF, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(cosimParser.STRING_LITERAL, 0); }
		public TerminalNode COMMA() { return getToken(cosimParser.COMMA, 0); }
		public Exps_listContext exps_list() {
			return getRuleContext(Exps_listContext.class,0);
		}
		public Printf_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printf_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterPrintf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitPrintf_stmt(this);
		}
	}

	public final Printf_stmtContext printf_stmt() throws RecognitionException {
		Printf_stmtContext _localctx = new Printf_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_printf_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(PRINTF);
			setState(202);
			match(LP);
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(203);
				match(STRING_LITERAL);
				setState(204);
				match(COMMA);
				setState(205);
				exps_list();
				}
				break;
			case 2:
				{
				setState(206);
				match(STRING_LITERAL);
				}
				break;
			}
			setState(209);
			match(RP);
			setState(210);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scanf_stmtContext extends ParserRuleContext {
		public TerminalNode SCANF() { return getToken(cosimParser.SCANF, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(cosimParser.STRING_LITERAL, 0); }
		public List<TerminalNode> COMMA() { return getTokens(cosimParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cosimParser.COMMA, i);
		}
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public TerminalNode SEMI() { return getToken(cosimParser.SEMI, 0); }
		public List<TerminalNode> ID() { return getTokens(cosimParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(cosimParser.ID, i);
		}
		public Scanf_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scanf_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterScanf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitScanf_stmt(this);
		}
	}

	public final Scanf_stmtContext scanf_stmt() throws RecognitionException {
		Scanf_stmtContext _localctx = new Scanf_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_scanf_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(SCANF);
			setState(213);
			match(LP);
			setState(214);
			match(STRING_LITERAL);
			setState(215);
			match(COMMA);
			{
			setState(216);
			match(T__0);
			setState(217);
			match(ID);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(219);
				match(COMMA);
				setState(220);
				match(T__0);
				setState(221);
				match(ID);
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			match(RP);
			setState(228);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_listContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitStmt_list(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(230);
				stmt();
				}
				}
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << INT) | (1L << STRING) | (1L << DOUBLE) | (1L << BOOL) | (1L << CONST) | (1L << LCB) | (1L << PRINTF) | (1L << SCANF) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_boolContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Exp_boolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp_bool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp_bool(this);
		}
	}

	public final Exp_boolContext exp_bool() throws RecognitionException {
		Exp_boolContext _localctx = new Exp_boolContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exp_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_intContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Exp_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp_int(this);
		}
	}

	public final Exp_intContext exp_int() throws RecognitionException {
		Exp_intContext _localctx = new Exp_intContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exp_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_realContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Exp_realContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp_real(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp_real(this);
		}
	}

	public final Exp_realContext exp_real() throws RecognitionException {
		Exp_realContext _localctx = new Exp_realContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exp_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_strContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Exp_strContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp_str(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp_str(this);
		}
	}

	public final Exp_strContext exp_str() throws RecognitionException {
		Exp_strContext _localctx = new Exp_strContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exp_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode AND() { return getToken(cosimParser.AND, 0); }
		public TerminalNode OR() { return getToken(cosimParser.OR, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(244);
			exp1();
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp);
					setState(246);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(247);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(248);
					exp1();
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp1Context extends ParserRuleContext {
		public List<Exp2Context> exp2() {
			return getRuleContexts(Exp2Context.class);
		}
		public Exp2Context exp2(int i) {
			return getRuleContext(Exp2Context.class,i);
		}
		public TerminalNode EQ() { return getToken(cosimParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(cosimParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(cosimParser.GT, 0); }
		public TerminalNode LT() { return getToken(cosimParser.LT, 0); }
		public TerminalNode GTE() { return getToken(cosimParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(cosimParser.LTE, 0); }
		public Exp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp1(this);
		}
	}

	public final Exp1Context exp1() throws RecognitionException {
		Exp1Context _localctx = new Exp1Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_exp1);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				exp2(0);
				setState(255);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << LTE) | (1L << GTE) | (1L << NEQ) | (1L << LT) | (1L << GT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(256);
				exp2(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				exp2(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp2Context extends ParserRuleContext {
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public TerminalNode ADD() { return getToken(cosimParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(cosimParser.SUB, 0); }
		public TerminalNode OR() { return getToken(cosimParser.OR, 0); }
		public Exp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp2(this);
		}
	}

	public final Exp2Context exp2() throws RecognitionException {
		return exp2(0);
	}

	private Exp2Context exp2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp2Context _localctx = new Exp2Context(_ctx, _parentState);
		Exp2Context _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_exp2, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			exp3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp2);
					setState(264);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(265);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << ADD) | (1L << SUB))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(266);
					exp3(0);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp3Context extends ParserRuleContext {
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public TerminalNode DIV() { return getToken(cosimParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(cosimParser.MUL, 0); }
		public TerminalNode AND() { return getToken(cosimParser.AND, 0); }
		public TerminalNode MOD() { return getToken(cosimParser.MOD, 0); }
		public Exp3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp3(this);
		}
	}

	public final Exp3Context exp3() throws RecognitionException {
		return exp3(0);
	}

	private Exp3Context exp3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp3Context _localctx = new Exp3Context(_ctx, _parentState);
		Exp3Context _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_exp3, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(273);
			exp4();
			}
			_ctx.stop = _input.LT(-1);
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp3Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exp3);
					setState(275);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(276);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(277);
					exp4();
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp4Context extends ParserRuleContext {
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public TerminalNode NOT() { return getToken(cosimParser.NOT, 0); }
		public TerminalNode SUB() { return getToken(cosimParser.SUB, 0); }
		public OperandsContext operands() {
			return getRuleContext(OperandsContext.class,0);
		}
		public Exp4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExp4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExp4(this);
		}
	}

	public final Exp4Context exp4() throws RecognitionException {
		Exp4Context _localctx = new Exp4Context(_ctx, getState());
		enterRule(_localctx, 58, RULE_exp4);
		int _la;
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(283);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(284);
				exp4();
				}
				break;
			case TRUE:
			case FALSE:
			case LP:
			case STRING_LITERAL:
			case REAL_LITERAL:
			case INTEGER_LITERAL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				operands();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandsContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(cosimParser.ID, 0); }
		public Call_expContext call_exp() {
			return getRuleContext(Call_expContext.class,0);
		}
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public Call_stmtContext call_stmt() {
			return getRuleContext(Call_stmtContext.class,0);
		}
		public OperandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterOperands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitOperands(this);
		}
	}

	public final OperandsContext operands() throws RecognitionException {
		OperandsContext _localctx = new OperandsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_operands);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				call_exp();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				match(LP);
				setState(292);
				exp(0);
				setState(293);
				match(RP);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(295);
				call_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primary_expContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(cosimParser.ID, 0); }
		public Primary_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterPrimary_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitPrimary_exp(this);
		}
	}

	public final Primary_expContext primary_exp() throws RecognitionException {
		Primary_expContext _localctx = new Primary_expContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary_exp);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case STRING_LITERAL:
			case REAL_LITERAL:
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				literal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_expContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(cosimParser.ID, 0); }
		public TerminalNode LP() { return getToken(cosimParser.LP, 0); }
		public TerminalNode RP() { return getToken(cosimParser.RP, 0); }
		public Exps_listContext exps_list() {
			return getRuleContext(Exps_listContext.class,0);
		}
		public Call_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterCall_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitCall_exp(this);
		}
	}

	public final Call_expContext call_exp() throws RecognitionException {
		Call_expContext _localctx = new Call_expContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_call_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(ID);
			setState(303);
			match(LP);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << SUB) | (1L << LP) | (1L << STRING_LITERAL) | (1L << REAL_LITERAL) | (1L << INTEGER_LITERAL) | (1L << ID))) != 0)) {
				{
				setState(304);
				exps_list();
				}
			}

			setState(307);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Params_listContext extends ParserRuleContext {
		public List<Ids_list_with_typeContext> ids_list_with_type() {
			return getRuleContexts(Ids_list_with_typeContext.class);
		}
		public Ids_list_with_typeContext ids_list_with_type(int i) {
			return getRuleContext(Ids_list_with_typeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(cosimParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cosimParser.COMMA, i);
		}
		public Params_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterParams_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitParams_list(this);
		}
	}

	public final Params_listContext params_list() throws RecognitionException {
		Params_listContext _localctx = new Params_listContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_params_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			ids_list_with_type();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(310);
				match(COMMA);
				setState(311);
				ids_list_with_type();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ids_list_with_typeContext extends ParserRuleContext {
		public Data_typesContext data_types() {
			return getRuleContext(Data_typesContext.class,0);
		}
		public Ids_listContext ids_list() {
			return getRuleContext(Ids_listContext.class,0);
		}
		public Ids_list_with_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids_list_with_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterIds_list_with_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitIds_list_with_type(this);
		}
	}

	public final Ids_list_with_typeContext ids_list_with_type() throws RecognitionException {
		Ids_list_with_typeContext _localctx = new Ids_list_with_typeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ids_list_with_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			data_types();
			setState(318);
			ids_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ids_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(cosimParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(cosimParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(cosimParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cosimParser.COMMA, i);
		}
		public Ids_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ids_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterIds_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitIds_list(this);
		}
	}

	public final Ids_listContext ids_list() throws RecognitionException {
		Ids_listContext _localctx = new Ids_listContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ids_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(ID);
			setState(325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(321);
					match(COMMA);
					setState(322);
					match(ID);
					}
					} 
				}
				setState(327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exps_listContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(cosimParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cosimParser.COMMA, i);
		}
		public Exps_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exps_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterExps_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitExps_list(this);
		}
	}

	public final Exps_listContext exps_list() throws RecognitionException {
		Exps_listContext _localctx = new Exps_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_exps_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			exp(0);
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(329);
				match(COMMA);
				setState(330);
				exp(0);
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_typesContext extends ParserRuleContext {
		public Primitive_typesContext primitive_types() {
			return getRuleContext(Primitive_typesContext.class,0);
		}
		public Compound_typesContext compound_types() {
			return getRuleContext(Compound_typesContext.class,0);
		}
		public Data_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterData_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitData_types(this);
		}
	}

	public final Data_typesContext data_types() throws RecognitionException {
		Data_typesContext _localctx = new Data_typesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_data_types);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				primitive_types();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				compound_types();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_typesContext extends ParserRuleContext {
		public Primitive_typesContext primitive_types() {
			return getRuleContext(Primitive_typesContext.class,0);
		}
		public TerminalNode LSB() { return getToken(cosimParser.LSB, 0); }
		public TerminalNode INTEGER_LITERAL() { return getToken(cosimParser.INTEGER_LITERAL, 0); }
		public TerminalNode RSB() { return getToken(cosimParser.RSB, 0); }
		public Compound_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterCompound_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitCompound_types(this);
		}
	}

	public final Compound_typesContext compound_types() throws RecognitionException {
		Compound_typesContext _localctx = new Compound_typesContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_compound_types);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			primitive_types();
			setState(341);
			match(LSB);
			setState(342);
			match(INTEGER_LITERAL);
			setState(343);
			match(RSB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_typesContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(cosimParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(cosimParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(cosimParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(cosimParser.BOOL, 0); }
		public Primitive_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterPrimitive_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitPrimitive_types(this);
		}
	}

	public final Primitive_typesContext primitive_types() throws RecognitionException {
		Primitive_typesContext _localctx = new Primitive_typesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primitive_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << STRING) | (1L << DOUBLE) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(cosimParser.INTEGER_LITERAL, 0); }
		public TerminalNode REAL_LITERAL() { return getToken(cosimParser.REAL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(cosimParser.STRING_LITERAL, 0); }
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_literal);
		try {
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(INTEGER_LITERAL);
				}
				break;
			case REAL_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				match(REAL_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				match(STRING_LITERAL);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				boolean_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(cosimParser.INTEGER_LITERAL, 0); }
		public TerminalNode SUB() { return getToken(cosimParser.SUB, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(353);
				match(SUB);
				}
			}

			setState(356);
			match(INTEGER_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(cosimParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(cosimParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof cosimListener ) ((cosimListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 27:
			return exp2_sempred((Exp2Context)_localctx, predIndex);
		case 28:
			return exp3_sempred((Exp3Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp2_sempred(Exp2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp3_sempred(Exp3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u016b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\6\2Z\n\2\r\2\16\2[\3\2\6\2_\n\2\r\2\16\2`\3\2\3\2\3\3\3\3\3\3"+
		"\5\3h\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\6\5s\n\5\r\5\16\5t\3\6\3"+
		"\6\5\6y\n\6\3\6\3\6\3\6\5\6~\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7\u008f\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\5\n\u009c\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5"+
		"\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u00d2\n\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u00e1\n\25\f\25\16\25\u00e4\13\25\3\25\3\25\3\25\3\26\6\26"+
		"\u00ea\n\26\r\26\16\26\u00eb\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\7\33\u00fc\n\33\f\33\16\33\u00ff\13\33\3"+
		"\34\3\34\3\34\3\34\3\34\5\34\u0106\n\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u010e\n\35\f\35\16\35\u0111\13\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\7\36\u0119\n\36\f\36\16\36\u011c\13\36\3\37\3\37\3\37\5\37\u0121\n\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u012b\n \3!\3!\5!\u012f\n!\3\"\3\"\3\"\5\""+
		"\u0134\n\"\3\"\3\"\3#\3#\3#\7#\u013b\n#\f#\16#\u013e\13#\3$\3$\3$\3%\3"+
		"%\3%\7%\u0146\n%\f%\16%\u0149\13%\3&\3&\3&\7&\u014e\n&\f&\16&\u0151\13"+
		"&\3\'\3\'\5\'\u0155\n\'\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3*\5*\u0162\n*\3"+
		"+\5+\u0165\n+\3+\3+\3,\3,\3,\2\5\648:-\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\13\3\2\5\7\3\2#(\3\2\33"+
		"\34\3\2\31\32\4\2\32\32\35\36\4\2\31\31\37!\4\2\30\30\36\36\3\2\21\24"+
		"\3\2\b\t\2\u016a\2Y\3\2\2\2\4g\3\2\2\2\6i\3\2\2\2\br\3\2\2\2\nx\3\2\2"+
		"\2\f\u008e\3\2\2\2\16\u0090\3\2\2\2\20\u0093\3\2\2\2\22\u009b\3\2\2\2"+
		"\24\u009d\3\2\2\2\26\u00a6\3\2\2\2\30\u00aa\3\2\2\2\32\u00b7\3\2\2\2\34"+
		"\u00ba\3\2\2\2\36\u00bd\3\2\2\2 \u00c1\3\2\2\2\"\u00c4\3\2\2\2$\u00c7"+
		"\3\2\2\2&\u00cb\3\2\2\2(\u00d6\3\2\2\2*\u00e9\3\2\2\2,\u00ed\3\2\2\2."+
		"\u00ef\3\2\2\2\60\u00f1\3\2\2\2\62\u00f3\3\2\2\2\64\u00f5\3\2\2\2\66\u0105"+
		"\3\2\2\28\u0107\3\2\2\2:\u0112\3\2\2\2<\u0120\3\2\2\2>\u012a\3\2\2\2@"+
		"\u012e\3\2\2\2B\u0130\3\2\2\2D\u0137\3\2\2\2F\u013f\3\2\2\2H\u0142\3\2"+
		"\2\2J\u014a\3\2\2\2L\u0154\3\2\2\2N\u0156\3\2\2\2P\u015b\3\2\2\2R\u0161"+
		"\3\2\2\2T\u0164\3\2\2\2V\u0168\3\2\2\2XZ\5\6\4\2YX\3\2\2\2Z[\3\2\2\2["+
		"Y\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]_\5\4\3\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2"+
		"\2`a\3\2\2\2ab\3\2\2\2bc\7\2\2\3c\3\3\2\2\2dh\5\b\5\2eh\5\n\6\2fh\5\16"+
		"\b\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2h\5\3\2\2\2ij\7/\2\2jk\7\4\2\2kl\7\'"+
		"\2\2lm\t\2\2\2mn\7(\2\2n\7\3\2\2\2op\5F$\2pq\7\60\2\2qs\3\2\2\2ro\3\2"+
		"\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\t\3\2\2\2vy\5L\'\2wy\7\25\2\2xv\3"+
		"\2\2\2xw\3\2\2\2yz\3\2\2\2z{\79\2\2{}\7)\2\2|~\5D#\2}|\3\2\2\2}~\3\2\2"+
		"\2~\177\3\2\2\2\177\u0080\7*\2\2\u0080\u0081\5$\23\2\u0081\13\3\2\2\2"+
		"\u0082\u008f\5$\23\2\u0083\u008f\5\24\13\2\u0084\u008f\5\26\f\2\u0085"+
		"\u008f\5\30\r\2\u0086\u008f\5\32\16\2\u0087\u008f\5\34\17\2\u0088\u008f"+
		"\5\36\20\2\u0089\u008f\5\16\b\2\u008a\u008f\5\"\22\2\u008b\u008f\5 \21"+
		"\2\u008c\u008f\5&\24\2\u008d\u008f\5(\25\2\u008e\u0082\3\2\2\2\u008e\u0083"+
		"\3\2\2\2\u008e\u0084\3\2\2\2\u008e\u0085\3\2\2\2\u008e\u0086\3\2\2\2\u008e"+
		"\u0087\3\2\2\2\u008e\u0088\3\2\2\2\u008e\u0089\3\2\2\2\u008e\u008a\3\2"+
		"\2\2\u008e\u008b\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\r\3\2\2\2\u0090\u0091\5\20\t\2\u0091\u0092\7\60\2\2\u0092\17\3\2\2\2"+
		"\u0093\u0094\5\22\n\2\u0094\u0095\7\"\2\2\u0095\u0096\5\64\33\2\u0096"+
		"\21\3\2\2\2\u0097\u009c\5H%\2\u0098\u009c\5F$\2\u0099\u009a\7\27\2\2\u009a"+
		"\u009c\5F$\2\u009b\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2\2"+
		"\2\u009c\23\3\2\2\2\u009d\u009e\7\n\2\2\u009e\u009f\7)\2\2\u009f\u00a0"+
		"\5,\27\2\u00a0\u00a1\7*\2\2\u00a1\u00a4\5$\23\2\u00a2\u00a3\7\13\2\2\u00a3"+
		"\u00a5\5$\23\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\25\3\2\2"+
		"\2\u00a6\u00a7\7\r\2\2\u00a7\u00a8\5,\27\2\u00a8\u00a9\5$\23\2\u00a9\27"+
		"\3\2\2\2\u00aa\u00ab\7\f\2\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\5\20\t\2\u00ad"+
		"\u00ae\7\60\2\2\u00ae\u00af\79\2\2\u00af\u00b0\t\3\2\2\u00b0\u00b1\5\64"+
		"\33\2\u00b1\u00b2\7\60\2\2\u00b2\u00b3\79\2\2\u00b3\u00b4\t\4\2\2\u00b4"+
		"\u00b5\7*\2\2\u00b5\u00b6\5$\23\2\u00b6\31\3\2\2\2\u00b7\u00b8\7\17\2"+
		"\2\u00b8\u00b9\7\60\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\7\20\2\2\u00bb\u00bc"+
		"\7\60\2\2\u00bc\35\3\2\2\2\u00bd\u00be\7\16\2\2\u00be\u00bf\5\64\33\2"+
		"\u00bf\u00c0\7\60\2\2\u00c0\37\3\2\2\2\u00c1\u00c2\7\16\2\2\u00c2\u00c3"+
		"\7\60\2\2\u00c3!\3\2\2\2\u00c4\u00c5\5B\"\2\u00c5\u00c6\7\60\2\2\u00c6"+
		"#\3\2\2\2\u00c7\u00c8\7+\2\2\u00c8\u00c9\5*\26\2\u00c9\u00ca\7,\2\2\u00ca"+
		"%\3\2\2\2\u00cb\u00cc\7\64\2\2\u00cc\u00d1\7)\2\2\u00cd\u00ce\7\66\2\2"+
		"\u00ce\u00cf\7\61\2\2\u00cf\u00d2\5J&\2\u00d0\u00d2\7\66\2\2\u00d1\u00cd"+
		"\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\7*\2\2\u00d4"+
		"\u00d5\7\60\2\2\u00d5\'\3\2\2\2\u00d6\u00d7\7\65\2\2\u00d7\u00d8\7)\2"+
		"\2\u00d8\u00d9\7\66\2\2\u00d9\u00da\7\61\2\2\u00da\u00db\7\3\2\2\u00db"+
		"\u00dc\79\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00de\7\61\2\2\u00de\u00df\7\3"+
		"\2\2\u00df\u00e1\79\2\2\u00e0\u00dd\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e5\u00e6\7*\2\2\u00e6\u00e7\7\60\2\2\u00e7)\3\2\2\2\u00e8\u00ea"+
		"\5\f\7\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec+\3\2\2\2\u00ed\u00ee\5\64\33\2\u00ee-\3\2\2\2\u00ef"+
		"\u00f0\5\64\33\2\u00f0/\3\2\2\2\u00f1\u00f2\5\64\33\2\u00f2\61\3\2\2\2"+
		"\u00f3\u00f4\5\64\33\2\u00f4\63\3\2\2\2\u00f5\u00f6\b\33\1\2\u00f6\u00f7"+
		"\5\66\34\2\u00f7\u00fd\3\2\2\2\u00f8\u00f9\f\4\2\2\u00f9\u00fa\t\5\2\2"+
		"\u00fa\u00fc\5\66\34\2\u00fb\u00f8\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\65\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0101\58\35\2\u0101\u0102\t\3\2\2\u0102\u0103\58\35\2\u0103\u0106\3\2"+
		"\2\2\u0104\u0106\58\35\2\u0105\u0100\3\2\2\2\u0105\u0104\3\2\2\2\u0106"+
		"\67\3\2\2\2\u0107\u0108\b\35\1\2\u0108\u0109\5:\36\2\u0109\u010f\3\2\2"+
		"\2\u010a\u010b\f\4\2\2\u010b\u010c\t\6\2\2\u010c\u010e\5:\36\2\u010d\u010a"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"9\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\b\36\1\2\u0113\u0114\5<\37\2"+
		"\u0114\u011a\3\2\2\2\u0115\u0116\f\4\2\2\u0116\u0117\t\7\2\2\u0117\u0119"+
		"\5<\37\2\u0118\u0115\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b;\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\t\b\2\2"+
		"\u011e\u0121\5<\37\2\u011f\u0121\5> \2\u0120\u011d\3\2\2\2\u0120\u011f"+
		"\3\2\2\2\u0121=\3\2\2\2\u0122\u012b\5R*\2\u0123\u012b\79\2\2\u0124\u012b"+
		"\5B\"\2\u0125\u0126\7)\2\2\u0126\u0127\5\64\33\2\u0127\u0128\7*\2\2\u0128"+
		"\u012b\3\2\2\2\u0129\u012b\5\"\22\2\u012a\u0122\3\2\2\2\u012a\u0123\3"+
		"\2\2\2\u012a\u0124\3\2\2\2\u012a\u0125\3\2\2\2\u012a\u0129\3\2\2\2\u012b"+
		"?\3\2\2\2\u012c\u012f\5R*\2\u012d\u012f\79\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012d\3\2\2\2\u012fA\3\2\2\2\u0130\u0131\79\2\2\u0131\u0133\7)\2\2\u0132"+
		"\u0134\5J&\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2\2"+
		"\2\u0135\u0136\7*\2\2\u0136C\3\2\2\2\u0137\u013c\5F$\2\u0138\u0139\7\61"+
		"\2\2\u0139\u013b\5F$\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013dE\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0140\5L\'\2\u0140\u0141\5H%\2\u0141G\3\2\2\2\u0142\u0147\79\2\2\u0143"+
		"\u0144\7\61\2\2\u0144\u0146\79\2\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148I\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u014a\u014f\5\64\33\2\u014b\u014c\7\61\2\2\u014c\u014e\5\64\33"+
		"\2\u014d\u014b\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150K\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0155\5P)\2\u0153\u0155"+
		"\5N(\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155M\3\2\2\2\u0156\u0157"+
		"\5P)\2\u0157\u0158\7-\2\2\u0158\u0159\78\2\2\u0159\u015a\7.\2\2\u015a"+
		"O\3\2\2\2\u015b\u015c\t\t\2\2\u015cQ\3\2\2\2\u015d\u0162\78\2\2\u015e"+
		"\u0162\7\67\2\2\u015f\u0162\7\66\2\2\u0160\u0162\5V,\2\u0161\u015d\3\2"+
		"\2\2\u0161\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162"+
		"S\3\2\2\2\u0163\u0165\7\36\2\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2\2"+
		"\u0165\u0166\3\2\2\2\u0166\u0167\78\2\2\u0167U\3\2\2\2\u0168\u0169\t\n"+
		"\2\2\u0169W\3\2\2\2\34[`gtx}\u008e\u009b\u00a4\u00d1\u00e2\u00eb\u00fd"+
		"\u0105\u010f\u011a\u0120\u012a\u012e\u0133\u013c\u0147\u014f\u0154\u0161"+
		"\u0164";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}