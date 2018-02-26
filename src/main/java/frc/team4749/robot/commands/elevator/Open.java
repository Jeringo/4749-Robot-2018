package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Open extends Command {

    public Open(){
        //requires(Robot.grabber);
    }

    protected void initialize(){
        Robot.elevator.open();
    }

    protected void end(){
        Robot.elevator.close();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}