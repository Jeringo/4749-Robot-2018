package frc.team4749.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4749.robot.commands.drive.SlowDrive;
import frc.team4749.robot.commands.elevator.Grab;
import frc.team4749.robot.commands.elevator.Eject;
import frc.team4749.robot.commands.elevator.Release;
import frc.team4749.robot.commands.drive.Brake;
import frc.team4749.robot.commands.climb.Climb;

public class OI implements RobotMap {

    public static OI instance;
    private Controller mainController;
    private JoystickButton brake, climb, grab, release, eject, slow;

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
    }

    private void createButtons(){
        //Create Buttons for main controller
        climb = new JoystickButton(mainController,CLIMB_BUTTON);
        grab = new JoystickButton(mainController,GRAB_BUTTON);
        release = new JoystickButton(mainController,RELEASE_BUTTON);
        eject = new JoystickButton(mainController,EJECT_BUTTON);
        brake = new JoystickButton(mainController,BRAKE_BUTTON);
        slow = new JoystickButton(mainController,SLOW_BUTTON);

        assignButtons();
    }

    private void assignButtons(){
        //Assign commands to main controller buttons
        brake.whileHeld(new Brake());
        climb.whileHeld(new Climb());
        grab.whileHeld(new Grab());
        release.whileHeld(new Release());
        eject.whileHeld(new Eject());
        slow.whileHeld(new SlowDrive());

    }
    public Controller getController(){
        return mainController;
    }
}
