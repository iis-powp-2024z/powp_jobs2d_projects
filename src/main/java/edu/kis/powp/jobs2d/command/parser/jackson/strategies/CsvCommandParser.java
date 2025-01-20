package edu.kis.powp.jobs2d.command.parser.jackson.strategies;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvCommandParser extends AbstractJacksonCommandParser {

    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema schema = CsvSchema.builder()
            .addColumn("name")
            .addColumn("x")
            .addColumn("y")
            .build()
            .withHeader();

    @Override
    public List<Map<String, Object>> getParsedRaw(String rawCommand) throws IOException {
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        ObjectReader mapper = new CsvMapper().readerFor(Map.class).with(csvSchema);
        MappingIterator<Map<String, Object>> iterator = mapper.readValues(rawCommand);

        return iterator.readAll();
    }

    @Override
    public String getStrategyName() {
        return "CSV";
    }
}
