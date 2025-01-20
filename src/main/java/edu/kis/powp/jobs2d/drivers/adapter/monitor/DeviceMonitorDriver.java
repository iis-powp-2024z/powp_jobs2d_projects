package edu.kis.powp.jobs2d.drivers.adapter.monitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.singleton.DeviceMonitor;
import edu.kis.powp.observer.Publisher;

public class DeviceMonitorDriver implements Job2dDriver {

    private Job2dDriver driver;
    private static final Publisher publisher = new Publisher();

    public DeviceMonitorDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setPosition(int x, int y) {
        driver.setPosition(x, y);
        DeviceMonitor.getInstance(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        driver.operateTo(x, y);
        DeviceMonitor.getInstance(x, y);
    }
}
