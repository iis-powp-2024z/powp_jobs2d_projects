package edu.kis.powp.jobs2d.drivers;

public final class DeviceMonitor {
    public int previousX, previousY;
    private static DeviceMonitor instance;

    private DeviceMonitor(int previousX, int previousY) {
        this.previousX = previousX;
        this.previousY = previousY;
    }

    public static DeviceMonitor getInstance(int previousX, int previousY) {
        if (instance == null) {
            instance = new DeviceMonitor(previousX, previousY);
        }

        return instance;
    }
}
