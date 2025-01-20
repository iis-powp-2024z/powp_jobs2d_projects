package edu.kis.powp.jobs2d;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.canvas.EllipseCanvas;
import edu.kis.powp.jobs2d.canvas.ICanvas;
import edu.kis.powp.jobs2d.canvas.RectangleCanvas;
import edu.kis.powp.jobs2d.canvas.RectangleCanvas.Format;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindow;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindowCommandChangeObserver;
import edu.kis.powp.jobs2d.command.parser.jackson.JacksonParserFactory;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.ImprovedLoggerDriver;
import edu.kis.powp.jobs2d.drivers.decorator.RealTimeDrawingDriverDecorator;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationFlip;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationFlipAxis;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationScale;
import edu.kis.powp.jobs2d.events.*;
import edu.kis.powp.jobs2d.features.CommandsFeature;
import edu.kis.powp.jobs2d.features.DrawerFeature;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.jobs2d.features.MouseClickDrawFeature;
import edu.kis.powp.jobs2d.features.CanvasFeature;
import edu.kis.powp.jobs2d.features.*;

public class TestJobs2dApp {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Setup test concerning preset figures in context.
     *
     * @param application Application context.
     */
    private static void setupPresetTests(Application application) {
        SelectTestFigureOptionListener selectTestFigureOptionListener = new SelectTestFigureOptionListener(DriverFeature.getDriverManager());
        SelectTestFigure2OptionListener selectTestFigure2OptionListener = new SelectTestFigure2OptionListener(DriverFeature.getDriverManager());

        application.addTest("Figure Joe 1", selectTestFigureOptionListener);
        application.addTest("Figure Joe 2", selectTestFigure2OptionListener);
    }

    /**
     * Setup test using driver commands in context.
     *
     * @param application Application context.
     */
    private static void setupCommandTests(Application application) {
        application.addTest("Load secret command", new SelectLoadSecretCommandOptionListener());
        application.addTest("Triangle command", new SelectLoadTriangleCommandOptionListener());

        application.addTest("Run command", new SelectRunCurrentCommandOptionListener(DriverFeature.getDriverManager()));
    }

    /**
     * Setup driver manager, and set default Job2dDriver for application.
     *
     * @param application Application context.
     */
    private static void setupDrivers(Application application) {
        DriverComposite driverComposite = new DriverComposite();    // addidtion to composite

        Job2dDriver loggerDriver = new ImprovedLoggerDriver(false);
        DriverFeature.addDriver("Logger driver", loggerDriver);

        Job2dDriver extendedLoggerDriver = new ImprovedLoggerDriver(true);
        DriverFeature.addDriver("Extended logger driver", extendedLoggerDriver);

        DrawPanelController drawerController = DrawerFeature.getDrawerController();
        Job2dDriver driver = new LineDriverAdapter(drawerController, LineFactory.getBasicLine(), "basic");

        DriverFeature.addDriver("Line Simulator", driver);
        DriverFeature.getDriverManager().setCurrentDriver(driver);
        driverComposite.addDriver(driver);  // addidtion to composite

        Job2dDriver fastRealTimeDriver = new RealTimeDrawingDriverDecorator(driver, 1000, 10);
        DriverFeature.addDriver("Line Simulator (Real Time)", fastRealTimeDriver);

        driver = new LineDriverAdapter(drawerController, LineFactory.getSpecialLine(), "special");
        DriverFeature.addDriver("Special line Simulator", driver);

        Job2dDriver specialRealTimeDriver = new RealTimeDrawingDriverDecorator(driver, 100, 1);
        DriverFeature.addDriver("Special Line Simulator (Real Time)", specialRealTimeDriver);

        // Composite usage
        driverComposite.addDriver(loggerDriver);
        driverComposite.addDriver(driver);

        DriverFeature.addDriver("Lines (including special) and logger", driverComposite);
    }

    private static void setupTransformations() {
        TransformationFeature.addTransformation("Scale 2x", DriverFeature.getDriverManager(), new TransformationScale(2.0));
        TransformationFeature.addTransformation("Scale 0.5x", DriverFeature.getDriverManager(), new TransformationScale(0.5));
        TransformationFeature.addTransformation("Flip X", DriverFeature.getDriverManager(), new TransformationFlip(TransformationFlipAxis.X));
        TransformationFeature.addTransformation("Flip Y", DriverFeature.getDriverManager(), new TransformationFlip(TransformationFlipAxis.Y));
    }

    private static void setupWindows(Application application) {
        CommandManagerWindow commandManager = new CommandManagerWindow(CommandsFeature.getDriverCommandManager(), new JacksonParserFactory());
        application.addWindowComponent("Command Manager", commandManager);

        CommandManagerWindowCommandChangeObserver windowObserver = new CommandManagerWindowCommandChangeObserver(commandManager);
        CommandsFeature.getDriverCommandManager().getChangePublisher().addSubscriber(windowObserver);
    }

    /**
     * Setup menu for adjusting logging settings.
     *
     * @param application Application context.
     */
    private static void setupLogger(Application application) {
        application.addComponentMenu(Logger.class, "Logger", 0);
        application.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> application.flushLoggerOutput());
        application.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> logger.setLevel(Level.FINE));
        application.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> logger.setLevel(Level.INFO));
        application.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> logger.setLevel(Level.WARNING));
        application.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> logger.setLevel(Level.SEVERE));
        application.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> logger.setLevel(Level.OFF));
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Application app = new Application("Jobs 2D");
                DrawerFeature.setupDrawerPlugin(app);
                CommandsFeature.setupCommandManager();

                List<ICanvas> canvases = new ArrayList<>();
                for (Format format : Format.values()) {
                    canvases.add(new RectangleCanvas(format));
                }
                canvases.add(new RectangleCanvas(200, 100, "Rectangle 200x100", "custom"));
                canvases.add(new EllipseCanvas(150, 100, "Ellipse rx:150 ry:100", "custom"));

                CanvasFeature.setCanvases(canvases);
                CanvasFeature.setupCanvasFeature(app);

                DriverFeature.setupDriverPlugin(app);
                TransformationFeature.setupTransformationPlugin(app, DriverFeature.getDriverManager());
                setupTransformations();
                setupDrivers(app);
                setupPresetTests(app);
                setupCommandTests(app);
                setupLogger(app);
                setupWindows(app);

                MouseClickDrawFeature.setupMousePlugin(app, DriverFeature.getDriverManager());

                app.setVisibility(true);
            }
        });
    }

}
