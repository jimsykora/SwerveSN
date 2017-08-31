package org.usfirst.frc.team2839.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//steer inputs
	public static double steerP() {
		return Preferences.getInstance().getDouble("steerP", 0.015);  //add to subsystem PID: "enable method"
	}
	public static double steerI() {
		return Preferences.getInstance().getDouble("steerI", 0.0);
	}
	public static double steerD() {
		return Preferences.getInstance().getDouble("steerD", 0.0);
	}
	public static double steerTolerance() {
		return Preferences.getInstance().getDouble("steerTolerance", 2.0);
	}
	public static double steerTargetRate() {
		return Preferences.getInstance().getDouble("steerTargetRate", 5.0);
	}
	public static double steerMaxSpeed() {
		return Preferences.getInstance().getDouble("steerMaxSpeed", 1.0);
	}
	public static double lfsOffset() {
		return Preferences.getInstance().getDouble("lfsOffset", -155.74); //force alignment of front & rear wheels with clamp and sprockets facing left, enter the number from the dashboard
	}
	public static double rfsOffset() {
		return Preferences.getInstance().getDouble("rfsOffset", -41.05);//force alignment of front & rear wheels with clamp and sprockets facing left, enter the number from the dashboard
	}
	public static double rrsOffset() {
		return Preferences.getInstance().getDouble("rrsOffset", 111.09);//force alignment of front & rear wheels with clamp and sprockets facing left, enter the number from the dashboard
	}
	public static double lrsOffset() {
		return Preferences.getInstance().getDouble("lrsOffset", 23.03);//force alignment of front & rear wheels with clamp and sprockets facing left, enter the number from the dashboard
	}
	public static double treadwidth() {
		return Preferences.getInstance().getDouble("treadwidth", 15.0);//for calculating center of spin
	}
	public static double wheelbase() {
		return Preferences.getInstance().getDouble("wheelbase", 18.25);//for calculating center of spin
	}
	
	//drive inputs
	public static double driveP() {
		return Preferences.getInstance().getDouble("driveP", 0.1);  //add to subsystem PID: "enable method"
	}
	public static double driveI() {
		return Preferences.getInstance().getDouble("driveI", 0.04);
	}
	public static double driveD() {
		return Preferences.getInstance().getDouble("driveD", 0.0);
	}
	public static double driveF() {
		return Preferences.getInstance().getDouble("driveF", 0.0); //works best at 0.0
	}
	public static double driveMaxSpeed() {
		return Preferences.getInstance().getDouble("driveMaxSpeed", 0.8);
	}
	public static double driveTolerance() {
		return Preferences.getInstance().getDouble("driveTolerance", 2.0);
	}
	public static double driveTargetRate() {
		return Preferences.getInstance().getDouble("driveTargetRate", 5.0);
	}
}
