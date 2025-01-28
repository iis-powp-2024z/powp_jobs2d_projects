package edu.kis.powp.jobs2d.drivers.logger;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface LoggerDriver extends Job2dDriver {
    void setExtendedLogger(boolean extendedLogger);
    default void accept(IDriverVisitor visitor){
        visitor.visit(this);
    }
}