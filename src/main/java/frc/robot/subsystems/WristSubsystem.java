package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase{

    CANSparkMax wristMotor;
    DutyCycleEncoder wristEncoder;
    private final double encoderOffset = 0.24;
    private final double rangeOffset = 0.03;

    public WristSubsystem() {
        wristMotor = new CANSparkMax(15, MotorType.kBrushless);
        wristEncoder =new DutyCycleEncoder(1);
    }

    public void goTo(double degrees)  {
        if ((wristEncoder.getAbsolutePosition() + encoderOffset) % 1 > (degrees + rangeOffset + encoderOffset) % 1) {
            this.goUp();
        }
        else if ((wristEncoder.getAbsolutePosition() + encoderOffset) % 1 < (degrees - rangeOffset + encoderOffset) % 1) {
            this.goDown();
        }
        else    {
            this.stop();
        }
    }

    public void goUp()   {
        wristMotor.set(.5);
    }

    public void goDown()    {
        wristMotor.set(-.5);
    }

    public void stop()  {
        wristMotor.stopMotor();
    }

    public boolean encoderCheck(double distance)    {
        if (wristEncoder.getAbsolutePosition() == distance)  {
            return true;
        }
        return false;
    }

}