package edu.kis.powp.jobs2d.command.parser.jackson.strategies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.parser.CommandParserStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonCommandParser extends AbstractJacksonCommandParser {
	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public List<Map<String, Object>> getParsedRaw(String rawCommand) throws JsonProcessingException {
		return mapper.readValue(
				rawCommand,
				new TypeReference<List<Map<String, Object>>>() {
				}
		);
	}

	@Override
	public String getStrategyName() {
		return "JSON";
	}
}
