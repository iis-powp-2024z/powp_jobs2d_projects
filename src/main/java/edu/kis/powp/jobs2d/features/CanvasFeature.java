package edu.kis.powp.jobs2d.features;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.canvas.Canvas;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.shapes.EllipseShape;
import edu.kis.powp.jobs2d.shapes.RectangleShape;
import edu.kis.powp.jobs2d.shapes.Shape;

import javax.swing.*;
import java.util.List;

public class CanvasFeature {
    private static Application application;
    private static List<Canvas> canvases = null;
    private static Canvas currentCanvas;

    /**
     * Initializes and sets up the canvas feature for the application.
     * It creates and adds the 'Canvas Settings' menu along with submenus for 'a formats' and 'b formats'.
     * It also adds individual items to the menus for each paper size and shape.
     *
     * @param app The application instance to which the canvas feature will be added.
     */
    public static void setupCanvasFeature(Application app) {
        application = app;
        application.addComponentMenu(CanvasFeature.class, "Canvas Settings", 0);

        JMenu mainMenu = getMainMenu();

        JMenu aFormatsMenu = new JMenu("a formats");
        JMenu bFormatsMenu = new JMenu("b formats");

        for (Canvas canvas : canvases) {
            String name = canvas.getName();

            if (name.toLowerCase().startsWith("a")) {
                addMenuItem(aFormatsMenu, canvas, name);
            } else if (name.toLowerCase().startsWith("b")) {
                addMenuItem(bFormatsMenu, canvas, name);
            } else {
                addMenuItem(mainMenu, canvas, name);
            }
        }


        mainMenu.add(aFormatsMenu);
        mainMenu.add(bFormatsMenu);
    }

    public static void setCanvases(List<Canvas> canvases) {
        CanvasFeature.canvases = canvases;
    }

    /**
     * Retrieves the main menu for the application.
     * If the "Canvas Settings" menu exists, it returns it; otherwise, it creates a new one.
     *
     * @return The main menu for canvas settings.
     */
    private static JMenu getMainMenu() {
        JMenuBar menuBar = application.getFreePanel().getRootPane().getJMenuBar();

        JMenu mainMenu = findMenu(menuBar);
        if (mainMenu != null) {
            return mainMenu;
        }

        mainMenu = new JMenu("Canvas Settings");
        menuBar.add(mainMenu);
        return mainMenu;
    }

    public static Canvas getCurrentCanvas() {
        return currentCanvas;
    }

    /**
     * Searches for an existing menu with the name "Canvas Settings" in the provided menu bar.
     *
     * @param menuBar The menu bar to search in.
     * @return The found menu, or null if no menu with the given name exists.
     */
    private static JMenu findMenu(JMenuBar menuBar) {
        return java.util.stream.IntStream.range(0, menuBar.getMenuCount())
                .mapToObj(menuBar::getMenu)
                .filter(menu -> "Canvas Settings".equals(menu.getText()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Adds a new menu item to the specified menu.
     * The item is associated with a shape and its action triggers the drawing of a canvas.
     *
     * @param menu The menu to which the item will be added.
     * @param canvas The shape associated with the menu item.
     * @param name The name of the menu item.
     */
    private static void addMenuItem(JMenu menu, Canvas canvas, String name) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(e -> {
            currentCanvas = canvas;
            drawCanvas(canvas);
        });
        menu.add(menuItem);
    }

    /**
     * Triggers the drawing of the given canvas. It retrieves the driver manager and delegates the drawing operation.
     *
     * @param canvas The canvas to be drawn.
     */
    public static void drawCanvas(Canvas canvas) {
        DriverManager driver = DriverFeature.getDriverManager();
        canvas.draw(driver);
    }
}
