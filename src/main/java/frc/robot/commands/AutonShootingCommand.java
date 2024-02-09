package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class AutonShootingCommand extends Command {
    
    ShooterSubsystem shooterSubsystem; 
    
    public AutonShootingCommand(ShooterSubsystem shooterSubsystem)  {
        this.shooterSubsystem = shooterSubsystem;
    }

    @Override
    public void execute()   {
        shooterSubsystem.shooterOn();
        shooterSubsystem.shoot();
    }

}
