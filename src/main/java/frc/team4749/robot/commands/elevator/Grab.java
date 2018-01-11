package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Grab extends Command {

    public Grab(){
        requires(Robot.grabber);
    }

    protected void initialize(){
        Robot.grabber.grab();
    }

    protected void end(){
        Robot.grabber.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}