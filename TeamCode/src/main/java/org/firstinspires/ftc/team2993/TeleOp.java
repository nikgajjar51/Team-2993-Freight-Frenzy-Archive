package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "OpMode")
public class TeleOp extends OpMode {
    public Hardware Robot;

    public void init() {
        Robot = new Hardware(hardwareMap);
        telemetry.addData("Front Left Encoder:", Robot.FrontLeft.getCurrentPosition());
        telemetry.addData("Back Left Encoder:", Robot.BackLeft.getCurrentPosition());
        telemetry.addData("Front Right Encoder:", Robot.FrontRight.getCurrentPosition());
        telemetry.addData("Back Right Encoder:", Robot.BackRight.getCurrentPosition());
        telemetry.addData("Lift Left Encoder:", Robot.LiftLeft.getCurrentPosition());
        telemetry.addData("Lift Right Encoder:", Robot.LiftRight.getCurrentPosition());
        telemetry.addData("Intake Encoder:", Robot.Intake.getCurrentPosition());
        telemetry.addData("Turner Encoder:", Robot.Turner.getCurrentPosition());
        telemetry.addData("Status:", "Robot Hardware Initialized");
        telemetry.addLine("Waiting to Start the Match:");
        telemetry.update();
    }

    public void loop() {
        Robot.TeleOpDrive(0);
        telemetry.addData("Status:", "Running the Tele-Operation Functions");
        telemetry.update();
    }
}