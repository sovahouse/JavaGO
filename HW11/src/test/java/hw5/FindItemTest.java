package hw5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FindItemTest {

    final private int[] arr = {6, 7, 40, 1, 4};

    @Test
    public void findMinItem() throws Exception {
        final int result = FindItem.findMinItem(arr);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findMaxItem() throws Exception {

        final int result = FindItem.findMaxItem(arr);
        Assert.assertEquals(40, result);
    }

}