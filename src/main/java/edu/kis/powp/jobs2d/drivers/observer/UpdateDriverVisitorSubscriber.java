package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.DriversCountVisitor;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

import java.util.logging.Logger;

public class UpdateDriverVisitorSubscriber implements Subscriber {
    private final DriversCountVisitor visitor = new DriversCountVisitor();
    private final Logger logger = Logger.getLogger("global");

    public UpdateDriverVisitorSubscriber() {
        super();
    }

    @Override
    public void update() {
        VisitableJob2dDriver currentDriver = (VisitableJob2dDriver) DriverFeature.getDriverManager().getCurrentDriver();
        currentDriver.accept(visitor);
        logger.info("Drivers count in " + currentDriver.toString() + ": " + visitor.getDriversCount());
    }
}