package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

import java.util.List;

public class DriversCountVisitor implements IDriverVisitor {
    @Override
    public void visit(IDriverComposite driver) {
        List<VisitableJob2dDriver> drivers = driver.getDrivers();
        return 1 + drivers.stream().mapToLong(d -> d.accept(this)).sum();
    }

    @Override
    public void visit(DriverDecorator driver) {
        VisitableJob2dDriver wrappedDriver = driver.getDriver();
        return 1 + wrappedDriver.accept(this);
    }

    @Override
    public void visit(VisitableJob2dDriver driver) {
        return 1;
    }

    @Override
    public void visit(LoggerDriver driver) {
        return 1;
    }
}