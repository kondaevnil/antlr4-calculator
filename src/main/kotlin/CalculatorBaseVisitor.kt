import CalculatorParser.AssignmentContext
import CalculatorParser.StatementContext
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor

class CalculatorBaseVisitor : AbstractParseTreeVisitor<MutableList<Double>>(), CalculatorVisitor<MutableList<Double>> {
    private val variables: HashMap<String, Double> = hashMapOf()

    override fun visitParse(ctx: CalculatorParser.ParseContext?): MutableList<Double> {
        if (ctx == null) {
            return mutableListOf(0.0)
        }

        return ctx.statement()
            .map { stm -> visitStatement(stm) }
            .map { lst -> lst[0] }
            .toMutableList()
    }

    override fun visitStatement(ctx: StatementContext?): MutableList<Double> {
        if (ctx == null) {
            return mutableListOf(0.0)
        }

        if (ctx.assignment() != null) {
            return visitAssignment(ctx.assignment())
        } else if (ctx.expression() != null) {
            return visitExpression(ctx.expression())
        }

        return mutableListOf(0.0)
    }

    override fun visitExpression(ctx: CalculatorParser.ExpressionContext?): MutableList<Double> {
        if (ctx?.ID() != null) {
            val variableName = ctx.ID().text
            if (variables.containsKey(variableName)) {
                return mutableListOf(variables[variableName]!!)
            } else {
                throw RuntimeException("Variable $variableName is not defined")
            }
        } else if (ctx?.INT() != null) {
            return mutableListOf(ctx.INT().text.toDouble())
        } else if (ctx?.expression()?.size == 2) {
            val left = visitExpression(ctx.expression(0))[0]
            val right = visitExpression(ctx.expression(1))[0]
            return when (ctx.op.type) {
                CalculatorParser.ADD -> mutableListOf(left + right)
                CalculatorParser.SUB -> mutableListOf(left - right)
                CalculatorParser.MUL -> mutableListOf(left * right)
                CalculatorParser.DIV -> mutableListOf(left / right)
                else -> throw RuntimeException("Invalid operator")
            }
        } else {
            throw RuntimeException("Invalid expression")
        }

    }

    override fun visitAssignment(ctx: AssignmentContext?): MutableList<Double> {
        val varName = ctx?.ID()?.text
        val expressionResult = visitExpression(ctx?.expression())

        if (varName != null) {
            variables[varName] = expressionResult[0]
        }
        return expressionResult

    }
}