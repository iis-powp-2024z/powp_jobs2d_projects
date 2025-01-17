package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CanvasCommandsFactory;

/**
 * Specialized canvas for rectangular shapes.
 */

public class RectangleCanvas extends Canvas{
    private Format format;

    public static final String GROUP_A = "a";
    public static final String GROUP_B = "b";
    
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
        A4(210, 297, GROUP_A),
        A3(297, 420, GROUP_A),
        A2(420, 594, GROUP_A),
        A1(594, 841, GROUP_A),
        A0(841, 1189, GROUP_A),
        B4(250, 353, GROUP_B),
        B3(353, 500, GROUP_B),
        B2(500, 707, GROUP_B),
        B1(707, 1000, GROUP_B),
        B0(1000, 1414, GROUP_B);

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
