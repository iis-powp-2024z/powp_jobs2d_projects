package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CompoundCommand;

/**
 * Interface defining the structure of a canvas.
 */
public interface ICanvas {
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