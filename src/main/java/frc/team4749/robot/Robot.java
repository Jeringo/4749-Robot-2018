package frc.team4749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4749.robot.subsystems.*;

public class Robot extends IterativeRobot {

    public static Climber climber;
    public static Grabber grabber;
    public static Elevator elevator;
    public static Ejector ejector;
    public static DriveTrain driveTrain;

    public static OI oi;
    
    @Override
    public void robotInit() { // runs once before robotPeriodic when the robot is turned on
        climber = new Climber();
        grabber = new Grabber();
        elevator = new Elevator();
        ejector = new Ejector();
        driveTrain = new DriveTrain();

        oi = new OI();
    }

    public Climber getClimber() {
        return climber;
    }
    public Grabber getGrabber() {
        return grabber;
    }
    public Elevator getElevator() {
        return elevator;
    }
    public Ejector getEjector() {
        return ejector;
    }
    public DriveTrain getDriveTrain() {
        return driveTrain;
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
        //autonomousCommand = new StraightAuto();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        //if (autonomousCommand != null)
        //    autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic() { // runs is a loop while the robot is in autonomous mode
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // runs once before teleopPeriodic after teleop mode is started
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null)
        //    autonomousCommand.cancel();
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
