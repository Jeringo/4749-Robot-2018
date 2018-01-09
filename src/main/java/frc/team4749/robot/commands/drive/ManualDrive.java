package frc.team4749.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.team4749.robot.Robot;

public class ManualDrive extends Command {

    public ManualDrive(){
        requires(Robot.dt);
    }

    protected void initialize() {
        Robot.dt.setManual();
        System.out.println("DT set to regular speed");
    }

    protected void execute() {
        Robot.dt.manualDrive();
    }

    protected boolean isFinished() {
        return false;
    }

}
