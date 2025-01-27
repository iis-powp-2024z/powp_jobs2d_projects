package edu.kis.powp.jobs2d.drivers.composite;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

public interface CompositeDriver extends Job2dDriver {
    void addDriver(Job2dDriver driver);

    void accept(IVisitor visitor);
}