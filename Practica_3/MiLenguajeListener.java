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
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link MiLenguajeParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(MiLenguajeParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link MiLenguajeParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(MiLenguajeParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#inicializacion}.
	 * @param ctx the parse tree
	 */
	void enterInicializacion(MiLenguajeParser.InicializacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#inicializacion}.
	 * @param ctx the parse tree
	 */
	void exitInicializacion(MiLenguajeParser.InicializacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(MiLenguajeParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(MiLenguajeParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#actualizacion}.
	 * @param ctx the parse tree
	 */
	void enterActualizacion(MiLenguajeParser.ActualizacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#actualizacion}.
	 * @param ctx the parse tree
	 */
	void exitActualizacion(MiLenguajeParser.ActualizacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(MiLenguajeParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(MiLenguajeParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(MiLenguajeParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(MiLenguajeParser.TerminoContext ctx);
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