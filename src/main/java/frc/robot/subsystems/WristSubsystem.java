package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;

public class WristSubsystem extends SubsystemBase{

    CANSparkMax wristMotor;
    DutyCycleEncoder wristEncoder;


    public WristSubsystem() {
        wristMotor = new CANSparkMax(15, MotorType.kBrushless);
        wristEncoder =new DutyCycleEncoder(1);
    }


    public void goRight(){
        wristMotor.set(.5);
    }

    public void goRight(double angle){
        if (wristEncoder.getDistance() < angle)   {
            wristMotor.set(0.5);
        }
        else if (wristEncoder.getDistance() > angle)   {
            wristMotor.stopMotor();
        }
    }  

    public void goLeft(double angle){
        if (wristEncoder.getDistance() < angle)   {
            wristMotor.set(-0.5);
        }
        else if (wristEncoder.getDistance() > angle)   {
            wristMotor.stopMotor();
        }
    }  

    public void goLeft(){
        wristMotor.set(-.5);
    }

    public boolean encoderCheck(double distance){
        if (wristEncoder.getAbsolutePosition() == distance)  {
            return true;
        }
        return false;
    }

    public void stop()  {
        wristMotor.stopMotor();
    }

}