package edu.kis.powp.jobs2d.command;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompoundCommandTest {

    @Test
    void copy() {
        OperateToCommand opCmd = new OperateToCommand(2, 5);
        SetPositionCommand stCmd = new SetPositionCommand(4, 7);

        List<DriverCommand> list = new ArrayList<DriverCommand>();
        list.add(opCmd);
        list.add(stCmd);

        CompoundCommand compoundCommand = new CompoundCommand(list, "test1");

        CompoundCommand result = compoundCommand.copy();

        assertTrue(result.hashCode() != compoundCommand.hashCode());
        assertTrue(result.iterator().next().hashCode() != opCmd.hashCode());
        assertTrue(result.iterator().next().hashCode() != stCmd.hashCode());
    }
}