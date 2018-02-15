package frc.team4749.robot;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team4749.robot.commands.drive.FastDrive;
import frc.team4749.robot.commands.elevator.Grab;
import frc.team4749.robot.commands.elevator.Eject;
import frc.team4749.robot.commands.elevator.Release;
import frc.team4749.robot.commands.drive.Brake;
import frc.team4749.robot.commands.climb.Climb;

public class OI implements RobotMap {

    public static OI instance;
    private Controller mainController;
    private JoystickButton brake, climb, grab, release, eject, fast;

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

        SmartDashboard::PutData("Set Minimum height", new );
    }

    private void createButtons(){
        //Create Buttons for main controller
        climb = new JoystickButton(mainController,CLIMB_BUTTON);
        grab = new JoystickButton(mainController,GRAB_BUTTON);
        release = new JoystickButton(mainController,RELEASE_BUTTON);
        eject = new JoystickButton(mainController,EJECT_BUTTON);
        brake = new JoystickButton(mainController,BRAKE_BUTTON);
        fast = new JoystickButton(mainController,FAST_BUTTON);

        assignButtons();
    }

    private void assignButtons(){
        //Assign commands to main controller buttons
        brake.whileHeld(new Brake());
        climb.whileHeld(new Climb());
        grab.whileHeld(new Grab());
        release.whileHeld(new Release());
        eject.whileHeld(new Eject());
        fast.whileHeld(new FastDrive());

    }
    public Controller getController(){
        return mainController;
    }
}
