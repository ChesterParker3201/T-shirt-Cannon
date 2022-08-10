// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with tank
 * steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
  private final CANSparkMax m_frontLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax m_topLeftMotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_backLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_frontRightMotor = new CANSparkMax(6, MotorType.kBrushless);
  private final CANSparkMax m_topRightMotor = new CANSparkMax(5, MotorType.kBrushless);
  private final CANSparkMax m_backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_frontLeftMotor, m_frontRightMotor);
  private final XboxController m_driverController = new XboxController(0);

  @Override
  public void robotInit() {
    m_backLeftMotor.follow(m_frontLeftMotor);
    m_topLeftMotor.follow(m_frontLeftMotor);
    m_backRightMotor.follow(m_frontRightMotor);
    m_topRightMotor.follow(m_frontRightMotor);
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.

  }

  @Override
  public void teleopPeriodic() {
    // Drive with tank drive.
    // That means that the Y axis of the left stick moves the left side
    // of the robot forward and backward, and the Y axis of the right stick
    // moves the right side of the robot forward and backward.
    m_robotDrive.tankDrive(-m_driverController.getLeftY(), -m_driverController.getRightY());
  }
}
