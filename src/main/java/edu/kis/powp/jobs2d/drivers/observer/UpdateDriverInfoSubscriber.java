package edu.kis.powp.jobs2d.drivers.observer;

import edu.kis.powp.appbase.Application;
import edu.kis.powp.jobs2d.features.DriverFeature;
import edu.kis.powp.observer.Subscriber;

public class UpdateDriverInfoSubscriber implements Subscriber {
    private final Application app;

    public UpdateDriverInfoSubscriber(Application app){
        this.app = app;
    }

    @Override
    public void update() {
        String selectedDriverName = DriverFeature.getDriverManager().getCurrentDriver().toString();
        app.updateInfo(selectedDriverName);
    }
}