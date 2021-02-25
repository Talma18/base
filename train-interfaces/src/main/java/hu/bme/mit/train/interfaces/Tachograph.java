package hu.bme.mit.train.interfaces;

public interface Tachograph {
    void addRecord(int measurement_time, int joystick_position, int reference_speed);
}
