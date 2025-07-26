package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



//This OpMode is a OpMode that moves a servo


@TeleOp(name="Servos!", group="Linear OpMode")
public class Servos extends LinearOpMode {

    // Declare the variables that you need
    //If you have more advanced java experience
    private ElapsedTime runtime = new ElapsedTime();
    private Servo exServo = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        exServo  = hardwareMap.get(Servo.class, "PUT THE NAME OF THE SERVO HERE");

        waitForStart();
        runtime.reset();

        // This code runs in a loop while until the stop button is pressed
        while (opModeIsActive()) {
            //Servos are small motors that go to a certain position instead of spinning, they also have limited range so be sure to check your servo to see its range1
            //Servos are programed with 0 being the minimum position and 1 being the maximum position.
            if (gamepad1.a){ exServo.setPosition(0);} // When the a button is pressed, go to position zero
            if (gamepad1.b){ exServo.setPosition(0.5);}
            if (gamepad1.x){ exServo.setPosition(1);}
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
