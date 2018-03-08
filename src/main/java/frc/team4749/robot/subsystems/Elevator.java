package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.Controller;
import frc.team4749.robot.OI;
import frc.team4749.robot.Robot;
import frc.team4749.robot.RobotMap;
import frc.team4749.robot.commands.elevator.ManualElevator;

public class Elevator extends Subsystem implements RobotMap {

    private static Elevator instance;
    private WPI_TalonSRX elevator;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Elevator()
    {
        elevator = new WPI_TalonSRX(ELEVATOR);
        // TODO - make this motor controller brake instead of coast
        elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

        this.close();
        elevator.setSelectedSensorPosition(0,0,0);
        elevator.configForwardSoftLimitEnable(true, 0);
        elevator.configReverseSoftLimitEnable(true, 0);
        elevator.configForwardSoftLimitThreshold(100, 0);
        elevator.configReverseSoftLimitThreshold(-20900, 0);
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
    public void manualControl(Controller controller){
        double rightYAxis = controller.getRY();
        rightYAxis = (rightYAxis < 0) ? rightYAxis * LOWER_MODIFIER : rightYAxis;
        rightYAxis = rightYAxis * ELEVATOR_SPEED;
        elevator.set(rightYAxis);

        SmartDashboard.putNumber("Elevator Position", this.getEncoderPosition());
    }

    //Basic Auto functions
    public void autoRaise(double time){
        elevator.set(AUTO_RAISE_SPEED);
        Timer.delay(time);
        this.stop();
    }

    public void autoLower(double time){
        elevator.set(AUTO_LOWER_SPEED);
        Timer.delay(time);
        this.stop();
    }

    // Support functions
    public void stop(){
        elevator.set(0);
    }

    public int getEncoderPosition(){
        return elevator.getSelectedSensorPosition(0);
    }

    public void setMax(){
        elevator.configForwardSoftLimitThreshold(this.getEncoderPosition(),0);
    }

    public void setMin(){
        elevator.configReverseSoftLimitThreshold(this.getEncoderPosition(), 0);
    }

    public void reset(){
        elevator.setSelectedSensorPosition(0,0,0);
    }

    public void open(){
        elevator.configForwardSoftLimitEnable(false, 0);
        elevator.configReverseSoftLimitEnable(false, 0);
    }

    public void close(){
        elevator.configForwardSoftLimitEnable(true, 0);
        elevator.configReverseSoftLimitEnable(true, 0);
    }

    public void resetPos() {
        System.out.println("elevator Talon position reset");
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualElevator());
    }

}
