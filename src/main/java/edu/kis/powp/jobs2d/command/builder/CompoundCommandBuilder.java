package edu.kis.powp.jobs2d.command.builder;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompoundCommandBuilder {
    private final List<DriverCommand> commandList = new ArrayList<>();
    private String name;

    public CompoundCommandBuilder addCommand(DriverCommand command) {
        commandList.add(command);
        return this;
    }

    public CompoundCommandBuilder addCommands(Collection<? extends DriverCommand> commands) {
        if (null == commands || commands.contains(null)) {
            throw new IllegalArgumentException("Commands cannot be null or have null elements");
        }
        commandList.addAll(commands);
        return this;
    }

    public CompoundCommandBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompoundCommand build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Name cannot be null");
        }

        return new CompoundCommand(commandList, name);
    }
}
