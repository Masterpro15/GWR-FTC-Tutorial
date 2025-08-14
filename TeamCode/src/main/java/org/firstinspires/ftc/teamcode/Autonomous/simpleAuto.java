
package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

// This is a simple autonomous program BASED on a basic auto I used while competing as a rookie in FTC
//Note that I use a bit more advanced Java concepts like methods in this program.
@Autonomous(name=" Simple Auto", group="Robot")

public class simpleAuto extends LinearOpMode {

    //declare motors
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private ElapsedTime     runtime = new ElapsedTime(); //we will use this timer to make the robot move for a certain amount of secodns


    //Autonomous programs work like TeleOP programs but there is no while loop as autonmous only runs once

    @Override
    public void runOpMode() throws InterruptedException {
        //the "throws interrupted exception" just means that it expects a "wait(<seconds)" somewhere in the proggram
        // Here we still initialize everything like normal
        leftDrive = hardwareMap.get(DcMotor.class, "put name here");
        rightDrive = hardwareMap.get(DcMotor.class, "put name from driver station here");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        //now we wait for start again
        waitForStart();
        //Now we put our programs here, but first scroll down to see the method that I created
        //here is where we run the method
        moveForward(0.5, 2); //move forward at half speed for 2 seconds
        sleep(1000); //wait for 1 second
        moveForward(0.2, 1); //move forwards at a speed of 0.2 for 1 second
        requestOpModeStop(); //we need to request the op mode to stop now because our autonomous program is done

    }



    // The method goes outside the runOpMode class

    //this method will move the robot forward for a certain amount of time, putting the speed negative will make the robot go backwards
    public void moveForward( double speed, double time){
        leftDrive.setPower(speed); //we set the power for the motors
        rightDrive.setPower(speed);
        runtime.reset(); //reset the timer, and it starts counting again
        while (opModeIsActive() && (runtime.seconds() < time)) {
            //the robot will continue running for the time specified
            telemetry.addLine("Moving Foward for " + time + " seconds." );
            telemetry.update();
        }
        leftDrive.setPower(0); //stop the motors
        rightDrive.setPower(0);
    }




}