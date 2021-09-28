import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void Sum_2Plus5_7Returned() {
        var res = Calculator.calculate(2, "+", 5);
        Assert.assertEquals(7, res);
    }

    @Test
    public void calc_2Multiply5_10Returned() {
        var res = Calculator.calculate(2, "*", 5);
        Assert.assertEquals(10, res);
    }

    @Test
    public void calc_7Minus5_2Returned() {
        var res = Calculator.calculate(7, "-", 5);
        Assert.assertEquals(2, res);
    }

    @Test
    public void calc_6Divide3_2Returned() {
        var res = Calculator.calculate(6, "/", 3);
        Assert.assertEquals(2, res);
    }

    @Test
    public void calc_default() {
        var res = Calculator.calculate(6, ":", 3);
        Assert.assertEquals(0, res);
    }
}
