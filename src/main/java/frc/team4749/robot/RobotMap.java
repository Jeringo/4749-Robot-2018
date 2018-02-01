package frc.team4749.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {

    //Driver Station
    int MAIN_CONTROLLER = 0;

    //Controller Buttons
    int BRAKE_BUTTON = 2;
    int CLIMB_BUTTON = 4;
    int SLOW_BUTTON = 3;
    int GRAB_BUTTON = 6;
    int RELEASE_BUTTON = 5;
    int EJECT_BUTTON = 1;

    //CanTalonSRX
    int DT_FRONTLEFT = 1;
    int DT_FRONTRIGHT = 2;
    int DT_BACKLEFT = 3;
    int DT_BACKRIGHT = 4;
    int CLIMBER = 10;
    int ELEVATOR = 11;
    int GRABBER = 12;
    int EJECTOR = 13;

    //Scales down Climber speed
    double CLIMBER_SPEED = 1.0;

    //Controls the elevator speeds
    double ELEVATOR_SPEED = 1.0;
    double LOWER_MODIFIER = 0.5;
    double AUTO_RAISE_SPEED = 0.8;
    double AUTO_LOWER_SPEED = -0.2;

    //Controls the Grabber speeds
    double GRABBER_SPEED = 1.0;
    double RELEASE_MODIFIER = -1.0;

    //Controls the Ejector speeds
    double EJECTOR_SPEED = 1.0;
    double RESET_MODIFIER = -1.0;

    //Drive variables
    double DRIVE_SPEED = 0.5;
    double DRIVE_SLOW = 0.2;

}
