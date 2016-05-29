package hw4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class ConverterTest {
    @Test
    public void convertToCelsius() throws Exception {
        final int a = 50;

        final double result = Converter.convertToCelsius(a);
        Assert.assertEquals(10, result, 0.001);
    }

    @Test
    public void convertToFahrenheit() throws Exception {
        final int a = 660;

        final double result = Converter.convertToFahrenheit(a);
        Assert.assertEquals(1220, result, 0.001);
    }

}