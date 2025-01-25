package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.CanvasFeature;

import java.util.logging.Logger;

public class CanvasRestrictionDriver implements Job2dDriver {
    private final Logger logger = Logger.getLogger("global");
    public Job2dDriver driver;

    public CanvasRestrictionDriver(Job2dDriver driver) {
        this.setCurrentDriver(driver);
    }

    public void setCurrentDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    public void setPosition(int x, int y) {
        if (this.checkCanvasBoundaries(x, y)) {
            this.driver.setPosition(x, y);
        } else {
            this.logger.info("Operation would exceed canvas area");
        }
    }

    public void operateTo(int x, int y) {
        if (this.checkCanvasBoundaries(x, y)) {
            this.driver.operateTo(x, y);
        } else {
            this.logger.info("Operation would exceed canvas area");
        }
    }

    public Boolean checkCanvasBoundaries(int x, int y) {
        if (CanvasFeature.getCurrentCanvas() == null) return true;
        return CanvasFeature.getCurrentCanvas().checkIfPointInside(x, y);
    }

    public String toString() {
        return "Canvas restriction driver";
    }
}

