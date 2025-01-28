package edu.kis.powp.jobs2d.drivers.composite;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;

public interface IDriverComposite extends VisitableJob2dDriver {
    void addDriver(Job2dDriver driver);
}