import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class ParserTest {

    private val parser = Parser()

    @Test
    fun parseOperatorTestPlus() {
        val plus: String = parser.parseOperatorOrError("+")
        Assertions.assertEquals("+", plus)
    }

    @Test
    fun parseOperatorTestMinus() {
        val minus: String = parser.parseOperatorOrError("-")
        Assertions.assertEquals("-", minus)
    }

    @Test
    fun parseOperatorTestMultiply() {
        val multiply: String = parser.parseOperatorOrError("*")
        Assertions.assertEquals("*", multiply)
    }

    @Test
    fun parseOperatorTestDivide() {
        val div: String = parser.parseOperatorOrError("/")
        Assertions.assertEquals("/", div)
    }


    @Test
    fun parseOperatorTestError() {
        Assertions.assertThrows(InvalidPropertiesFormatException::class.java) { parser.parseOperatorOrError("d") }
    }

    @Test
    fun parseIntTestSuccess() {
        val num: Int = parser.parseIntOrError("555")
        Assertions.assertEquals(555, num)
    }

    @Test
    fun parseIntTestError() {
        Assertions.assertThrows(NumberFormatException::class.java) { parser.parseIntOrError("five") }
    }

    @Test
    fun countOfArgumentsCheckerTest() {
        Assertions.assertThrows(InvalidPropertiesFormatException::class.java) {
            parser.countOfArgumentsChecker(arrayOf("5","7"))
        }
    }
}