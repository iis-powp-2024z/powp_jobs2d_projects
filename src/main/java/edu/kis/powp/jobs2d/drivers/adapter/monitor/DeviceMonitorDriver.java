package edu.kis.powp.jobs2d.drivers.adapter.monitor;

import edu.kis.powp.jobs2d.Job2dDriver;

public class DeviceMonitorDriver implements Job2dDriver {

    private Job2dDriver driver;


    @Override
    public void setPosition(int x, int y) {
        driver.setPosition(x, y);
        edu.kis.powp.jobs2d.drivers.singleton.DeviceMonitor.getInstance(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        driver.operateTo(x, y);
        edu.kis.powp.jobs2d.drivers.singleton.DeviceMonitor.getInstance(x, y);
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }
}
