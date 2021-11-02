package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear OpMode")
public class ExampleLinearOp extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private Hardware Robot;
    @Override
    public void runOpMode() {
        Robot = new Hardware(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());telemetry.update();
        }
    }
}
