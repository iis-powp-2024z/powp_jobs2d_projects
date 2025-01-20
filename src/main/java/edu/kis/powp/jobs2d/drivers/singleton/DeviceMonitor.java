package edu.kis.powp.jobs2d.drivers.singleton;

import java.util.logging.Logger;

public final class DeviceMonitor {
    private static DeviceMonitor instance;
    private int previousX = 0, previousY = 0;
    private double setPositionDistance = 0.0;
    private double operateToDistance = 0.0;
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public double getSetPositionDistance() {
        return this.setPositionDistance;
    }

    public double getOperateToDistance() {
        return this.operateToDistance;
    }

    public double getWorkDistance() {
        return this.setPositionDistance + this.operateToDistance;
    }

    public static DeviceMonitor getInstance() {
        if (instance == null) {
            instance = new DeviceMonitor();
        }
        return instance;
    }

    public void calculateSetPositionDistance(int newX, int newY){
        setPositionDistance = calculate(newX, newY, setPositionDistance);
        logger.info("Traveled setPosition distance: " + instance.getSetPositionDistance());
    }

    public void calculateOperateToDistance(int newX, int newY){
        operateToDistance = calculate(newX, newY, operateToDistance);
        logger.info("Traveled operateTo distance: " + instance.getOperateToDistance());

    }

    private double calculate(int newX, int newY, double distanceToAdd){
        //d=√((x_2-x_1)²+(y_2-y_1)²
        double distance = Math.sqrt(Math.pow(newX - previousX, 2) + Math.pow(newY - previousY, 2));
        previousX = newX;
        previousY = newY;
        return (distanceToAdd + distance);
    }

}
