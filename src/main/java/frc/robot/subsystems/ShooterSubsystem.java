package frc.robot.subsystems;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    
    CANSparkFlex shooterMotor1;
    CANSparkFlex shooterMotor2;
    PWM shooterServo;
    public DigitalInput sensor;


    public ShooterSubsystem()    {
        shooterMotor1 = new CANSparkFlex(20, MotorType.kBrushless);
        shooterMotor2 = new CANSparkFlex(21, MotorType.kBrushless);
        shooterServo = new PWM(0);
        sensor = new DigitalInput(2);
    }


    public void shooterOn() {
        shooterMotor1.set(-1);
        shooterMotor2.set(-1); 
    }

    public void stop()    {
        shooterMotor1.stopMotor();
        shooterMotor2.stopMotor();
    }

    public void shoot()   {
        shooterServo.setSpeed(1);
    }

    public void resetServo()  {
        shooterServo.setSpeed(0);
    }

   @Override
   public void periodic()  {
       SmartDashboard.putBoolean("Sensor", sensor.get());
   }
}