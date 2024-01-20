package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

public class AutonArmCommand extends Command    {
    
    RotationArmSubsystem rotationArmSubsystem;
    boolean isDone = false;
    
    public AutonArmCommand(RotationArmSubsystem rotationArmSubsystem)  {
        this.rotationArmSubsystem = rotationArmSubsystem;
        addRequirements(rotationArmSubsystem);
    }

    @Override
    public void execute()   {
        isDone = rotationArmSubsystem.goToGround();
    }

    @Override
    public boolean isFinished() {
        return isDone;
    }
}
