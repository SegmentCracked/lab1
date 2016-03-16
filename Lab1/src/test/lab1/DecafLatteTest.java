package test.lab1;

import lab1.DecafLatte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class DecafLatteTest {
    DecafLatte decafLatte;
    @Before
    public void setUp(){
        decafLatte=new DecafLatte();
    }

    @Test
    public void testSizeCost(){
        decafLatte.setSize("small");
        Assert.assertEquals(1.2,decafLatte.cost(), 1e-8);
        decafLatte.setSize("medium");
        Assert.assertEquals(1.5,decafLatte.cost(), 1e-8);
        decafLatte.setSize("large");
        Assert.assertEquals(1.8,decafLatte.cost(), 1e-8);
        decafLatte.setSize("grande");
        Assert.assertEquals(2.1,decafLatte.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(decafLatte.getDescription().contains("Decaf Latte"));
    }
}