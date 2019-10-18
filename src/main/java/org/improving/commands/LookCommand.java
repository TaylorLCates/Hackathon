package org.improving.commands;

import org.improving.ConsoleInputOutput;
import org.improving.Game;
import org.improving.GameContext;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasCommand {

    public LookCommand(InputOutput io) {
        super(io, "look", "l", "see", "check");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        var location = gameContext.getPlayer().getLocation();
        io.displayText("You look to see that you are at: " + location.getName());
        io.displayText("\nYou may exit to " + location.getExits().getName());
    }
}
