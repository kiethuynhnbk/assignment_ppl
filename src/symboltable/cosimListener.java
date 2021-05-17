// Generated from cosim.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link cosimParser}.
 */
public interface cosimListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link cosimParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(cosimParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(cosimParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(cosimParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(cosimParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#include_stmt}.
	 * @param ctx the parse tree
	 */
	void enterInclude_stmt(cosimParser.Include_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#include_stmt}.
	 * @param ctx the parse tree
	 */
	void exitInclude_stmt(cosimParser.Include_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#var_declare}.
	 * @param ctx the parse tree
	 */
	void enterVar_declare(cosimParser.Var_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#var_declare}.
	 * @param ctx the parse tree
	 */
	void exitVar_declare(cosimParser.Var_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#func_declare}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declare(cosimParser.Func_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#func_declare}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declare(cosimParser.Func_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(cosimParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(cosimParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(cosimParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(cosimParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#assign_body}.
	 * @param ctx the parse tree
	 */
	void enterAssign_body(cosimParser.Assign_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#assign_body}.
	 * @param ctx the parse tree
	 */
	void exitAssign_body(cosimParser.Assign_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#assign_lhs}.
	 * @param ctx the parse tree
	 */
	void enterAssign_lhs(cosimParser.Assign_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#assign_lhs}.
	 * @param ctx the parse tree
	 */
	void exitAssign_lhs(cosimParser.Assign_lhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(cosimParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(cosimParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(cosimParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(cosimParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(cosimParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(cosimParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#brk_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBrk_stmt(cosimParser.Brk_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#brk_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBrk_stmt(cosimParser.Brk_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#cont_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCont_stmt(cosimParser.Cont_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#cont_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCont_stmt(cosimParser.Cont_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#ret_stmt_func}.
	 * @param ctx the parse tree
	 */
	void enterRet_stmt_func(cosimParser.Ret_stmt_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#ret_stmt_func}.
	 * @param ctx the parse tree
	 */
	void exitRet_stmt_func(cosimParser.Ret_stmt_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#ret_void_func}.
	 * @param ctx the parse tree
	 */
	void enterRet_void_func(cosimParser.Ret_void_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#ret_void_func}.
	 * @param ctx the parse tree
	 */
	void exitRet_void_func(cosimParser.Ret_void_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#call_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCall_stmt(cosimParser.Call_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#call_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCall_stmt(cosimParser.Call_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(cosimParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(cosimParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#printf_stmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintf_stmt(cosimParser.Printf_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#printf_stmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintf_stmt(cosimParser.Printf_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#scanf_stmt}.
	 * @param ctx the parse tree
	 */
	void enterScanf_stmt(cosimParser.Scanf_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#scanf_stmt}.
	 * @param ctx the parse tree
	 */
	void exitScanf_stmt(cosimParser.Scanf_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(cosimParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(cosimParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp_bool}.
	 * @param ctx the parse tree
	 */
	void enterExp_bool(cosimParser.Exp_boolContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp_bool}.
	 * @param ctx the parse tree
	 */
	void exitExp_bool(cosimParser.Exp_boolContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp_int}.
	 * @param ctx the parse tree
	 */
	void enterExp_int(cosimParser.Exp_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp_int}.
	 * @param ctx the parse tree
	 */
	void exitExp_int(cosimParser.Exp_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp_real}.
	 * @param ctx the parse tree
	 */
	void enterExp_real(cosimParser.Exp_realContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp_real}.
	 * @param ctx the parse tree
	 */
	void exitExp_real(cosimParser.Exp_realContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp_str}.
	 * @param ctx the parse tree
	 */
	void enterExp_str(cosimParser.Exp_strContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp_str}.
	 * @param ctx the parse tree
	 */
	void exitExp_str(cosimParser.Exp_strContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(cosimParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(cosimParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp1}.
	 * @param ctx the parse tree
	 */
	void enterExp1(cosimParser.Exp1Context ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp1}.
	 * @param ctx the parse tree
	 */
	void exitExp1(cosimParser.Exp1Context ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp2}.
	 * @param ctx the parse tree
	 */
	void enterExp2(cosimParser.Exp2Context ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp2}.
	 * @param ctx the parse tree
	 */
	void exitExp2(cosimParser.Exp2Context ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp3}.
	 * @param ctx the parse tree
	 */
	void enterExp3(cosimParser.Exp3Context ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp3}.
	 * @param ctx the parse tree
	 */
	void exitExp3(cosimParser.Exp3Context ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exp4}.
	 * @param ctx the parse tree
	 */
	void enterExp4(cosimParser.Exp4Context ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exp4}.
	 * @param ctx the parse tree
	 */
	void exitExp4(cosimParser.Exp4Context ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#operands}.
	 * @param ctx the parse tree
	 */
	void enterOperands(cosimParser.OperandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#operands}.
	 * @param ctx the parse tree
	 */
	void exitOperands(cosimParser.OperandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#primary_exp}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_exp(cosimParser.Primary_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#primary_exp}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_exp(cosimParser.Primary_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#call_exp}.
	 * @param ctx the parse tree
	 */
	void enterCall_exp(cosimParser.Call_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#call_exp}.
	 * @param ctx the parse tree
	 */
	void exitCall_exp(cosimParser.Call_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#params_list}.
	 * @param ctx the parse tree
	 */
	void enterParams_list(cosimParser.Params_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#params_list}.
	 * @param ctx the parse tree
	 */
	void exitParams_list(cosimParser.Params_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#ids_list_with_type}.
	 * @param ctx the parse tree
	 */
	void enterIds_list_with_type(cosimParser.Ids_list_with_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#ids_list_with_type}.
	 * @param ctx the parse tree
	 */
	void exitIds_list_with_type(cosimParser.Ids_list_with_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#ids_list}.
	 * @param ctx the parse tree
	 */
	void enterIds_list(cosimParser.Ids_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#ids_list}.
	 * @param ctx the parse tree
	 */
	void exitIds_list(cosimParser.Ids_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#exps_list}.
	 * @param ctx the parse tree
	 */
	void enterExps_list(cosimParser.Exps_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#exps_list}.
	 * @param ctx the parse tree
	 */
	void exitExps_list(cosimParser.Exps_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#data_types}.
	 * @param ctx the parse tree
	 */
	void enterData_types(cosimParser.Data_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#data_types}.
	 * @param ctx the parse tree
	 */
	void exitData_types(cosimParser.Data_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#compound_types}.
	 * @param ctx the parse tree
	 */
	void enterCompound_types(cosimParser.Compound_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#compound_types}.
	 * @param ctx the parse tree
	 */
	void exitCompound_types(cosimParser.Compound_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#primitive_types}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_types(cosimParser.Primitive_typesContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#primitive_types}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_types(cosimParser.Primitive_typesContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(cosimParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(cosimParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(cosimParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(cosimParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link cosimParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(cosimParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link cosimParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(cosimParser.Boolean_literalContext ctx);
}