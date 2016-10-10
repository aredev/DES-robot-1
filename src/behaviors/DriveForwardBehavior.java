package behaviors;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.SensorConstants;
import lejos.hardware.sensor.SensorMode;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.*;

import lejos.robotics.subsumption.Behavior;
import main.Robot;

public class DriveForwardBehavior implements Behavior{

	private Robot robot;
	private boolean suppressed = false;
	
	public DriveForwardBehavior(Robot r){
		this.robot = r;
	}
	
	@Override
	public boolean takeControl() {
		return true;
		//return robot.getFloorColor() == SensorConstants.WHITE;
	}

	@Override
	public void action() {
		while(! suppressed){
			System.out.println("Drive");
			robot.rotateLeftMotorForward();
			robot.rotateRightMotorForward();
			
			System.out.println(robot.getDistanceValue());
		}
		
		robot.stopLeftMotor();
		robot.stopRightMotor();
	}

	@Override
	public void suppress() {
		suppressed = true;
	}
	
	

}
