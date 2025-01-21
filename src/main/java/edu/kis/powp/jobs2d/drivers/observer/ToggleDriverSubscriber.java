package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.ToggleDriver;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.observer.Subscriber;

public class ToggleDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final ToggleDriver toggleDriver;

    public ToggleDriverSubscriber(DriverManager driverManager, ToggleDriver toggleDriver) {
        this.toggleDriver = toggleDriver;
        this.driverManager = driverManager;
    }

    @Override
    public void update() {
        DeviceMonitorDriver deviceMonitorDriver = (DeviceMonitorDriver) driverManager.getCurrentDriver();
        Job2dDriver innerDriver = ((DeviceMonitorDriver) driverManager.getCurrentDriver()).getDriver();
        if (innerDriver == toggleDriver) {
            innerDriver = toggleDriver.getDriver();
        }
        toggleDriver.setDriver(innerDriver);
        deviceMonitorDriver.setDriver(toggleDriver);
        driverManager.setCurrentDriver(deviceMonitorDriver);
    }
}