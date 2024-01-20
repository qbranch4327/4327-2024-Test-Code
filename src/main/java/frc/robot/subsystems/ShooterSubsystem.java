package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    CANSparkFlex shooterMotor1;
    CANSparkFlex shooterMotor2;
    Servo shooterServo;


    public ShooterSubsystem()    {
        shooterMotor1 = new CANSparkFlex(0,  null);
        shooterMotor2 = new CANSparkFlex(1, null);
        shooterServo = new Servo(0);
    }


    public void shooterOn() {
        shooterMotor1.set(1);
        shooterMotor2.set(1); 
    }

    public void stop()    {
        shooterMotor1.stopMotor();
        shooterMotor2.stopMotor();
    }

    public void shoot()   {
        shooterServo.set(1);
    }

    public void resetServo()  {
        shooterServo.set(0);
    }
}