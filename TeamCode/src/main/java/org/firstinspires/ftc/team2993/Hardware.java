package org.firstinspires.ftc.team2993;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

public class Hardware {
    public final int CPR = 560; //Encoder counts per Wheel revolution//
    public final double deadZone = 0.05;
    private final double DIAMETER = 4;
    private final double GEARING = 1;
    public final double CPI = (CPR * GEARING) / (DIAMETER * Math.PI);//Encoder Counts per Wheel Revolution Per Inch//
    public HardwareMap map;
    public DcMotorEx FrontLeft, FrontRight, BackLeft, BackRight, LiftLeft, LiftRight, Turner, Intake;
    public TouchSensor LiftSensor;
    public Gamepad Controller1, Controller2;
    float LeftX;
    float RightX;
    float LeftY;
    float RightY;
    float LeftXC = Math.abs(LeftX);
    float RightXC = Math.abs(RightX);
    float LeftYC = Math.abs(LeftY);
    float RightYC = Math.abs(RightY);
    float TurnerButton = Controller2.right_trigger;
    boolean LiftButtonMid = Controller2.a;
    boolean LiftButtonHigh = Controller2.y;
    double StopButton = Controller2.left_trigger;

    {
        assert false;
        LeftX = (Controller1.right_stick_x);
        RightX = (Controller1.left_stick_x);
        LeftY = (Controller1.left_stick_y);
        RightY = (Controller1.left_stick_y);
    }

    public Hardware(@NonNull HardwareMap map) {
        this.map = map;
        FrontLeft = map.get(DcMotorEx.class, "FrontLeft");
        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRight = map.get(DcMotorEx.class, "FrontRight");
        BackLeft = map.get(DcMotorEx.class, "BackLeft");
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight = map.get(DcMotorEx.class, "BackRight");
        LiftLeft = map.get(DcMotorEx.class, "LiftLeft");
        LiftLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        LiftRight = map.get(DcMotorEx.class, "LiftRight");
        Intake = map.get(DcMotorEx.class, "Intake");
        Turner = map.get(DcMotorEx.class, "Turner");
        LiftSensor = map.get(TouchSensor.class, "LiftSensor");

        FrontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        LiftLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        LiftRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Turner.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        Intake.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void DriveStraightInches(double pow, int in) {
        FrontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        int target = (int) (in * CPI);
        FrontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FrontLeft.setTargetPosition(target);
        FrontRight.setTargetPosition(target);
        BackLeft.setTargetPosition(target);
        BackRight.setTargetPosition(target);
        FrontLeft.setPower(pow);
        FrontRight.setPower(pow);
        BackLeft.setPower(pow);
        BackRight.setPower(pow);
        if (!FrontLeft.isBusy() && !FrontRight.isBusy() && !BackLeft.isBusy() && !BackRight.isBusy()) {
            FrontLeft.setPower(0);
            FrontRight.setPower(0);
            BackLeft.setPower(0);
            BackRight.setPower(0);
        }
        FrontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        FrontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        BackLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        BackRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void LiftMid(double pow) {
        //LiftLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        LiftRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);//
        LiftLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        LiftRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        //TODO - Find Correct PID Values//
        LiftLeft.setTargetPosition(20);
        LiftRight.setTargetPosition(20);
        LiftLeft.setPower(pow);
        LiftRight.setPower(pow);
        while (LiftLeft.isBusy() && LiftRight.isBusy()) {
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);
        }
        LiftLeft.setPower(0);
        LiftRight.setPower(0);
        LiftLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        LiftRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void LiftHigh(double pow) {
        //LiftLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        LiftRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);//
        LiftLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        LiftRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        //TODO - Find Correct PID Values//
        LiftLeft.setTargetPosition(50);
        LiftRight.setTargetPosition(50);
        LiftLeft.setPower(pow);
        LiftRight.setPower(pow);
        while (LiftLeft.isBusy() && LiftRight.isBusy()) {
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);
        }
        LiftLeft.setPower(0);
        LiftRight.setPower(0);
        LiftLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        LiftRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void TeleOpDrive() {
        if (RightXC >= deadZone) {
            if (RightX >= deadZone) {
                FrontLeft.setPower(Range.clip(RightX, -1.0, 1.0));
                BackLeft.setPower(Range.clip(RightX, -1.0, 1.0));
                FrontRight.setPower(Range.clip(-RightX, -1.0, 1.0));
                BackRight.setPower(Range.clip(-RightX, -1.0, 1.0));
            } else if (RightX <= -deadZone) {
                FrontLeft.setPower(Range.clip(-RightX, -1.0, 1.0));
                BackLeft.setPower(Range.clip(-RightX, -1.0, 1.0));
                FrontRight.setPower(Range.clip(RightX, -1.0, 1.0));
                BackRight.setPower(Range.clip(RightX, -1.0, 1.0));
            }
        } else if (LeftYC >= deadZone) {
            FrontLeft.setPower(Range.clip(LeftX, -1.0, 1.0));
            BackLeft.setPower(Range.clip(LeftX, -1.0, 1.0));
            FrontRight.setPower(Range.clip(LeftX, -1.0, 1.0));
            BackRight.setPower(Range.clip(LeftX, -1.0, 1.0));
        } else if (TurnerButton >= deadZone) {
            Turner.setPower(Range.clip(.5 * TurnerButton, -1.0, 1.0));
        } else if (LiftButtonMid) {
            LiftMid(50);
        } else if (LiftButtonHigh) {
            LiftHigh(50);
        } else if (StopButton >= deadZone) {
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            FrontRight.setPower(0);
            BackRight.setPower(0);
        }
    }

    public void Autonomous() {
        DriveStraightInches(50, 12);
    }
}