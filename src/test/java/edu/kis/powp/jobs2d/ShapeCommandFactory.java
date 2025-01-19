package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.builder.CompoundCommandBuilder;

public class ShapeCommandFactory {

    public CompoundCommand createSecretShape() {
        return new CompoundCommandBuilder()
                .setName("TopSecretCommand")
                .addCommand(new SetPositionCommand(-20, -50))
                .addCommand(new OperateToCommand(-20, -50))
                .addCommand(new SetPositionCommand(-20, -40))
                .addCommand(new OperateToCommand(-20, 50))
                .addCommand(new SetPositionCommand(0, -50))
                .addCommand(new OperateToCommand(0, -50))
                .addCommand(new SetPositionCommand(0, -40))
                .addCommand(new OperateToCommand(0, 50))
                .addCommand(new SetPositionCommand(70, -50))
                .addCommand(new OperateToCommand(20, -50))
                .addCommand(new OperateToCommand(20, 0))
                .addCommand(new OperateToCommand(70, 0))
                .addCommand(new OperateToCommand(70, 50))
                .addCommand(new OperateToCommand(20, 50))
                .build();
    }

    public CompoundCommand createTriangleShape() {
        double A_x = -120;
        double A_y = -120;
        double side = 80;

        double angleB = 120;
        double B_x = A_x + side * Math.cos(Math.toRadians(angleB));
        double B_y = A_y + side * Math.sin(Math.toRadians(angleB));

        double angleC = -120;
        double C_x = A_x + side * Math.cos(Math.toRadians(angleC));
        double C_y = A_y + side * Math.sin(Math.toRadians(angleC));

        return new CompoundCommandBuilder()
                .setName("TriangleCommand")
                .addCommand(new SetPositionCommand((int) Math.round(A_x), (int) Math.round(A_y)))
                .addCommand(new OperateToCommand((int) Math.round(B_x), (int) Math.round(B_y)))
                .addCommand(new OperateToCommand((int) Math.round(C_x), (int) Math.round(C_y)))
                .addCommand(new OperateToCommand((int) Math.round(A_x), (int) Math.round(A_y)))
                .build();
    }
}
