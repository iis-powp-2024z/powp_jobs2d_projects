package edu.kis.powp.jobs2d.command.parser;

import java.util.Collection;

public interface CommandParserFactory {

	Collection<String> getAvailableParsers();
	CommandParserStrategy getParser(String parserName);
}
