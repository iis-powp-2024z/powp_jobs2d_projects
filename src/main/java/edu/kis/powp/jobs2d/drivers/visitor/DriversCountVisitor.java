package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

import java.util.List;
import java.util.stream.Collectors;

public class DriversCountVisitor implements IDriverVisitor {
    private long count = 0;

    public long getDriversCount() {
        long tmpCount = count;
        count = 0;
        return tmpCount;
    }

    @Override
    public void visit(IDriverComposite driver) {
        List<VisitableJob2dDriver> drivers = driver.getDrivers().stream()
                .map(driver1 -> (VisitableJob2dDriver) driver1)
                .collect(Collectors.toList());

        drivers.forEach(driver1 -> driver1.accept(this));
    }

    @Override
    public void visit(DriverDecorator driver) {
        VisitableJob2dDriver wrappedDriver = (VisitableJob2dDriver) driver.getDriver();
        wrappedDriver.accept(this);
        count++;
    }


    @Override
    public void visit(VisitableJob2dDriver driver) {
        count++;
    }

    @Override
    public void visit(LoggerDriver driver) {
        count++;
    }
}
