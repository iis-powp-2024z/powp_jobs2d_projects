package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;

public class UsageMonitorFeature {

    private static DeviceMonitorDriver deviceMonitorDriver = new DeviceMonitorDriver();

    public static DeviceMonitorDriver getDeviceMonitorDriver() {
        return deviceMonitorDriver;
    }
}
