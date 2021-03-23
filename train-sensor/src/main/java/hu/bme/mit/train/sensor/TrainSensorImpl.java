package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		//check absolute margin
		if (speedLimit>500 || speedLimit<0)
			this.user.setAlarmState(true);
		//check relative margin
		else if (speedLimit<0.5*this.controller.getReferenceSpeed())
			this.user.setAlarmState(true);
		//set new speedLimits if it passes all checks
		else {
			this.speedLimit = speedLimit;
			controller.setSpeedLimit(speedLimit);
		}
	}

}
