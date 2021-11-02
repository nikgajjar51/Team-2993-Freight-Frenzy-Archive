package org.firstinspires.ftc.team2993;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Backup Linear Operation Mode")
public class LinearOp extends LinearOpMode {
    private final ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        Hardware robot = new Hardware(hardwareMap);
        telemetry.addData("Status:", "Robot Hardware Initialized");
        telemetry.addLine("Waiting to Start the Match:");
        telemetry.update();
        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            robot.TeleOpDrive();
            telemetry.addData("Status", "Run Time: " + runtime.toString());telemetry.update();
            telemetry.addData("Status:", "Running the Tele-Operation Functions");
            telemetry.update();
        }
    }
}