package edu.kis.powp.jobs2d.features;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.ToggleTransformationOptionListener;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;
import edu.kis.powp.jobs2d.drivers.observer.ToggleTransformationDriverSubscriber;
import edu.kis.powp.observer.Publisher;

public class TransformationFeature {
    private static final TransformationDriver transformationDriver = new TransformationDriver();
    private static final Publisher publisher = new Publisher();
    private static Application app;

    /**
     * Setup jobs2d drivers Plugin and add to application.
     *
     * @param application Application context.
     */
    public static void setupTransformationPlugin(Application application, DriverManager driverManager) {
        app = application;
        app.addComponentMenu(TransformationFeature.class, "Transformations");

        ToggleTransformationDriverSubscriber subscriber = new ToggleTransformationDriverSubscriber(driverManager, transformationDriver);
        driverManager.addSubscriber(subscriber);
    }

    /**
     * Add driver to context, create button in driver menu.
     *
     * @param name          Button name.
     */
    public static void addTransformation(String name, TransformationMethod transformationMethod) {
        ToggleTransformationOptionListener listener = new ToggleTransformationOptionListener(transformationDriver, transformationMethod, publisher);
        app.addComponentMenuElementWithCheckBox(TransformationFeature.class, name, listener, false);
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
