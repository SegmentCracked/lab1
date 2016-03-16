package test.lab1;

import lab1.DecafCappuccino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class DecafCappuccinoTest {
    DecafCappuccino decafCappuccino;
    @Before
    public void setUp(){
        decafCappuccino=new DecafCappuccino();
    }

    @Test
    public void testSizeCost(){
        decafCappuccino.setSize("small");
        Assert.assertEquals(1.2,decafCappuccino.cost(), 1e-8);
        decafCappuccino.setSize("medium");
        Assert.assertEquals(1.5,decafCappuccino.cost(), 1e-8);
        decafCappuccino.setSize("large");
        Assert.assertEquals(1.8,decafCappuccino.cost(), 1e-8);
        decafCappuccino.setSize("grande");
        Assert.assertEquals(2.1,decafCappuccino.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(decafCappuccino.getDescription().contains("Decaf Cappuccino"));
    }
}