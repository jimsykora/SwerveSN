
package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2839.robot.subsystems.LFdrive;
import org.usfirst.frc.team2839.robot.subsystems.LFdrivePID;
import org.usfirst.frc.team2839.robot.subsystems.LFsteer;
import org.usfirst.frc.team2839.robot.subsystems.LFsteerPID;
import org.usfirst.frc.team2839.robot.subsystems.LRdrive;
import org.usfirst.frc.team2839.robot.subsystems.LRdrivePID;
import org.usfirst.frc.team2839.robot.subsystems.LRsteer;
import org.usfirst.frc.team2839.robot.subsystems.LRsteerPID;
import org.usfirst.frc.team2839.robot.subsystems.RFdrive;
import org.usfirst.frc.team2839.robot.subsystems.RFdrivePID;
import org.usfirst.frc.team2839.robot.subsystems.RFsteer;
import org.usfirst.frc.team2839.robot.subsystems.RFsteerPID;
import org.usfirst.frc.team2839.robot.subsystems.RRdrive;
import org.usfirst.frc.team2839.robot.subsystems.RRdrivePID;
import org.usfirst.frc.team2839.robot.subsystems.RRsteer;
import org.usfirst.frc.team2839.robot.subsystems.RRsteerPID;
import org.usfirst.frc.team2839.robot.subsystems.Telemetry;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static LFsteer lfSteer;
	public static LFsteerPID lfSteerPID;
	public static RFsteer rfSteer;
	public static RFsteerPID rfSteerPID;
	public static RRsteer rrSteer;
	public static RRsteerPID rrSteerPID;
	public static LRsteer lrSteer;
	public static LRsteerPID lrSteerPID;
	
	public static LFdrive lfDrive;
	public static LFdrivePID lfDrivePID;
	public static RFdrive rfDrive;
	public static RFdrivePID rfDrivePID;
	public static RRdrive rrDrive;
	public static RRdrivePID rrDrivePID;
	public static LRdrive lrDrive;
	public static LRdrivePID lrDrivePID;
	

	public static Telemetry telemetry; //Smart Dashboard & OI must be at the end
	public static OI oi; //Smart Dashboard (Telemetry) & OI must be at the end

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		lfSteer = new LFsteer();
		lfSteerPID = new LFsteerPID();
		rfSteer = new RFsteer();
		rfSteerPID = new RFsteerPID();
		rrSteer = new RRsteer();
		rrSteerPID = new RRsteerPID();
		lrSteer = new LRsteer();
		lrSteerPID = new LRsteerPID();
		
		lfDrive = new LFdrive();
		lfDrivePID = new LFdrivePID();
		rfDrive = new RFdrive();
		rfDrivePID = new RFdrivePID();
		rrDrive = new RRdrive();
		rrDrivePID = new RRdrivePID();
		lrDrive = new LRdrive();
		lrDrivePID = new LRdrivePID();

		SmartDashboard.putData("Auto mode", chooser);
		telemetry = new Telemetry();
		oi = new OI(); //Smart Dashboard & OI must be at the end
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		telemetry.update();  //makes SmartDashboard live when in disabled mode
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		telemetry.update();  //makes SmartDashboard live when in disabled mode
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		telemetry.update();  //makes SmartDashboard live when in disabled mode
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
