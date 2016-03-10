package test.lab1;

import lab1.DecafMocha;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Zheyu Lu on 2016/3/10.
 */
public class DecafMochaTest {
    DecafMocha decafMocha;
    @Before
    public void setUp(){
        decafMocha=new DecafMocha();
    }

    @Test
    public void testSizeCost(){
        decafMocha.setSize("small");
        Assert.assertEquals(1.2,decafMocha.cost(),0);
        decafMocha.setSize("medium");
        Assert.assertEquals(1.5,decafMocha.cost(),0);
        decafMocha.setSize("large");
        Assert.assertEquals(1.8,decafMocha.cost(),0);
        decafMocha.setSize("grant");
        Assert.assertEquals(2.1,decafMocha.cost(),0);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(decafMocha.getDescription().contains("DecafMocha"));
    }
}