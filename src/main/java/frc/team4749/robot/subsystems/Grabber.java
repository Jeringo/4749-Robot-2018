package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4749.robot.RobotMap;

public class Grabber extends Subsystem implements RobotMap {

    private static Grabber instance;
    private WPI_TalonSRX grabber;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Grabber()
    {
        grabber = new WPI_TalonSRX(GRABBER);

        // TODO - make this motor controller brake instead of coast
    }

    public void grab(){
        grabber.set(GRABBER_SPEED);
    }

    public void release(){
        grabber.set(GRABBER_SPEED * RELEASE_MODIFIER);
    }

    public void stop(){
        grabber.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}