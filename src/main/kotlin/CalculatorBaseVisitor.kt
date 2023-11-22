import CalculatorParser.AssignmentContext
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

/**
 * This class provides an empty implementation of [CalculatorVisitor],
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use [Void] for
 * operations with no return type.
</T> */
class CalculatorBaseVisitor : AbstractParseTreeVisitor<Double>(), CalculatorVisitor<Double> {
    override fun visitParse(ctx: CalculatorParser.ParseContext?): Double {
        TODO("Not yet implemented")
    }

    override fun visitExpression(ctx: CalculatorParser.ExpressionContext?): Double {
        TODO("Not yet implemented")
    }

    override fun visitAssignment(ctx: AssignmentContext?): Double {
        TODO("Not yet implemented")
    }
}