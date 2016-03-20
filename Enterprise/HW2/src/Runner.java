import Implementation.*;
import Interface.*;

import java.util.List;

@SuppressWarnings("unchecked")

public class Runner {

    public void test(List<Task<Long>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Long> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }


}
