package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean alarm;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
		alarm = false;
	}

	@Override
	public boolean getAlarmFlag() {
		return false;
	}

	@Override
	public boolean getAlarmState() {
		return this.alarm;
	}

	@Override
	public void setAlarmState(boolean alarmSate) {
		this.alarm = alarmSate;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

}
