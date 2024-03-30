// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MusicSubsystem;

public class playMusic extends Command {
  String song;
  MusicSubsystem MusicSub;
  /** Creates a new playMusic. */
  public playMusic(MusicSubsystem MusicSub, String song) {
    this.MusicSub = MusicSub;
    this.song = song;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(MusicSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Now playing: " + song);
    MusicSub.loadPlayTrack(song);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopped playing: " + song);
    MusicSub.stopMusic();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
