package frc.team4749.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller extends Joystick {

    public Controller(int port) {
        super(port);
    }

    /*
    Axis and button labels

    Axis indexes:
    1 - LeftX
    2 - LeftY
    3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
    4 - RightX
    5 - RightY
    6 - DPad Left/Right

    Button mapping matches Windows Control Panel>Game Pads display
     */

    public double getLX(){
        return Math.pow(super.getRawAxis(0), 3);
    }
    public double getLY(){
        return Math.pow(super.getRawAxis(1), 3);
    }
    public double getRX(){
        return Math.pow(super.getRawAxis(4), 3);
    }
    public double getRY(){
        return Math.pow(super.getRawAxis(5), 3);
    }

    public double getRT(){
        return Math.pow(super.getRawAxis(0), 3);
    }
    public double getLT(){
        return Math.pow(super.getRawAxis(1), 3);
    }

    public double getRudder(){
    // combines the left and right trigger into one so that is can act as a rudder for rotating the robot
        double rightTrigger = super.getRawAxis(0);
        double leftTrigger = (super.getRawAxis(1) * -1);
        double combinedAxis = rightTrigger + leftTrigger;

        return Math.pow(combinedAxis, 2);
    }

}
