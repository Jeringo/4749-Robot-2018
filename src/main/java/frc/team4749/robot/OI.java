package frc.team4749.robot;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.commands.drive.FastDrive;
import frc.team4749.robot.commands.drive.KillMode;
import frc.team4749.robot.commands.drive.ManualDrive;
import frc.team4749.robot.commands.elevator.*;
import frc.team4749.robot.commands.drive.Brake;
import frc.team4749.robot.commands.climb.Climb;

public class OI implements RobotMap {

    public static OI instance;
    private Controller mainController;
    private JoystickButton brake, climb, intake, eject, fast;

    private Thread m_visionThread;

    public static OI getInstance()
    {
        if (instance == null){
            instance =  new OI();
        }
        return instance;
    }

    OI(){
        mainController = new Controller(MAIN_CONTROLLER);

        createButtons();
        dashboardInit();
    }

    private void dashboardInit(){
        m_visionThread = new Thread(() -> {
            // Get the Axis camera from CameraServer
            AxisCamera camera = CameraServer.getInstance().addAxisCamera("axis-camera.local");

            // Get a CvSink. This will capture Mats from the camera
            CvSink cvSink = CameraServer.getInstance().getVideo();
        });
        m_visionThread.setDaemon(true);
        m_visionThread.start();

        SmartDashboard.putData("Set Minimum height", new SetMin());
        SmartDashboard.putData("Set Maximum height", new SetMax());
        SmartDashboard.putData("Reset height", new Reset());
        SmartDashboard.putData("Open Limits", new Open());
        SmartDashboard.putData("Kill Mode", new KillMode());
        SmartDashboard.putData("Manual Drive", new ManualDrive());
    }

    private void createButtons(){
        //Create Buttons for main controller
        climb = new JoystickButton(mainController,CLIMB_BUTTON);
        intake = new JoystickButton(mainController,INTAKE_BUTTON);
        eject = new JoystickButton(mainController,EJECT_BUTTON);
        brake = new JoystickButton(mainController,BRAKE_BUTTON);
        fast = new JoystickButton(mainController,FAST_BUTTON);

        assignButtons();
    }

    private void assignButtons(){
        //Assign commands to main controller buttons
        brake.whileHeld(new Brake());
        climb.whileHeld(new Climb());
        intake.whileHeld(new Intake());
        eject.whileHeld(new Eject());
        fast.whileHeld(new FastDrive());

    }
    public Controller getController(){
        return mainController;
    }
}
