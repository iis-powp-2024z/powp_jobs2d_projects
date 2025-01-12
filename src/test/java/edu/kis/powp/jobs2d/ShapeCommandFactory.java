package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.ArrayList;
import java.util.List;

public class ShapeCommandFactory {

    public List<DriverCommand> createSecretShape(){
        List<DriverCommand> commands = new ArrayList<DriverCommand>();
        commands.add(new SetPositionCommand(-20, -50));
        commands.add(new OperateToCommand(-20, -50));
        commands.add(new SetPositionCommand(-20, -40));
        commands.add(new OperateToCommand(-20, 50));
        commands.add(new SetPositionCommand(0, -50));
        commands.add(new OperateToCommand(0, -50));
        commands.add(new SetPositionCommand(0, -40));
        commands.add(new OperateToCommand(0, 50));
        commands.add(new SetPositionCommand(70, -50));
        commands.add(new OperateToCommand(20, -50));
        commands.add(new OperateToCommand(20, 0));
        commands.add(new OperateToCommand(70, 0));
        commands.add(new OperateToCommand(70, 50));
        commands.add(new OperateToCommand(20, 50));

        return commands;
    }

    public List<DriverCommand> createTriangleShape(){

        List<DriverCommand> list = new ArrayList<>();

        double A_x = -120;
        double A_y = -120;
        double side = 80;

        list.add(new SetPositionCommand((int) Math.round(A_x),(int) Math.round(A_y)));

        double angleB = 120;
        double B_x = A_x + side * Math.cos(Math.toRadians(angleB));
        double B_y = A_y + side * Math.sin(Math.toRadians(angleB));

        list.add(new OperateToCommand((int) Math.round(B_x),(int) Math.round(B_y)));

        double angleC = -120;
        double C_x = A_x + side * Math.cos(Math.toRadians(angleC));
        double C_y = A_y + side * Math.sin(Math.toRadians(angleC));

        list.add(new OperateToCommand((int) Math.round(C_x),(int) Math.round(C_y)));

        list.add(new OperateToCommand((int) Math.round(A_x),(int) Math.round(A_y)));

        return list;
    }
}
