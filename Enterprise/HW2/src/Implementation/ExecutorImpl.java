package Implementation;

import Interface.Executor;
import Interface.Task;
import Interface.Validator;

import java.util.List;

public class ExecutorImpl<T> implements Executor<T> {

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
