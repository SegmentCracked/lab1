package test.lab1;

import lab1.GreenTea;
import lab1.WhiteTea;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class WhiteTeaTest {
    WhiteTea tea;
    @Before
    public void setUp(){
        tea=new WhiteTea();
    }

    @Test
    public void testSizeCost(){
        tea.setSize("small");
        Assert.assertEquals(1.2,tea.cost(),0);
        tea.setSize("medium");
        Assert.assertEquals(1.5,tea.cost(),0);
        tea.setSize("large");
        Assert.assertEquals(1.7,tea.cost(),0);
        tea.setSize("grant");
        Assert.assertEquals(1.9,tea.cost(),0);
    }

    @Test
    public void testDescription(){
        Assert.assertTrue(tea.getDescription().contains("White Tea"));
    }
}
