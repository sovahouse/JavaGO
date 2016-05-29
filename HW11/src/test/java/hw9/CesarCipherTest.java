package hw9;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class CesarCipherTest {

    private static File file;
    private static CesarCipher cesarCipher;

    @BeforeClass
    public static void setUp() throws Exception {
        file = new Audio("Music");
        cesarCipher = new CesarCipher();
    }

    @Test
    public void encode() throws Exception {
        String result = cesarCipher.encode(file.toString());

        Assert.assertEquals("XFDtn", result);
    }

}