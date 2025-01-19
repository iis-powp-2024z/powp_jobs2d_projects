package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.observer.Subscriber;

public class DeviceMonitorDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final DeviceMonitorDriver deviceMonitorDriver;

    public DeviceMonitorDriverSubscriber(DriverManager driverManager, DeviceMonitorDriver deviceMonitorDriver) {
        this.deviceMonitorDriver = deviceMonitorDriver;
        this.driverManager = driverManager;
    }

    @Override
    public void update() {
        deviceMonitorDriver.setDriver(driverManager.getCurrentDriver());
        driverManager.setCurrentDriver(deviceMonitorDriver);
    }
}