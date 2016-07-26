import Implementation.LongTask;
import Interface.Executor;
import Interface.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RunnerTest {
    @Test
    public void run() throws Exception {
        Runner runner = new Runner();
        List<Task<Long>> tasks = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            tasks.add(new LongTask(random.nextLong()));
        }



        Executor<Number> numberExecutor = runner.run(tasks);

        boolean isOdd = true;

        for (Number number : numberExecutor.getValidResults()) {
            if(number.longValue() % 2 == 0) {
                isOdd = false;
                break;
            }
        }
        assertEquals(true, isOdd);


        boolean isEven = true;

        for (Number number : numberExecutor.getInvalidResults()) {
            if(number.longValue() % 2 != 0) {
                isEven = false;
                break;
            }
        }
        assertEquals(true, isEven);
    }

}