/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick mainOI;
  public static Joystick subOI;
  public static boolean usingMainOI = false;
  public static boolean usingSubOI = false;

  /**
   * Initialize all the controller
   */
  public static void init() {
    if(Robot.driverStation.getStickButtonCount(0)>0){
      mainOI = new Joystick(0);
      usingMainOI=true;
    }else {
      usingMainOI=false;
    }
    if(Robot.driverStation.getStickButtonCount(1)>0){
      subOI = new Joystick(1);
      usingSubOI=true;
    }else {
      usingSubOI=false;
    }
    SmartDashboard.putBoolean("Main OI connected", usingMainOI);
    SmartDashboard.putBoolean("Sub OI connected", usingSubOI);
  }

  /**
   * Cartesian X-Axis
   */
  public static double getDriveX() {
    if(!usingMainOI)return 0;
    return correctJoystick(mainOI.getRawAxis(2)); // Left joystick
  }

  /**
   * Cartesian Y-Axis
   */
  public static double getDriveY() {
    if(!usingMainOI)return 0;
    return correctJoystick(-mainOI.getRawAxis(1)); // Right joystick
  }

  //TODO: make sure there's no "null pointer exception", and the button ids are correct
  public static boolean getDriveLeft(){
    if(!usingMainOI)return false;
    return mainOI.getRawButton(5);
  }
  
  public static boolean getDriveRight(){
    if(!usingMainOI)return false;
    return mainOI.getRawButton(6);
  }

  public static double getArm() { // negative is going up
    if(!usingSubOI)return 0;
    double output = correctJoystick(0.85 * subOI.getRawAxis(5));
    if(output == 0){
    //1 and 0 reserved for joystick
    if (subOI.getRawButton(1)) output = 2; //hatch loading station (left btn)
    else if (subOI.getPOV()==90 ) output = 3; //cargo loading station (right pov)
    else if (subOI.getRawButton(2)) output = 4; //hatch level 1 (down btn)
    else if (subOI.getPOV()==180) output = 5; //cargo level 1 (down pov)
    else if (subOI.getRawButton(3)) output = 6; //hatch level 2 (right btn)
    else if (subOI.getPOV()==270) output = 7; //cargo level 2 (left pov)
    else if (subOI.getRawButton(4)) output = 8; //hatch level 3 (up btn)
    else if (subOI.getPOV()==0) output = 9; //cargo level 3 (up pov)
    else if (subOI.getRawButton(13)) output = 10; // ground pickup (ps button)
    }

    return output;
  }

  public static double getWrist() {
    if(!usingSubOI)return 0;
    double output = correctJoystick(subOI.getRawAxis(4)); // downward (left trigger)
    output -= correctJoystick(subOI.getRawAxis(3)); // upward (right trigger)
    output *= 0.3;
    // if(output == 0){
    // //-1~1 is reserved for the joystick
    // if (subOI.getRawButton(1)) output = 2; //hatch loading station (left btn)
    // else if (subOI.getPOV()==90 ) output = 3; //cargo loading station(right pov)
    // else if (subOI.getRawButton(2)) output = 4; //hatch level 1 (down btn)
    // else if (subOI.getPOV()==180) output = 5; //cargo level 1 (down pov)
    // else if (subOI.getRawButton(3)) output = 6; //hatch level 2 (right btn)
    // else if (subOI.getPOV()==270) output = 7; //cargo level 2 (left pov)
    // else if (subOI.getRawButton(4)) output = 8; //hatch level 3 (up btn)
    // else if (subOI.getPOV()==0) output = 9; //cargo level 3 (up pov)
    // else if (subOI.getRawButton(13)) output = 10; // ground pickup (ps button)
    // }
    return output;

  }

  public static double getLift() {
    if(!usingSubOI)return 0;
    double output = correctJoystick(-subOI.getRawAxis(1)); // Left joystick
    if(output == 0){
    //-1~1 is reserved for the joystick
    if (subOI.getRawButton(1)) output = 2; //hatch loading station (left btn)
    else if (subOI.getPOV()==90 ) output = 3; //cargo loading station(right pov)
    else if (subOI.getRawButton(2)) output = 4; //hatch level 1 (down btn)
    else if (subOI.getPOV()==180) output = 5; //cargo level 1 (down pov)
    else if (subOI.getRawButton(3)) output = 6; //hatch level 2 (right btn)
    else if (subOI.getPOV()==270) output = 7; //cargo level 2 (left pov)
    else if (subOI.getRawButton(4)) output = 8; //hatch level 3 (up btn)
    else if (subOI.getPOV()==0) output = 9; //cargo level 3 (up pov)
    else if (subOI.getRawButton(13)) output = 10; // ground pickup (ps button)
    }
    return output;
  }

  public static boolean getIntakePressed() {
    if(!usingSubOI)return false;
    return subOI.getRawButton(5); // Back Left btn
  }

  public static boolean getRevIntakePressed() {
    if(!usingSubOI)return false;
    return subOI.getRawButton(6); // back right btn
  }

  public static double correctJoystick(double input) {
    return input > Constant.joystickDeadZone || input < -Constant.joystickDeadZone ? input : 0;
  }

}
