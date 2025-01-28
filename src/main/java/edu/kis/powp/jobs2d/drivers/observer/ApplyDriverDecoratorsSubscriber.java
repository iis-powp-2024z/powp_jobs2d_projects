package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.DriverDecorator;
import edu.kis.powp.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public final class ApplyDriverDecoratorsSubscriber implements Subscriber {
    private static final List<DriverDecorator> driverDecorators = new ArrayList<>();
    private static DriverManager driverManager;
    private static ApplyDriverDecoratorsSubscriber instance;

    public static ApplyDriverDecoratorsSubscriber getInstance() {
        if (instance == null) {
            instance = new ApplyDriverDecoratorsSubscriber();
        }

        return instance;
    }

    @Override
    public void update() {
        // Preventing stack overflow and recursion
        if (isAlreadyDecorated()) {
            return;
        }

        driverManager.setCurrentDriver(getDecoratedDriver());
    }

    private boolean isAlreadyDecorated() {
        return driverManager.getCurrentDriver().equals(driverDecorators.get(0));
    }

    private Job2dDriver getDecoratedDriver() {
        Job2dDriver decoratedDriver = driverManager.getCurrentDriver();
        for (int i = driverDecorators.size() - 1; i >= 0; i -= 1) {
            DriverDecorator decorator = driverDecorators.get(i);
            decorator.setDriver(decoratedDriver);
            decoratedDriver = decorator;
        }

        return decoratedDriver;
    }

    public void addDriverDecorator(DriverDecorator driverDecorator) {
        driverDecorators.add(driverDecorator);
    }

    public void removeDriverDecorator(DriverDecorator driverDecorator) {
        driverDecorators.remove(driverDecorator);
    }

    public void setDriverManager(DriverManager driverManager) {
        ApplyDriverDecoratorsSubscriber.driverManager = driverManager;
    }
}