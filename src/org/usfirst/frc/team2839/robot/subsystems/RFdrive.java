package org.usfirst.frc.team2839.robot.subsystems;

import org.usfirst.frc.team2839.robot.RobotMap;
import org.usfirst.frc.team2839.robot.commands.DriveStart;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RFdrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP rfdMotor = null;  //added, see Tayer's Power Point document, these are empty variables
	Encoder rfdEncoder = null;
	
	public RFdrive(){//added this constructor
		rfdMotor = new VictorSP(RobotMap.RFD_MOTOR);//must create a constant in RobotMap
		rfdMotor.setSafetyEnabled(false);//to allow a motor to run continuously without continuous repeated commands
		rfdEncoder = new Encoder(RobotMap.RF_ENCODER_CH_A,RobotMap.RF_ENCODER_CH_B);
	}

	public void setSpeed(double speed){
		rfdMotor.set(speed);
	}
	public void resetEncoderCount(){
		rfdEncoder.reset();
	}
	public double getEncoderRate(){//this method returns somrthing so we define it as double, if void it would not return anything
		return rfdEncoder.getRate();
	}
	public double getEncoderRPS(){//rps is getERate/(100 counts/rev) //getERate is counts/sec
		
		double cpr = 100.0*5.5; //cpr of shooter wheel (encoder counts/rev)*(gear reduction)
		return rfdEncoder.getRate()/cpr;  //returns rps (rev/sec) of shooter wheel
	}
    public void initDefaultCommand() {
        double rps = 0.0;
		// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveStart(rps));
    }
}

