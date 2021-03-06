package behaviors;


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
		// Set suppressed to false
		suppressed = false;
		// Rotate CCW (Counter Clock Wise)
		robot.getRightMotor().rotate(180, true);
		robot.getLeftMotor().rotate(-180, true);
		while (robot.getLeftMotor().isMoving() && !suppressed){
			// Wait till turn is complete or suppressed is called
			Thread.yield();
		}
		// Clean up
		robot.stopRightMotor();
		robot.stopLeftMotor();
	}

	@Override
	public void suppress() {
		suppressed = true; 
	}

}
