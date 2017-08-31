package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LRsteerPID extends PIDSubsystem {
	double output = 0.0;
	boolean outputValid = false;
	double targetAngle = 2.5;  //remove later if/when PID loop gets tuned properly. its used to delay turning off PID loop while in motion
	double tolerance = 1.0;
	
    // Initialize your subsystem here
    public LRsteerPID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("LRsteerPID",0,0,0);
    	this.setSetpoint(0.0);
    	getPIDController().setContinuous(true);
    }

    public void enable()  {
    	this.getPIDController().setPID(RobotPreferences.steerP(), RobotPreferences.steerI(), RobotPreferences.steerD());
    	double maxSpeed = RobotPreferences.steerMaxSpeed(); //set to <1.0 to limit max motor speed
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	this.setInputRange(-180.0, 180.0);
    	outputValid = false;
    	super.enable();
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.lrSteer.getPotAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	this.output = output;
    	outputValid = true;

    }
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) { // == meams "is equal to", || means "or"
    		return 0.0;
    	}
    	return output;
    }
    public void setRawTolerance(double tolerance) {
    	this.tolerance = tolerance;
    }
    /*public boolean onRawTargrt() {   //use when having pre set turret positions
    	if(Math.abs(getPIDController().getSetpoint() - Robot.shooter.getEncoderRPS()) < tolerance) {
    		targetAngle = targetAngle +1;
    	}
    	else {
    		targetAngle = 0;
    	}
    	//return (targetAngle >= RobotPreferences.targetRate());
    	return (targetAngle >= 0.3);
    }*/

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}