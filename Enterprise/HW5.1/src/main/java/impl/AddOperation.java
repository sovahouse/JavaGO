package impl;

import operationInterface.Operation;

public class AddOperation implements Operation {

    private double firstOperand;
    private double secondOperand;

    public AddOperation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return String.valueOf(add());
    }

    private double add() {
        return firstOperand + secondOperand;
    }

}
