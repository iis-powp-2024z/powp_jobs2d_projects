package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;

import edu.kis.powp.observer.Publisher;
import edu.kis.powp.observer.Subscriber;

/**
 * Driver manager provides means to setup the driver. It also enables other
 * components and features of the application to react on configuration changes.
 */
public class DriverManager {

    private Job2dDriver currentDriver = new ImprovedLoggerDriver(false);
    private final Publisher publisher = new Publisher();


    /**
     * @return Current driver.
     */
    public synchronized Job2dDriver getCurrentDriver() {
        return currentDriver;
    }

    /**
     * @param driver Set the driver as current.
     */
    public synchronized void setCurrentDriver(Job2dDriver driver) {
        currentDriver = driver;
        publisher.notifyObservers();
    }

    public void addSubscriber(Subscriber subscriber) {
        publisher.addSubscriber(subscriber);
    }

}
