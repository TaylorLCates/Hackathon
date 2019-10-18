package org.improving.commands;

import org.improving.GameContext;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MoveCommand extends BaseAliasCommand {
    public MoveCommand(InputOutput io) {
        super(io, "move", "m");
    }

    @Override
    public boolean isValid(String input, GameContext gameContext) {
        if (input.split(" ").length < 2) return false;
        return input.split(" ")[0].equalsIgnoreCase("move");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        // TODO: remove precious block of code beneath that will only be used if we give Location a list of exits
        var parts = input.split(" ");
        var destArr = Arrays.copyOfRange(parts, 1, parts.length);
        var dest = String.join(" ", destArr);

        var location = gameContext.getPlayer().getLocation();
        if (location.getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS");
            return;
        }

        var newLocation = location.getExits().getDestination();
        gameContext.getPlayer().setLocation(newLocation);
    }
}
