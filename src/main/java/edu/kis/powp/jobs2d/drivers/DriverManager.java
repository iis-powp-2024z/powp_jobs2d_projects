package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
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
    private final DeviceMonitorDriver deviceMonitorDriver = new DeviceMonitorDriver();

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
        if (driver instanceof TransformationDriver) {
            Job2dDriver innerTransformationDriver = ((TransformationDriver) driver).getDriver();
            deviceMonitorDriver.setDriver(innerTransformationDriver);
            currentDriver = deviceMonitorDriver;

        } else {
            currentDriver = driver;
        }
        publisher.notifyObservers();

    }

    public void addSubscriber(Subscriber subscriber) {
        publisher.addSubscriber(subscriber);
    }

}
