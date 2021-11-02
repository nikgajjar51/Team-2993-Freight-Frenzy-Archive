package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Iterative OpMode", group="Iterative OpMode")
public class BasicOpMode_Iterative extends OpMode
{
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
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }
    @Override
    public void stop() {
    }

}
