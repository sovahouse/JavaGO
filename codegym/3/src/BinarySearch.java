public class BinarySearch {
    public int find(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int midIndex = (start + end) >>> 1;
            int midElement = array[midIndex];

            if(midElement < target) {
                start = midIndex + 1;
            } else if (midElement > target) {
                end = midIndex - 1;
            } else return midIndex;

        }

        return -1 - start;
    }
}