package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.observer.Subscriber;

public class ToggleDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final DriverDecorator driverDecorator;

    public ToggleDriverSubscriber(DriverManager driverManager, DriverDecorator driverDecorator) {
        this.driverDecorator = driverDecorator;
        this.driverManager = driverManager;
    }

    @Override
    public void update() {
        DeviceMonitorDriver deviceMonitorDriver = (DeviceMonitorDriver) driverManager.getCurrentDriver();
        Job2dDriver innerDriver = ((DeviceMonitorDriver) driverManager.getCurrentDriver()).getDriver();
        if (innerDriver == driverDecorator) {
            innerDriver = driverDecorator.getDriver();
        }
        driverDecorator.setDriver(innerDriver);
        deviceMonitorDriver.setDriver(driverDecorator);
        driverManager.setCurrentDriver(deviceMonitorDriver);
    }
}