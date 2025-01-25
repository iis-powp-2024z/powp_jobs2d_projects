package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;

public class DriversHierarchyVisitor implements IVisitor {
    @Override
    public void visitComposite(DriverComposite driver) {

    }

    @Override
    public void visitSingleDriver(Job2dDriver driver) {

    }
}
