import Implementation.AddOperation;
import Implementation.SubtractionOperation;
import Interface.Operation;

public class Parser {

    public Operation parse(String input) {

        Operation operation = null;
        final int numberOfOperands = 2;

        Double[] operands = new Double[numberOfOperands];

        for (int i = 0, j = 0; i < input.length(); i++) {

            if(input.charAt(i) == ',') {
                i++;

                int endOfSubstring = input.indexOf(',', i);

                if( endOfSubstring == -1) {
                    endOfSubstring = input.length();
                }

                String stringToNumber = input.substring(i, endOfSubstring);
                operands[j] = Double.parseDouble(stringToNumber);

                j++;
            }

        }

        if(input.contains("+")) {
            operation = new AddOperation(operands[0], operands[1]);
        } else if(input.contains("-")) {
            operation = new SubtractionOperation(operands[0], operands[1]);
        }

        return operation;
    }

}
