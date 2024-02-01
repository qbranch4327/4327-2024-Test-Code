package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class RotationArmCommand extends Command {
    
    RotationArmSubsystem rotationArmSubsystem;
    WristSubsystem wristSubsystem;
    XboxController controller2;


    public RotationArmCommand(RotationArmSubsystem rotationArmSubsystem, WristSubsystem wristSubsystem, XboxController controller2)    {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.wristSubsystem= wristSubsystem;
        this.controller2 = controller2;
        addRequirements(rotationArmSubsystem);
        addRequirements(wristSubsystem);
    }


    @Override
    public void execute()   {
        if (controller2.getAButton())   {
            rotationArmSubsystem.goTo(0.033);
            wristSubsystem.goTo(0.3794);
        }
        else if (controller2.getYButton()) {
            rotationArmSubsystem.goTo(0.961);
            wristSubsystem.goTo(0.1897);
        }
        else if (controller2.getLeftBumper())   {
            rotationArmSubsystem.goTo(0.291);
            wristSubsystem.goTo(0.3794);
        }
        else    {
            rotationArmSubsystem.stop();
            wristSubsystem.stop();
        }
    }
    
}