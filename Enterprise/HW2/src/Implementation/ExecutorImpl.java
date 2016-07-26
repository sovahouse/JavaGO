package Implementation;

import Interface.*;

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
    private List<Entry<T>> entries = new ArrayList<>();

    private boolean wasExecuted = false;

    @Override
    public void addTask(Task task) {
        entries.add(new Entry<>(task, null));
    }

    @Override
    public void addTask(Task task, Validator validator) {
        entries.add(new Entry<>(task, validator));
    }

    @Override
    public void execute() {

        if (wasExecuted) return;
        wasExecuted = true;

        validResults = new ArrayList<>();
        invalidResults = new ArrayList<>();

        for (Entry<T> entry: entries) {

            if (entry.validator == null) {

                entry.task.execute();
                validResults.add(entry.task.getResult());

            } else {

                entry.task.execute();

                if (entry.validator.isValid(entry.task.getResult())) {
                    validResults.add(entry.task.getResult());
                } else {
                    invalidResults.add(entry.task.getResult());
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
