package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;

public interface IVisitor {
    void visit(DriverComposite driver);
    void visit(Job2dDriver driver);
    void visit(DriverDecorator driver);
    void visit(LineSimulatorDriver driver);
}
