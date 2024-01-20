package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class IntakeCommand extends Command {
    
    IntakeSubsystem intakeSubsystem;
    Joystick controller1;
    XboxController controller2;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, XboxController controller2, Joystick controller1)  {
        this.intakeSubsystem = intakeSubsystem;
        this.controller1 = controller1;
        this.controller2 = controller2;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute()   {
        if (controller1.getRawButton(6)) {
            intakeSubsystem.intakeOn(true);
        }
        else if (controller2.getRightBumper())   {
            intakeSubsystem.intakeOn(true);
         }
        else if (controller2.getLeftY() < -.2){
            intakeSubsystem.intakeSlow(true);
        }
        else if (controller2.getLeftY() > .2){
            intakeSubsystem.intakeOn(false);
        }
        else    {
          intakeSubsystem.intakeOff();
        }
    }

}