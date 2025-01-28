package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

public class DriversCountVisitor implements IDriverVisitor {
    private long count = 0;

    public long getDriversCount(){
        return count;
    }

    @Override
    public void visit(DriverComposite driver) {
        count += driver.getDrivers().size();
    }

    @Override
    public void visit(DriverDecorator driver) {
        count++;
    }


    @Override
    public void visit(VisitableJob2dDriver driver) {
        count++;
    }

    @Override
    public void visit(LineSimulatorDriver driver) {
        count++;
    }

    @Override
    public void visit(LoggerDriver driver) {
        count ++;
    }
}
