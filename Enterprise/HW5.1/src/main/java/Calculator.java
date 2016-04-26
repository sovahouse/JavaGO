import operationInterface.*;

class Calculator {

    String calculate(String input) {

        if (input.isEmpty()) {
            throw (new IllegalArgumentException("Empty string detected"));
        }

        ParseredNumber parsered = new ParseredNumber(input);

        OperationProvider operationProvider = new OperationProvider(parsered);

        Operation operation = operationProvider.provide();

        return input + " = " + operation.execute();

    }

}
