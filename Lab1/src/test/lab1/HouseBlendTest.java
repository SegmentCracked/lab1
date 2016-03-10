package test.lab1;

import lab1.Espresso;
import lab1.HouseBlend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class HouseBlendTest {
    HouseBlend houseBlend;
    @Before
    public void setUp(){
        houseBlend=new HouseBlend();
    }

    @Test
    public void testSizeCost(){
        houseBlend.setSize("small");
        Assert.assertEquals(1.2,houseBlend.cost(),1e-8);
        houseBlend.setSize("medium");
        Assert.assertEquals(1.5,houseBlend.cost(),1e-8);
        houseBlend.setSize("large");
        Assert.assertEquals(1.8,houseBlend.cost(),1e-8);
        houseBlend.setSize("grant");
        Assert.assertEquals(2.1,houseBlend.cost(),1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(houseBlend.getDescription().contains("HouseBlend"));
    }
}
