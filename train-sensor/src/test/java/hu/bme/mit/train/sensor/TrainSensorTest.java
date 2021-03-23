package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorTest {

    TrainController mockController;
    TrainSensor sensor;
    TrainUser mockUser;

    @Before
    public void before() {
        mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockController, mockUser);

        sensor.overrideSpeedLimit(50);
    }

    @Test
    public void TestNormalBehaviour() {
        sensor.overrideSpeedLimit(10);
        verify(mockUser, times(0)).setAlarmState(true);
    }

    @Test
    public void TestAbsoluteUpperMargin() {
        sensor.overrideSpeedLimit(1000);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void TestAbsoluteLowerMargin() {
        sensor.overrideSpeedLimit(-10);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void TestRelativeMargin() {
        when(mockController.getReferenceSpeed()).thenReturn(20);
        sensor.overrideSpeedLimit(5);
        verify(mockUser, times(1)).setAlarmState(true);
    }

    @Test
    public void TestGetSpeedLimit() {
        Assert.assertEquals(50, sensor.getSpeedLimit());
    }
}
