package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.ShapeCommandFactory;
import edu.kis.powp.jobs2d.command.visitor.CommandCounterVisitor;

import java.util.Arrays;
import java.util.List;

public class CommandVisitorTest {
    public static void main(String[] args) {
        List<DriverCommand> command = new ShapeCommandFactory().createTriangleShape();
        CommandCounterVisitor counterVisitor = new CommandCounterVisitor();

        for(DriverCommand c : command) {
            c.accept(counterVisitor);
        }

        System.out.println("Number of commands: " + counterVisitor.getCount());
    }
}