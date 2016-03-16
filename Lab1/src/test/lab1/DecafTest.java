package test.lab1;

import lab1.Decaf;
import lab1.Espresso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class DecafTest {
    Decaf decaf;
    @Before
    public void setUp(){
        decaf=new Decaf();
    }

    @Test
    public void testSizeCost(){
        decaf.setSize("small");
        Assert.assertEquals(0.9 ,decaf.cost(),0);
        decaf.setSize("medium");
        Assert.assertEquals(1.2,decaf.cost(),0);
        decaf.setSize("large");
        Assert.assertEquals(1.5 ,decaf.cost(),0);
        decaf.setSize("grande");
        Assert.assertEquals(1.8,decaf.cost(),0);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(decaf.getDescription().contains("Decaf"));
    }
}
