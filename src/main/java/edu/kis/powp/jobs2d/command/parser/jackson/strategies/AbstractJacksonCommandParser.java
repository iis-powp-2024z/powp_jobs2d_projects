package edu.kis.powp.jobs2d.command.parser.jackson.strategies;

import edu.kis.powp.jobs2d.command.CompoundCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.command.parser.CommandParserStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractJacksonCommandParser implements CommandParserStrategy {

    public abstract List<Map<String, Object>> getParsedRaw(String rawCommand) throws IOException;

    @Override
    public List<DriverCommand> parse(String rawCommand) throws IOException {

        List<Map<String, Object>> rawCommands = getParsedRaw(rawCommand);

        List<DriverCommand> commands = new ArrayList<>();

        for (Map<String, Object> cmd : rawCommands) {
            if (!cmd.containsKey("name")) {
                throw new IOException("No command name is present");
            }
            String rawCommandName = (String) cmd.get("name");

            switch (rawCommandName) {
                case "OperateToCommand": {
                    Integer[] props = parsePrimitiveCommandProps(cmd, rawCommandName);
                    commands.add(new OperateToCommand(props[0], props[1]));

                    break;
                }
                case "SetPositionCommand": {
                    Integer[] props = parsePrimitiveCommandProps(cmd, rawCommandName);
                    commands.add(new SetPositionCommand(props[0], props[1]));

                    break;
                }
                default:
                    throw new IOException("Unsupported command: " + rawCommandName);
            }
        }

        return commands;
    }

    private Integer[] parsePrimitiveCommandProps(Map<String, Object> props, String rawCommandName) throws IOException {
        int x;
        int y;
        if (props.containsKey("x")) {
            x = Integer.parseInt(props.get("x").toString());
        } else {
            throw new IOException("No x property for command " + rawCommandName);
        }
        if (props.containsKey("y")) {
            y = Integer.parseInt(props.get("y").toString());
        } else {
            throw new IOException("No y property for command " + rawCommandName);
        }

        return new Integer[]{x, y};
    }
}
