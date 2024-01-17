package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;

public class ExampleCommand extends Command {

    Swerve swerve;

    public ExampleCommand(Swerve swerve)    {
        this.swerve = swerve;
    }

    @Override
    public void execute(){
        System.out.println("execute");
        swerve.xStance();
    }
}