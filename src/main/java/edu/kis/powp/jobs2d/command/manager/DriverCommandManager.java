package edu.kis.powp.jobs2d.command.manager;

import java.util.ArrayList;
import java.util.List;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.visitor.CommandVisitor;
import edu.kis.powp.observer.Publisher;

/**
 * Driver command Manager.
 */
public class DriverCommandManager {
    private DriverCommand currentCommand = null;
    private Publisher changePublisher = new Publisher();
    private List<CommandVisitor> visitorList= new ArrayList<CommandVisitor>();
    /**
     * Set current command.
     * 
     * @param commandList Set the command as current.
     */
    public synchronized void setCurrentCommand(DriverCommand commandList) {
        this.currentCommand = commandList;
        changePublisher.notifyObservers();
    }

    /**
     * Set current command.
     * 
     * @param commandList list of commands representing a compound command.
     * @param name        name of the command.
     */
    public synchronized void setCurrentCommand(List<DriverCommand> commandList, String name) {
        setCurrentCommand(new CompoundCommand(commandList, name));}

    /**
     * Return current command.
     * 
     * @return Current command.
     */
    public synchronized DriverCommand getCurrentCommand() {
        return currentCommand;
    }

    public synchronized void clearCurrentCommand() {
        currentCommand = null;
    }

    public synchronized String getCurrentCommandString() {
        if (getCurrentCommand() == null) {
            return "No command loaded";
        } else
            return getCurrentCommand().toString();
    }

    public synchronized void addVisitor(CommandVisitor visitor) {
        this.visitorList.add(visitor);
    }

    public synchronized String getVisitorString() {
        if (getCurrentCommand() == null || visitorList == null) {
            return "No visitor loaded";
        } else {
            for (CommandVisitor v : visitorList) {
                getCurrentCommand().accept(v);
            }
            StringBuilder visitorString = new StringBuilder();
            for (CommandVisitor v : visitorList) {
                visitorString.append(v.toString()).append("\n");
            }
            visitorList.clear();
            return visitorString.toString();
        }
    }

    public Publisher getChangePublisher() {
        return changePublisher;
    }
}
