package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RotationArmSubsystem;
import frc.robot.subsystems.WristSubsystem;

public class AutonArmDownCommand extends Command    {
    
    RotationArmSubsystem rotationArmSubsystem;
    WristSubsystem wristSubsystem;
    boolean isItFinished;

    public AutonArmDownCommand(RotationArmSubsystem rotationArmSubsystem, WristSubsystem wristSubsystem) {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.wristSubsystem = wristSubsystem;
        isItFinished = false;
        addRequirements(rotationArmSubsystem);
        addRequirements(wristSubsystem);
    }

    @Override
    public void execute()   {
        if (rotationArmSubsystem.wentTo(0.291) && wristSubsystem.wentTo(0.367, 0.1)) {
            isItFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}