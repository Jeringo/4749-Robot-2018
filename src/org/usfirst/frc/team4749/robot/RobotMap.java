package org.usfirst.frc.team4749.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // CanTalonSRX

    public static final int DT_FRONTLEFT = 3;
    public static final int DT_FRONTRIGHT = 4;
    public static final int DT_BACKLEFT = 5;
    public static final int DT_BACKRIGHT = 6;
    public static final int CLIMBER = 10;

    //Scales down Climber speed
    public static final double CLIMBER_SPEED = 1.0;

    /*
     * Driving Constants
     */
    //Scales down DT speed
    public static final double DT_SCALE = 2.0;
    //Radius of Wheel
    public static final double DT_WHEEL_RAD_IN = 2;
    public static final double DT_WHEEL_RAD_FT = DT_WHEEL_RAD_IN/12;
    //Diameter of Wheel
    public static final double DT_WHEEL_DIA_IN = 2*DT_WHEEL_RAD_IN;
    public static final double DT_WHEEL_DIA_FT = 2*DT_WHEEL_RAD_FT;
    //Circumference of Wheel
    public static final double DT_WHEEL_CIRC_IN = DT_WHEEL_DIA_IN*Math.PI;
    public static final double DT_WHEEL_CIRC_FT = DT_WHEEL_DIA_FT*Math.PI;
    //Turning Circle constants
    public static final double DT_TURN_DIA_FT = 2;
    public static final double DT_TURN_CIRC_FT = 2*Math.PI;
    //Encoder Ticks Per Revolution
    //****PRACTICE****
    public static final int DT_LEFT_ENC_COUNT_PRACTICE = 256;
    public static final int DT_RIGHT_ENC_COUNT_PRACTICE = 360;
    //****COMPETITION
    public static final int DT_LEFT_ENC_COUNT_COMP = 360;
    public static final int DT_RIGHT_ENC_COUNT_COMP = 360;
}
