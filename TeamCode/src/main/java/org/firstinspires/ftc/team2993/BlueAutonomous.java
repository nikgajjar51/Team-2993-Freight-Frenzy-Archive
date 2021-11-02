package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue Autonomous")
public class BlueAutonomous extends OpMode {
    public Hardware Robot;
    @Override
    public void init() {
        Robot = new Hardware(hardwareMap);
        telemetry.addData("Front Left Encoder:", "Encoder: (%.2f)" + Robot.FrontLeft.getCurrentPosition());
        telemetry.addData("Back Left Encoder:", "Encoder: (%.2f)" + Robot.BackLeft.getCurrentPosition());
        telemetry.addData("Front Right Encoder:", "Encoder: (%.2f)" + Robot.FrontRight.getCurrentPosition());
        telemetry.addData("Back Right Encoder:", "Encoder: (%.2f)" +  Robot.BackRight.getCurrentPosition());
        telemetry.addData("Lift Left Encoder:", "Encoder: (%.2f)" + Robot.LiftLeft.getCurrentPosition());
        telemetry.addData("Lift Right Encoder:", "Encoder: (%.2f)" + Robot.LiftRight.getCurrentPosition());
        telemetry.addData("Intake Encoder:", "Encoder: (%.2f)" + Robot.Intake.getCurrentPosition());
        telemetry.addData("Turner Encoder:", "Encoder: (%.2f)" + Robot.Turner.getCurrentPosition());
        telemetry.addData("Status:",  "Robot Hardware Initialized");
        telemetry.addLine("Waiting to Start the Match:");
        telemetry.update();
    }
    @Override
    public void loop() {
        Robot.Autonomous();
        telemetry.addData("Status:", "Running the Autonomous Functions");
        telemetry.update();
    }
}