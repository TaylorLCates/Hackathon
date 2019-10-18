package org.improving.commands;

import org.improving.GameContext;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand extends BaseAliasCommand {
    public HelpCommand(InputOutput io) {
        super(io, "help", "h");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        io.displayText("List of Available Commands:");
        io.displayText("   look (l, see, check)");
        io.displayText("   move (m, mo, mov, teleport)");
        io.displayText("   attack (a, jab, punch)");
    }
}
