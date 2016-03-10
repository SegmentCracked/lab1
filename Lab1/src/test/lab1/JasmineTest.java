package test.lab1;

import lab1.Espresso;
import lab1.Jasmine;
import lab1.WhipCream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class JasmineTest {
    Espresso espresso;
    Jasmine order;
    @Before
    public void setUp(){
        espresso= new Espresso();
    }
    @Test
    public void testCost() {
        espresso.setSize("small");
        order = new Jasmine(espresso);
        Assert.assertEquals(0.5, order.cost() - espresso.cost(),1e-8);
        espresso.setSize("large");
        order = new Jasmine(espresso);
        Assert.assertEquals(0.5, order.cost() - espresso.cost(),1e-8);
    }
    @Test
    public void testDescription(){
        order=new Jasmine(espresso);
        Assert.assertTrue(order.getDescription().contains("jasmine"));
    }
}
