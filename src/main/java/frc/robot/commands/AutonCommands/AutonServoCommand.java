package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class AutonServoCommand extends Command  {

    ShooterSubsystem shooterSubsystem;
    Timer timer;

    public AutonServoCommand(ShooterSubsystem shooterSubsystem)   {
        this.shooterSubsystem = new ShooterSubsystem();
        timer = new Timer();
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize()    {
        timer.restart();
    }

    @Override
    public void execute()   {
        shooterSubsystem.shoot();
    }

    @Override
    public boolean isFinished() {
        if (timer.get() >= 3) {
            return true;
        }
        return false;
    }
    
}
