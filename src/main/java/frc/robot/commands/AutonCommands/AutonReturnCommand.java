package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Swerve;

public class AutonReturnCommand extends Command {
    
    Swerve swerve;
    Timer timer;
    boolean isItFinished;

    public AutonReturnCommand(Swerve swerve)    {
        this.swerve = swerve;
        addRequirements(swerve);
        timer = new Timer();
    }

    @Override
    public void initialize() {
        timer.restart();
        isItFinished = false;
    }

    @Override
    public void execute() {
        swerve.drive(true);
        if (timer.get() > .5)    {
            isItFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}
