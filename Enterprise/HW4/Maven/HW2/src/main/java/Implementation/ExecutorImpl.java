package Implementation;

import Interface.Executor;
import Interface.Task;
import Interface.Validator;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")

public class ExecutorImpl<T> implements Executor<T> {

    private class Entry<E> {

        Task<E> task;
        Validator<E> validator;

        Entry(Task<E> task, Validator<E> validator) {
            this.task = task;
            this.validator = validator;
        }
    }

    private List<T> validResults;
    private List<T> invalidResults;
    private List<Entry<T>> tasks = new ArrayList<>();

    private boolean wasExecuted = false;

    @Override
    public void addTask(Task task) {
        tasks.add(new Entry<>(task, null));
    }

    @Override
    public void addTask(Task task, Validator validator) {
        tasks.add(new Entry<>(task, validator));
    }

    @Override
    public void execute() {

        if (wasExecuted) return;
        wasExecuted = true;

        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();

        for (Entry<T> task: tasks) {

            if (task.validator == null) {

                task.task.execute();
                validResults.add(task.task.getResult());

            } else {

                task.task.execute();

                if (task.validator.isValid(task.task.getInput())) {
                    validResults.add(task.task.getResult());
                } else {
                    invalidResults.add(task.task.getResult());
                }
            }
        }
    }

    @Override
    public List<T> getValidResults() throws IllegalStateException {
        if (wasExecuted) {
            return validResults;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<T> getInvalidResults() throws IllegalStateException {
        if (wasExecuted) {
            return invalidResults;
        } else {
            throw new IllegalStateException();
        }
    }
}
