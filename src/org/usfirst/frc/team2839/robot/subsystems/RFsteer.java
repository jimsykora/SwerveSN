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
public class RFsteer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP rfsMotor = null;
	AnalogInput rfsEncoder= null;
	
	public RFsteer(){//added this constructor
		rfsMotor = new VictorSP(RobotMap.RFS_MOTOR);
		rfsMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		rfsEncoder = new AnalogInput(RobotMap.RFS_ENCODER);
	}
	public void setAngle(double angle){
		rfsMotor.setSpeed(angle);
	}
	public double getPotAngle(){
		return (180-rfsEncoder.getAverageVoltage()*72)  - (RobotPreferences.rfsOffset()+0.0);//the last addition may need tweaking
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SteerStart());
    }
}