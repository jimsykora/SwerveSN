package org.usfirst.frc.team2839.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	//PWM-avoid duplicate values
		public static final int LFS_MOTOR = 1;
		public static final int LFD_MOTOR = 0;
		public static final int RFS_MOTOR = 5;
		public static final int RFD_MOTOR = 4;
		public static final int RRS_MOTOR = 6;
		public static final int RRD_MOTOR = 7;
		public static final int LRS_MOTOR = 2;
		public static final int LRD_MOTOR = 3;
		
	//joystick
		public static final int OI_JOYSTICK = 1;
		
	//Digital Inputs (DIO)-avoid duplicate values
		public static final int LF_ENCODER_CH_A = 0;
		public static final int LF_ENCODER_CH_B = 1;
		public static final int RF_ENCODER_CH_A = 4;
		public static final int RF_ENCODER_CH_B = 5;
		public static final int RR_ENCODER_CH_A = 6;
		public static final int RR_ENCODER_CH_B = 7;
		public static final int LR_ENCODER_CH_A = 2;
		public static final int LR_ENCODER_CH_B = 3;
		
	//Analog inputs-avoid duplicate values
		public static final int LFS_ENCODER = 0;
		public static final int RFS_ENCODER = 2;
		public static final int RRS_ENCODER = 3;
		public static final int LRS_ENCODER = 1;
}
