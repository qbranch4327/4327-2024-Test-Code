package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class RotationArmCommand extends Command {
    
    RotationArmSubsystem rotationArmSubsystem;
    XboxController controller2;


    public RotationArmCommand(RotationArmSubsystem rotationArmSubsystem, XboxController controller2)    {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.controller2 = controller2;
    }


    @Override
    public void execute()   {
        if (controller2.getAButton())   {
            rotationArmSubsystem.goUp();
        }
        else if (controller2.getYButton()) {
            rotationArmSubsystem.goDown();;
        }
        else if (controller2.getLeftBumper())   {
            rotationArmSubsystem.goDown();
        }
        else    {
            rotationArmSubsystem.stop();
        }
    }
    
}