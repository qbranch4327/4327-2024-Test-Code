package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;


public class ClimberCommand extends CommandBase {

    ClimberSubsystem climberSubsystem;
    XboxController controller2;


    public ClimberCommand(ClimberSubsystem climberSubsystem,XboxController controller2){
        this.climberSubsystem = climberSubsystem;
        this.controller2 = controller2;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute(){
        if (controller2.getYButton()) {
            climberSubsystem.goUp();
        }
        else if (controller2.getAButton()){
            climberSubsystem.goDown();
        }
        else {
            climberSubsystem.stop();
        }
    }


}