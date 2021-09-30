import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun calc_2Plus5_7Returned() {
        val res: Int = calculator.calculate(2, "+", 5)
        Assertions.assertEquals(7, res)
    }

    @Test
    fun calc_2Multiply5_10Returned() {
        val res: Int = calculator.calculate(2, "*", 5)
        Assertions.assertEquals(10, res)
    }

    @Test
    fun calc_7Minus5_2Returned() {
        val res: Int = calculator.calculate(7, "-", 5)
        Assertions.assertEquals(2, res)
    }

    @Test
    fun calc_6Divide3_2Returned() {
        val res: Int = calculator.calculate(6, "/", 3)
        Assertions.assertEquals(2, res)
    }

    @Test
    fun calc_default() {
        val res: Int = calculator.calculate(6, ":", 3)
        Assertions.assertEquals(0, res)
    }
}