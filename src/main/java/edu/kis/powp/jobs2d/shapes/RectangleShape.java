package edu.kis.powp.jobs2d.shapes;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

/**
 * This class represents a rectangular shape. It offers two ways to create:
 * 1) by explicit width and height,
 * 2) by a known format name (e.g., "a4", "b3").
 */

public class RectangleShape implements Shape{
    private int width;
    private int height;
	
    /**
     * Create a RectangleShape with given dimensions.
     * 
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    public RectangleShape(int width, int height) {
        this.width = width;
        this.height = height;
    }
	
    /**
     * Create a RectangleShape with given format.
     * 
     * @param format format of the rectangle
     * @throws IllegalArgumentException if the format is not supported.
     */
    public RectangleShape(String format) {
    	switch(format.toLowerCase()) {
    	    case "a4":
    	        this.height = 210;
    	        this.width = 297;
    	        break;
    	    case "a3":
                this.height = 297;
                this.width = 420;
                break;
            case "a2":
                this.height = 420;
                this.width = 594;
                break;
            case "a1":
                this.height = 594;
                this.width = 841;
                break;
            case "a0":
                this.height = 841;
                this.width = 1189;
                break;
            case "b4":
                this.height = 250;
                this.width = 353;
                break;
            case "b3":
                this.height = 353;
                this.width = 500;
                break;
            case "b2":
                this.height = 500;
                this.width = 707;
                break;
            case "b1":
                this.height = 707;
                this.width = 1000;
                break;
            case "b0":
                this.height = 1000;
                this.width = 1414;
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
    	}
	}
    
    /**
     * Generate a CompoundCommand to draw this rectangle.
     * The rectangle is drawn starting at (0,0), going right and down.
     *
     * @param name A descriptive name for the command set.
     * @return CompoundCommand describing how to draw the rectangle.
     */
	@Override
    public CompoundCommand getCommands(String name) {
	    List<DriverCommand> commands = new ArrayList<>();
        commands.add(new SetPositionCommand(0, 0));
        commands.add(new OperateToCommand(this.width, 0));
        commands.add(new OperateToCommand(this.width, this.height));
        commands.add(new OperateToCommand(0, this.height));
        commands.add(new OperateToCommand(0, 0));

        return new CompoundCommand(commands, name);
	}

}
