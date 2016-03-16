package test.lab1;

import lab1.Mocha;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class MochaTest {
    Mocha mocha;
    @Before
    public void setUp(){
        mocha=new Mocha();
    }

    @Test
    public void testSizeCost(){
        mocha.setSize("small");
        Assert.assertEquals(1.7,mocha.cost(), 1e-8);
        mocha.setSize("medium");
        Assert.assertEquals(2.0,mocha.cost(), 1e-8);
        mocha.setSize("large");
        Assert.assertEquals(2.3,mocha.cost(), 1e-8);
        mocha.setSize("grande");
        Assert.assertEquals(2.6,mocha.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(mocha.getDescription().contains("Mocha"));
    }
}