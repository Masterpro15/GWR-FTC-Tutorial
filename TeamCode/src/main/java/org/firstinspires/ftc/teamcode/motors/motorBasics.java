package org.firstinspires.ftc.teamcode.motors;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="Motor Basics", group="Linear OpMode")


public class motorBasics extends LinearOpMode {


    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor1 = null;


    @Override
    public void runOpMode() {


        motor1 = hardwareMap.get(DcMotor.class, "PUT THE NAME THATS IN THE DRIVERSTATION HERE!");
        motor1.setDirection(DcMotorSimple.Direction.REVERSE); // This command flips the default direction of the motor. You can also put FOWARD instead of reverse.
        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();
        runtime.reset();


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
           motor1.setPower(1); // This command sets the motor power in a range from -1 to 1. Negative makes it go backwards.

        }
    }
}
