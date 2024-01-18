package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;

public class WristCommand extends CommandBase   {

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
            wristSubsystem.goLeft(0);
        }
        else if (controller2.getBButton())  {
            wristSubsystem.goRight(180);
        }
    }

}
