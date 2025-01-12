package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.drivers.adapter.transformation.TransformationMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleTransformationOptionListener implements ActionListener {

    private DriverManager driverManager;
    private TransformationMethod transformationMethod;

    public ToggleTransformationOptionListener(DriverManager driverManager, TransformationMethod transformationMethod) {
        this.driverManager = driverManager;
        this.transformationMethod = transformationMethod;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
        if (item.isSelected()) {
            driverManager.addTransformationMethod(transformationMethod);
        } else {
            driverManager.removeTransformationMethod(transformationMethod);
        }
    }
}
