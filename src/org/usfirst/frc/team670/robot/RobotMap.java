package org.usfirst.frc.team670.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static int leftMotor1 = 2;
    public static int rightMotor1 = 4;
    public static int middleMotor = 0;
    public static int leftEncoderA = 0;		//BLUE = ALPHA
    public static int leftEncoderB = 0;
    public static int rightEncoderA = 0;
    public static int rightEncoderB = 0;
    public static int liftMotor = 0;
    public static int liftUltrasonic = 0;
    
    public static int leftDriveStick = 1;
    public static int rightDriveStick = 2;
    public static int operatorStick = 0;
    public static int arcButtons = 4;
    
    public static final int liftMin = 0;
    public static final int liftMax = 100;
    public static final int liftPos1 = 15;
    public static final int liftPos2 = 30;
    public static final int liftPos3 = 45;
    public static final int liftPos4 = 60;
    public static final int liftPos5 = 75;
    public static final int liftPos6 = 90;
	
	// For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
