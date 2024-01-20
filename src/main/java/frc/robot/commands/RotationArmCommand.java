package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class RotationArmCommand extends CommandBase {
    
    RotationArmSubsystem rotationArmSubsystem;
    XboxController controller2;
    boolean commandScheduled;


    public RotationArmCommand(RotationArmSubsystem rotationArmSubsystem, XboxController controller2)    {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.controller2 = controller2;
    }


    @Override
    public void execute()   {
        if (controller2.getAButton())   {
            commandScheduled = true;
            if (commandScheduled)   {
                boolean doInterrupt = rotationArmSubsystem.goToShoot();
                if (doInterrupt)    {
                    commandScheduled = false;
                }
            }
        }
        else if (controller2.getYButton()) {
            commandScheduled = true;
            if (commandScheduled)   {
                boolean doInterrupt = rotationArmSubsystem.goToAmp();
                if (doInterrupt)    {
                    commandScheduled = false;
                }
            }
        }
        else if (controller2.getLeftBumper())   {
            commandScheduled = true;
            if (commandScheduled)   {
                boolean doInterrupt = rotationArmSubsystem.goToGround();
                if (doInterrupt)    {
                    commandScheduled = false;
                }
            }
        }
    }
}