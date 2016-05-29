package hw4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class LengthTest {

    @Test
    public void calculate() throws Exception {
        final int x1 = 5;
        final int y1 = 4;
        final int x2 = 6;
        final int y2 = 10;

        final double result = Length.calculate(x1, y1, x2, y2);
        Assert.assertEquals(6.0827, result, 0.0001);
    }

}