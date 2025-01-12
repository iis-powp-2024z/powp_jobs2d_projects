package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.SelectDriverMenuOptionListener;
import edu.kis.powp.jobs2d.drivers.observer.UpdateDriverInfoSubscriber;

public class TransformationFeature {

    private static DriverManager driverManager = new DriverManager();
    private static Application app;

    public static DriverManager getDriverManager() {
        return driverManager;
    }

    /**
     * Setup jobs2d drivers Plugin and add to application.
     *
     * @param application Application context.
     */
    public static void setupTransformationPlugin(Application application) {
        app = application;
        app.addComponentMenu(TransformationFeature.class, "Transformation");

        UpdateDriverInfoSubscriber updateDriverInfoSubscriber = new UpdateDriverInfoSubscriber(app);
        driverManager.addSubscriber(updateDriverInfoSubscriber);
    }

    /**
     * Add driver to context, create button in driver menu.
     * 
     * @param name   Button name.
     * @param driver Job2dDriver object.
     */
    public static void addDriver(String name, Job2dDriver driver) {
        SelectDriverMenuOptionListener listener = new SelectDriverMenuOptionListener(driver, driverManager);
        app.addComponentMenuElementWithCheckBox(TransformationFeature.class, name, listener, false);
    }
}
