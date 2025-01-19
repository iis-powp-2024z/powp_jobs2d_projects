package edu.kis.powp.jobs2d.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating drawing commands for various shapes.
 */
public class CanvasCommandsFactory {

    /**
     * Creates commands to draw a rectangle with the specified width and height.
     * The rectangle is drawn around the point 0,0.
     *
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param name The name of the rectangle.
     * @return CompoundCommand for drawing the rectangle.
     */
    public static CompoundCommand createRectangleCommand(int width, int height, String name) {
        List<DriverCommand> commands = new ArrayList<>();
        
        int startX = -width / 2;
        int startY = -height / 2;

        commands.add(new SetPositionCommand(startX, startY));
        commands.add(new OperateToCommand(startX + width, startY));
        commands.add(new OperateToCommand(startX + width, startY + height));
        commands.add(new OperateToCommand(startX, startY + height));
        commands.add(new OperateToCommand(startX, startY));

        return new CompoundCommand(commands, name);
    }

    /**
     * Creates commands to draw an ellipse with the specified radii.
     * The ellipse is drawn around the point 0,0.
     * @param rx Radius along the X-axis.
     * @param ry Radius along the Y-axis.
     * @param name The name of the ellipse.
     * @return CompoundCommand for drawing the ellipse.
     */
    public static CompoundCommand createEllipseCommand(int rx, int ry, String name) {
        List<DriverCommand> commands = new ArrayList<>();
        int segments = 50;
        commands.add(new SetPositionCommand(rx, 0));

        double angleIncrement = 2 * Math.PI / segments;
        for (int i = 1; i <= segments; i++) {
            double angle = i * angleIncrement;
            int x = (int) (rx * Math.cos(angle));
            int y = (int) (ry * Math.sin(angle));
            commands.add(new OperateToCommand(x, y));
        }

        return new CompoundCommand(commands, name);
    }
}
