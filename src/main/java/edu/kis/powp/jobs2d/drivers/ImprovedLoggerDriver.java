package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

import java.util.logging.Logger;

public class ImprovedLoggerDriver implements Job2dDriver {
    private final Logger logger = Logger.getLogger("global");

    private static long setPositionCount = 0;
    private static long operateToCount = 0;
    private boolean extendedLogger = false;

    public ImprovedLoggerDriver(boolean extendedLogger) {
        this.extendedLogger = extendedLogger;
    }

    public void setPosition(int x, int y) {
        this.logger.info(String.format("Position set at [x: %d, y: %d]", x, y));
        if (this.extendedLogger) {
            this.logger.info(String.format("setPosition operations count: %d", ++setPositionCount));
        }
    }

    public void operateTo(int x, int y) {
        this.logger.info(String.format("Operated to [x: %d, y: %d]", x, y));
        if (this.extendedLogger) {
            this.logger.info(String.format("operateTo operations count: %d", ++operateToCount));
        }
    }

    public String toString() {
        return "Logger driver";
    }

    public void visit(IVisitor visitor) {
        visitor.visit(this);
    }
}