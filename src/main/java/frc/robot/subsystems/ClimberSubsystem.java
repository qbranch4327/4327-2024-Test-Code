package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

    private TalonFX climberMotor;


    public ClimberSubsystem(){
        climberMotor = new TalonFX(40);
    }
    
    public void goUp()  {
        climberMotor.set(0.5);
    }
    
    public void goDown(){
        climberMotor.set(-1);
    }

    public void stop()    {
        climberMotor.set(0);
    }

}