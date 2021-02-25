package hu.bme.mit.train.tachograph;

import hu.bme.mit.train.interfaces.Tachograph;
import org.junit.Assert;
import org.junit.Test;

public class TachoGraphTest {



    @Test
    public void TachographStorage() {
        Tachograph tg =  new TachographImpl();

        tg.addRecord(0,0, 10);

        Assert.assertEquals(10, tg.getSpeed(0, 0));
    }
}
