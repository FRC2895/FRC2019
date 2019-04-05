/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot; 


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 * March 2nd, 2019 Jaden and Enid were here.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_driveTrain;
  private Joystick m_drivestick;
  private Joystick m_hatchstick ;
  private Spark m_hatchdriveL ;
  private Spark m_hatchdriveR ;
  

  public class ButtonMap {
		public static final int A = 0;
		public static final int B = 1;
		public static final int X = 2;
		public static final int Y = 3;
		public static final int LB = 4;
		public static final int RB = 5;
		public static final int Back = 6;
		public static final int Start = 7;
		public static final int L3 = 8;
    public static final int R3 = 9;
  }
  
  @Override
  public void robotInit() {
    m_driveTrain = new DifferentialDrive(new Spark(0), new Spark(1));
    /* Left joystick on driver station */
    m_drivestick = new Joystick(0);

    m_hatchstick = new Joystick(1);
    m_hatchdriveL =new Spark(2);
    m_hatchdriveR = new Spark(3) ;

    /* Camera object on the Rio */
    CameraServer.getInstance().startAutomaticCapture();
 }

  @Override
  public void autonomousPeriodic(){
    teleopPeriodic();
  }


  @Override
  public void teleopPeriodic(){
    /* Drivetrade for driving robot */
    m_driveTrain.arcadeDrive(m_drivestick.getY(),m_drivestick.getX());
    /* Hatch panel arm control */
    double hatchPanelSpeed = 0.3*m_hatchstick.getY();
    m_hatchdriveR.set(-hatchPanelSpeed);
    m_hatchdriveL.set(-hatchPanelSpeed);
  }

} // Close Robot class
