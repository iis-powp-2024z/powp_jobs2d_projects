package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.DriverComposite;
import edu.kis.powp.jobs2d.drivers.LineSimulatorDriver;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

public interface IVisitor {
    void visit(DriverComposite driver);
    void visit(VisitableJob2dDriver driver);
    void visit(DriverDecorator driver);
    void visit(LineSimulatorDriver driver);
    void visit(LoggerDriver driver);
}
