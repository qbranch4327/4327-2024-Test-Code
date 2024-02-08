package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.RotationArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.WristSubsystem;

public class AutonArmCommand extends Command    {
    
    RotationArmSubsystem rotationArmSubsystem;
    WristSubsystem wristSubsystem;
    IntakeSubsystem intakeSubsystem;
    ShooterSubsystem shooterSubsystem;
    Timer timer;
    Swerve swerve;

    public AutonArmCommand(RotationArmSubsystem rotationArmSubsystem, Swerve swerve, WristSubsystem wristSubsystem, IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.swerve = swerve;
        this.wristSubsystem = wristSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        timer = new Timer();
        addRequirements(swerve);
        addRequirements(rotationArmSubsystem);
        addRequirements(wristSubsystem);
        addRequirements(intakeSubsystem);
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute()   {
        if (rotationArmSubsystem.wentTo(0.291) && wristSubsystem.wentTo(0.367, 0.1)) {
            swerve.goForward();
            intakeSubsystem.intakeOn(true);
        }
    }

    @Override
    public boolean isFinished() {
        if (!intakeSubsystem.sensor.get())   {
            swerve.stop();
            intakeSubsystem.intakeOff();
            if (rotationArmSubsystem.wentTo(0.043) && wristSubsystem.wentTo(0.367, 0.1))    {
                intakeSubsystem.intakeOn(true);
                if (!shooterSubsystem.sensor.get())   {
                    intakeSubsystem.intakeOff();
                }
                return true;
            }
        }
        return false;
    }

}