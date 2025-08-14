## Warning, please do not use this code on an actual robot. This is to learn how to use encoders
## Please ignore the syntax if you don't understand. The Main goal is for you to under the encoder part of the code only!
## This might be hard to understand, so I've also included another encoder example not shown in the video
package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Encoder Test ") // This TeleOp mode will appear as "Encoder Test" on the Driver Station
public class encoder extends OpMode {

    DcMotor motor; // Declare the motor variable
    double ticks = 537.7; // Encoder ticks per full rotation of the motor
    double newTarget; // Stores the calculated target position for movement

    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class, "motor"); // Link motor variable to hardware configuration
        telemetry.addData("Hardware: ", "Initialized"); // Display message to Driver Station
        motor.setMode(DcMotor.RunMode.USING_ENCODER); // Enable encoder for precise motor tracking
    }

    @Override
    public void loop() {
        if(gamepad1.a) { // Check if A button is pressed
            encoder(2); // Move motor half a rotation
        }
        
        telemetry.addData("Motor Ticks: ", motor.getCurrentPosition()); // Display current motor position
        
        if(gamepad1.x) { // Check if X button is pressed
            tracker(); // Return motor to starting position
        }
    }

    // Method to move motor by a fraction of a full rotation
    public void encoder(int turnage) {
        newTarget = ticks / turnage; // Calculate target position
        motor.setTargetPosition((int)newTarget); // Set motor target
        motor.setPower(0.3); // Set movement speed
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Run motor to target position
    }

    // Method to return motor to starting position
    public void tracker() {
        motor.setTargetPosition(0); // Target is zero (starting position)
        motor.setPower(0.8); // Set higher speed for return
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Run motor to target position
    }
}
