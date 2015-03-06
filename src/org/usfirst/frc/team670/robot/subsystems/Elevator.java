package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team670.robot.commands.LiftWithJoystick;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends PIDSubsystem {
    
	private Jaguar liftMotor;
	private AnalogInput liftUltrasonic;
	
    public Elevator()
    {
    	super(0,0,0);
    	liftMotor = new Jaguar(RobotMap.liftMotor);
    	liftUltrasonic = new AnalogInput(RobotMap.liftUltrasonic);
    	
    	setPercentTolerance(2);
    	setInputRange(RobotMap.liftMin, RobotMap.liftMax);
    	setOutputRange(-1,1);
    	
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	// disable() - Disables the punk PID controller.
    	// onTarget() - Is the PID right on the money?
    }

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new LiftWithJoystick());
    }
    
    public void setMotor(double val)
    {
    	if(getPosition() < RobotMap.liftMin && val < 0)
    		liftMotor.set(0);
    	else if(getPosition() > RobotMap.liftMax && val > 0)
    		liftMotor.set(0);
    	else
    		liftMotor.set(val);
    }
    
    public double getPosition()
    {
    	return liftUltrasonic.getAverageVoltage() * 1000.0/0.997;
    }
    
	@Override
	protected double returnPIDInput() 
	{
		return getPosition();
	}

	@Override
	protected void usePIDOutput(double output) 
	{
		setMotor(output);
	}
}

