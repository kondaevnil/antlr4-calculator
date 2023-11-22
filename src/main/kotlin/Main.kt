
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
    val result: Double = calcVisitor.visit(tree)
    println("Result: $result")
}