package org.usfirst.frc.team4749.robot.commands.brake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class Brake extends Command {

    public Brake(){
        requires(Robot.dt);
    }

    protected void initialize(){
        Robot.dt.stop();
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return true;
    }

}
