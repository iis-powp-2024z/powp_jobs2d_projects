package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface DriverDecorator extends VisitableJob2dDriver {
    VisitableJob2dDriver getDriver();

    void setDriver(VisitableJob2dDriver driver);

    @Override
    default long accept(IDriverVisitor visitor) {
        return visitor.visit(this);
    }
}
