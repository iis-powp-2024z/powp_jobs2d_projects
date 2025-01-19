package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindowVisitorChangeObserver implements Subscriber {

    private CommandManagerWindow commandManagerWindow;

    public CommandManagerWindowVisitorChangeObserver(CommandManagerWindow commandManagerWindow) {
        super();
        this.commandManagerWindow = commandManagerWindow;
    }

    public String toString() {
        return "Current command change observer for command manager window";
    }

    @Override
    public void update() {
        commandManagerWindow.updateVisitorFields();
    }

}
