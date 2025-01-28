package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.*;

import java.util.List;
import java.util.stream.Collectors;

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
        List<DriverCommand> copiedCommandList = command.getCommandList().stream()
                .map(cmd -> {
                    CompoundCommandCopyVisitor visitor = new CompoundCommandCopyVisitor();
                    cmd.accept(visitor);
                    return visitor.getCopiedCommand();
                })
                .collect(Collectors.toList());
        copiedCommand = new CompoundCommand(copiedCommandList, command.toString());
    }

    public DriverCommand getCopiedCommand() {
        return copiedCommand;
    }
}
