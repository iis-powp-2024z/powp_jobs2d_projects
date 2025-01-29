package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.observer.ApplyDriverDecoratorsSubscriber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleDriverDecoratorOptionListener implements ActionListener {
    private final CanvasRestrictionDriverDecorator driverDecorator;

    public ToggleDriverDecoratorOptionListener(CanvasRestrictionDriverDecorator driverDecorator) {
        this.driverDecorator = driverDecorator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
        if (item.isSelected()) {
            ApplyDriverDecoratorsSubscriber.getInstance().addDriverDecorator(driverDecorator);

        } else {
            ApplyDriverDecoratorsSubscriber.getInstance().removeDriverDecorator(driverDecorator);
        }
    }
}
