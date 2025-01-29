package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.canvas.ICanvas;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.features.CanvasFeature;

import java.util.logging.Logger;

public class CanvasRestrictionDriverDecorator implements DriverDecorator {
    private final Logger logger = Logger.getLogger("global");
    public Job2dDriver driver;

    public CanvasRestrictionDriverDecorator(Job2dDriver driver) {
        this.setDriver(driver);
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    public Job2dDriver getDriver() {
        return this.driver;
    }

    public void setPosition(int x, int y) {
        if (this.checkCanvasBoundaries(x, y)) {
            this.driver.setPosition(x, y);
        } else {
            this.logger.warning("Operation would exceed canvas area");
        }
    }

    public void operateTo(int x, int y) {
        if (this.checkCanvasBoundaries(x, y)) {
            this.driver.operateTo(x, y);
        } else {
            this.logger.warning("Operation would exceed canvas area");
        }
    }

    public Boolean checkCanvasBoundaries(int x, int y) {
        ICanvas currentCanvas = CanvasFeature.getCurrentCanvas();
        return currentCanvas != null ? currentCanvas.checkIfPointInside(x, y) : true;
    }
}

