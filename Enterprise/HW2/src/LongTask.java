import java.util.Objects;

import static java.lang.Math.*;

class LongTask implements Task {

    private long input;
    private long result;

    LongTask(Long input) {
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
