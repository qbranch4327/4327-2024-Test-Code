package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class LEDCommand extends Command {
    LEDSubsystem ledSubsystem;
    ShooterSubsystem shooterSubsystem;
    IntakeSubsystem intakeSubsystem;
    XboxController controller2;

    public LEDCommand(LEDSubsystem ledSubsystem, XboxController controller2, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem)    {
        this.ledSubsystem = ledSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.controller2 = controller2;
        addRequirements(ledSubsystem);
    }
    
    @Override
    public void execute()   {
        if (!shooterSubsystem.sensor.get()) {
            ledSubsystem.set(0.73);
        }
        // else if (!intakeSubsystem.sensor.get()) {
        //     ledSubsystem.set(0.65);
        // }
        else    {
            ledSubsystem.set(0.57);
        }
    }
}