import java.util.InvalidPropertiesFormatException;

public class Parser {
    static String parseOperatorOrError(String operator) throws InvalidPropertiesFormatException {
        if ("+".equals(operator) ||
                "-".equals(operator) ||
                "*".equals(operator) ||
                "/".equals(operator)
        ) {

            return operator;
        }
        throw new InvalidPropertiesFormatException("Operator is not supported");
    }

    static int parseIntOrError(String val) {
        try {
            return Integer.parseInt(val);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Val is not int");
        }
    }

    static void countOfArgumentsChecker(String[] args) throws InvalidPropertiesFormatException {
        if (args.length != 3) {
            throw new InvalidPropertiesFormatException("Args format is: val1 +-/* val2");
        }
    }
}