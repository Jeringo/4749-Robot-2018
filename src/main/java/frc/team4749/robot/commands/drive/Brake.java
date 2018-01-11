package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Brake extends Command {

    public Brake(){
        requires(Robot.dt);
    }

    protected void initialize(){
        // TODO - Hook up these commands
    }

    protected void end(){
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
