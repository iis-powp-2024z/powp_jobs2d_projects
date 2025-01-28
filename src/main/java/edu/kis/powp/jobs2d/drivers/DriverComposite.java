package edu.kis.powp.jobs2d.drivers;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.composite.IDriverComposite;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public class DriverComposite implements IDriverComposite {
    private final List<Job2dDriver> drivers = new ArrayList<>();

    @Override
    public void addDriver(Job2dDriver driver) {
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

    public List<Job2dDriver> getDrivers() {
        return drivers;
    }

    @Override
    public void accept(IDriverVisitor visitor) {
        visitor.visit(this);
    }


}