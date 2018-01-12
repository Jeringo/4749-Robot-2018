package frc.team4749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.subsystems.*;

public class Robot extends IterativeRobot {

    public static Climber climber = new Climber();
    public static Grabber grabber = new Grabber();
    public static Elevator elevator = new Elevator();
    public static Ejector ejector = new Ejector();
    public static DriveTrain driveTrain = new DriveTrain();

    public static OI oi = new OI();
    
    @Override
    public void robotInit() { // runs once before robotPeriodic when the robot is turned on
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
