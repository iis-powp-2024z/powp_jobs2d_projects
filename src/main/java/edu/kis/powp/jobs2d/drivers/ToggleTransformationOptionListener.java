package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationDriver;
import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;
import edu.kis.powp.observer.Publisher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleTransformationOptionListener implements ActionListener {

    private Publisher publisher;
    private TransformationDriver transformationDriver;
    private TransformationMethod transformationMethod;

    public ToggleTransformationOptionListener(TransformationDriver transformationDriver, TransformationMethod transformationMethod, Publisher publisher) {
        this.transformationDriver = transformationDriver;
        this.publisher = publisher;
        this.transformationMethod = transformationMethod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
        if (item.isSelected()) {
            transformationDriver.addTransformationMethod(transformationMethod);
        } else {
            transformationDriver.removeTransformationMethod(transformationMethod);
        }

        publisher.notifyObservers();
    }

    public TransformationDriver getTransformationDriver() {
        return transformationDriver;
    }
}
