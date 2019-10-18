package org.improving.commands;

import org.improving.ConsoleInputOutput;
import org.improving.Game;
import org.improving.GameContext;
import org.improving.InputOutput;
import org.improving.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasCommand {

    public LookCommand(InputOutput io) {
        super(io, "look", "l", "see", "check");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        var location = gameContext.getPlayer().getLocation();
        io.displayText("You look to see that you are at: " + location.getName().toUpperCase());
        io.displayText("You may move to " + location.getExits().getName().toUpperCase());
        if (gameContext.getPlayer().getInventory().size() >= 1) {
            io.displayText("\nINVENTORY:");
            for (Item item : gameContext.getPlayer().getInventory()) {
                io.displayText("  " + item.getName());
            }
        }
        if (location.getAdversary() != null) {
            io.displayText("\nWatch out! " + location.getAdversary().getName() + " is right behind you! He wants to " + location.getAdversary().getAttackType());
        }

    }
}
