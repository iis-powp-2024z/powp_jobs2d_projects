package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.ToggleTransformationOptionListener;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;

public class TransformationFeature {

    private static Application app;

    /**
     * Setup jobs2d drivers Plugin and add to application.
     *
     * @param application Application context.
     */
    public static void setupTransformationPlugin(Application application) {
        app = application;
        app.addComponentMenu(TransformationFeature.class, "Transformations");
    }

    /**
     * Add driver to context, create button in driver menu.
     *
     * @param name          Button name.
     * @param driverManager DriverManager object.
     */
    public static void addTransformation(String name, DriverManager driverManager, TransformationMethod transformationMethod) {
        ToggleTransformationOptionListener listener = new ToggleTransformationOptionListener(driverManager, transformationMethod);
        app.addComponentMenuElementWithCheckBox(TransformationFeature.class, name, listener, false);
    }
}
