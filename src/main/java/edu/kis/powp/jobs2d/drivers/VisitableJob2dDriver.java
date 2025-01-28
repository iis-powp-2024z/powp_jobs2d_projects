package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

public interface VisitableJob2dDriver extends Job2dDriver {
    void accept(IVisitor visitor);
}
