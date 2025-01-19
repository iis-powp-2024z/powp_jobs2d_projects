package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.monitor.DeviceMonitorDriver;
import edu.kis.powp.jobs2d.drivers.observer.DeviceMonitorDriverSubscriber;
import edu.kis.powp.observer.Publisher;

public class DeviceMonitorFeature {
    private static final DeviceMonitorDriver deviceMonitorDriver = new DeviceMonitorDriver();
    private static final Publisher publisher = new Publisher();

    /**
     * Setup jobs2d drivers Plugin and add to application.
     */
    public static void setupDeviceMonitorPlugin(DriverManager driverManager) {
        DeviceMonitorDriverSubscriber subscriber = new DeviceMonitorDriverSubscriber(
            driverManager,
            deviceMonitorDriver
        );
        driverManager.addSubscriber(subscriber);
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
