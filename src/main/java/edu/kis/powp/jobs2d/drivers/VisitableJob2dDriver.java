package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface VisitableJob2dDriver extends Job2dDriver {
    void accept(IDriverVisitor visitor);
}
