package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface LineSimulatorDriver extends Job2dDriver {
    default void accept(IDriverVisitor visitor) {
        visitor.visit(this);
    }
}