package frc.team4749.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team4749.robot.commands.brake.Brake;
import frc.team4749.robot.commands.climb.Climb;

public class OI implements RobotMap {

    public static OI instance;
    BetterJoystick driveStick, driveStick2, controlStick;
    //Buttons for Drive joystick
    JoystickButton brake;
    //Buttons for Control joystick
    JoystickButton climb;

    public static OI getInstance()
    {
        if (instance == null){
            instance =  new OI();
        }
        return instance;
    }

    private OI(){
        driveStick = new BetterJoystick(0);
        driveStick = new BetterJoystick(1);
        controlStick = new BetterJoystick(2);

        createButtons();
    }

    public void createButtons(){
        //Create Buttons for main joystick
        brake = new JoystickButton(driveStick,1);
        //Create Buttons for shooting joystick
        climb = new JoystickButton(controlStick,2);


        assignButtons();
    }

    public void assignButtons(){
        //Assign commands to main joystick buttons
        brake.whileHeld(new Brake());

        //Assign commands to shooting joystick buttons
        climb.whenPressed(new Climb());

    }
    public BetterJoystick getStick(){
        return driveStick;
    }

    public BetterJoystick getStick2(){
        return driveStick2;
    }

    public BetterJoystick getControlStick(){
        return controlStick;
    }
}
