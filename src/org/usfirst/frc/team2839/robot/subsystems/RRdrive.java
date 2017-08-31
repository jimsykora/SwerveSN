package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DriveStart;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RRdrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP rrdMotor = null;  //added, see Tayer's Power Point document, these are empty variables
	Encoder rrdEncoder = null;
	
	public RRdrive(){//added this constructor
		rrdMotor = new VictorSP(RobotMap.RRD_MOTOR);//must create a constant in RobotMap
		rrdMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		rrdEncoder = new Encoder(RobotMap.RR_ENCODER_CH_A,RobotMap.RR_ENCODER_CH_B);
	}

	public void setSpeed(double speed){
		rrdMotor.set(speed);
	}
	public void resetEncoderCount(){
		rrdEncoder.reset();
	}
	public double getEncoderRate(){//this method returns somrthing so we define it as double, if void it would not return anything
		return rrdEncoder.getRate();
	}
	public double getEncoderRPS(){//rps is getERate/(100 counts/rev) //getERate is counts/sec
		
		double cpr = 100.0*5.5; //cpr of shooter wheel (encoder counts/rev)*(gear reduction)
		return rrdEncoder.getRate()/cpr;  //returns rps (rev/sec) of shooter wheel
	}
    public void initDefaultCommand() {
        double rps = 0.0;
		// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveStart(rps));
    }
}

