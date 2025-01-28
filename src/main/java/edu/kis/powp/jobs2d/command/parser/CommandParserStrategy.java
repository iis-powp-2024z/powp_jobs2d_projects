package edu.kis.powp.jobs2d.command.parser;

import edu.kis.powp.jobs2d.command.DriverCommand;

import java.io.IOException;

public interface CommandParserStrategy {

    String getStrategyName();

    DriverCommand parse(String rawCommand, String newCommandName) throws IOException;
}
