import operationInterface.*;
import parsedInterface.Parsed;

class Calculator {

    String calculate(String input) {

        if (input.isEmpty()) {
            throw (new IllegalArgumentException("Empty string detected"));
        }

        ParsedNumber parsed = new ParsedNumber();

        parsed.parse(input);

        OperationProvider operationProvider = new OperationProvider(parsed);

        Operation operation = operationProvider.provide();

        return input + " = " + operation.execute();

    }

}
