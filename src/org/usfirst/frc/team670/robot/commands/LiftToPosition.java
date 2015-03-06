package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToPosition extends Command 
{
	
	private double position;
	
    public LiftToPosition(double position) 
    {
        requires(Robot.elevator);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.elevator.setSetpoint(position);
    	Robot.elevator.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.elevator.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	Robot.elevator.disable();
    }
}
