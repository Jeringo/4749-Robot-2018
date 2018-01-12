package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Eject extends Command {

    public Eject(){
        //requires(Robot.ejector);
    }

    protected void initialize(){
        Robot.ejector.eject();
    }

    protected void end(){
        Robot.ejector.reset();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}