package Implementation;

import Interface.Task;

import static java.lang.Math.*;

public class LongTask implements Task {

    private long input;
    private long result;

    public LongTask(Long input) {
        this.input = input;
    }

    @Override
    public void execute() {
        result = round(PI*input);
    }

    @Override
    public Object getResult() {
        return result;
    }
}
