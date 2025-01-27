package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

import java.util.logging.Logger;

public class DriversCountVisitor implements IVisitor {
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
    public void visit(Job2dDriver driver) {
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
