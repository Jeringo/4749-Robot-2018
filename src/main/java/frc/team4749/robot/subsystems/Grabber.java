package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4749.robot.RobotMap;

public class Grabber extends Subsystem implements RobotMap {

    private static Grabber instance;
    private WPI_TalonSRX grabber, grabber2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Grabber()
    {
        grabber = new WPI_TalonSRX(GRABBER);
        grabber2 = new WPI_TalonSRX(GRABBER_2);
        grabber2.configOpenloopRamp(0,0);

        // TODO - make this motor controller brake instead of coast
    }

    public void intake(){
        grabber.set(GRABBER_SPEED * -1);
        grabber2.set(GRABBER_SPEED * SECONDARY_SPEED);
    }

    public void eject(){
        grabber.set(GRABBER_SPEED * RELEASE_MODIFIER * -1);
        grabber2.set(GRABBER_SPEED * RELEASE_MODIFIER * SECONDARY_SPEED);
    }

    public void stop(){
        grabber.set(0);
        grabber2.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}