package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;
import frc.team4749.robot.RobotMap;

public class FastDrive extends Command {

    public FastDrive(){
        //requires(Robot.driveTrain);
    }

    protected void initialize(){
        Robot.driveTrain.setSpeed(RobotMap.FAST_MODIFIER);
    }

    protected void end(){
        Robot.driveTrain.setSpeed(RobotMap.DRIVE_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}