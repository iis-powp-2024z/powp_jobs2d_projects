package edu.kis.powp.jobs2d.command.parser.jackson.strategies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;
import java.util.Map;

public class XmlCommandParser extends AbstractJacksonCommandParser {
	private final ObjectMapper mapper = new XmlMapper();

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
		return "XML";
	}

}
