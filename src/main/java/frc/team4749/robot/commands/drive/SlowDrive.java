package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;
import frc.team4749.robot.RobotMap;

public class SlowDrive extends Command {

    public SlowDrive(){
        //requires(Robot.driveTrain);
    }

    protected void initialize(){
        Robot.driveTrain.setSpeed(RobotMap.DRIVE_SLOW);
    }

    protected void end(){
        Robot.driveTrain.setSpeed(RobotMap.DRIVE_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}