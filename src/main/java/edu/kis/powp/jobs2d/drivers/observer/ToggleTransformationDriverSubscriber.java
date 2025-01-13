package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

public class ToggleTransformationDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final TransformationDriver transformationDriver;

    public ToggleTransformationDriverSubscriber(DriverManager driverManager, TransformationDriver transformationDriver) {
        this.transformationDriver = transformationDriver;
        this.driverManager = driverManager;
    }

    @Override
    public void update() {
        transformationDriver.setDriver(driverManager.getCurrentDriver());
        driverManager.setCurrentDriver(transformationDriver);
    }
}