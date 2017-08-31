package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveSpin extends Command {
	double speed = 0.0;
	//double angle = 0.0;

    public DriveSpin(double rps) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	speed = rps;
    	//angle = degrees:

    	requires(Robot.lfSteer);
    	requires(Robot.lfSteerPID);
    	requires(Robot.rfSteer);
    	requires(Robot.rfSteerPID);
    	requires(Robot.rrSteer);
    	requires(Robot.rrSteerPID);
    	requires(Robot.lrSteer);
    	requires(Robot.lrSteerPID);
    	
    	
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
    	Robot.lfSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.lfSteerPID.enable();
    	Robot.rfSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.rfSteerPID.enable();
    	Robot.rrSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.rrSteerPID.enable();
    	Robot.lrSteerPID.setRawTolerance(1.0);//tolerance in degrees
    	Robot.lrSteerPID.enable();
    	
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
    	//angle=Robot.oi.joystick.getDirectionDegrees();// if using the handle on a joystick
    	Robot.lfSteerPID.setSetpoint(-90-Math.atan(RobotPreferences.treadwidth()/RobotPreferences.wheelbase())*57.296); //(-135.0); for square robot
    	Robot.lfSteer.setAngle(Robot.lfSteerPID.getOutput());
    	Robot.rfSteerPID.setSetpoint(Math.atan(RobotPreferences.wheelbase()/RobotPreferences.treadwidth()*-1)*57.296);//(-45.0); for square robot
    	Robot.rfSteer.setAngle(Robot.rfSteerPID.getOutput());
    	Robot.rrSteerPID.setSetpoint(Math.atan(RobotPreferences.wheelbase()/RobotPreferences.treadwidth())*57.296);//(45.0);for square robot
    	Robot.rrSteer.setAngle(Robot.rrSteerPID.getOutput());
    	Robot.lrSteerPID.setSetpoint(90+Math.atan(RobotPreferences.treadwidth()/RobotPreferences.wheelbase())*57.296);//(135.0);for square robot
    	Robot.lrSteer.setAngle(Robot.lrSteerPID.getOutput());
    	
    	speed = Math.pow(Robot.oi.joystick.getTwist(), 5)*-1.0*100.0/5.5;//*(encoder counts/rev)/(gear reduction), twist value is raised to 5th power for more control at low speeds
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
    	Robot.lfSteerPID.disable();	//will temporarily disable PID loop if eg over ridden by a button location command
    	Robot.rfSteerPID.disable();
    	Robot.rrSteerPID.disable();
    	Robot.lrSteerPID.disable();
    	
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
