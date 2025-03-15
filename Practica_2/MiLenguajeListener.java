// Generated from MiLenguaje.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiLenguajeParser}.
 */
public interface MiLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiLenguajeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiLenguajeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiLenguajeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiLenguajeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(MiLenguajeParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(MiLenguajeParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MiLenguajeParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MiLenguajeParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiLenguajeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiLenguajeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MiLenguajeParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MiLenguajeParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void enterRelationalOp(MiLenguajeParser.RelationalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#relationalOp}.
	 * @param ctx the parse tree
	 */
	void exitRelationalOp(MiLenguajeParser.RelationalOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiLenguajeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiLenguajeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MiLenguajeParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MiLenguajeParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiLenguajeParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiLenguajeParser.FactorContext ctx);
}