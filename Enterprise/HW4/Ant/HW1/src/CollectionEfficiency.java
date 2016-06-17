import java.time.Clock;
import java.util.*;

public class CollectionEfficiency {

    public static void main(String[] args) {

        final int metodsQuantity = 7;
        final int collectionsQuantity = 4;
        final int testSet = 3;

        int iterations = 10000;

        long[][][] result = new long[testSet][collectionsQuantity][metodsQuantity];

        for (int i = 0; i < 3; i++, iterations *= 10) {

            result[i][0] = listTest(iterations, true);
            result[i][1] = listTest(iterations, false);
            result[i][2] = setTest(iterations, true);
            result[i][3] = setTest(iterations, false);
        }
        Writer.write(result);

    }

    private static long[] setTest(int iterations, boolean isHashSet) {

        Set<Integer> set;
        if (isHashSet) {
            set = new HashSet<>();
        } else {
            set = new TreeSet<>();
        }

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                set.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                set.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                set.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                set.remove(j);
                set.add(-j);
            }
            sum[5] += clock.millis() - start;
        }
        return average(sum);
    }

    private static long[] listTest(int iterations, boolean isArrayList) {

        List<Integer> list;

        if (isArrayList) {
            list = new ArrayList<>();
        } else {
            list = new LinkedList<>();
        }

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                list.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                list.get(i); // i!!!
            }
            sum[1] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                list.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                list.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = list.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.set(j);
                }
            }
            sum[5] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = list.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
            sum[6] += clock.millis() - start;
        }

        return average(sum);
    }

    private static long[] average(long[] sum) {

        for (int i = 0; i < sum.length; i++) sum[i] /= 100;
        return sum;
    }
}

