package main;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.robotics.subsumption.Arbitrator;

public class Robot {
	
	private final String name;
	// Motors
	private final EV3LargeRegulatedMotor leftMotor;
	private final EV3LargeRegulatedMotor rightMotor;
	// Sensors
	private final EV3TouchSensor touchLeftSensor;
	private final EV3TouchSensor touchRightSensor;
	private final EV3UltrasonicSensor distanceSensor;
	private final EV3ColorSensor lightSensor;
	
	private final SampleProvider touchLeft, touchRight, light, distance;

	public Robot(String name){
		this.name = name;
		// Initialize Motors
		leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		rightMotor = new EV3LargeRegulatedMotor(MotorPort.D);
		// Initialize Sensors
		touchLeftSensor = new EV3TouchSensor(LocalEV3.get().getPort("S1"));
		touchRightSensor = new EV3TouchSensor(LocalEV3.get().getPort("S4"));
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S3"));
		// Assuming that port S2 is indeed the color sensor
		lightSensor = new EV3ColorSensor(LocalEV3.get().getPort("S2"));
		// Initialize Sample Providers
		touchLeft = touchLeftSensor.getTouchMode();
		touchRight = touchRightSensor.getTouchMode();
		light = lightSensor.getColorIDMode();
		distance = distanceSensor.getDistanceMode();
	}
	
	public void Run(){
		// Make some noise to indicate that the robot is alive
		Sound.buzz();
		// Draw name on screen
		LCD.drawString("Hello, my name is " + name, 0, 1);
		/*
		 * Our Arbitrator, see http://www.lejos.org/nxt/nxj/tutorial/Behaviors/BehaviorProgramming.htm
		 */
		Arbitrator arbitrator;
		
		while(!Button.ESCAPE.isDown()){
			// Making use of subsumption architecture
		}
	}
	
	/**
	 * Returns the color ID of the surface.
	 * The sensor can identify 8 unique colors (NONE, BLACK, BLUE, GREEN, YELLOW, RED, WHITE, BROWN)
	 * with ID of 0-7 respectively.
	 * @return The color ID of the surface.
	 */
	public int getFloorColor(){
		return lightSensor.getColorID();
	}
	
	public void rotateLeftMotorBackward(){
		this.leftMotor.backward();
	}
	
	public void rotateLeftMotorForward(){
		this.leftMotor.forward();
	}
	
	public void rotateRightMotorBackward(){
		this.rightMotor.backward();
	}
	
	public void rotateRightMotorForward(){
		this.rightMotor.forward();
	}
	
	public void stopRightMotor(){
		this.rightMotor.stop();
	}
	
	public void stopLeftMotor(){
		this.leftMotor.stop();
	}
	
}
