import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InvalidPropertiesFormatException;

public class MainTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void mainTest() throws InvalidPropertiesFormatException {
        Main.main(new String[]{"2", "+", "5"});
        Assert.assertEquals("Result is 7", output.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
