package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RotationArmSubsystem extends SubsystemBase{
    
    CANSparkMax armMotor;
    DutyCycleEncoder armEncoder;
    private final double holdingPwr = 0;

    public RotationArmSubsystem()   {
        armMotor = new CANSparkMax(24, MotorType.kBrushless);
        armEncoder = new DutyCycleEncoder(10);
    }

    public void goUp(double degrees)  {
        if (armEncoder.getAbsolutePosition() < degrees) {
            this.goUp();
        }
        else    {
            armMotor.set(holdingPwr);
        }
    }

    public void goDown(double degrees) {
        if (armEncoder.getAbsolutePosition() > degrees) {
            this.goDown();
        }
        else    {
            armMotor.set(holdingPwr);
        }
    }

    public void goTo(double degrees)  {
        if (armEncoder.getAbsolutePosition() < degrees) {
            this.goUp();
        }
        else if (armEncoder.getAbsolutePosition() > degrees) {
            this.goDown();
        }
    }

    public void goUp() {
        armMotor.set(0.8);
    }

    public void goDown()    {
        armMotor.set(-0.5);
    }

    public boolean encoderCheck(double distance){
        if (armEncoder.getAbsolutePosition() == distance)  {
            return true;
        }
        return false;
    }

}