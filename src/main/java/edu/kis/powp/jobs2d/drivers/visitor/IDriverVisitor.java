package edu.kis.powp.jobs2d.drivers.visitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.logger.LoggerDriver;

public interface IDriverVisitor {
    long visit(IDriverComposite driver);
    long visit(VisitableJob2dDriver driver);
    long visit(DriverDecorator driver);
    long visit(LoggerDriver driver);
}
