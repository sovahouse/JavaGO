import impl.AddOperation;
import impl.SubtractionOperation;
import operationInterface.Operation;

class OperationProvider {

    private ParsedNumber parsed;

    //TODO: add support for different parsers type

    OperationProvider (ParsedNumber parsed) {
        this.parsed = parsed;
    }

    Operation provide() {

        if(parsed.getOperator().equals("+")) {
            return new AddOperation(parsed.getFirstOperand(), parsed.getSecondOperand());
        } else if(parsed.getOperator().equals("-")) {
            return new SubtractionOperation(parsed.getFirstOperand(), parsed.getSecondOperand());
        } else {
            throw (new IllegalArgumentException("Unsupported operator detected!"));
        }

    }

}
