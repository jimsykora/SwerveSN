package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DriveStart;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LRdrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP lrdMotor = null;  //added, see Tayer's Power Point document, these are empty variables
	Encoder lrdEncoder = null;
	
	public LRdrive(){//added this constructor
		lrdMotor = new VictorSP(RobotMap.LRD_MOTOR);//must create a constant in RobotMap
		lrdMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		lrdEncoder = new Encoder(RobotMap.LR_ENCODER_CH_A,RobotMap.LR_ENCODER_CH_B);
	}

	public void setSpeed(double speed){
		lrdMotor.set(speed);
	}
	public void resetEncoderCount(){
		lrdEncoder.reset();
	}
	public double getEncoderRate(){//this method returns somrthing so we define it as double, if void it would not return anything
		return lrdEncoder.getRate();
	}
	public double getEncoderRPS(){//rps is getERate/(100 counts/rev) //getERate is counts/sec
		
		double cpr = 100.0*5.5; //cpr of shooter wheel (encoder counts/rev)*(gear reduction)
		return lrdEncoder.getRate()/cpr;  //returns rps (rev/sec) of shooter wheel
	}
    public void initDefaultCommand() {
        double rps = 0.0;
		// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveStart(rps));
    }
}

