import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.github.stefanbirkner.systemlambda.SystemLambda.*

class MainTest {

    @Test
    fun mainTest() {
        val output = tapSystemOut {
            main(arrayOf("2", "+", "5"))
        }
        Assertions.assertEquals("7", output.toString().trim())
    }

}