package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class AutonIntakeCommand extends Command {
    IntakeSubsystem intakeSubsystem;
    RotationArmSubsystem rotationArmSubsystem;
    Timer timer;
    Swerve swerve;
    DigitalInput sensor;
    
    public AutonIntakeCommand(IntakeSubsystem intakeSubsystem, Swerve swerve, RotationArmSubsystem rotationArmSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.swerve = swerve;
        this.rotationArmSubsystem = rotationArmSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
        addRequirements(swerve);
        addRequirements(rotationArmSubsystem);
    }

    @Override
    public void execute()   {
        intakeSubsystem.intakeOn(true);
        swerve.goForward();
    }

    @Override
    public boolean isFinished() {
        if (sensor.get())   {
            intakeSubsystem.intakeOff();
            swerve.stop();
            rotationArmSubsystem.goToShoot();
            return true;
        }
        return false;
    }
}