package test.lab1;

import lab1.Latte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class LatteTest {
    Latte latte;
    @Before
    public void setUp(){
        latte=new Latte();
    }

    @Test
    public void testSizeCost(){
        latte.setSize("small");
        Assert.assertEquals(1.7,latte.cost(), 1e-8);
        latte.setSize("medium");
        Assert.assertEquals(2.0,latte.cost(), 1e-8);
        latte.setSize("large");
        Assert.assertEquals(2.3,latte.cost(), 1e-8);
        latte.setSize("grande");
        Assert.assertEquals(2.6,latte.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(latte.getDescription().contains("Latte"));
    }
}