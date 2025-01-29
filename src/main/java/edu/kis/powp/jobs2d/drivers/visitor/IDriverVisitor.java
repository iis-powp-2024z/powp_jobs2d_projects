package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

public interface IDriverVisitor {
    void visit(IDriverComposite driver);
    void visit(VisitableJob2dDriver driver);
    void visit(DriverDecorator driver);
    void visit(LoggerDriver driver);
}
