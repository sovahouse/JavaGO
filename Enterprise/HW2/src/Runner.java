import Implementation.*;
import Interface.*;
import java.util.List;

@SuppressWarnings("unchecked")

class Runner {

    Executor<Number> run(List<Task<Long>> longTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Long> intTask : longTasks) {
            numberExecutor.addTask(intTask, new NumberValidator());
        }
        //numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }

        return numberExecutor;
    }
}
