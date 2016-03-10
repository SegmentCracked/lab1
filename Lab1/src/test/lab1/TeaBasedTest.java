package test.lab1;

import lab1.TeaBased;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class TeaBasedTest {
    private TeaBased tb;
    @Before
    public void setUp(){
        tb=new TeaBased();
    }
    @Test
    public void testSizeCost(){
        Assert.assertEquals(0.2, tb.sizeCost("small"), 0);
        Assert.assertEquals(0.5, tb.sizeCost("medium"), 0);
        Assert.assertEquals(0.7, tb.sizeCost("large"), 0);
        Assert.assertEquals(0.9, tb.sizeCost("grant"), 0);
    }
}
