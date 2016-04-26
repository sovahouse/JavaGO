import parsedInterface.Parsed;

class ParsedNumber implements Parsed {

    //private String input;

    private double firstOperand;
    private double secondOperand;
    private String operator;

    public void parse(String input) {

        String[] operands = input.trim().split(",");

        try {
            firstOperand = Double.parseDouble(operands[1]);
            secondOperand = Double.parseDouble(operands[2]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown number format");
        }

        operator = operands[0];


    }

    double getFirstOperand() {
        return firstOperand;
    }

    double getSecondOperand() {
        return secondOperand;
    }

    String getOperator() {
        return operator;
    }
}
