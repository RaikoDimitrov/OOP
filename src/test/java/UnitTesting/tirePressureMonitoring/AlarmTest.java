package UnitTesting.tirePressureMonitoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {
    private static final double LOW_PRESSURE_VALUE = 1.0;
    private static final double HIGH_PRESSURE_VALUE = 23.0;
    private Alarm alarm;
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    void testThatAlarmShouldBeOff() throws NoSuchFieldException, IllegalAccessException {
        Field sensorField = this.alarm.getClass().getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(this.alarm, this.sensor);
        assertFalse(this.alarm.getAlarmOn());

    }

    @Test
    void testThatAlarmShouldBeONForLowPressure() {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        this.alarm.check();
        assertTrue(this.alarm.getAlarmOn());
    }
    @Test
    void testThatAlarmShouldBeONForHighPressure() {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        this.alarm.check();
        assertTrue(this.alarm.getAlarmOn());
    }
}