fun main(args: Array<String>) {
    val parser = Parser()
    parser.countOfArgumentsChecker(args)

    val val1 = parser.parseIntOrError(args[0])
    val val2 = parser.parseIntOrError(args[2])
    val operator = parser.parseOperatorOrError(args[1])

    val calculator = Calculator()
    val result = calculator.calculate(val1, operator, val2)

    println(result)
}