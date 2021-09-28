import java.util.*

class Parser {
    fun parseIntOrError(num: String): Int {
        try {
            return Integer.parseInt(num)
        } catch (e: NumberFormatException) {
            throw NumberFormatException("Val is not int")
        }
    }

    fun parseOperatorOrError(operator: String): String {
        if ("+" == operator || "-" == operator || "*" == operator || "/" == operator) {
            return operator
        }
        throw InvalidPropertiesFormatException("Operator is not supported")
    }

    fun countOfArgumentsChecker(args: Array<String>) {
        if (args.size != 3) {
            throw InvalidPropertiesFormatException("Args format is: val1 +-/* val2")
        }
    }
}