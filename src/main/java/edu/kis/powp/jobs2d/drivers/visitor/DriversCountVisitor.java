package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

public class DriversCountVisitor implements IDriverVisitor {
    private long count = 0;

    public long getDriversCount(){
        long tmpCount = count;
        count = 0;
        return tmpCount;
    }

    @Override
    public void visit(DriverComposite driver) {
        for (Job2dDriver innerDriver : driver.getDrivers()) {
            if (innerDriver instanceof VisitableJob2dDriver) {
                ((VisitableJob2dDriver) innerDriver).accept(this);
            }
        }
    }

    @Override
    public void visit(DriverDecorator driver) {
        Job2dDriver wrappedDriver = driver.getDriver();
        if (wrappedDriver instanceof VisitableJob2dDriver) {
            ((VisitableJob2dDriver) wrappedDriver).accept(this);
        }
        count++;
    }


    @Override
    public void visit(VisitableJob2dDriver driver) {
        count++;
    }

    @Override
    public void visit(LoggerDriver driver) {
        count ++;
    }
}
