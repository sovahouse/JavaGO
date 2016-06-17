import Implementation.ExecutorImpl;
import Implementation.LongTask;
import Implementation.NumberValidator;
import Interface.Executor;
import Interface.Task;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")

public class Runner {

    public static void main(String[] args) {

        Runner runner = new Runner();
        List<Task<Long>> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            taskList.add(new LongTask((long)i));
        }

        runner.test(taskList);
    }

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
