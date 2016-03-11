package test.lab1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import lab1.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class MainTest {
    private ByteArrayOutputStream cout;

    @Before
    public void setUp() {
        cout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(cout));
    }

    @After
    public void recoveryStream() {
        System.setOut(null);
    }

    private boolean trimSame(String s1, String s2) {
        return s1.trim().equals(s2.trim());
    }

    @Test
    public void testOldMethodOnEspresso() {
        String[] args;
        args = new String[2];
        args[0] = "ESPRESSO";
        args[1] = "small";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 1.4"));
        cout.reset();
        args[1] = "medium";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 1.7"));
        cout.reset();
        args = new String[3];
        args[0] = "ESPRESSO";
        args[1] = "lArge";
        args[2] = "CHOcolate";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 2.3"));
        cout.reset();
        args = new String[4];
        args[0] = "ESPRESSO";
        args[1] = "lArge";
        args[2] = "CHOcolate";
        args[3] = "Jasmine";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 2.8"));
        cout.reset();
    }

    @Test
    public void testNewMethodOnEspresso() {
        String[] args;
        args = new String[3];
        args[0] = "2";
        args[1] = "ESPRESSO";
        args[2] = "small";
        Main.main(args);
        Assert.assertEquals(cout.toString().trim(), "The total cost of your order is: 2.8");
        cout.reset();
        args[0] = "0";
        args[2] = "medium";
        Main.main(args);
        Assert.assertEquals(cout.toString().trim(), "The total cost of your order is: 0.0");
        cout.reset();
        args = new String[4];
        args[0] = "5";
        args[1] = "ESPRESSO";
        args[2] = "lArge";
        args[3] = "CHOcolate";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 11.5"));
        cout.reset();
        args = new String[5];
        args[0] = "1234";
        args[1] = "ESPRESSO";
        args[2] = "lArge";
        args[3] = "CHOcolate";
        args[4] = "Jasmine";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(), "The total cost of your order is: 3455.2"));
        cout.reset();
    }

    @Test
    public void testMultiRequest() {
        String[] args;
        args = new String[7];
        args[0] = "2";
        args[1] = "ESPRESSO";
        args[2] = "small";
        args[3] = ";";
        args[4] = "ESPRESSO";
        args[5] = "lArge";
        args[6] = "CHOcolate";
        Main.main(args);
        Assert.assertEquals(cout.toString().trim(), "The total cost of your order is: 5.1");
        cout.reset();
    }
}
