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
    public void setUp(){
        cout= new ByteArrayOutputStream();
        System.setOut(new PrintStream(cout));
    }
    @After
    public void recoveryStream(){
        System.setOut(null);
    }
    private boolean trimSame(String s1, String s2){
        return s1.trim().equals(s2.trim());
    }
    @Test
    public void testOldMethodOnEspresso(){
        String [] args;
        args=new String[2];
        args[0]="ESPRESSO";
        args[1]="small";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(),"The total cost of your order is: 1.4"));
        cout.reset();
        args[1]="medium";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(),"The total cost of your order is: 1.7"));
        cout.reset();
        args=new String[3];
        args[0]="ESPRESSO";
        args[1]="lArge";
        args[2]="CHOcolate";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(),"The total cost of your order is: 2.3"));
        cout.reset();
        args=new String[4];
        args[0]="ESPRESSO";
        args[1]="lArge";
        args[2]="CHOcolate";
        args[3]="Jasmine";
        Main.main(args);
        Assert.assertTrue(trimSame(cout.toString(),"The total cost of your order is: 2.8"));
    }

}
