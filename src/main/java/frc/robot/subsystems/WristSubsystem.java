package frc.robot.subsystems;

//import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase{

    CANSparkFlex wristMotor;
    DutyCycleEncoder wristEncoder;
    private final double rangeOffset = 0.03;

    public WristSubsystem() {
        wristMotor = new CANSparkFlex(25, MotorType.kBrushless);
        wristEncoder = new DutyCycleEncoder(1);
    }

    public void goTo(double encoderGoal, double extremaValue)  {
        if (encoderGoal > extremaValue && wristEncoder.get() < encoderGoal - rangeOffset)   {
            this.goDown();
        }
        else if (encoderGoal > extremaValue && wristEncoder.get() > encoderGoal + rangeOffset)    {
            this.goUp();
        }
        else if (encoderGoal < extremaValue && wristEncoder.get() > encoderGoal + rangeOffset)  {
            this.goUp();
        }
        else if (encoderGoal < extremaValue && wristEncoder.get() < encoderGoal - rangeOffset)  {
            this.goDown();
        }
        else    {
            this.stop();
        }
    }

    public boolean wentTo(double encoderGoal, double extremaValue)  {
        if (encoderGoal > extremaValue && wristEncoder.get() < encoderGoal - rangeOffset)   {
            this.goDown();
            return false;
        }
        else if (encoderGoal > extremaValue && wristEncoder.get() > encoderGoal + rangeOffset)    {
            this.goUp();
            return false;
        }
        else if (encoderGoal < extremaValue && wristEncoder.get() > encoderGoal + rangeOffset)  {
            this.goUp();
            return false;
        }
        else if (encoderGoal < extremaValue && wristEncoder.get() < encoderGoal - rangeOffset)  {
            this.goDown();
            return false;
        }
        else    {
            this.stop();
            return true;
        }
    }

    public void goUp()   {
        wristMotor.set(-.2);
    }

    public void goDown()    {
        wristMotor.set(.2);
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