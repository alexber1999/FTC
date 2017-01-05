package Advanced.alexstestprograms.teleop;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by alexanderberezovsky on 07.10.16.
 */

public class ExtendArm {

    private DcMotor arm_motor1;


    public ExtendArm(DcMotor arm_motor1){
        this.arm_motor1 = arm_motor1;

    }

    public void extendArm(Gamepad gamepad){
        if(gamepad.a){
            arm_motor1.setPower(.5);
        } else if(gamepad.b){
            arm_motor1.setPower(-.5);
        } else{
            arm_motor1.setPower(0);
        }
    }





}
