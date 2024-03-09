package frc.robot.subsystems;

//import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase   {
    CANSparkFlex wristMotor;
    DutyCycleEncoder wristEncoder;
    private final double rangeOffset = 0.03;
    private final double encoderOffset = 0.3;

    public WristSubsystem() {
        wristMotor = new CANSparkFlex(25, MotorType.kBrushless);
        wristEncoder = new DutyCycleEncoder(1);
    }

    public void goTo(double encoderGoal, double extremaValue)  {
        if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1)   {
            this.goDown();
        }
        else if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1)    {
            this.goUp();
        }
        else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1)  {
            this.goUp();
        }
        else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1)  {
            this.goDown();
        }
        else    {
            this.stop();
        }
    }

    public boolean wentTo(double encoderGoal, double extremaValue)  {
        if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1)   {
            this.goDown();
            return false;
        }
        else if ((encoderGoal + encoderOffset) % 1 > (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1)    {
            this.goUp();
            return false;
        }
        else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 > (encoderGoal + rangeOffset + encoderOffset) % 1)  {
            this.goUp();
            return false;
        }
        else if ((encoderGoal + encoderOffset) % 1 < (extremaValue + encoderOffset) % 1 && (wristEncoder.get() + encoderOffset) % 1 < (encoderGoal - rangeOffset + encoderOffset) % 1)  {
            this.goDown();
            return false;
        }
        else    {
            this.stop();
            return true;
        }
    }

    public void goUp()   {
        wristMotor.set(-.1);
    }

    public void goDown()    {
        wristMotor.set(.1);
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

    @Override
    public void periodic()  {
        SmartDashboard.putNumber("Wrist Encoder", (wristEncoder.getAbsolutePosition()));
    }
}