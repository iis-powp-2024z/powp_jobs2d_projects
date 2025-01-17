package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CanvasCommandsFactory;

/**
 * Specialized canvas for rectangular shapes.
 */

public class RectangleCanvas extends Canvas{
    private Format format;
    
    /**
     * Creates a rectangle canvas with a predefined format.
     *
     * @param format The rectangle format (e.g., A4, B3).
     */
    public RectangleCanvas(Format format) {
        super(CanvasCommandsFactory.createRectangleCommand(format.getWidth(), format.getHeight(), format.name()), format.name(), format.name());
        this.format = format;
    }
    
    /**
     * Creates a rectangle canvas with custom dimensions.
     *
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public RectangleCanvas(int width, int height, String name, String group) {
        super(CanvasCommandsFactory.createRectangleCommand(width, height, name), name, group);
        this.format = null; // Indicates custom dimensions
    }
    
    /**
     * Enum representing predefined format of rectangles.
     */
    public enum Format {
        A4(210, 297, "a"),
        A3(297, 420, "a"),
        A2(420, 594, "a"),
        A1(594, 841, "a"),
        A0(841, 1189, "a"),
        B4(250, 353, "b"),
        B3(353, 500, "b"),
        B2(500, 707, "b"),
        B1(707, 1000, "b"),
        B0(1000, 1414, "b");

        private final int width;
        private final int height;
        private final String group;
        

        Format(int width, int height, String group) {
            this.width = width;
            this.height = height;
            this.group = group;
        }
        
        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
    
    /**
     * Gets the format of the rectangle.
     *
     * @return The rectangle format.
     */
    public Format getFormat() {
        return format;
    }
    
    /**
     * Gets the group of the rectangle.
     *
     * @return The rectangle format. If format from enum is not specified, returns "custom"
     */
    public String getGroup() {
        if (format == null) {
            return "custom";
        }
        return format.group;
    }
}
