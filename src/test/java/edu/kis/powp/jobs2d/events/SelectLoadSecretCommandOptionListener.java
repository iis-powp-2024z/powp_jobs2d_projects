package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.ShapeCommandFactory;
import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

public class SelectLoadSecretCommandOptionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CompoundCommand secretCommand = new ShapeCommandFactory().createSecretShape();
        DriverCommandManager manager = CommandsFeature.getDriverCommandManager();
        manager.setCurrentCommand(secretCommand);
    }
}