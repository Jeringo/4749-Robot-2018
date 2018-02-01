package frc.team4749.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.Robot;

public class ManualElevator extends Command {

    public ManualElevator(){
        requires(Robot.elevator);
    }

    protected void initialize() {
        Robot.elevator.setManual();
        System.out.println("Elevator set to manual speed");
    }

    protected void execute() {
        Robot.elevator.manualControl(Robot.oi.getController());
    }

    protected void end() {
        Robot.driveTrain.stop();
    }

    protected void interrupted() {
        end();
    }

    protected boolean isFinished() {
        return false;
    }

}
