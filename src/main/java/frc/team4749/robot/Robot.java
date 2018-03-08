package frc.team4749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.subsystems.*;

public class Robot extends IterativeRobot {


    private static final String left = "Left";
    private static final String right = "Right";
    private static final String forward = "Forward";
    private static final String nothing = "Nothing";

    public static Climber climber = new Climber();
    public static Grabber grabber = new Grabber();
    public static Elevator elevator = new Elevator();
    public static DriveTrain driveTrain = new DriveTrain();

    public static OI oi = new OI();

    private boolean toggle = true;

    private SendableChooser<String> autoChooser = new SendableChooser<>();
    
    @Override
    public void robotInit() { // runs once before robotPeriodic when the robot is turned on
        autoChooser.addDefault("Default Forward Auto", forward);
        autoChooser.addObject("Left Auto", left);
        autoChooser.addObject("Right Auto", right);
        autoChooser.addObject("Nothing Auto", nothing);
        SmartDashboard.putData("Auto modes", autoChooser);
    }

    @Override
    public void disabledInit() { // runs once before disabledPeriodic after the robot is disabled

    }

    @Override
    public void disabledPeriodic() { // runs is a loop while the robot is disabled
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() { // runs once before autonomousPeriodic after autonomous mode is started
        String autoSelected = autoChooser.getSelected();
        // String autoSelected = SmartDashboard.getString("Auto Selector",
        // defaultAuto);
        System.out.println("Auto selected: " + autoSelected);

        // MotorSafety improves safety when motors are updated in loops
        // but is disabled here because motor updates are not looped in
        // this autonomous mode.
        driveTrain.setSaftey(false);

        switch (autoSelected) {
            case left:
                grabber.intake();
                driveTrain.autoForward(6.5);
                driveTrain.autoRotateR(4.0);
                driveTrain.autoForward(4.0);
                grabber.eject();
                break;
            case right:
                grabber.intake();
                driveTrain.autoForward(6.5);
                driveTrain.autoRotateL(4.0);
                driveTrain.autoForward(4.0);
                grabber.eject();
                break;
            case nothing:
                break;
            case forward:
            default:
                driveTrain.autoForward(4.0);
                break;
        }
    }

    @Override
    public void autonomousPeriodic() { // runs is a loop while the robot is in autonomous mode
        Scheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {
        // runs once before teleopPeriodic after teleop mode is started
        driveTrain.resetPos();
        driveTrain.setManual();
    }

    @Override
    public void teleopPeriodic() { // runs is a loop while the robot is in teleop mode
        Scheduler.getInstance().run();
    }


    @Override
    public void testInit() { // runs once before testPeriodic after test mode is started

    }

    @Override
    public void testPeriodic() { // runs is a loop while the robot is in test mode

    }
}
