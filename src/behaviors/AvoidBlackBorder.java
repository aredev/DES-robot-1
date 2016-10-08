package behaviors;


import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import main.Robot;

public class AvoidBlackBorder implements Behavior {
	
	private final Robot robot;
	
	public AvoidBlackBorder(Robot robot){
		this.robot = robot;
	}

	@Override
	public boolean takeControl() {
		return robot.getFloorColor() == Color.BLACK;
	}

	@Override
	public void action() {
		/*
		 * Deal with the fact that we now ride on the border.
		 * Following algorithm:
		 * - Turn CCW (Counter Clock Wise) by 5 degrees until the surface color is white again.
		 * - Turning should be done by putting left motor block in reverse and right motor block as normal.
		 * - Both should run at equal speed.
		 * NOTE: Use a negative number in the power field to go in reverse.
		 */
		robot.rotateLeftMotorBackward();
		robot.rotateRightMotorForward();
		while (robot.getFloorColor() == Color.BLACK){
				// Still rotating
		}
		robot.stopLeftMotor();
		robot.stopRightMotor();
	}

	@Override
	public void suppress() {
		/*
		 * Stop the motors that cause the robot to rotate
		 */
		robot.stopLeftMotor();
		robot.stopRightMotor();
	}

}
