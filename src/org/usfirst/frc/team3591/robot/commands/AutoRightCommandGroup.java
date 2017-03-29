package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightCommandGroup extends CommandGroup {

    public AutoRightCommandGroup() {
    	addSequential(new AutoDriveClicks(1000, "Y"));
    	addSequential(new AutoDriveClicks(0, "Z"));
    	addSequential(new AutoDriveClicks(0, "Y"));
        Timer timer = new Timer();
        try {
			timer.wait(Robot.autoWaitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        addSequential(new AutoDriveClicks(0, "Y"));
        addSequential(new AutoDriveClicks(0, "Z"));
        addSequential(new AutoDriveClicks(0, "X"));
        addSequential(new AutoDriveClicks(0, "Y"));
    }
}
