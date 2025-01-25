package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;

public class DriversHierarchyVisitor implements IVisitor {
    @Override
    public void visit(DriverComposite driver) {
        // Code before
        driver.visitDrivers(this);
        // Code after
    }

    @Override
    public void visit(Job2dDriver driver) {
    }
}
