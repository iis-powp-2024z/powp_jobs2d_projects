package edu.kis.powp.jobs2d.command.parser;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;

import java.io.IOException;
import java.util.List;

public interface CommandParserStrategy {

    String getStrategyName();

    List<DriverCommand> parse(String rawCommand) throws IOException;
}
