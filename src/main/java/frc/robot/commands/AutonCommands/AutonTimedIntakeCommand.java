package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class AutonTimedIntakeCommand extends Command {
    
    IntakeSubsystem intakeSubsystem;
    Timer timer;

    public AutonTimedIntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }
    
    @Override
    public void execute()   {
        intakeSubsystem.intakeOn(true);
    }

    @Override
    public boolean isFinished() {
        if (timer.get() >= 2)  {
            intakeSubsystem.intakeOff();
            return true;
        }
        return false;
    }

}
