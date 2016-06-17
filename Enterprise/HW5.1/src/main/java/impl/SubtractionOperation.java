package impl;

import operationInterface.Operation;

public class SubtractionOperation implements Operation {

    private double firstOperand;
    private double secondOperand;

    public SubtractionOperation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return String.valueOf(subtract());
    }

    private double subtract() {
        return firstOperand - secondOperand;
    }



}
