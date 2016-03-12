package test.lab1;

import lab1.GingerTea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class GingerTeaTest {
    GingerTea gingerTea;
    @Before
    public void setUp(){
        gingerTea=new GingerTea();
    }

    @Test
    public void testSizeCost(){
        gingerTea.setSize("small");
        Assert.assertEquals(1.8,gingerTea.cost(), 1e-8);
        gingerTea.setSize("medium");
        Assert.assertEquals(2.1,gingerTea.cost(), 1e-8);
        gingerTea.setSize("large");
        Assert.assertEquals(2.3,gingerTea.cost(), 1e-8);
        gingerTea.setSize("grande");
        Assert.assertEquals(2.5,gingerTea.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(gingerTea.getDescription().contains("Ginger Tea"));
    }
}