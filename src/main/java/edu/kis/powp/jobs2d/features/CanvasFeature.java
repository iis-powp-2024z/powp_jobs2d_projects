package edu.kis.powp.jobs2d.features;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.canvas.Canvas;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.shapes.EllipseShape;
import edu.kis.powp.jobs2d.shapes.RectangleShape;
import edu.kis.powp.jobs2d.shapes.Shape;

import javax.swing.*;

public class CanvasFeature {
    private static Application application;

    public static void setupCanvasFeature(Application app) {
        application = app;
        application.addComponentMenu(CanvasFeature.class, "Canvas Settings", 0);

        JMenu mainMenu = getMainMenu();
        String[] aFormatsMenuItems = {"a0", "a1", "a2", "a3", "a4"};
        String[] bFormatsMenuItems = {"b0", "b1", "b2", "b3", "b4"};

        JMenu aFormatsMenu = new JMenu("a formats");
        JMenu bFormatsMenu = new JMenu("b formats");

        for (String itemName : aFormatsMenuItems) {
            addMenuItem(aFormatsMenu, new RectangleShape(itemName), itemName);
        }

        for (String itemName : bFormatsMenuItems) {
            addMenuItem(bFormatsMenu, new RectangleShape(itemName), itemName);
        }

        addMenuItem(mainMenu, new EllipseShape(200, 200), "eclipse");

        mainMenu.add(aFormatsMenu);
        mainMenu.add(bFormatsMenu);
    }

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

    private static JMenu findMenu(JMenuBar menuBar) {
        return java.util.stream.IntStream.range(0, menuBar.getMenuCount())
                .mapToObj(menuBar::getMenu)
                .filter(menu -> "Canvas Settings".equals(menu.getText()))
                .findFirst()
                .orElse(null);
    }

    private static void addMenuItem(JMenu menu, Shape shape, String name) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(e -> drawCanvas(new Canvas(shape)));
        menu.add(menuItem);
    }

    public static void drawCanvas(Canvas canvas) {
        DriverManager driver = DriverFeature.getDriverManager();
        canvas.draw(driver);
    }
}
