package edu.kis.powp.jobs2d.drivers.logger;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;

public interface LoggerDriver extends VisitableJob2dDriver {
    void setExtendedLogger(boolean extendedLogger);
}
