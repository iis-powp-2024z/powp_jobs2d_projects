package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

public interface LineSimulatorDriver extends Job2dDriver {
    default void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}