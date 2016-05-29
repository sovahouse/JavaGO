package hw4;

import org.junit.Assert;
import org.junit.Test;


public class AreaTest {


    @Test
    public void testCalculate() throws Exception {
        final int a = 4;
        final int b = 5;
        final int c = 8;

        double result = Area.calculate(a, b, c);
        Assert.assertEquals(8.18153, result, 0.0001);

        result = Area.calculate(a, b);
        Assert.assertEquals(20, result, 0.1);

        result = Area.calculate(a);
        Assert.assertEquals(50.26, result, 0.01);

    }


}