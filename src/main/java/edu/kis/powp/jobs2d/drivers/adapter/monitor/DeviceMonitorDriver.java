package edu.kis.powp.jobs2d.drivers.adapter.monitor;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.singleton.DeviceMonitor;
import edu.kis.powp.jobs2d.drivers.visitor.IVisitor;

public class DeviceMonitorDriver implements DriverDecorator {

    private Job2dDriver driver;

    public DeviceMonitorDriver() {
    }

    public DeviceMonitorDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setPosition(int x, int y) {
        driver.setPosition(x, y);
        DeviceMonitor.getInstance().calculateSetPositionDistance(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        driver.operateTo(x, y);
        DeviceMonitor.getInstance().calculateOperateToDistance(x, y);
    }

    public Job2dDriver getDriver() {
        return this.driver;
    }

    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

}
