/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constant {
    //controller buttons
    public static int mainOI = 0;
    public static int subOI = 1;

    public static class DualShock4{
        public static int leftYAxis = 1;
        public static int rightXAxis = 2;
        public static int rightYAxis = 5;
        public static int l2Axis=4;
        public static int r2Axis=3;
        public static int l1 = 5;
        public static int r1 = 6;
        public static int left = 1;
        public static int down = 2;
        public static int right = 3;
        public static int up = 4;
        public static int ps = 4;
        public static int povRight = 90;
        public static int povDown = 180;
        public static int povLeft = 270;
        public static int povUp = 0;

    }

    
    

        
    public static double joystickDeadZone = 0.04;

    public static double driveRampRate = 0.7; //Neutral to full throttle in sec.
    public static double driveYChangelimit = 1/(driveRampRate*50); //Maximum change in y per loop.    
    public static double maxTurningSpeed = 0.7;
    public static double tankDriveSpeed = 0.3; 
    public static double armRampRate = 0.9;
    public static double wristRampRate = 0.25;

    public static int liftSmoothingFactor = 7; //Larger number = More smoothing
    public static double liftSmoothingDeadZone = 0.1; //Too complicated to explain, just dont touch it.
    public static double intakeSpeed = 0.4;
    public static double liftHoldPower = 0.00;
    public static double liftkp = 1;
    public static double liftki = 0.001;
    public static double liftkd = 2.5;
    public static double liftTolerance = 100;
    public static double liftLowerLimit = -50;


    public static double dt = 0.02;

    public static double armMaxHoldPower = -0.34;

    /*   sensorUnit*gearRatio*RadperUnit
                    (15.0/24.0)*(2PI/4096)     */
    public static double armAngleRatio = (15.0/24.0)*(2*Math.PI/4096.0);
    /* Trial and error: (radian)
        Angle/encoderVal*/
        /*   90 Degree/440sensorUnit    */
    public static double wristAngleRatio = (15.0/28.0)*(2*Math.PI/4096.0);
       /*   10 Degree    */
    public static double armOffset = 10.0*Math.PI/180.0;
    public static double wristOffset = 10.0*Math.PI/180.0;

    public static int liftMaxHeight = 15500;
    public static int armMaxHeight = 2300;
    public static int kTimeoutMs = 30;

    public static int hatchLoading = 0, cargoPickup = 1, hatch1 = 2, cargo1 = 3, hatch2 = 4, cargo2 = 5, hatch3 = 6, cargo3 = 7, ground = 8;
    /**
     * <pre>
     * [0]: hatch loading station
     * [1]: cargo pickup
     * [2]: hatch level 1   
     * [3]: cargo level 1
     * [4]: hatch level 2
     * [5]: cargo level 2
     * [6]: hath level 3
     * [7]: cargo level 3
     * [8]: ground pickup
     * </pre>
     */
    public static String[] inputLevels = {"hatch loading","cargo pickup","hatch 1","cargo 1","hatch2","cargo2","hatch3","cargo3","ground"};
    public static double[] liftLevels = {        0       ,      0       ,    0    ,    0    ,   0    ,    0  ,  15000 ,  15000 ,    0   };
    public static double[] armLevels = {        26       ,     113       ,   40    ,   75    ,   112   ,  128  ,   125  ,   146  ,   29   };
    public static double[] wristLevels = {      25       ,     75       ,   40    ,   55    ,   112   ,  80   ,   125  ,    80  ,   48   };
}
