package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class LinearOp extends LinearOpMode {
    Hardware Robot;

    @Override
    public void runOpMode() throws InterruptedException {
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
        telemetry.addLine("Waiting to Start the Match...");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            if (Robot.RightXC >= Robot.deadZone) {
                Robot.FrontLeft.setPower(Robot.RightX);
                Robot.BackLeft.setPower(Robot.RightX);
                Robot.FrontRight.setPower(Robot.RightX);
                Robot.BackRight.setPower(Robot.RightX);
            }
            else if(Robot.LeftXC>= Robot.deadZone) {
                Robot.FrontLeft.setPower(Robot.LeftX);
                Robot.BackLeft.setPower(Robot.LeftX);
                Robot.FrontRight.setPower(Robot.LeftX);
                Robot.BackRight.setPower(Robot.LeftX);
            }
            else if(Robot.TurnerButton>= Robot.deadZone){
                Robot.Turner.setPower(.5*Robot.TurnerButton);
            }
            else if(Robot.LiftButtonMid){
                Robot.LiftMid(50);
            }
            else if(Robot.LiftButtonHigh){
                Robot.LiftHigh(50);
            }
            else if(Robot.StopButton >= Robot.deadZone){
                Robot.FrontLeft.setPower(0);
                Robot.BackLeft.setPower(0);
                Robot.FrontRight.setPower(0);
                Robot.BackRight.setPower(0);
            }
            telemetry.addData("Status:", "Running the Tele-Operation Functions");
            telemetry.update();
        }
    }
}