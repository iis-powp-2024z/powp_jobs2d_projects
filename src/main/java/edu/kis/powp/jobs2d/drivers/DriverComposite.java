package edu.kis.powp.jobs2d.drivers;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;

public class DriverComposite implements IDriverComposite {
    private final List<VisitableJob2dDriver> drivers = new ArrayList<>();

    @Override
    public void addDriver(VisitableJob2dDriver driver) {
        drivers.add(driver);
    }

    @Override
    public void operateTo(int x, int y) {
        for (Job2dDriver driver : drivers) {
            driver.operateTo(x, y);
        }
    }

    @Override
    public void setPosition(int x, int y) {
        for (Job2dDriver driver : drivers) {
            driver.setPosition(x, y);
        }
    }

    public List<VisitableJob2dDriver> getDrivers() {
        return new ArrayList<>(drivers);
    }
}