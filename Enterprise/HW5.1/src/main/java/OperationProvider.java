import impl.AddOperation;
import impl.SubtractionOperation;
import operationInterface.Operation;

class OperationProvider {

    private ParseredNumber parsered;


    OperationProvider (ParseredNumber parsered) {
        this.parsered = parsered;
    }

    Operation provide() {

        if(parsered.getOperator().equals("+")) {
            return new AddOperation(parsered.getFirstOperand(), parsered.getSecondOperand());
        } else if(parsered.getOperator().equals("-")) {
            return new SubtractionOperation(parsered.getFirstOperand(), parsered.getSecondOperand());
        } else {
            throw (new IllegalArgumentException("Unsupported operator detected!"));
        }

    }

}
