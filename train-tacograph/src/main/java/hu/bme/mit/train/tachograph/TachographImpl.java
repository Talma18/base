package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import hu.bme.mit.train.interfaces.Tachograph;
import com.google.common.collect.Table;

public class TachographImpl implements  Tachograph{

    Table<Integer, Integer, Integer> table = HashBasedTable.create();

    @Override
    public void addRecord(int measurementTime, int joystickPosition, int referenceSpeed) {
        table.put(measurementTime, joystickPosition, referenceSpeed);
    }

    @Override
    public int getSpeed(int time, int position) {
        return table.get(time, position);
    }
}
