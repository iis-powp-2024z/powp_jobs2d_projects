package edu.kis.powp.jobs2d.command.builder;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.ArrayList;
import java.util.List;

public class CompoundCommandBuilder {
    private final List<DriverCommand> commandList = new ArrayList<>();
    private String name;

    public CompoundCommandBuilder addCommand(DriverCommand command) {
        commandList.add(command);
        return this;
    }

    public CompoundCommandBuilder addCommands(List<DriverCommand> commands) {
        commandList.addAll(commands);
        return this;
    }

    public CompoundCommandBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompoundCommand build() {
        if (name == null || !name.isEmpty()) {
            throw new IllegalStateException("Name cannot be null");
        }

        return new CompoundCommand(commandList, name);
    }
}
