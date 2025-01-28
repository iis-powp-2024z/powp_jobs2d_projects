package edu.kis.powp.jobs2d.drivers.adapter.monitor;

import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.jobs2d.drivers.singleton.DeviceMonitor;

public class DeviceMonitorDriver implements DriverDecorator {

    private VisitableJob2dDriver driver;

    public DeviceMonitorDriver() {
    }

    public DeviceMonitorDriver(VisitableJob2dDriver driver) {
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

    public VisitableJob2dDriver getDriver() {
        return this.driver;
    }

    public void setDriver(VisitableJob2dDriver driver) {
        this.driver = driver;
    }

}
