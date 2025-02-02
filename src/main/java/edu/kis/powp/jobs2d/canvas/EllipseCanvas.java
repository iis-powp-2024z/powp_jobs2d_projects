package edu.kis.powp.jobs2d.canvas;

import edu.kis.powp.jobs2d.command.CanvasCommandsFactory;

/**
 * Specialized canvas for elliptical shapes.
 */
public class EllipseCanvas extends Canvas {
    private final Type type;
    private Integer ry;
    private Integer rx;
    /**
     * Creates an ellipse canvas with a predefined type.
     *
     * @param type The type of the ellipse (CIRCLE, ELLIPSE).
     */
    public EllipseCanvas(Type type) {
        super(CanvasCommandsFactory.createEllipseCommand(
                type.getRx(), type.getRy(), type.name()), type.name(), type.name()
                );
        this.type = type;
        this.rx = type.getRx();
        this.ry = type.getRy();
    }
    
    /**
     * Creates a ellipse canvas with custom dimensions.
     *
     * @param rx Radius along the X-axis.
     * @param ry Radius along the Y-axis.
     */
    public EllipseCanvas(int rx, int ry, String name, String group) {
        super(CanvasCommandsFactory.createEllipseCommand(rx, ry, name), name, group);
        this.rx = rx;
        this.ry = ry;
        this.type = null; // Indicates custom dimensions
    }

    /**
     * Enum representing predefined types of ellipses.
     */
    public enum Type {
        CIRCLE(200, 200, "cirlce"),
        LARGE_CIRCLE(500, 500, "circle"),
        ELLIPSE(300, 150, "ellipse"),
        LARGE_ELLIPSE(400, 250, "ellipse");

        private final int rx;
        private final int ry;
        private final String group;

        Type(int rx, int ry, String group) {
            this.rx = rx;
            this.ry = ry;
            this.group = group;
        }

        public int getRx() {
            return rx;
        }

        public int getRy() {
            return ry;
        }
    }

    /**
     * Gets the type of the ellipse.
     *
     * @return The ellipse type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Gets the radius x of the ellipse.
     *
     * @return radius x of the ellipse.
     */
    public Integer getRx() {
        return this.rx;
    }

    /**
     * Gets the radius y of the ellipse.
     *
     * @return radius y of the ellipse.
     */
    public Integer getRy() {
        return this.ry;
    }
    
    /**
     * Gets the group of the ellipse.
     *
     * @return The ellipse type. If type from enum is not specified, returns "custom"
     */
    public String getGroup() {
        if (type == null) {
            return "custom";
        }
        return type.group;
    }

    /**
     * Check if point from given coordinates is inside ellipse.
     *
     * @return true if inside, else false
     */
    public Boolean checkIfPointInside(int x, int y) {
        double normalizedX = Math.pow(x, 2) / Math.pow(this.getRx(), 2);
        double normalizedY = Math.pow(y, 2) / Math.pow(this.getRy(), 2);
        return normalizedX + normalizedY <= 1;
    }
}
