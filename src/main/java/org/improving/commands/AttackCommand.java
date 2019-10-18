package org.improving.commands;

import org.improving.GameContext;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class AttackCommand extends BaseAliasCommand {
    public AttackCommand(InputOutput io) {
        super(io, "attack", "a", "jab", "punch");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        var location = gameContext.getPlayer().getLocation();
        var adversary = location.getAdversary();
        if (adversary == null) {
            io.displayText("Attack what?");
        } else {
            adversary.subtractHitPoints(10);
            var advHp =  adversary.getHitPoints();
            io.displayText(adversary.getName() + " has " + adversary.getHitPoints() + " HP remaining.");

            if (adversary.getHitPoints() <= 0) {
                location.setAdversary(null);
                io.displayText(adversary.getName() + " has been defeated! You may now pass.");
            }
        }


    }
}
