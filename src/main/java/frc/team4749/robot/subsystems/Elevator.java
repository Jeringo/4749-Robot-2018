package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4749.robot.Controller;
import frc.team4749.robot.OI;
import frc.team4749.robot.RobotMap;

public class Elevator extends Subsystem implements RobotMap {

    private static Elevator instance;
    private WPI_TalonSRX elevator;
    private Controller controller;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static Elevator getInstance()
    {
        if (instance == null)
        {
            instance = new Elevator();
        }
        return instance;
    }
    private Elevator()
    {
        elevator = new WPI_TalonSRX(ELEVATOR);

        controller = OI.getInstance().getController();
        // TODO - make this motor controller brake instead of coast
    }

    //Talon Mode change functions
    public void setAuto(){
        resetPos();

        System.out.println("elevator set to autonomous");
    }

    public void setManual(){
        System.out.println("elevator set to manual");
    }


    // Basic Teleop Functions
    public void manualControl(){
        double rightYAxis = controller.getRY();
        rightYAxis = (rightYAxis < 0) ? rightYAxis * LOWER_MODIFIER : rightYAxis;
        rightYAxis = rightYAxis * ELEVATOR_SPEED;
        elevator.set(rightYAxis);
    }

    // Support functions
    public void stop(){
        elevator.set(0);
    }

    public void resetPos() {
        System.out.println("elevator Talon position reset");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}
