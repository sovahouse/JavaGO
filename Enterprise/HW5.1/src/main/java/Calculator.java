import operationInterface.*;


import static org.apache.commons.lang3.StringUtils.*;

class Calculator {


    public String calculate(String input) {

        if (isBlank(input)) {
            throw (new IllegalArgumentException("Empty string detected"));
        }

        ParsedNumber parsed = new ParsedNumber(input);

        parsed.parse();

        OperationProvider operationProvider = new OperationProvider(parsed);

        Operation operation = operationProvider.provide();

        return input + " = " + operation.execute();

    }

}
