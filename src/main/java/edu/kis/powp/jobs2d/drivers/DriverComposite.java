package edu.kis.powp.jobs2d.drivers;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.Job2dDriver;

public class DriverComposite {
    private List<Job2dDriver> drivers = new ArrayList<>();

    public void addDriver(Job2dDriver driver) {
        drivers.add(driver);
    }

    public void operateTo(int x, int y) {
        for (Job2dDriver driver : drivers) {
            driver.operateTo(x, y);
        }
    }

    public void setPosition(int x, int y) {
        for (Job2dDriver driver : drivers) {
            driver.setPosition(x, y);
        }
    }
}