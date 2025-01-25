package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;

public class DriversHierarchyVisitor implements IVisitor {
    @Override
    public void visit(DriverComposite driver) {
    }

    @Override
    public void visit(DriverDecorator driver) {
    }


    @Override
    public void visit(Job2dDriver driver) {
    }
}
