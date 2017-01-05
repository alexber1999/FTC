package Advanced.alexstestprograms.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.exampleprograms.Drive;

/**
 * Created by alexanderberezovsky on 06.10.16.
 */
// this makes it much easier to test and change code
@TeleOp(name = "MainTeleOp")
public class Main extends OpMode {// opmode is the super method

    Drive myRobotDrive;// if we make the class abstract, we don't need the init() method so we
    // can initialize and make a new RobotDrive object in the same line
    ExtendArm myExtendArm;
    GrabBall myNewGrabBall;

    @Override// makes sure that the method isn't the same as the one in the parent program
    public void init(){
        myRobotDrive = new Drive(hardwareMap.dcMotor.get("F_L"),
                hardwareMap.dcMotor.get("F_R"), hardwareMap.dcMotor.get("B_L"),
                hardwareMap.dcMotor.get("B_R"));//hardwareMap is an object that refers to the
        // configuration on the phone 
        // Everything stated by your robot configuration file will be here.

        myExtendArm = new ExtendArm(hardwareMap.dcMotor.get("arm_motor"));

        myNewGrabBall = new GrabBall(hardwareMap.servo.get("arm_servo1"), hardwareMap.servo.get("arm_servo2"));




    }


    @Override
    public void loop(){
        myRobotDrive.tankDrive(gamepad1);
        myExtendArm.extendArm(gamepad2);
        myNewGrabBall.grabBall(gamepad2);

    }









}
