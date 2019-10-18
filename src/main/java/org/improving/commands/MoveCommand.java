package org.improving.commands;

import org.improving.GameContext;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class MoveCommand extends BaseAliasCommand {
    public MoveCommand(InputOutput io) {
        super(io, "move", "m", "mo", "mov", "teleport");
    }

    @Override
    public void execute(String input, GameContext gameContext) {

        var location = gameContext.getPlayer().getLocation();
        if (location.getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS");
            return;
        }

        var newLocation = location.getExits().getDestination();
        gameContext.getPlayer().setLocation(newLocation);
        io.displayText("You move to " + newLocation.getName());
    }
}
