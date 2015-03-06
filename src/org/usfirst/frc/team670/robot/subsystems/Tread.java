package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Tread extends PIDSubsystem {

    private Jaguar motor1;
    private Encoder encoder;
    private boolean reverse;
	
    public Tread(int motor1, int encoderA, int encoderB, boolean reverse)
    {
    	super(0,0,0);		//SET K's
    	
    	this.motor1 = new Jaguar(motor1);
    	encoder = new Encoder(encoderA, encoderB);
    	
    	this.reverse = reverse;
    	encoder.setReverseDirection(reverse);
    	
    	//SET DISTANCE PER PULSE
    	setPercentTolerance(2);
    	setOutputRange(-1,1);
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	// disable() - Disables the punk PID controller.
    	// onTarget() - Is the PID right on the money?
    }
    
    public void initDefaultCommand() {}
    
    protected double returnPIDInput() 
    {
        return encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        motor1.pidWrite(output);
    }
    
    public void set(double val)
    {
    	if(reverse)
    		val = -val;
    	
    	motor1.set(val);
    }
    
    public double get()
    {
    	if(reverse)
    		return -motor1.get();
    	else
    		return motor1.get(); 
    }
    
    public double getDistance()
    {
    	return encoder.getDistance();
    }
    
    public double getSpeed()
    {
    	return encoder.getRate();
    }
    
    public void resetEncoder()
    {
    	encoder.reset();
    }
    
    
}
