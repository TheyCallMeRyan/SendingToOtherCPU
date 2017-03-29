package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeCommand extends Command {
	
	int direction = 0;
	
    public RopeCommand(int direction) {
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ropeSubsystem.climb(direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ropeSubsystem.climb(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ropeSubsystem.climb(0);
    }
}
