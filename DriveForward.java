package Advanced.alexstestprograms.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;


/**
 * Created by alexanderberezovsky on 07.10.16.
 */

public class DriveForward {

    private DcMotor left_motor;
    private DcMotor right_motor;
  //  private TouchSensor TouchSensor1;


    public DriveForward(DcMotor left_motor, DcMotor right_motor, TouchSensor TouchSensor1){
        this.left_motor = left_motor;
        this.right_motor = right_motor;
       // this.TouchSensor1 = TouchSensor1;
        right_motor.setDirection(DcMotor.Direction.REVERSE);

    }

    public void driveForward() throws InterruptedException{
        //if(TouchSensor1.isPressed()){
            left_motor.setPower(-.5);
            right_motor.setPower(-.5);
            wait(1000);
       // } else{
            left_motor.setPower(.5);
            right_motor.setPower(.5);
       // }

    }



}
