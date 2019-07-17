/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.DriveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double throttleRaw = Robot.oi.stick.getRawAxis(RobotMap.throttle_axis);
    double strafeRaw = Robot.oi.stick.getRawAxis(RobotMap.strafe_axis);
    double rotateRaw = Robot.oi.stick.getRawAxis(RobotMap.strafe_axis);

    double R = Math.sqrt(RobotMap.Length*RobotMap.Length + RobotMap.width*RobotMap.width);

    double A = strafeRaw-rotateRaw*(RobotMap.Length/R);
    double B = strafeRaw+rotateRaw*(RobotMap.Length/R);
    double C = throttleRaw-rotateRaw*(RobotMap.width/R);
    double D = throttleRaw+rotateRaw*(RobotMap.width/R);

    double WS1 = Math.sqrt((B*B)+(C*C));
    double WS2 = Math.sqrt((B*B)+(D*D));
    double WS3 = Math.sqrt((A*A)+(D*D));
    double WS4 = Math.sqrt((A*A)+(C*C));
    
    double max1 = Math.max(WS1, WS2);
    double max2 = Math.max(WS3, WS4);
    double max = Math.max(max1, max2);
    
    if(max > 1){
      double RFMspeed= WS1/max;
      double LFMspeed = WS2/max;
      double RBMspeed = WS3/max;
      double LBMspeed= WS4/max;
    }


    
    Robot.DriveSubsystem.swerveDrive(LFTspeed, LBTspeed, RFTspeed, RBTspeed, LFMspeed, LBMspeed, RFMspeed, RBMspeed);
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
