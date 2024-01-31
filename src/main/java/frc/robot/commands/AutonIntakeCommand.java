package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RotationArmSubsystem;
import frc.robot.subsystems.Swerve;

public class AutonIntakeCommand extends Command {

    IntakeSubsystem intakeSubsystem;
    RotationArmSubsystem rotationArmSubsystem;
    Timer timer;
    Swerve swerve;
    DigitalInput intakeSensor;
    DigitalInput shooterSensor;
    
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
        if (intakeSensor.get())   {
            intakeSubsystem.intakeOff();
            swerve.stop();
            if  (rotationArmSubsystem.wentTo(0.033))   {
                intakeSubsystem.intakeOn(true);
                if (shooterSensor.get()) {
                    intakeSubsystem.intakeOff();
                    return true;
                }
            }
        }
        return false;
    }
}