package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

    private TalonFX climberMotor;


    public ClimberSubsystem(){
        climberMotor = new TalonFX(40);
    }

    
    public void goUp()  {
        climberMotor.set(ControlMode.PercentOutput, -1);
    }
    
    public void goDown(){
        climberMotor.set(ControlMode.PercentOutput, 0.5);
    }

    public void stop()    {
        climberMotor.set(ControlMode.PercentOutput, 0);
    }

}