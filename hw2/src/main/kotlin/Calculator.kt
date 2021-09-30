class Calculator{
    fun calculate(val1: Int, operator: String, val2: Int): Int {
        return when (operator) {
            "+" -> val1 + val2
            "-" -> val1 - val2
            "*" -> val1 * val2
            "/" -> val1 / val2
            else -> 0
        }
    }
}