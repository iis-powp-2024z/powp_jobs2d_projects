package edu.kis.powp.jobs2d.command.parser.jackson;

import edu.kis.powp.jobs2d.command.parser.CommandParserFactory;
import edu.kis.powp.jobs2d.command.parser.CommandParserStrategy;
import edu.kis.powp.jobs2d.command.parser.jackson.strategies.CsvCommandParser;
import edu.kis.powp.jobs2d.command.parser.jackson.strategies.JsonCommandParser;
import edu.kis.powp.jobs2d.command.parser.jackson.strategies.XmlCommandParser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JacksonParserFactory implements CommandParserFactory {

    private final Map<String, CommandParserStrategy> availableStrategies;

    public JacksonParserFactory() {
        availableStrategies = new HashMap<>();

        CommandParserStrategy json = new JsonCommandParser();
        CommandParserStrategy xml = new XmlCommandParser();
        CommandParserStrategy csv = new CsvCommandParser();

        availableStrategies.put(json.getStrategyName(), json);
        availableStrategies.put(xml.getStrategyName(), xml);
        availableStrategies.put(csv.getStrategyName(), csv);
    }


    @Override
    public Collection<String> getAvailableParsers() {
        return availableStrategies.keySet();
    }

    @Override
    public CommandParserStrategy getParser(String parserName) {
        if (!getAvailableParsers().contains(parserName)) {
            return null;
        }

        return availableStrategies.getOrDefault(parserName, null);
    }
}
