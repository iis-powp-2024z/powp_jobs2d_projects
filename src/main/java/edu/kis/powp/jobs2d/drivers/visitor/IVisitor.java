package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;

public interface IVisitor {
    void visitComposite(DriverComposite driver);
    //void visitObserver(driver);
    void visitSingleDriver(Job2dDriver driver);
}
