package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by alexanderberezovsky on 04.01.17.
 */
@TeleOp(name = "JosephMotors")
public class JosephMotors extends OpMode {
    DcMotor F_L;
    DcMotor F_R;
    DcMotor B_L;
    DcMotor B_R;
    DcMotor Shooter_Motor;
    DcMotor Shooter_Motor2;

    @Override
    public void init() {
        F_L = hardwareMap.dcMotor.get("front_left");
        F_R = hardwareMap.dcMotor.get("front_right");
        B_L = hardwareMap.dcMotor.get("back_left");
        B_R = hardwareMap.dcMotor.get("back_right");
        Shooter_Motor = hardwareMap.dcMotor.get("shooter_motor");
        Shooter_Motor2 = hardwareMap.dcMotor.get("shooter_motor2");

        F_R.setDirection(DcMotorSimple.Direction.REVERSE);
        B_R.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        F_R.setPower(gamepad1.right_stick_y);
        B_R.setPower(gamepad1.right_stick_y);
        B_L.setPower(gamepad1.left_stick_y);
        F_L.setPower(gamepad1.left_stick_y);

        if (gamepad2.left_stick_y > .5) {
            Shooter_Motor.setPower(gamepad2.left_stick_y);
            Shooter_Motor2.setPower(gamepad2.left_stick_y);
        } else if (gamepad2.left_stick_y < -.5) {
            Shooter_Motor.setPower(gamepad2.left_stick_y);
            Shooter_Motor2.setPower(gamepad2.left_stick_y);
        } else {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);
        }

    }
}



