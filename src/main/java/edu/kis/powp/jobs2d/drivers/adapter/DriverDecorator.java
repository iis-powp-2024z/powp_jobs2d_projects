package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface DriverDecorator extends Job2dDriver {
    Job2dDriver getDriver();

    void setDriver(Job2dDriver driver);

    default void accept(IDriverVisitor visitor) {
        visitor.visit(this);
    }
}
