package Advanced.alexstestprograms.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by alexanderberezovsky on 07.10.16.
 */

public class GrabBall {

    private Servo arm_servo1;
    private Servo arm_servo2;

    public GrabBall(Servo arm_servo1, Servo arm_servo2) {
        this.arm_servo1 = arm_servo1;
        this.arm_servo2 = arm_servo2;
        arm_servo1.setDirection(Servo.Direction.REVERSE);
    }

    public void grabBall(Gamepad gamepad) {
        if (gamepad.x) {
            arm_servo1.setPosition(.5);
            arm_servo1.setPosition(.5);
        } else if (gamepad.y) {
            arm_servo1.setPosition(-.5);
            arm_servo1.setPosition(-.5);
        } else {
            arm_servo1.setPosition(0);
            arm_servo1.setPosition(0);
        }

    }


}
