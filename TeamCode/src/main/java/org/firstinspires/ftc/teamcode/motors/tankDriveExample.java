package org.firstinspires.ftc.teamcode.motors;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;



//This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot


@TeleOp(name="Basic Tank Drive", group="Linear OpMode")
public class tankDriveExample extends LinearOpMode {

    // Declare the variables that you need
    //If you have more advanced java experience
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive  = hardwareMap.get(DcMotor.class, "PUT THE NAME OF THE LEFT MOTOR HERE");
        rightDrive = hardwareMap.get(DcMotor.class, "PUT THE NAME OF THE RIGHT MOTOR HERE");

        // To drive forward, most robots need the motor on one side to be reversed,
        // because the axles point in opposite directions. So thats why you see on motor
        //is REVERSE and one is FOWARD
        //Make sure to adjust these two lines based on your first test drive.
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // For more advanced tank drive trains with gears and chains you might need to also use your GEAR RATIO.
        // But dont worry too much about it if your a rookie

        // This code waits for the start button to be pressed
        waitForStart();
        runtime.reset();

        // This code runs in a loop while until the stop button is pressed
        while (opModeIsActive()) {

            //So here we set up 2 java variables to store the power of both th motors
            double leftPower;
            double rightPower;

            // Here we make 2 variables: drive and turn. Drive controls the forward and backward movement\
            //and turn controls the turning and rotating.
            //We set the variable's value to the joysticks so we can control it!
            //Remeber that this is in a loop so the joysticks value are constantly updated
            //as we move it so the code will work properly.
            double drive = -gamepad1.left_stick_y; // we set it to negative because when you push the
            // left stick up it actually gives you -1 but we want it to be one.
            double turn  =  gamepad1.right_stick_x;

            //Here we calculate the correct power to the motors. Range.clip makes sure we dont send a value
            //above 1 and below -1 to the motors.
            //The reason why right power is -turn is that one of the motors needs to spin in the other direction
            //to spin the robot around. Try imagining what the power of the motors are depending on the joysticks to get a better understandign
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Now we just actually send the power
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
