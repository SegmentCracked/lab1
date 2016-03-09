package test.lab1;

import lab1.Espresso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class EspressoTest {
    Espresso espresso;
    @Before
    public void setUp(){
        espresso=new Espresso();
    }

    @Test
    public void testEspressoCost(){
        espresso.setSize("small");
        Assert.assertEquals(1.4,espresso.cost(),0);
        espresso.setSize("medium");
        Assert.assertEquals(1.7,espresso.cost(),0);
        espresso.setSize("large");
        Assert.assertEquals(2,espresso.cost(),0);
        espresso.setSize("grant");
        Assert.assertEquals(2.3,espresso.cost(),0);
    }
}
