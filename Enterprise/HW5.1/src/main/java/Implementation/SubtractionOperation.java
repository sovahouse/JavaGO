package Implementation;

import Interface.Operation;

public class SubtractionOperation implements Operation {

    private double firstOperand;
    private double secondOperand;

    public SubtractionOperation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return subtract().toString();
    }

    private Double subtract() {
        return firstOperand - secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }


}
