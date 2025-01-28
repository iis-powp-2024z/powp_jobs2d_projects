package edu.kis.powp.jobs2d.drivers.composite;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

public interface IDriverComposite extends Job2dDriver {
    void addDriver(Job2dDriver driver);

    void accept(IDriverVisitor visitor);
}