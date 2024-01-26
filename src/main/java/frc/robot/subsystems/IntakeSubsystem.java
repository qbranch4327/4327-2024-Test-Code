package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    CANSparkMax intakeMotor;

    public IntakeSubsystem()    {
        intakeMotor = new CANSparkMax(41, MotorType.kBrushless);
        intakeMotor.setInverted(true);
    }

    public void intakeOn(boolean forward)  {
        if (forward)    {
            intakeMotor.set(1);
        }
        else {
            intakeMotor.set(-.5);
        }
    }
    
    public void intakeOff() {
        intakeMotor.stopMotor();
    }


    public void intakeSlow(boolean forward)  {
        if (forward)    {
            intakeMotor.set(.3);
        }
    }

}