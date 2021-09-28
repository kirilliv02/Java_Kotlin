import java.util.InvalidPropertiesFormatException;

public class Main {
    public static void main(String[] args) throws InvalidPropertiesFormatException {
        Parser.countOfArgumentsChecker(args);

        var val1 = Parser.parseIntOrError(args[0]);
        var val2 = Parser.parseIntOrError(args[2]);
        var operator = Parser.parseOperatorOrError(args[1]);

        System.out.println("Result is " + Calculator.calculate(val1, operator, val2));
    }
}