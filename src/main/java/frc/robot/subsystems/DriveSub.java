/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.DriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSub extends Subsystem {
  
  public CANSparkMax LFT = new CANSparkMax(1, MotorType.kBrushless);
  public CANSparkMax LFM = new CANSparkMax(2, MotorType.kBrushless);
  public CANSparkMax RFT = new CANSparkMax(3, MotorType.kBrushless);
  public CANSparkMax RFM = new CANSparkMax(4, MotorType.kBrushless);
  public CANSparkMax LBT = new CANSparkMax(5, MotorType.kBrushless);
  public CANSparkMax LBM = new CANSparkMax(6, MotorType.kBrushless);
  public CANSparkMax RBT = new CANSparkMax(7, MotorType.kBrushless);
  public CANSparkMax RBM = new CANSparkMax(8, MotorType.kBrushless);

  
  // Put methods for controlling this subsystem

  public void swerveDrive(double throttleRaw, double rotateRaw){

    LFT.set(rotateRaw);
    LBT.set(rotateRaw);
    RFT.set(rotateRaw);
    RBT.set(rotateRaw);   
    LFM.set(throttleRaw);
    LBM.set(throttleRaw);
    RFM.set(throttleRaw);
    RBM.set(throttleRaw);
     

  }
  // here. Call these from Commands.


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
}
