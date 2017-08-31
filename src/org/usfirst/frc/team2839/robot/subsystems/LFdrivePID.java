package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class LFdrivePID extends PIDSubsystem {
	double output = 0.0;
	boolean outputValid = false;
//	int targetRate = 0;  //remove later if/when PID loop gets tuned properly. its used to delay turning off PID loop while in motion
	double tolerance = 0.0;

    // Initialize your subsystem here
    public LFdrivePID() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super("LFdrivePID",0,0,0,0);
    	this.setSetpoint(0.0);
    }
    
    public void enable()  {
    	this.getPIDController().setPID(RobotPreferences.driveP(), RobotPreferences.driveI(), RobotPreferences.driveD(), RobotPreferences.driveF());
    	double maxSpeed = RobotPreferences.driveMaxSpeed(); //set to <1.0 to limit max motor speed
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	outputValid = false;
    	super.enable();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.lfDrive.getEncoderRPS(); 
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
   /* public boolean onRawTargrt() {
    	if(Math.abs(getPIDController().getSetpoint() - Robot.rrDrive.getEncoderRPS()) < tolerance) {
    		targetRate = targetRate +1;
    	}
    	else {
    		targetRate = 0;
    	}
    	return (targetRate >= RobotPreferences.driveTargetRate());
    }*/
}
