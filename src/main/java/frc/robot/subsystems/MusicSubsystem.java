// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.Orchestra;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.KrakenConstants;

public class MusicSubsystem extends SubsystemBase {
  
  private final TalonFX BackLeftKraken; 
  private final TalonFX BackRightKraken; 
  private final TalonFX FrontLeftKraken; 
  private final TalonFX FrontRightKraken; 

  Orchestra s_Orchestra;
  
  /** Creates a new MusicSubsystem. */
  public MusicSubsystem() {
    BackLeftKraken = new TalonFX(KrakenConstants.kBackLeft);
    BackRightKraken = new TalonFX(KrakenConstants.kBackRight);
    FrontLeftKraken = new TalonFX(KrakenConstants.kFrontLeft);
    FrontRightKraken = new TalonFX(KrakenConstants.kFrontRight);
    s_Orchestra = new Orchestra();
    s_Orchestra.addInstrument(BackLeftKraken);
    s_Orchestra.addInstrument(BackRightKraken);
    s_Orchestra.addInstrument(FrontLeftKraken);
    s_Orchestra.addInstrument(FrontRightKraken);

    var status = s_Orchestra.loadMusic("kickstart.chrp");
    if(!status.isOK()){
      System.out.println("Error playing track!");
    }
    s_Orchestra.play();
  }

  public void loadPlayTrack(){
    var status = s_Orchestra.loadMusic("kickstart.chrp");
    if(!status.isOK()){
      System.out.println("Error playing track!");
    }
    s_Orchestra.play();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
