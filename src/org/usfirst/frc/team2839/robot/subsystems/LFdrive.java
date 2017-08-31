package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DriveStart;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LFdrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP lfdMotor = null;  //added, see Tayer's Power Point document, these are empty variables
	Encoder lfdEncoder = null;
	
	public LFdrive(){//added this constructor
		lfdMotor = new VictorSP(RobotMap.LFD_MOTOR);//must create a constant in RobotMap
		lfdMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		lfdEncoder = new Encoder(RobotMap.LF_ENCODER_CH_A,RobotMap.LF_ENCODER_CH_B);
	}

	public void setSpeed(double speed){
		lfdMotor.set(speed);
	}
	public void resetEncoderCount(){
		lfdEncoder.reset();
	}
	public double getEncoderRate(){//this method returns somrthing so we define it as double, if void it would not return anything
		return lfdEncoder.getRate();
	}
	public double getEncoderRPS(){//rps is getERate/(100 counts/rev) //getERate is counts/sec
		
		double cpr = 100.0*5.5; //cpr of shooter wheel (encoder counts/rev)*(gear reduction)
		return lfdEncoder.getRate()/cpr;  //returns rps (rev/sec) of shooter wheel
	}
    public void initDefaultCommand() {
        double rps = 0.0;
		// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveStart(rps));
    }
}

