
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


fun main(args: Array<String>) {
    val input: CharStream = CharStreams.fromStream(System.`in`)
    val lexer = CalculatorLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = CalculatorParser(tokens)
    val tree: ParseTree = parser.parse()

    val calcVisitor = CalculatorBaseVisitor()
    val result: List<Double> = calcVisitor.visit(tree)

    input.toString()
        .split(";")
        .dropLast(1)
        .forEachIndexed { i, s -> print("$s = ${result[i]}") }
}