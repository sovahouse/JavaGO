import java.util.ArrayList;
import java.util.List;

class ExecutorImpl<T> implements Executor<T> {

    private List<T> validResults;
    private List<T> invalidResults;

    @Override
    public void addTask(Task<? extends T> task) {

    }

    @Override
    public void addTask(Task<? extends T> task, Validator<? super T> validator) {

    }

    @Override
    public void execute() {

    }

    @Override
    public List<T> getValidResults() throws IllegalStateException {
        return null;
    }

    @Override
    public List<T> getInvalidResults() throws IllegalStateException {
        return null;
    }
}
