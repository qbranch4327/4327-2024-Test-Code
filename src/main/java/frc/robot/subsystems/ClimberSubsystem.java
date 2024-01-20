package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

    private CANSparkMax climberMotor;


    public ClimberSubsystem(){
        climberMotor = new CANSparkMax(0, MotorType.kBrushless);
    }

    
    public void goUp()  {
        climberMotor.set(-1);
    }
    
    public void goDown(){
        climberMotor.set(0.5);
    }

    public void stop()    {
        climberMotor.stopMotor();
    }

}