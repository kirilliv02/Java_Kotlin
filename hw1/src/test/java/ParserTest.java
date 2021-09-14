import org.junit.Assert;
import org.junit.Test;

import java.util.InvalidPropertiesFormatException;

public class ParserTest {

    @Test
    public void parseOperatorTestPlus() throws InvalidPropertiesFormatException {
        String plus = Parser.parseOperatorOrError("+");
        Assert.assertEquals("+", plus);
    }

    @Test
    public void parseOperatorTestMinus() throws InvalidPropertiesFormatException {
        String minus = Parser.parseOperatorOrError("-");
        Assert.assertEquals("-", minus);
    }

    @Test
    public void parseOperatorTestMultiply() throws InvalidPropertiesFormatException {
        String multiply = Parser.parseOperatorOrError("*");
        Assert.assertEquals("*", multiply);
    }

    @Test
    public void parseOperatorTestDivide() throws InvalidPropertiesFormatException {
        String div = Parser.parseOperatorOrError("/");
        Assert.assertEquals("/", div);
    }


    @Test
    public void parseOperatorTestError() {
        Assert.assertThrows(InvalidPropertiesFormatException.class, () -> Parser.parseOperatorOrError("d"));
    }

    @Test
    public void parseIntTestSuccess() {
        int num = Parser.parseIntOrError("555");
        Assert.assertEquals(555, num);
    }

    @Test
    public void parseIntTestError() {
        Assert.assertThrows(NumberFormatException.class, () -> Parser.parseIntOrError("five"));
    }

    @Test
    public void countOfArgumentsCheckerTest() {
        Assert.assertThrows(InvalidPropertiesFormatException.class, () -> Parser.countOfArgumentsChecker(new String[4]));
    }
}
