package frc.team4749.robot.subsystems;

import com.ctre.phoenix.drive.MecanumDrive;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;
import frc.team4749.robot.OI;
import frc.team4749.robot.RobotMap;
import frc.team4749.robot.commands.drive.ManualDrive;

public class DriveTrain extends Subsystem implements RobotMap {

    public static DriveTrain instance;
    private CANTalon frontLeft, frontRight, backLeft, backRight;
    private MecanumDrive robotDrive;

    public static DriveTrain getInstance(){
        if (instance == null){
            instance = new DriveTrain();
        }
        return instance;
    }

    private DriveTrain(){
        frontLeft  = new CANTalon(DT_FRONTLEFT);
        backLeft = new CANTalon(DT_BACKLEFT);
        frontRight = new CANTalon(DT_FRONTRIGHT);
        backRight = new CANTalon(DT_BACKRIGHT);

        robotDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);

        frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        frontLeft.configEncoderCodesPerRev(DT_LEFT_ENC_COUNT_COMP);
        frontRight.configEncoderCodesPerRev(DT_RIGHT_ENC_COUNT_COMP);

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
        robotDrive.mecanumDrive_Cartesian(OI.getInstance().getStick().getCubeX(), OI.getInstance().getStick().getCubeY(), OI.getInstance().getStick2().getCubeX(), 0);
    }

    // Support functions
    public void stop() { // this stops the robot from moving
        robotDrive.drive(0,0);
    }

    public void resetPos() {
        System.out.println("Talon positions set to 0.");
        frontLeft.setEncPosition(0);
        frontRight.setEncPosition(0);
        backLeft.setEncPosition(0);
        backRight.setEncPosition(0);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ManualDrive());
    }


}
