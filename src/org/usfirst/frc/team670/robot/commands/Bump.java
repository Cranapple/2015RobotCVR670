package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Bump extends Command {

	private boolean forward;
	
    public Bump(boolean f) 
    {
    	super(0.1);
    	requires(Robot.driveTrain);
    	forward = f;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	if(forward)
    		Robot.driveTrain.drive(0.25, 0.25);
    	else
    		Robot.driveTrain.drive(-0.25, -0.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.driveTrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
