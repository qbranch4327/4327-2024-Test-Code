package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDSubsystem;

public class LEDCommand extends Command {
    LEDSubsystem ledSubsystem;
    XboxController controller2;

    public LEDCommand(LEDSubsystem ledSubsystem, XboxController controller2)    {
        this.ledSubsystem = ledSubsystem;
        this.controller2 = controller2;
        addRequirements(ledSubsystem);
    }
    
    @Override
    public void execute()   {
        if (controller2.getStartButton()) {
            ledSubsystem.set(0.07);
        }
        else    {
            ledSubsystem.set(0.57);
        }
    }
}
