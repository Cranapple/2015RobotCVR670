package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	double distanceForward;
	
    public DriveDistance(double distanceForward) 
    {
        requires(Robot.driveTrain);
        this.distanceForward = distanceForward;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.driveTrain.leftTread.setSetpoint(Robot.driveTrain.leftTread.getDistance() + distanceForward);
    	Robot.driveTrain.rightTread.setSetpoint(Robot.driveTrain.rightTread.getDistance() + distanceForward);
    	
    	Robot.driveTrain.leftTread.enable();
    	Robot.driveTrain.rightTread.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.driveTrain.leftTread.enable();
    	Robot.driveTrain.rightTread.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.leftTread.onTarget() && Robot.driveTrain.rightTread.onTarget(); 
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.driveTrain.leftTread.disable();
    	Robot.driveTrain.rightTread.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
