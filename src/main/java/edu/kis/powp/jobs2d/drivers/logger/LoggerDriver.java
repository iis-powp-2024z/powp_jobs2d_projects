package edu.kis.powp.jobs2d.drivers.logger;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface LoggerDriver extends VisitableJob2dDriver {
    void setExtendedLogger(boolean extendedLogger);

    @Override
    default long accept(IDriverVisitor visitor) {
        return visitor.visit(this);
    }
}
