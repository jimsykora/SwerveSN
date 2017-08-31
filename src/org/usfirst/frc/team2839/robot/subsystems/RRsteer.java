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
public class RRsteer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP rrsMotor = null;
	AnalogInput rrsEncoder= null;
	
	public RRsteer(){//added this constructor
		rrsMotor = new VictorSP(RobotMap.RRS_MOTOR);
		rrsMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		rrsEncoder = new AnalogInput(RobotMap.RRS_ENCODER);
	}
	public void setAngle(double angle){
		rrsMotor.setSpeed(angle);
	}
	public double getPotAngle(){
		return (180-rrsEncoder.getAverageVoltage()*72)  - (RobotPreferences.rrsOffset()+0.0);//the last addition may need tweaking
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SteerStart());
    }
}