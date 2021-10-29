package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red Autonomous")
public class RedAutonomous extends OpMode{
    public Hardware Robot;

    public void init() {
        Robot = new Hardware(hardwareMap);
        telemetry.addData("Front Left Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Back Left Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Front Right Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Back Right Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Lift Left Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Lift Right Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Intake Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Turner Encoder:", "Robot Hardware Initialized");
        telemetry.addData("Status:", "Robot Hardware Initialized");
        telemetry.addLine("Waiting to Start the Match:");
        telemetry.update();
    }

    public void loop() {
        Autonomous();
        telemetry.addData("Status:", "Running the Autonomous Functions");
        telemetry.update();
    }
    public void Autonomous(){
        Robot.DriveStraightInches(50,12);
    }
}
