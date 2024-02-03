package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    
    CANSparkFlex intakeMotor;

    public IntakeSubsystem()    {
        intakeMotor = new CANSparkFlex(22, MotorType.kBrushless);
        intakeMotor.setInverted(true);
    }

    public void intakeOn(boolean forward)  {
        if (forward)    {
            intakeMotor.set(-.4);
        }
        else {
            intakeMotor.set(.1);
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