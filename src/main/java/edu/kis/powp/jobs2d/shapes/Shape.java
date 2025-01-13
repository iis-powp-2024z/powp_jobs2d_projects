package edu.kis.powp.jobs2d.shapes;

import edu.kis.powp.jobs2d.command.CompoundCommand;

/**
 * Shape interface for generating drawing commands.
 */
public interface Shape {

    /**
     * Generate a CompoundCommand (list of DriverCommands) to draw this shape.
     *
     * @param name A descriptive name for the command set (e.g. "A4 rectangle").
     * @return CompoundCommand describing how to draw the shape.
     */
    CompoundCommand getCommands(String name);
}
