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

    /**
     * @return If point is inside canvas then true, else false.
     */
    Boolean checkIfPointInside(int x, int y);
}