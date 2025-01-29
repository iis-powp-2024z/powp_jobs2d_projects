package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

import java.util.List;

public class DriversCountVisitor implements IDriverVisitor {
    private long count = 0;

    public long getCount() {
        return count;
    }

    @Override
    public void visit(IDriverComposite driver) {
        count = 1;
        List<VisitableJob2dDriver> drivers = driver.getDrivers();
        drivers.forEach(d -> d.accept(this));
    }

    @Override
    public void visit(DriverDecorator driver) {
        count = 1;
        VisitableJob2dDriver wrappedDriver = driver.getDriver();
        wrappedDriver.accept(this);
    }

    @Override
    public void visit(VisitableJob2dDriver driver) {
        count = 1;
    }

    @Override
    public void visit(LoggerDriver driver) {
        count = 1;
    }
}