package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class CommandCounterVisitor implements CommandVisitor {
    private int count = 0;

    public int getCount() {
        return count;
    }

    @Override
    public void visit(SetPositionCommand command) {
        count++;
    }

    @Override
    public void visit(OperateToCommand command) {
        count++;
    }

    @Override
    public void visit(ICompoundCommand command) {
        count++;
    }

}