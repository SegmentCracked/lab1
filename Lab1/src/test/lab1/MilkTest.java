package test.lab1;

import lab1.Espresso;
import lab1.Milk;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class MilkTest {
    Espresso espresso;
    Milk order;
    @Before
    public void setUp(){
        espresso = new Espresso();
    }
    @Test
    public void testCost(){
        espresso.setSize("small");
        order=new Milk(espresso);
        Assert.assertEquals(0.3, order.cost()-espresso.cost(), 1e-8);
        espresso.setSize("large");
        order=new Milk(espresso);
        Assert.assertEquals(0.3, order.cost()-espresso.cost(), 1e-8);
    }
    @Test
    public void testDescription(){
        order=new Milk(espresso);
        Assert.assertTrue(order.getDescription().contains("milk"));
    }
}
