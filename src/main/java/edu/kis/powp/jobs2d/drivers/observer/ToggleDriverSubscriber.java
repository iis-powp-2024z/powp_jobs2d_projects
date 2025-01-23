package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class ToggleDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final List<DriverDecorator> driverDecorators = new ArrayList<>();

    public ToggleDriverSubscriber(DriverManager driverManager) {
        this.driverManager = driverManager;
        driverDecorators.add(new DeviceMonitorDriver());
    }

    @Override
    public void update() {
        DeviceMonitorDriver deviceMonitorDriver = (DeviceMonitorDriver) driverManager.getCurrentDriver();
        Job2dDriver innerDriver = getMostInnerDriver(deviceMonitorDriver.getDriver());

        Job2dDriver rewrappedDriver = rewrapDriver(innerDriver);

        // At this point the `rewrappedDriver` is `DeviceMonitorDriver`
        driverManager.setCurrentDriver(rewrappedDriver);
    }

    private Job2dDriver getMostInnerDriver(Job2dDriver driver) {
        while (driverDecorators.contains(driver)) {
            driver = ((DriverDecorator) driver).getDriver();
        }

        return driver;
    }

    private Job2dDriver rewrapDriver(Job2dDriver innerDriver) {
        for (int i = driverDecorators.size() - 1; i >= 0; i -= 1) {
            DriverDecorator decorator = driverDecorators.get(i);
            decorator.setDriver(innerDriver);
            innerDriver = decorator;
        }

        return innerDriver;
    }

    public void addDriver(DriverDecorator deviceDecorator) {
        this.driverDecorators.add(deviceDecorator);
    }
}