package edu.kis.powp.jobs2d.shapes;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class EllipseShape implements Shape{
    private final int rx;
    private final int ry;
    private final int segments;

    private static final int DEFAULT_SEGMENTS = 50;

    /**
     * Create an ellipse with default number of segments.
     *
     * @param rx radius in the X direction.
     * @param ry radius in the Y direction.
     */
    public EllipseShape(int rx, int ry) {
        this(rx, ry, DEFAULT_SEGMENTS);
    }
    
    /**
     * Create an ellipse with a specified number of segments.
     *
     * @param rx       radius in the X direction.
     * @param ry       radius in the Y direction.
     * @param segments number of segments used to approximate the ellipse.
     */
    public EllipseShape(int rx, int ry, int segments) {
        this.rx = rx;
        this.ry = ry;
        this.segments = segments;
    }
    
    /**
     * Generate a CompoundCommand to draw this ellipse around (0,0).
     * Starts drawing from (rx, 0).
     *
     * @param name A descriptive name for the command set.
     * @return CompoundCommand describing how to draw the ellipse.
     */
    @Override
    public CompoundCommand getCommands(String name) {
        List<DriverCommand> commands = new ArrayList<>();

        commands.add(new SetPositionCommand(rx, 0));

        double angleIncrement = 2 * Math.PI / this.segments;
        for (int i = 1; i <= this.segments; i++) {
            double angle = i * angleIncrement;
            int x = (int) (this.rx * Math.cos(angle));
            int y = (int) (this.ry * Math.sin(angle));
            commands.add(new OperateToCommand(x, y));
        }

        return new CompoundCommand(commands, name);
    }
}
