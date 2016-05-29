package hw5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class BubbleSortTest {

    @Test
    public void sort() throws Exception {

        int[] arr = {10,5,8,4,406};
        final int[] expectedResult = {4,5,8,10,406};

        BubbleSort.sort(arr);
        Assert.assertArrayEquals(expectedResult, arr);

    }

}