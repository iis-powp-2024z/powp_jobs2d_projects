package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;
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
        DriverDecorator driverDecorator = (DriverDecorator) DriverFeature.getDriverManager().getCurrentDriver();
        Job2dDriver currentDriver = driverDecorator.getDriver();
        if (currentDriver instanceof DriverDecorator) {
            currentDriver = ((DriverDecorator) currentDriver).getDriver();
        }

        if (currentDriver instanceof DriverComposite) {
            ((DriverComposite) currentDriver).accept(visitor);
        } else if (currentDriver instanceof LineSimulatorDriver) {
            ((LineSimulatorDriver) currentDriver).accept(visitor);
        } else {
            ((LoggerDriver) currentDriver).accept(visitor);
        }
        logger.info("Used drivers count: " + visitor.getDriversCount());
    }
}