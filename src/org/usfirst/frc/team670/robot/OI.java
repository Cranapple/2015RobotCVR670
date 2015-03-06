package org.usfirst.frc.team670.robot;

import org.usfirst.frc.team670.robot.commands.BumpAndLift;
import org.usfirst.frc.team670.robot.commands.FreeRobot;
import org.usfirst.frc.team670.robot.commands.LiftToPosition;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
	private Joystick leftDriveStick = new Joystick(RobotMap.leftDriveStick);
	private Joystick rightDriveStick = new Joystick(RobotMap.rightDriveStick);
	private Joystick operatorStick = new Joystick(RobotMap.operatorStick);
	private Joystick arcButtons = new Joystick(RobotMap.arcButtons);
	
	JoystickButton ldsT;
	JoystickButton lds2;
	JoystickButton lds3;
	JoystickButton lds4;
	JoystickButton lds5;
	JoystickButton lds6;
	JoystickButton lds7; 
	JoystickButton lds8; 
	JoystickButton lds9; 
	JoystickButton lds10; 
	JoystickButton lds11;
	JoystickButton lds12; 
	
	JoystickButton rdsT; 
	JoystickButton rds2; 
	JoystickButton rds3;
	JoystickButton rds4; 
	JoystickButton rds5;
	JoystickButton rds6; 
	JoystickButton rds7; 
	JoystickButton rds8;
	JoystickButton rds9; 
	JoystickButton rds10;
	JoystickButton rds11;
	JoystickButton rds12; 
	
	JoystickButton osT; 
	JoystickButton os2; 
	JoystickButton os3;
	JoystickButton os4; 
	JoystickButton os5;
	JoystickButton os6; 
	JoystickButton os7;
	JoystickButton os8; 
	JoystickButton os9;
	JoystickButton os10;
	JoystickButton os11; 
	JoystickButton os12; 

	JoystickButton arc1;
	JoystickButton arc2;
	JoystickButton arc3;
	JoystickButton arc4;
	JoystickButton arc5;
	JoystickButton arc6;
	JoystickButton arc7;
	JoystickButton arc8;
	JoystickButton arc9;
	JoystickButton arc10;
	
	public OI()
	{
		ldsT = new JoystickButton(leftDriveStick, 1);
		lds2 = new JoystickButton(leftDriveStick, 2);
		lds3 = new JoystickButton(leftDriveStick, 3);
		lds4 = new JoystickButton(leftDriveStick, 4);
		lds5 = new JoystickButton(leftDriveStick, 5);
		lds6 = new JoystickButton(leftDriveStick, 6);
		lds7 = new JoystickButton(leftDriveStick, 7);
		lds8 = new JoystickButton(leftDriveStick, 8);
		lds9 = new JoystickButton(leftDriveStick, 9);
		lds10 = new JoystickButton(leftDriveStick, 10);
		lds11 = new JoystickButton(leftDriveStick, 11);
		lds12 = new JoystickButton(leftDriveStick, 12);
		
		rdsT = new JoystickButton(rightDriveStick, 1);
		rds2 = new JoystickButton(rightDriveStick, 2);
		rds3 = new JoystickButton(rightDriveStick, 3);
		rds4 = new JoystickButton(rightDriveStick, 4);
		rds5 = new JoystickButton(rightDriveStick, 5);
		rds6 = new JoystickButton(rightDriveStick, 6);
		rds7 = new JoystickButton(rightDriveStick, 7);
		rds8 = new JoystickButton(rightDriveStick, 8);
		rds9 = new JoystickButton(rightDriveStick, 9);
		rds10 = new JoystickButton(rightDriveStick, 10);
		rds11 = new JoystickButton(rightDriveStick, 11);
		rds12 = new JoystickButton(rightDriveStick, 12);
		
		osT = new JoystickButton(operatorStick, 1);
		os2 = new JoystickButton(operatorStick, 2);
		os3 = new JoystickButton(operatorStick, 3);
		os4 = new JoystickButton(operatorStick, 4);
		os5 = new JoystickButton(operatorStick, 5);
		os6 = new JoystickButton(operatorStick, 6);
		os7 = new JoystickButton(operatorStick, 7);
		os8 = new JoystickButton(operatorStick, 8);
		os9 = new JoystickButton(operatorStick, 9);
		os10 = new JoystickButton(operatorStick, 10);
		os11 = new JoystickButton(operatorStick, 11);
		os12 = new JoystickButton(operatorStick, 12);
		
		arc1 = new JoystickButton(arcButtons, 1);
		arc2 = new JoystickButton(arcButtons, 2);
		arc3 = new JoystickButton(arcButtons, 3);
		arc4 = new JoystickButton(arcButtons, 4);
		arc5 = new JoystickButton(arcButtons, 5);
		arc6 = new JoystickButton(arcButtons, 6);
		arc7 = new JoystickButton(arcButtons, 7);
		arc8 = new JoystickButton(arcButtons, 8);
		arc9 = new JoystickButton(arcButtons, 9);
		arc10 = new JoystickButton(arcButtons, 10);
	
		
		
		os5.whenPressed(new LiftToPosition(RobotMap.liftMin));
		os6.whenPressed(new LiftToPosition(RobotMap.liftMax));
		
		arc1.whenPressed(new LiftToPosition(RobotMap.liftPos2));
		arc2.whenPressed(new BumpAndLift(true, true, (RobotMap.liftPos4 + RobotMap.liftPos3) / 2));
		arc3.whenPressed(new BumpAndLift(false, false, RobotMap.liftMin));
		arc4.whenPressed(new LiftToPosition(1));
		arc5.whenPressed(new LiftToPosition(1));
		arc6.whenPressed(new LiftToPosition(1));
		arc7.whenPressed(new LiftToPosition(1));
		arc10.whenPressed(new FreeRobot());
		
		//UPDATE TO CORRECT BUTTONS
		
		// There are a few additional built in buttons you can use. Additionally,
	    // by subclassing Button you can create custom triggers and bind those to
	    // commands the same as any other Button.
		
	    //// TRIGGERING COMMANDS WITH BUTTONS
	    // Once you have a button, it's trivial to bind it to a button in one of
	    // three ways:
	    
	    // Start the command when the button is pressed and let it run the command
	    // until it is finished as determined by it's isFinished method.
	    // button.whenPressed(new ExampleCommand());
	    
	    // Run the command while the button is being held down and interrupt it once
	    // the button is released.
	    // button.whileHeld(new ExampleCommand());
	    
	    // Start the command when the button is released  and let it run the command
	    // until it is finished as determined by it's isFinished method.
	    // button.whenReleased(new ExampleCommand());
		
	}
	
	public double getLeftDriveStickX() 
	{
        return leftDriveStick.getX();
    }
	
	public double getLeftDriveStickY() 
	{
        return leftDriveStick.getY();
    }
	
	public double getLeftDriveStickTwist()
	{
		return leftDriveStick.getZ();
	}
	
	public double getLeftDriveStickThrottle()
	{
		return leftDriveStick.getThrottle();
	}
	
	public double getLeftDriveStickPOV()
	{
		return leftDriveStick.getPOV();
	}
	
	public double getRightDriveStickX() 
	{
        return rightDriveStick.getX();
    }
	
	public double getRightDriveStickY() 
	{
        return rightDriveStick.getY();
    }
	
	public double getRightDriveStickTwist()
	{
		return rightDriveStick.getZ();
	}
	
	public double getRightDriveStickThrottle()
	{
		return rightDriveStick.getThrottle();
	}
	
	public double getRightDriveStickPOV()
	{
		return rightDriveStick.getPOV();
	}
	
	public double getOperatorStickX() 
	{
        return operatorStick.getX();
    }
	
	public double getOperatorStickY() 
	{
        return operatorStick.getY();
    }
	
	public double getOperatorStickTwist()
	{
		return operatorStick.getZ();
	}
	
	public double getOperatorStickThrottle()
	{
		return operatorStick.getThrottle();
	}
	
	public double getOperatorStickPOV()
	{
		return operatorStick.getPOV();
	}
	
	
}

