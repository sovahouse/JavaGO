import Interface.Operation;

public class Calculator {

    public String calculate(String input) {
        Parser parser = new Parser();
        String result;

        Operation operation = parser.parse(input);

        result = input + " = " + operation.execute();
        return result;

    }

}
