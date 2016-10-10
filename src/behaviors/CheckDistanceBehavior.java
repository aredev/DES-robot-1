package behaviors;

import lejos.robotics.subsumption.Behavior;
import main.Robot;

public class CheckDistanceBehavior implements Behavior{

	private Robot robot;
	private boolean suppressed = false;
	
	public CheckDistanceBehavior(Robot r) {
		this.robot = r;
	}
	
	@Override
	public boolean takeControl() {
		return robot.getDistanceValue() <= 0.33;
	}

	@Override
	public void action() {
		suppressed = false;
		while(!suppressed){
			robot.getLeftMotor().rotate(180, true);
			robot.getRightMotor().rotate(-180, true);
		}
		
	}

	@Override
	public void suppress() {
		suppressed = true;
		
	}

}
