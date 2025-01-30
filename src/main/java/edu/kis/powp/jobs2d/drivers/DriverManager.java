package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.observer.Publisher;
import edu.kis.powp.observer.Subscriber;

/**
 * Driver manager provides means to setup the driver. It also enables other
 * components and features of the application to react on configuration changes.
 */
public class DriverManager {

    private final Publisher publisher = new Publisher();
    private VisitableJob2dDriver currentDriver = new ImprovedLoggerDriver(false);

    /**
     * @return Current driver.
     */
    public synchronized VisitableJob2dDriver getCurrentDriver() {
        return currentDriver;
    }

    /**
     * @param driver Set the driver as current.
     */
    public synchronized void setCurrentDriver(VisitableJob2dDriver driver) {
        currentDriver = driver;
        publisher.notifyObservers();
    }

    public void addSubscriber(Subscriber subscriber) {
        publisher.addSubscriber(subscriber);
    }

}
