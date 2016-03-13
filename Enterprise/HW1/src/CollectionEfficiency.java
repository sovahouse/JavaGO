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

            result[i][0] = arrayListTest(iterations);
            result[i][1] = linkedListTest(iterations);
            result[i][2] = hashSetTest(iterations);
            result[i][3] = treeSetTest(iterations);
        }
        Writer.write(result);

    }

    private static long[] treeSetTest(int iterations) {
        Set<Integer> treeSet = new TreeSet<>();

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                treeSet.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                treeSet.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                treeSet.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                treeSet.remove(i);
                treeSet.add(-i);
            }
            sum[5] += clock.millis() - start;
        }
        return average(sum);
    }

    private static long[] hashSetTest(int iterations) {
        Set<Integer> hashSet = new HashSet<>();

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                hashSet.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                hashSet.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                hashSet.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                hashSet.remove(i);
                hashSet.add(-i);
            }
            sum[5] += clock.millis() - start;
        }

        return average(sum);
    }

    private static long[] linkedListTest(int iterations) {
        List<Integer> linkedList = new LinkedList<>();

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                linkedList.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations && iterations < 1000000; j++) {
                linkedList.get(j);
            }
            sum[1] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                linkedList.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                linkedList.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = linkedList.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.set(i);
                }
            }
            sum[5] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = linkedList.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
            sum[6] += clock.millis() - start;
        }

        return average(sum);
    }

    private static long[] arrayListTest(int iterations) {

        List<Integer> arrayList = new ArrayList<>();

        Clock clock = Clock.systemUTC();
        long start;

        long[] sum = new long[7];

        for (int i = 0; i < 100; i++) {

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                arrayList.add(j);
            }
            sum[0] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                arrayList.get(j);
            }
            sum[1] += clock.millis() - start;

            start = clock.millis();
            for (int j = iterations - 1; j > 0; j--) {
                arrayList.remove(j);
            }
            sum[2] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                arrayList.contains(j);
            }
            sum[3] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = arrayList.listIterator();
                while (it.hasNext()) {
                    it.next();
                    it.set(i);
                }
            }
            sum[5] += clock.millis() - start;

            start = clock.millis();
            for (int j = 0; j < iterations; j++) {
                ListIterator<Integer> it = arrayList.listIterator();
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

