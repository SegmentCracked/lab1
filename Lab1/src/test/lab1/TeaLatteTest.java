package test.lab1;

import lab1.TeaLatte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Kaiwen Xu on 2016/3/12.
 */
public class TeaLatteTest {
    TeaLatte teaLatte;
    @Before
    public void setUp(){
        teaLatte=new TeaLatte();
    }

    @Test
    public void testSizeCost(){
        teaLatte.setSize("small");
        Assert.assertEquals(1.3,teaLatte.cost(), 1e-8);
        teaLatte.setSize("medium");
        Assert.assertEquals(1.6,teaLatte.cost(), 1e-8);
        teaLatte.setSize("large");
        Assert.assertEquals(1.8,teaLatte.cost(), 1e-8);
        teaLatte.setSize("grande");
        Assert.assertEquals(2.0,teaLatte.cost(), 1e-8);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(teaLatte.getDescription().contains("Tea Latte"));
    }
}