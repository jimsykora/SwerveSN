package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStart extends Command {
	double speed = 0.0;

    public DriveStart(double rps) {  //rps is rev/sec
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = rps;
    	//angle = degrees:

    	/*requires(Robot.lfSteer);
    	requires(Robot.lfSteerPID);
    	requires(Robot.rfSteer);
    	requires(Robot.rfSteerPID);
    	requires(Robot.rrSteer);
    	requires(Robot.rrSteerPID);
    	requires(Robot.lrSteer);
    	requires(Robot.lrSteerPID);
    	*/
    	
    	requires(Robot.lfDrivePID);
    	requires(Robot.lfDrive);
    	requires(Robot.rfDrivePID);
    	requires(Robot.rfDrive);
    	requires(Robot.rrDrivePID);
    	requires(Robot.rrDrive);
    	requires(Robot.lrDrivePID);
    	requires(Robot.lrDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*Robot.lfSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.lfSteerPID.enable();
    	Robot.rfSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.rfSteerPID.enable();
    	Robot.rrSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.rrSteerPID.enable();
    	Robot.lrSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.lrSteerPID.enable();
    	*/
    	Robot.lfDrivePID.setSetpoint(speed);
    	Robot.lfDrivePID.setRawTolerance(RobotPreferences.driveTolerance());
    	Robot.lfDrivePID.enable();
    	Robot.rfDrivePID.setSetpoint(speed);
    	Robot.rfDrivePID.setRawTolerance(RobotPreferences.driveTolerance());
    	Robot.rfDrivePID.enable();
    	Robot.rrDrivePID.setSetpoint(speed);
    	Robot.rrDrivePID.setRawTolerance(RobotPreferences.driveTolerance());
    	Robot.rrDrivePID.enable();
    	Robot.lrDrivePID.setSetpoint(speed);
    	Robot.lrDrivePID.setRawTolerance(RobotPreferences.driveTolerance());
    	Robot.lrDrivePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//speed = Robot.oi.joystick.getMagnitude()*100.0/5.5*1.414; // *(encoder counts/rev)/(gear reduction)*1.414 (max magnitude is at corners of joystick
    	speed = Math.pow(Robot.oi.joystick.getMagnitude(), 3)*100.0/5.5*1.414; // same as above except Magnitude is cubed for better control at low speeds
    	Robot.lfDrivePID.setSetpoint(speed);
    	Robot.lfDrive.setSpeed(Robot.lfDrivePID.getOutput());
    	Robot.rfDrivePID.setSetpoint(speed);
    	Robot.rfDrive.setSpeed(Robot.rfDrivePID.getOutput());
    	Robot.rrDrivePID.setSetpoint(speed);
    	Robot.rrDrive.setSpeed(Robot.rrDrivePID.getOutput());
    	Robot.lrDrivePID.setSetpoint(speed);
    	Robot.lrDrive.setSpeed(Robot.lrDrivePID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lfDrivePID.disable();
    	Robot.lfDrive.setSpeed(0);
    	Robot.rfDrivePID.disable();
    	Robot.rfDrive.setSpeed(0);
    	Robot.rrDrivePID.disable();
    	Robot.rrDrive.setSpeed(0);
    	Robot.lrDrivePID.disable();
    	Robot.lrDrive.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}