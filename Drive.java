package Advanced.alexstestprograms.teleop;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by alexanderberezovsky on 06.10.16.
 */

public class Drive {

    // encapsulating motors so that only this class can access the variables?
    private DcMotor F_L;
    private DcMotor B_L;
    private DcMotor F_R;
    private DcMotor B_R;


    public Drive(DcMotor left, DcMotor right, DcMotor left2, DcMotor right2) {// creating a constructor to initialize variables??
        this.F_L = left;
        this.F_R = right;
        this.B_L = left2;
        this.B_R = right2;
    }

    public void tankDrive(Gamepad gamepad) { // method that sets the left and right motors to their values?
        if (gamepad.left_stick_y > .1 && gamepad.right_stick_y > .1) {
            F_R.setPower(gamepad.right_stick_y);
            B_R.setPower(gamepad.right_stick_y);
            B_L.setPower(gamepad.left_stick_y);
            F_L.setPower(gamepad.left_stick_y);
        } else if (gamepad.left_stick_y < -.1 && gamepad.right_stick_y < -.1) {
            F_R.setPower(gamepad.right_stick_y);
            B_R.setPower(gamepad.right_stick_y);
            B_L.setPower(gamepad.left_stick_y);
            F_L.setPower(gamepad.left_stick_y);
        } else if (gamepad.left_stick_y < -.1 && gamepad.right_stick_y > .1) {
            F_R.setPower(0);
            B_R.setPower(0);
            B_L.setPower(0);
            F_L.setPower(0);
        } else if (gamepad.left_stick_y > .1 && gamepad.right_stick_y < -.1) {
            F_R.setPower(0);
            B_R.setPower(0);
            B_L.setPower(0);
            F_L.setPower(0);
        } else {
            F_R.setPower(0);
            B_R.setPower(0);
            B_L.setPower(0);
            F_L.setPower(0);
        }
    }


}
