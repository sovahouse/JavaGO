package hw10;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class CesarCipherTest {

    private static CesarCipher cesarCipher;
    private String string = "Hello";

    @BeforeClass
    public static void setUp() throws Exception {
        cesarCipher = new CesarCipher();
    }

    @Test
    public void encode() throws Exception {
        String result = cesarCipher.encode(string);

        Assert.assertEquals("Spwwz", result);
    }

    @Test
    public void decode() throws Exception {
        String result = cesarCipher.decode("Spwwz");

        Assert.assertEquals("Hello", result);
    }

}