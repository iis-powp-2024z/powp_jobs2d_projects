package edu.kis.powp.jobs2d.drivers.singleton;

import java.util.logging.Logger;

public final class DeviceMonitor {
    private static DeviceMonitor instance;
    private int previousX = 0, previousY = 0;
    private double traversedDistance = 0.0;
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public double getTraversedDistance() {
        return this.traversedDistance;
    }

    private DeviceMonitor(int previousX, int previousY) {
        this.previousX = previousX;
        this.previousY = previousY;
    }

    public static DeviceMonitor getInstance(int x, int y) {
        if (instance == null) {
            instance = new DeviceMonitor(x, y);
        }

        instance.calculateDistance(x, y);
        logger.info("Traveled distance: " + instance.getTraversedDistance());
        return instance;
    }

    public void calculateDistance(int newX, int newY) {
        //d=√((x_2-x_1)²+(y_2-y_1)²
        double distance = Math.sqrt(Math.pow(newX - previousX, 2) + Math.pow(newY - previousY, 2));
        traversedDistance += distance;
        previousX = newX;
        previousY = newY;
    }

}
