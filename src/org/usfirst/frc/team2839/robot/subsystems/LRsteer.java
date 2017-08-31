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
public class LRsteer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP lrsMotor = null;
	AnalogInput lrsEncoder= null;
	
	public LRsteer(){//added this constructor
		lrsMotor = new VictorSP(RobotMap.LRS_MOTOR);
		lrsMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		lrsEncoder = new AnalogInput(RobotMap.LRS_ENCODER);
	}
	public void setAngle(double angle){
		lrsMotor.setSpeed(angle);
	}
	public double getPotAngle(){
		return (180-lrsEncoder.getAverageVoltage()*72)  - (RobotPreferences.lrsOffset()+0.0);//the last addition may need tweaking
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SteerStart());
    }
}