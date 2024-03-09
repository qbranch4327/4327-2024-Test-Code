package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class AutonDriveCommand extends Command  {
    
    Swerve swerve;
    IntakeSubsystem intakeSubsystem;
    Timer timer;
    boolean isItFinished;
    boolean wentForward;
    double time;

    public AutonDriveCommand(Swerve swerve, IntakeSubsystem intakeSubsystem)  {
        this.swerve = swerve;
        this.intakeSubsystem = intakeSubsystem;
        timer = new Timer();
        addRequirements(swerve);
    }

    @Override
    public void initialize() {
        timer.restart();
        swerve.zeroGyro();
        isItFinished = false;
        wentForward = false;
    }

    @Override
    public void execute() {
        if (intakeSubsystem.sensor.get() && timer.get() < 1)   {
            swerve.drive(false);
            intakeSubsystem.intakeOn(true);
        }
        else    {
            swerve.drive(true);
            intakeSubsystem.intakeOff();
            if (!wentForward)    {
                wentForward = true;
                time = timer.get();
                timer.restart();
            }
            if (timer.get() > time)   
            {
                swerve.stop();
                isItFinished = true;
            }
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}
