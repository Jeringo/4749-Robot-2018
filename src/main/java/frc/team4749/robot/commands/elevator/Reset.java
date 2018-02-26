package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Reset extends Command {

    public Reset(){
        //requires(Robot.grabber);
    }

    protected void initialize(){
        Robot.elevator.reset();
    }

    protected void end(){

    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}