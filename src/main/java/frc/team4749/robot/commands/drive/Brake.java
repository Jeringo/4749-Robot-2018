package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Brake extends Command {

    public Brake(){
        requires(Robot.driveTrain);
    }

    protected void initialize(){
        Robot.driveTrain.stop();
    }

    protected void end(){
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
