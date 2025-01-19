package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.ShapeCommandFactory;
import edu.kis.powp.jobs2d.command.visitor.CommandCounterVisitor;
import edu.kis.powp.jobs2d.command.builder.CompoundCommandBuilder;

import java.util.Arrays;
import java.util.List;

public class CommandVisitorTest {
    public static void main(String[] args) {
        CompoundCommand command = new ShapeCommandFactory().createTriangleShape();
        CommandCounterVisitor counterVisitor = new CommandCounterVisitor();
        command.accept(counterVisitor);

        System.out.println("Number of commands: " + counterVisitor.getCount());
    }

}