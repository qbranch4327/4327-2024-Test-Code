package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;

public class WristCommand extends Command   {

    WristSubsystem wristSubsystem;
    XboxController controller2;

    public WristCommand(WristSubsystem wristSubsystem,XboxController controller2)   {
        this.controller2 = controller2;
        this.wristSubsystem = wristSubsystem;
        addRequirements(wristSubsystem);
    }


    @Override
    public void execute()   {
        if (controller2.getXButton())   {
            wristSubsystem.goTo(0);
        }
        else if (controller2.getBButton())  {
            wristSubsystem.goTo(0);
        }
        else    {
            wristSubsystem.stop();
        }
    }

}