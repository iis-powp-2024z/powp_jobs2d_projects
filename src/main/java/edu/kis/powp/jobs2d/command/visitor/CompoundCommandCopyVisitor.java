package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.*;

import java.util.ArrayList;
import java.util.List;

public class CompoundCommandCopyVisitor implements CommandVisitor {
    private DriverCommand copiedCommand;

    @Override
    public void visit(OperateToCommand command) {
        copiedCommand = new OperateToCommand(command.getPosX(), command.getPosY());
    }

    @Override
    public void visit(SetPositionCommand command) {
        copiedCommand = new SetPositionCommand(command.getPosX(), command.getPosY());
    }

    @Override
    public void visit(ICompoundCommand command) {
        List<DriverCommand> copiedCommandList = new ArrayList<>();
        command.iterator().forEachRemaining(cmd -> copiedCommandList.add(cmd.copy()));
        copiedCommand = new CompoundCommand(copiedCommandList, command.toString());
    }

    public DriverCommand getCopiedCommand() {
        return copiedCommand;
    }
}
