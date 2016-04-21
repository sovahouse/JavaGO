package Implementation;

import Interface.Operation;

public class SubtractionOperation implements Operation {

    private Double firstOperand;
    private Double secondOperand;

    public SubtractionOperation(Double firstOperand, Double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return subtract().toString();
    }

    private Double subtract() {
        return firstOperand - secondOperand;
    }

    public Double getFirstOperand() {
        return firstOperand;
    }

    public Double getSecondOperand() {
        return secondOperand;
    }


}
