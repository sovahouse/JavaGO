package Implementation;

import Interface.Operation;

public class AddOperation implements Operation {

    private Double firstOperand;
    private Double secondOperand;

    public AddOperation(Double firstOperand, Double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public String execute() {
        return add().toString();
    }

    private Double add() {
        return firstOperand + secondOperand;
    }

    public Double getFirstOperand() {
        return firstOperand;
    }

    public Double getSecondOperand() {
        return secondOperand;
    }
}
