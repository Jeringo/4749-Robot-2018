package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team4749.robot.RobotMap;

public class Ejector extends Subsystem implements RobotMap {

    private static Ejector instance;
    private WPI_TalonSRX pusher;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Ejector()
    {
        pusher = new WPI_TalonSRX(EJECTOR);

        // TODO - make this motor controller coast instead of brake
    }

    public void eject(){
        pusher.set(EJECTOR_SPEED);
    }

    public void reset(){
        pusher.set(EJECTOR_SPEED * RESET_MODIFIER);
    }

    public void stop(){
        pusher.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

}