package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Eject extends Command {

    public Eject(){
        //requires(Robot.grabber);
    }

    protected void initialize(){
        Robot.grabber.eject();
    }

    protected void end(){
        Robot.grabber.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}