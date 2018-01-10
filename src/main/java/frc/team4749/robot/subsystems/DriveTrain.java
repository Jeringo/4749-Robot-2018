package frc.team4749.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.team4749.robot.OI;
import frc.team4749.robot.RobotMap;
import frc.team4749.robot.commands.drive.ManualDrive;

public class DriveTrain extends Subsystem implements RobotMap {

    private static DriveTrain instance;
    private WPI_TalonSRX frontLeft, frontRight, backLeft, backRight;
    private MecanumDrive robotDrive;

    public static DriveTrain getInstance(){
        if (instance == null){
            instance = new DriveTrain();
        }
        return instance;
    }

    private DriveTrain(){
        frontLeft  = new WPI_TalonSRX(DT_FRONTLEFT);
        backLeft = new WPI_TalonSRX(DT_BACKLEFT);
        frontRight = new WPI_TalonSRX(DT_FRONTRIGHT);
        backRight = new WPI_TalonSRX(DT_BACKRIGHT);

        robotDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
        setManual();
    }

    //Talon Mode change functions
    public void setAuto(){
        resetPos();

        System.out.println("Talons set to autonomous mode.");
    }

    public void setManual(){
        System.out.println("DT set to Manual" );
    }

    // Basic Teleop Functions
    public void manualDrive(){
        robotDrive.driveCartesian(OI.getInstance().getStick().getCubeX(), OI.getInstance().getStick().getCubeY(), OI.getInstance().getStick2().getCubeX(), 0.0);
    }

    // Support functions
    public void stop() { // this stops the robot from moving
        robotDrive.driveCartesian(0.0, 0.0, 0.0, 0.0);
    }

    public void resetPos() {
        System.out.println("Talon positions set to 0.");
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }


}
