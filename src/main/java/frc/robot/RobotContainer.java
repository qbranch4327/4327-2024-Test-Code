package frc.robot;
import java.util.List;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.GoalEndState;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final XboxController driver2 = new XboxController(1);
    private final IntakeSubsystem iSub;
    private final WristSubsystem wSub;
    private final VisionSubsystem vSub;
    private final RotationArmSubsystem rSub;
    private final ClimberSubsystem cSub;
    private final ShooterSubsystem sSub;
    // private final BuddyBarSubsystem bSub;

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kRightX.value;
    private final int strafeAxis = XboxController.Axis.kRightTrigger.value;
    private final int rotationAxis = XboxController.Axis.kLeftX.value;
    Command vCommand;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kRightBumper.value);

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();

    /* Paths */
    //private final autoBuilder autoBuilder;
    // private static final String[] paths = {
    //     "Test Auto 2024 v2",
    //     "P Auto"
    //     };

    private final SendableChooser<Command> autoChooser;
    // SendableChooser<String> qChooser = new SendableChooser<>();

   

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        this.iSub = new IntakeSubsystem();
        this.wSub = new WristSubsystem();
        this.vSub = new VisionSubsystem();
        this.rSub = new RotationArmSubsystem();
        this.cSub = new ClimberSubsystem();
        this.sSub = new ShooterSubsystem();

        // this.bSub = new BuddyBarSubsystem();
        //this.vision = new VisionSubsystem();
        //this.autoBuilder = new autoBuilder(s_Swerve, iSub, sSub);

        // Automatically adds paths from the paths array. The path name at index 0 is set to the default.
        // autoChooser.setDefaultOption(paths[0], paths[0]);
        // for(int i = 1; i < paths.length; i++)  {
        //     autoChooser.addOption(paths[i], paths[i]);
        // }
        
        autoChooser = AutoBuilder.buildAutoChooser();
        SmartDashboard.putData("Auto Mode", autoChooser);


        iSub.setDefaultCommand(new IntakeCommand(iSub, driver2, driver));
        wSub.setDefaultCommand(new WristCommand(wSub, driver2));
        //vSub.setDefaultCommand(new VisionCommand);
        rSub.setDefaultCommand(new RotationArmCommand(rSub, driver2));
        cSub.setDefaultCommand(new ClimberCommand(cSub, driver2));
        sSub.setDefaultCommand(new ShooterCommand(sSub, driver2));

        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean(),
                driver
            )
        );

        //NamedCommands.registerCommand("ExampleCommand", new ExampleCommand(s_Swerve));

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        // zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        //String selection = autoChooser.getSelected();
        return autoChooser.getSelected();
    }
}