package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;

import java.util.logging.Logger;

public class DriversHierarchyVisitor implements IVisitor {

    @Override
    public void visit(DriverComposite driver) {
        Logger logger = Logger.getLogger("global");
        logger.info("Composite contains " + driver.countDrivers() + " drivers");
    }

    @Override
    public void visit(DriverDecorator driver) {

    }


    @Override
    public void visit(Job2dDriver driver) {
    }

    @Override
    public void visit(LineSimulatorDriver driver) {
    }
}
