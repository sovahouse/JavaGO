import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class SquareSumImpl implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        Phaser phaser = new Phaser(numberOfThreads);

        final int increment = values.length / numberOfThreads;

        List<Callable<Long>> tasks = new ArrayList<>();

        IntStream.range(0, numberOfThreads).forEach((i -> tasks.add(() -> {
            phaser.register();
            long result = 0;
            int startIndex = i * increment;
            int endIndex;

            if ((i + 1) == numberOfThreads) {
                endIndex = values.length;
            } else {
                endIndex = (i + 1) * increment;
            }

            for (int j = startIndex; j < endIndex; j++) {
                result += Math.pow(values[j], 2);
            }
            phaser.arrive();

            phaser.arriveAndAwaitAdvance();

            return result;
        })));

        return compute(tasks, numberOfThreads);
    }

    private long compute(List<Callable<Long>> tasks, int numberOfThreads) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        long sum = 0;

        try {
            List<Future<Long>> resultList = executor.invokeAll(tasks);
            for (Future<Long> res : resultList) {
                sum += res.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        executor.shutdown();

        return sum;
    }

}
