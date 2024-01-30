package frc.robot.subsystems;


import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RotationArmSubsystem extends SubsystemBase{
    
    CANSparkFlex armMotor;
    DutyCycleEncoder armEncoder;
    private final double encoderOffset = 0.24;
    private final double rangeOffset = 0.03;

    public RotationArmSubsystem()   {
        armMotor = new CANSparkFlex(23, MotorType.kBrushless);
        armEncoder = new DutyCycleEncoder(0);
    }

    public void goTo(double degrees)  {
        if ((armEncoder.getAbsolutePosition() + encoderOffset) % 1 > (degrees + rangeOffset + encoderOffset) % 1) {
            this.goUp();
        }
        else if ((armEncoder.getAbsolutePosition() + encoderOffset) % 1 < (degrees - rangeOffset + encoderOffset) % 1) {
            this.goDown();
        }
        else    {
            this.stop();
        }
    }

    public void goUp() {
        armMotor.set(-0.5);
    }

    public void goDown()    {
        armMotor.set(0.5);
    }

    public void stop()  {
        armMotor.stopMotor();
    }

    public boolean encoderCheck(double distance){
        if (armEncoder.getAbsolutePosition() == distance)  {
            return true;
        }
        return false;
    }

    @Override
    public void periodic()  {
        SmartDashboard.putNumber("Arm Encoder", (armEncoder.getAbsolutePosition()));
        SmartDashboard.putNumber("Value", ((armEncoder.getAbsolutePosition() + encoderOffset) % 1));
    }

}