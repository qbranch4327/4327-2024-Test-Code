package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RotationArmSubsystem;
import frc.robot.subsystems.Swerve;

public class AutonArmCommand extends Command    {
    
    RotationArmSubsystem rotationArmSubsystem;
    Timer timer;
    Swerve swerve;
    DigitalInput sensor;

    public AutonArmCommand(RotationArmSubsystem rotationArmSubsystem, Swerve swerve) {
        this.rotationArmSubsystem = rotationArmSubsystem;
        this.swerve = swerve;
        timer = new Timer();
        addRequirements(swerve);
        addRequirements(rotationArmSubsystem);
    }

    @Override
    public void execute()   {
        if (rotationArmSubsystem.wentTo(0.291)) {
            
        }
    }

    @Override
    public boolean isFinished() {
        if (sensor.get())   {
            swerve.stop();
            rotationArmSubsystem.goTo(0.291);
            return true;
        }
        return false;
    }

}