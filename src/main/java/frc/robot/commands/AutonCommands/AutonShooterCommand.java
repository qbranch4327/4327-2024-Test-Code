package frc.robot.commands.AutonCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class AutonShooterCommand extends Command {
    
    ShooterSubsystem shooterSubsystem; 
    Timer timer;
    
    public AutonShooterCommand(ShooterSubsystem shooterSubsystem)  {
        this.shooterSubsystem = shooterSubsystem;
        timer = new Timer();
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize()   {
        timer.restart();
    }

    @Override
    public void execute()   {
        shooterSubsystem.shooterOn();
    }

    @Override
    public boolean isFinished()    {
        if (timer.get() >= 15)  {
            return false;
        }
        return true;
    }

}
