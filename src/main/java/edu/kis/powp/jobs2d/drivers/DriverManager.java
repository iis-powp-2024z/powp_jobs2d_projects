package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriverAdapter;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;

import edu.kis.powp.observer.Publisher;
import edu.kis.powp.observer.Subscriber;

/**
 * Driver manager provides means to setup the driver. It also enables other
 * components and features of the application to react on configuration changes.
 */
public class DriverManager {
    private final Publisher publisher = new Publisher();
    private final TransformationDriverAdapter transformationDriverAdapter = new TransformationDriverAdapter();


    /**
     * @return Current driver.
     */
    public synchronized Job2dDriver getCurrentDriver() {
        return transformationDriverAdapter;
    }

    /**
     * @param driver Set the driver as current.
     */
    public synchronized void setCurrentDriver(Job2dDriver driver) {
        transformationDriverAdapter.setDriver(driver);
        publisher.notifyObservers();
    }

    public void addSubscriber(Subscriber subscriber) {
        publisher.addSubscriber(subscriber);
    }

    public void addTransformationMethod(TransformationMethod transformationMethod) {
        transformationDriverAdapter.addTransformationMethod(transformationMethod);
    }
    
    public void removeTransformationMethod(TransformationMethod transformationMethod) {
        transformationDriverAdapter.removeTransformationMethod(transformationMethod);
    }
}
