package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.Robot;
import org.usfirst.frc.team2839.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void update() {
		SmartDashboard.putNumber("Raw LFS angle", 180-Robot.lfSteer.lfsEncoder.getAverageVoltage()*72);
		SmartDashboard.putNumber("Raw RFS angle", 180-Robot.rfSteer.rfsEncoder.getAverageVoltage()*72);
		SmartDashboard.putNumber("Raw RRS angle", 180-Robot.rrSteer.rrsEncoder.getAverageVoltage()*72);
		SmartDashboard.putNumber("Raw LRS angle", 180-Robot.lrSteer.lrsEncoder.getAverageVoltage()*72);
		SmartDashboard.putNumber("LFD rate", Robot.lfDrive.getEncoderRate());
		SmartDashboard.putNumber("RFD rate", Robot.rfDrive.getEncoderRate());
		SmartDashboard.putNumber("RRD rate", Robot.rrDrive.getEncoderRate());
		SmartDashboard.putNumber("LRD rate", Robot.lrDrive.getEncoderRate());
		SmartDashboard.putNumber("Rate delta", Robot.lrDrive.getEncoderRate()-Robot.rrDrive.getEncoderRate());
		//SmartDashboard.putNumber("ArcTangent", Math.atan(RobotPreferences.wheelbase()/RobotPreferences.treadwidth())*57.296);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

