package frc.robot.subsystems;

import com.ctre.phoenix.CANifier.LEDChannel;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    
    Spark LED;

    public LEDSubsystem()   {
        LED = new Spark(1);
    }

    public void slowFlash()     {
        LED.set(.03);
    }

    public void fastFlash()     {
        LED.set(0.07);
    }

    public void noteFlash()     {
        LED.set(0);
    }

    public void shotFlash()     {
        LED.set(0);
    }
    public void solid()     {
        LED.set(.57);
    }
}