package edu.kis.powp.jobs2d.command.gui;

import edu.kis.powp.observer.Subscriber;

public class CommandManagerWindowCanvasChangeObserver implements Subscriber {

    private CommandManagerWindow commandManagerWindow;

    public CommandManagerWindowCanvasChangeObserver(CommandManagerWindow commandManagerWindow) {
        super();
        this.commandManagerWindow = commandManagerWindow;
    }

    public String toString() {
        return "Current canvas change observer for command manager window";
    }

    @Override
    public void update() {
        commandManagerWindow.updateCurrentCanvasField();
        commandManagerWindow.renderPreview();
    }

}
