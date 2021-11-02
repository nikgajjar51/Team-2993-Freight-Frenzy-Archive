package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "OpMode")
public class TeleOp extends OpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    private Hardware Robot;
    @Override
    public void init() {
        Robot = new Hardware(hardwareMap);
        telemetry.addData("Status:", "Robot Hardware Initialized");
        telemetry.addLine("Waiting to Start the Match:");
        telemetry.update();
    }
    @Override
    public void init_loop() {
    }
    @Override
    public void start() {
        runtime.reset();
    }
    @Override
    public void loop() {
        Robot.TeleOpDrive();
        telemetry.addData("Status", "Run Time: " + runtime.toString());telemetry.update();
        telemetry.addData("Status:", "Running the Tele-Operation Functions");
        telemetry.update();
    }
}