package org.usfirst.frc.team3591.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3591.robot.commands.RopeCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveStick = new Joystick(RobotMap.DRIVESTICK_ID);
	public Button ropeUpButton = new JoystickButton(driveStick, RobotMap.ROPE_UP_BUTTON);
	public Button ropeDownButton = new JoystickButton(driveStick, RobotMap.ROPE_DOWN_BUTTON);
	
	public OI(){
		ropeUpButton.whileHeld(new RopeCommand(1));
		ropeDownButton.whileHeld(new RopeCommand(-1));
	}
	
	public double getAxis(String axis){
		double speed=0;
		double throttleMultiplier=(1-driveStick.getThrottle())/2;
		
		if(axis.equals("X")){
			speed=driveStick.getX();
		}else if(axis.equals("Y")){
			speed=driveStick.getY();
		}else if(axis.equals("Z")){
			speed=driveStick.getZ();
		}
		
		if(speed<.4 && speed>-.4){
			speed=0;
		}
		
		speed*=throttleMultiplier;
		
		return speed;
	}
	
}
