package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem 
{
	
	public Tread leftTread;		//use these to access the right and left sides of the drivebase
	public Tread rightTread;
    
    //private Gyro gyro;
    
    double previousTime;
    
	public DriveTrain() 
	{
        leftTread = new Tread(RobotMap.leftMotor1, 
        					  RobotMap.leftEncoderA, 
        					  RobotMap.leftEncoderB,
        					  false);
        rightTread = new Tread(RobotMap.rightMotor1, 
				  			  RobotMap.rightEncoderA, 
				  			  RobotMap.rightEncoderB,
				  			  true);
        //gyro = new Gyro(RobotMap.gyro);
	}

	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	//MOTOR SETTERS---------------------------------------------------------
	
	public void drive(double left, double right) 
	{
		leftTread.set(victor_linearize(left));
		rightTread.set(victor_linearize(right));
	}
	
	//GYRO------------------------------------------------------------------------------
	/*
	public void resetGyro()
	{
		gyro.reset();
	}
	
	public double getAngle()
	{
		return gyro.getAngle();
	}
	*/
	
      public static double victor_linearize(double goal_speed)
      {
			final double deadband_value = 0.082;
			
			if (goal_speed > deadband_value)
				goal_speed -= deadband_value;
			else if (goal_speed < -deadband_value)
				goal_speed += deadband_value;
			else
				goal_speed = 0.0;
			goal_speed = goal_speed / (1.0 - deadband_value);

			double goal_speed2 = goal_speed * goal_speed;
			double goal_speed3 = goal_speed2 * goal_speed;
			double goal_speed4 = goal_speed3 * goal_speed;
			double goal_speed5 = goal_speed4 * goal_speed;
			double goal_speed6 = goal_speed5 * goal_speed;
			double goal_speed7 = goal_speed6 * goal_speed;

			// Original untweaked one.
			//double victor_fit_c		= -1.6429;
			//double victor_fit_d		= 4.58861e-08;
			//double victor_fit_e		= 0.547087;
			//double victor_fit_f		= -1.19447e-08;

			// Constants for the 5th order polynomial
			double victor_fit_e1		= 0.437239;
			double victor_fit_c1		= -1.56847;
			double victor_fit_a1		= (- (125.0 * victor_fit_e1  + 125.0 * victor_fit_c1 - 116.0) / 125.0);
			double answer_5th_order = (victor_fit_a1 * goal_speed5
				+ victor_fit_c1 * goal_speed3
				+ victor_fit_e1 * goal_speed);

			// Constants for the 7th order polynomial
			double victor_fit_c2 = -5.46889;
			double victor_fit_e2 = 2.24214;
			double victor_fit_g2 = -0.042375;
			double victor_fit_a2 = (- (125.0 * (victor_fit_c2 + victor_fit_e2 + victor_fit_g2) - 116.0) / 125.0);
			double answer_7th_order = (victor_fit_a2 * goal_speed7
				+ victor_fit_c2 * goal_speed5
				+ victor_fit_e2 * goal_speed3
				+ victor_fit_g2 * goal_speed);


			// Average the 5th and 7th order polynomials
			double answer =  0.85 * 0.5 * (answer_7th_order + answer_5th_order)
			+ .15 * goal_speed * (1.0 - deadband_value);

			if (answer > 0.001)
				answer += deadband_value;
			else if (answer < -0.001)
				answer -= deadband_value;

			return answer;
		}
     
}
