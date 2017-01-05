package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by alexanderberezovsky on 05.01.17.
 */
@Autonomous(name = "SimpleAutonomous")
public class SimpleAutonomous extends LinearOpMode {

    DcMotor F_L;
    DcMotor B_L;
    DcMotor F_R;
    DcMotor B_R;

    @Override
    public void runOpMode() throws InterruptedException{

        F_L = hardwareMap.dcMotor.get("F_L");
        B_L = hardwareMap.dcMotor.get("B_L");
        F_R = hardwareMap.dcMotor.get("F_R");
        B_R = hardwareMap.dcMotor.get("B_R");
        F_R.setDirection(DcMotorSimple.Direction.REVERSE);
        B_R.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();


        F_L.setPower(.5);
        B_L.setPower(.5);
        F_R.setPower(.5);
        B_R.setPower(.5);

        wait(2000);
        stop();



    }

}
