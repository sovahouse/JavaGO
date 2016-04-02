import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class SquareSumImpl implements SquareSum {

    private volatile int sum;

    public SquareSumImpl() {
        this.sum = 0;
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        Phaser phaser = new Phaser(numberOfThreads);

        final int packs;
        final int elementsValue;

        if (values.length % 2 == 0) {
            packs = values.length / numberOfThreads;
            elementsValue = values.length / packs;
        } else {
            packs = (values.length / numberOfThreads) + 1;
            elementsValue = values.length / (packs - 1);
        }


        IntStream.range(0, numberOfThreads).forEach((i ->
                executor.execute(() -> {

                    int currentPow = 0;
                    for (int j = 0; j < values.length; j += elementsValue) {
                        currentPow = (int) Math.pow(values[i + j], 2);
                    }

                    phaser.arriveAndAwaitAdvance();

                    sum += currentPow;
                    System.out.println(sum);

                })));


        executor.shutdown();


        return sum;
    }

}
