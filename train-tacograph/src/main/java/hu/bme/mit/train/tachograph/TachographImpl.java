package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import hu.bme.mit.train.interfaces.Tachograph;
import com.google.common.collect.Table;

public class TachographImpl implements  Tachograph{

    Table<Integer, Integer, Integer> table = HashBasedTable.create();

    @Override
    public void addRecord(int measurement_time, int joystick_position, int reference_speed) {
        table.put(measurement_time, joystick_position, reference_speed);
    }
}
