package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

public interface LineDriver extends Job2dDriver {
    void accpet(IVisitor visitor);
}