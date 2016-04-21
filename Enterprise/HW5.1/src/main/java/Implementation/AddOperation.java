package Implementation;

import Interface.Operation;

public class AddOperation implements Operation {

    private double firstOperand;
    private double secondOperand;

    public AddOperation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return add().toString();
    }

    private Double add() {
        return firstOperand + secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }
}
