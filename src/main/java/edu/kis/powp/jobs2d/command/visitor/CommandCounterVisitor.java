package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandCounterVisitor implements CommandVisitor {
    
    private Map<String, Integer> allCommandsCounter = new HashMap<>();

    

    @Override
    public void visit(SetPositionCommand command) {
       
        incrementCommandsCounter(command.getClass().getSimpleName());
    }
    
    public void incrementCommandsCounter(String command) {
        
    	allCommandsCounter.merge(command, 1, Integer::sum);
    }

    @Override
    public void visit(OperateToCommand command) {
        
        incrementCommandsCounter(command.getClass().getSimpleName());
    }

    @Override
    public void visit(ICompoundCommand command) {
        Iterator<DriverCommand> commandListIterator = command.iterator();
        while(commandListIterator.hasNext())
        {
            DriverCommand cmd = commandListIterator.next();
            incrementCommandsCounter(cmd.getClass().getSimpleName());
           
        }
    }

    @Override
    public String toString() {
        StringBuilder commands = new StringBuilder();
        for (Map.Entry<String, Integer> entry : allCommandsCounter.entrySet()) {
        	commands.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return commands.toString();
    }

}