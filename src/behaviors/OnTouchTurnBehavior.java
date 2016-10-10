package behaviors;

import lejos.robotics.subsumption.Behavior;
import main.Robot;

public class OnTouchTurnBehavior implements Behavior{

	private Robot robot;
	private boolean suppressed = false;
	private boolean collisionLeft = false;
	private boolean collisionRight = false;
	
	public OnTouchTurnBehavior (Robot r) {
		this.robot = r;
	}
	
	@Override
	public boolean takeControl() {
		if (robot.getTouchLeftValue() == 1.0){
			collisionLeft = true;
			return true;
		}else if(robot.getTouchRightValue() == 1.0){
			collisionRight = true;
			return true;
		}
		return false;
	}

	@Override
	public void action() {
		suppressed = false;
		while(! suppressed ){
			System.out.println("Backwards");
			robot.getRightMotor().rotate(-180, true);
			robot.getLeftMotor().rotate(-180);
			if (collisionLeft){
				System.out.println("Left C");
				robot.getRightMotor().rotate(-180, true);
				robot.getLeftMotor().rotate(180);
			}else{
				System.out.println("Right C");
				robot.getLeftMotor().rotate(-180, true);
				robot.getRightMotor().rotate(180);
			}
			break;
		}
		
		collisionLeft = false;
		collisionRight = false;
	}

	@Override
	public void suppress() {
		suppressed = true; 
	}

}
