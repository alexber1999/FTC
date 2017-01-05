package Advanced.alexstestprograms.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by alexanderberezovsky on 07.10.16.
 */
@Autonomous(name = "MainAutonomous")
public class MainAuton extends LinearOpMode {
    DriveForward myDriveForward;

    @Override
    public void runOpMode() throws InterruptedException {
     myDriveForward = new DriveForward(hardwareMap.dcMotor.get("left_motor"),
             hardwareMap.dcMotor.get("right_motor"),
             hardwareMap.touchSensor.get("touch_sensor"));

        waitForStart();

        myDriveForward.driveForward();





    }



}
