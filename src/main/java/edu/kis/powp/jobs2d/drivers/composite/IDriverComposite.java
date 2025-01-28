package edu.kis.powp.jobs2d.drivers.composite;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.drivers.visitor.IDriverVisitor;

import java.util.List;

public interface IDriverComposite extends VisitableJob2dDriver {
    void addDriver(Job2dDriver driver);
    List<Job2dDriver> getDrivers();

    @Override
    default void accept(IDriverVisitor visitor) {
        visitor.visit(this);
    }
}