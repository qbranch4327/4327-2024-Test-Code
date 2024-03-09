package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RotationArmSubsystem;
import frc.robot.subsystems.WristSubsystem;

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
        if (controller2.getXButton())   {
            wristSubsystem.goUp();
        }
        else if (controller2.getBButton())  {
            wristSubsystem.goDown();
        }
        else if (controller2.getAButton())   {
            rotationArmSubsystem.goTo(0.04);
            wristSubsystem.goTo(0.055, 0.78);
        }
        else if (controller2.getYButton()) {
            rotationArmSubsystem.goTo(0.96);
            wristSubsystem.goTo(0.79, 0.367);
        }
        else if (controller2.getLeftBumper())   {
            rotationArmSubsystem.goTo(0.24); 
            wristSubsystem.goTo(0.057, 0.78);
        }
        else if (controller2.getStartButton())  {
            rotationArmSubsystem.goTo(0.058);
            wristSubsystem.goTo(0.027, 0.78);
        }
        else    {
            rotationArmSubsystem.stop();
            wristSubsystem.stop();
        }
    }
    
}