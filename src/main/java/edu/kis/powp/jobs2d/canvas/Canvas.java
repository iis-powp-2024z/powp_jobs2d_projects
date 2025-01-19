package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CompoundCommand;

/**
 * Represents a canvas with a specific drawing compound command.
 * Can be drawn.
 */
public class Canvas implements ICanvas{
    private final CompoundCommand command;
    private final String name;
    private final String group;

    /**
     * Create a canvas with a given name and compound command.
     *
     * @param command The compound command representing the canvas shape.
     * @param name The name of the canvas.
     * @param group The group of the canvas.
     */
    public Canvas(CompoundCommand command, String name, String group) {
        this.command = command;
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    /**
     * @return The drawing compound command representing this canvas shape.
     */
    @Override
    public CompoundCommand getCommand() {
        return command;
    }
    
    /**
     * @return The canvas group.
     */
    @Override
    public String getGroup() {
        return group;
    }
    
    
}
