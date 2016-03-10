package test.lab1;

import lab1.Espresso;
import lab1.Ginger;
import lab1.Jasmine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class GingerTest {
    Espresso espresso;
    Ginger order;
    @Before
    public void setUp(){
        espresso= new Espresso();
    }
    @Test
    public void testCost() {
        espresso.setSize("small");
        order = new Ginger(espresso);
        Assert.assertEquals(0.6, order.cost() - espresso.cost(),1e-8);
        espresso.setSize("large");
        order = new Ginger(espresso);
        Assert.assertEquals(0.6, order.cost() - espresso.cost(),1e-8);
    }
    @Test
    public void testDescription(){
        order=new Ginger(espresso);
        Assert.assertTrue(order.getDescription().contains("ginger"));
    }
}
