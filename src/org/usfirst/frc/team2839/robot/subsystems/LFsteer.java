package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.RobotPreferences;
import org.usfirst.frc.team2839.robot.commands.SteerStart;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LFsteer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP lfsMotor = null;
	AnalogInput lfsEncoder= null;

	public LFsteer(){//added this constructor
		lfsMotor = new VictorSP(RobotMap.LFS_MOTOR);
		lfsMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		lfsEncoder = new AnalogInput(RobotMap.LFS_ENCODER);
	}
	public void setAngle(double angle){
		lfsMotor.setSpeed(angle);
	}
	public double getPotAngle(){
		return (180-lfsEncoder.getAverageVoltage()*72)  - (RobotPreferences.lfsOffset()+0.0);//the last addition may need tweaking
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SteerStart());
    }
}