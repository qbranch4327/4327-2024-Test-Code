package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class Auton180Command extends Command {

    Swerve swerve;
    double startingAngle;
    boolean isItFinished;

    public Auton180Command(Swerve swerve)   {
        this.swerve = swerve;
        addRequirements(swerve);
    }
    
    @Override
    public void initialize() {
        startingAngle = swerve.gyro.getAngle() % 360;
        isItFinished = false;
    }

    @Override
    public void execute() {
        if (!swerve.rotateTo((180 + startingAngle) % 360))   {
            isItFinished = false;
        }
        else    {
            swerve.stop();
            isItFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isItFinished;
    }

}