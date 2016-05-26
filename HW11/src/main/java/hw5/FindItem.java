package hw5;


public class FindItem {

    public static int findMinItem(int[] arr) {

        int result = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < result) {

                result = arr[i];

        }

    }

        return result;

    }

    public static int findMaxItem(int[] arr) {

        int result = arr[0];

        for (int anArr : arr) {

            if (anArr > result) {

                result = anArr;

            }

        }

        return result;

    }

}
