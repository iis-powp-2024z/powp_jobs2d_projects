package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.drivers.DriverManager;

/**
 * Interface defining the structure of a canvas.
 */
public interface ICanvas {
    /**
     * Draw the canvas shape using the current driver.
     *
     * @param driverManager The driver manager providing access to the current driver.
     */
    void draw(DriverManager driverManager);

    /**
     * @return The name of this canvas.
     */
    String getName();

    /**
     * @return The drawing commands representing this canvas shape.
     */
    CompoundCommand getCommand();
    
    /**
     * 
     * @return The group of the canvas.
     */
    String getGroup();
}