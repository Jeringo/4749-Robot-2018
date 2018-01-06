/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4749.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team4749.robot.subsystems.Climber;
import frc.team4749.robot.subsystems.DriveTrain;

public class Robot extends IterativeRobot {


	public static OI oi;
	public static Climber climber;
	public static DriveTrain dt;

	@Override
	public void robotInit() { // runs once before robotPeriodic when the robot is turned on
		climber = Climber.getInstance();
		dt = DriveTrain.getInstance();

		oi = OI.getInstance();

		// chooser.addObject("My Auto", new MyAutoCommand());
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
	public void teleopInit() { // runs once before teleopPeriodic after teleop mode is started
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (autonomousCommand != null)
		//    autonomousCommand.cancel();
		dt.resetPos();
		dt.setManual();
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