package org.usfirst.frc.team2839.robot.commands;

import org.usfirst.frc.team2839.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SteerStart extends Command {
	double angle = 0.0;

    public SteerStart() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lfSteer);
    	requires(Robot.lfSteerPID);
    	requires(Robot.rfSteer);
    	requires(Robot.rfSteerPID);
    	requires(Robot.rrSteer);
    	requires(Robot.rrSteerPID);
    	requires(Robot.lrSteer);
    	requires(Robot.lrSteerPID);
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
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	angle=Robot.oi.joystick.getDirectionDegrees();// if using the handle on a joystick
    	Robot.lfSteerPID.setSetpoint(angle);
    	Robot.lfSteer.setAngle(Robot.lfSteerPID.getOutput());
    	Robot.rfSteerPID.setSetpoint(angle);
    	Robot.rfSteer.setAngle(Robot.rfSteerPID.getOutput());
    	Robot.rrSteerPID.setSetpoint(angle);
    	Robot.rrSteer.setAngle(Robot.rrSteerPID.getOutput());
    	Robot.lrSteerPID.setSetpoint(angle);
    	Robot.lrSteer.setAngle(Robot.lrSteerPID.getOutput());
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
