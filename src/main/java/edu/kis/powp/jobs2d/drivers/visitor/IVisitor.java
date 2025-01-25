package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;

public interface IVisitor {
    void visit(DriverComposite driver);
    //void visitObserver(driver);
    void visit(Job2dDriver driver);
}
