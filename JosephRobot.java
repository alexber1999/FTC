package org.firstinspires.ftc.robotcontroller.ctfgameprograms.teleopgame;

import android.widget.Spinner;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by alexanderberezovsky on 10.12.16.
 */
@TeleOp(name = "JosephRobot")
public class JosephRobot extends OpMode {
    DcMotor F_L;
    DcMotor F_R;
    DcMotor B_L;
    DcMotor B_R;
    DcMotor Shooter_Motor;
    DcMotor Shooter_Motor2;
    DcMotor Arm_Motor;
   DcMotor Arm_Motor2;


    Servo Shooter_Servo;
    Servo Shooter_Servo2;
    Servo Ball_Servo;
    Servo Ball_Servo2;
    Servo Spinner_Servo;

    double increment = .05;


    @Override
    public void init() {

        F_L = hardwareMap.dcMotor.get("front_left");
        F_R = hardwareMap.dcMotor.get("front_right");
        B_L = hardwareMap.dcMotor.get("back_left");
        B_R = hardwareMap.dcMotor.get("back_right");
        Shooter_Motor = hardwareMap.dcMotor.get("shooter_motor");
        Shooter_Motor2 = hardwareMap.dcMotor.get("shooter_motor2");
        Arm_Motor = hardwareMap.dcMotor.get("arm_motor");
        Arm_Motor2 = hardwareMap.dcMotor.get("arm_motor2");


        F_R.setDirection(DcMotorSimple.Direction.REVERSE);
        B_R.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        Arm_Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        Shooter_Servo2.setDirection(Servo.Direction.REVERSE);
        Ball_Servo2.setDirection(Servo.Direction.REVERSE);


        Shooter_Servo = hardwareMap.servo.get("shooter_servo");
        Shooter_Servo2 = hardwareMap.servo.get("shooter_servo2");
        Ball_Servo = hardwareMap.servo.get("ball_servo");
        Ball_Servo2 = hardwareMap.servo.get("ball_servo2");
        Spinner_Servo = hardwareMap.servo.get("spinner_servo");


        Shooter_Servo.setPosition(0);
        Shooter_Servo2.setPosition(0);
        Spinner_Servo.setPosition(0);
        Ball_Servo.setPosition(0);
        Ball_Servo2.setPosition(0);


    }

    @Override
    public void loop() {


            F_R.setPower(gamepad1.right_stick_y);
            B_R.setPower(gamepad1.right_stick_y);
            B_L.setPower(gamepad1.left_stick_y);
            F_L.setPower(gamepad1.left_stick_y);

        double ShooterPosition = Shooter_Servo.getPosition();
        double ShooterPosition2 = Shooter_Servo2.getPosition();
        double SpinnerPosition = Spinner_Servo.getPosition();
        double BallPosition = Ball_Servo.getPosition();
        double BallPosition2 = Ball_Servo2.getPosition();

        Range.clip(SpinnerPosition, 0, 1);
        Range.clip(ShooterPosition, 0, 1);
        Range.clip(ShooterPosition2, 0, 1);
        Range.clip(BallPosition, 0, 1);
        Range.clip(BallPosition2, 0, 1);


        if (gamepad2.left_stick_y > .5) {
            Shooter_Motor.setPower(gamepad2.left_stick_y);
            Shooter_Motor2.setPower(gamepad2.left_stick_y);

            ShooterPosition += increment;

            ShooterPosition2 += increment;
            Shooter_Servo.setPosition(ShooterPosition);
            Shooter_Servo2.setPosition(ShooterPosition2);

        } else if (gamepad2.left_stick_y < -.5) {
            Shooter_Motor.setPower(gamepad2.left_stick_y);
            Shooter_Motor2.setPower(gamepad2.left_stick_y);


            ShooterPosition -= increment;

            ShooterPosition2 -= increment;
            Shooter_Servo.setPosition(ShooterPosition);
            Shooter_Servo2.setPosition(ShooterPosition2);

        } else if (gamepad2.dpad_up) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);

            ShooterPosition += increment;
            ShooterPosition2 += increment;
            Shooter_Servo.setPosition(ShooterPosition);
            Shooter_Servo2.setPosition(ShooterPosition2);

        } else if (gamepad2.dpad_down) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);


            ShooterPosition += increment;
            ShooterPosition2 += increment;
            Shooter_Servo.setPosition(ShooterPosition);
            Shooter_Servo2.setPosition(ShooterPosition2);

        } else if (gamepad2.a) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);


            SpinnerPosition += increment;
            Spinner_Servo.setPosition(SpinnerPosition);


        } else if (gamepad2.b) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);

            SpinnerPosition -= increment;
            Spinner_Servo.setPosition(SpinnerPosition);

        } else if (gamepad2.y) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);

            BallPosition += increment;
            BallPosition2 += increment;
            Ball_Servo.setPosition(BallPosition);
            Ball_Servo2.setPosition(BallPosition2);

        } else if (gamepad2.y) {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);

            BallPosition -= increment;
            BallPosition2 -= increment;
            Ball_Servo.setPosition(BallPosition);
            Ball_Servo2.setPosition(BallPosition2);

        } else if (gamepad2.left_bumper) {
            Arm_Motor.setPower(.5);
            Arm_Motor2.setPower(.5);
        } else if (gamepad2.right_bumper) {
            Arm_Motor.setPower(-.5);
            Arm_Motor2.setPower(-.5);
        } else {
            Shooter_Motor.setPower(0);
            Shooter_Motor2.setPower(0);

            Shooter_Servo.setPosition(ShooterPosition);
            Shooter_Servo2.setPosition(ShooterPosition2);
            Spinner_Servo.setPosition(SpinnerPosition);
            Ball_Servo.setPosition(BallPosition);
            Ball_Servo2.setPosition(BallPosition2);
        }


    }

}

