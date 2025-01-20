package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.observer.Subscriber;

public class ToggleTransformationDriverSubscriber implements Subscriber {
    private final DriverManager driverManager;
    private final TransformationDriver transformationDriver;

    public ToggleTransformationDriverSubscriber(DriverManager driverManager, TransformationDriver transformationDriver) {
        this.transformationDriver = transformationDriver;
        this.driverManager = driverManager;
    }

    @Override
    public void update() {
        DeviceMonitorDriver deviceMonitorDriver = (DeviceMonitorDriver) driverManager.getCurrentDriver();
        Job2dDriver innerDriver = ((DeviceMonitorDriver) driverManager.getCurrentDriver()).getDriver();
        if (innerDriver == transformationDriver) {
            innerDriver = transformationDriver.getDriver();
        }
        transformationDriver.setDriver(innerDriver);
        deviceMonitorDriver.setDriver(transformationDriver);
        driverManager.setCurrentDriver(deviceMonitorDriver);
    }
}