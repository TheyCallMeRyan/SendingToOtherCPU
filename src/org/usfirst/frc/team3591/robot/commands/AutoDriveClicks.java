package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;
import org.usfirst.frc.team3591.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveClicks extends Command {
	
	public int clicks = 0;
	public String axis = "Y";
	public boolean finished = false;
	public double speed = .5;
	
    public AutoDriveClicks(int clicks, String axis) {
        this.clicks = clicks;
        this.axis = axis;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double averageClicks = (Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.FRONT_LEFT)) 
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.FRONT_RIGHT))
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.BACK_LEFT))
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.BACK_RIGHT))) / 4.0;
    	
    	
    	if(averageClicks > Math.abs(clicks)){
    		Robot.driveSubsystem.setMotors(0, 0, 0);
    		finished = true;
    	}
    	
    	if(!finished){
    		switch(axis){
    		case "X":
    			Robot.driveSubsystem.setMotors(speed*clicks/Math.abs(clicks), 0, 0);
    		case "Y":
    			Robot.driveSubsystem.setMotors(0, speed*clicks/Math.abs(clicks), 0);
    		case "Z":
    			Robot.driveSubsystem.setMotors(0, 0, speed*clicks/Math.abs(clicks));
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }
}
