package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.shapes.Shape;

/**
 * Represents a canvas that has a Shape.
 * Can be drawn.
 */
public class Canvas {
    private final Shape shape;

    /**
     * Create a canvas with a given shape.
     *
     * @param shape The shape representing the "outline" of this canvas or its visible area.
     */
    public Canvas(Shape shape) {
        this.shape = shape;
    }

    /**
     * Draw the canvas shape on the current driver.
     *
     * @param driverManager The driver manager providing access to the current driver.
     */
    public void draw(DriverManager driverManager) {
        CompoundCommand commands = shape.getCommands("Canvas shape");
        commands.execute(driverManager.getCurrentDriver());
    }

    /**
     * @return The shape composing this canvas (e.g. for bounding-box checks).
     */
    public Shape getShape() {
        return shape;
    }
}
