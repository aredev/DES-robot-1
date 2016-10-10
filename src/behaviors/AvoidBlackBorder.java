package behaviors;


import lejos.hardware.sensor.SensorConstants;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import main.Robot;

public class AvoidBlackBorder implements Behavior {
	
	private final Robot robot;
	private boolean suppressed = false;
	
	public AvoidBlackBorder(Robot robot){
		this.robot = robot;
	}

	@Override
	public boolean takeControl() {
		return robot.getFloorColor() <= 0.42;
	}

	@Override
	public void action() {
		suppressed = false;
		/*
		 * Deal with the fact that we now ride on the border.
		 * Following algorithm:
		 * - Turn CCW (Counter Clock Wise) by 5 degrees until the surface color is white again.
		 * - Turning should be done by putting left motor block in reverse and right motor block as normal.
		 * - Both should run at equal speed.
		 * NOTE: Use a negative number in the power field to go in reverse.
		 */
		while (!suppressed){
			System.out.println("Blaximus");
			robot.getRightMotor().rotate(180, true);
			robot.getLeftMotor().rotate(-180);
			
		}
	}

	@Override
	public void suppress() {
		suppressed = true; 
	}

}
