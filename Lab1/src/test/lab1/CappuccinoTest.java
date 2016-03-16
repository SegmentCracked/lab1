package test.lab1;

import lab1.Cappuccino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class CappuccinoTest {
    Cappuccino cappuccino;
    @Before
    public void setUp(){
        cappuccino=new Cappuccino();
    }

    @Test
    public void testSizeCost(){
        cappuccino.setSize("small");
        Assert.assertEquals(1.7,cappuccino.cost(), 1e-8);
        cappuccino.setSize("medium");
        Assert.assertEquals(2.0,cappuccino.cost(), 1e-8);
        cappuccino.setSize("large");
        Assert.assertEquals(2.3,cappuccino.cost(), 1e-8);
        cappuccino.setSize("grande");
        Assert.assertEquals(2.6,cappuccino.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(cappuccino.getDescription().contains("Cappuccino"));
    }
}