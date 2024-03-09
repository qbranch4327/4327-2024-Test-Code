package frc.robot.subsystems;


import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RotationArmSubsystem extends SubsystemBase{
    CANSparkFlex armMotor;
    DutyCycleEncoder armEncoder;
    private final double encoderOffset = 0.2;
    private final double rangeOffset = 0.02;

    public RotationArmSubsystem()   {
        armMotor = new CANSparkFlex(23, MotorType.kBrushless);
        armEncoder = new DutyCycleEncoder(0);
    }

    public void goTo(double degrees)  {
        var position = (armEncoder.getAbsolutePosition() + encoderOffset) % 1;
        
        if (position > (degrees + rangeOffset + encoderOffset) % 1) {
            this.goUp(0.9);
        }
        else if (position < (degrees - rangeOffset + encoderOffset) % 1) {
            this.goDown(0.9);
        }
        else    {
            this.stop();
        }
    }

    public boolean wentTo(double degrees)  {
        var pos = (armEncoder.getAbsolutePosition() + encoderOffset) % 1;
        var target = (degrees + rangeOffset + encoderOffset) % 1;
        System.out.println("position: " + pos + ", target: " + target);
        if (pos > target) {
            this.goUp(0.5);
            return false;
        }
        else if ((armEncoder.getAbsolutePosition() + encoderOffset) % 1 < (degrees - rangeOffset + encoderOffset) % 1) {
            this.goDown(0.9);
            return false;
        }
        else    {
            this.stop();
            return true;
        }
    }

    public void goUp(double speed) {
        // PIDController pid = new PIDController(0, 0, 0);
        // pid.setTolerance(posTolerance, velocityTolerance);
        // var pidSpeed = pid.calculate(armEncoder.getAbsolutePosition(), setpoint);
        armMotor.set(speed);
    }

    public void goDown(double speed)    {
        armMotor.set(-speed);
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