package test.lab1;

import lab1.FlowerTea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class FlowerTeaTest {
    FlowerTea flowerTea;
    @Before
    public void setUp(){
        flowerTea=new FlowerTea();
    }

    @Test
    public void testSizeCost(){
        flowerTea.setSize("small");
        Assert.assertEquals(1.7,flowerTea.cost(), 1e-8);
        flowerTea.setSize("medium");
        Assert.assertEquals(2.0,flowerTea.cost(), 1e-8);
        flowerTea.setSize("large");
        Assert.assertEquals(2.2,flowerTea.cost(), 1e-8);
        flowerTea.setSize("grande");
        Assert.assertEquals(2.4,flowerTea.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(flowerTea.getDescription().contains("Flower Tea"));
    }
}