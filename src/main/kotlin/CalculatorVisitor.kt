import CalculatorParser.AssignmentContext
import org.antlr.v4.runtime.tree.ParseTreeVisitor

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by [CalculatorParser].
 *
 * @param <T> The return type of the visit operation. Use [Void] for
 * operations with no return type.
</T> */
interface CalculatorVisitor<T> : ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by [CalculatorParser.parse].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitParse(ctx: CalculatorParser.ParseContext?): T

    /**
     * Visit a parse tree produced by [CalculatorParser.expression].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitExpression(ctx: CalculatorParser.ExpressionContext?): T

    /**
     * Visit a parse tree produced by [CalculatorParser.assignment].
     * @param ctx the parse tree
     * @return the visitor result
     */
    fun visitAssignment(ctx: AssignmentContext?): T
}