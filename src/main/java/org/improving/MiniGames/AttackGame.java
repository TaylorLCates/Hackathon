package org.improving.MiniGames;

import org.improving.GameContext;
import org.improving.InputOutput;
import org.improving.domain.Adversary;
import org.improving.domain.Location;
import org.improving.domain.Player;

import java.util.Random;

public class AttackGame implements MiniGame {
    Random random = new Random();
    Location location;
    InputOutput io;
    GameContext gameContext;

    public AttackGame(Location location, InputOutput io, GameContext gameContext) {
        this.location = location;
        this.io = io;
        this.gameContext = gameContext;
    }

    @Override
    public void run() {
        var adversary = location.getAdversary();
        var critRandom = random.nextInt(100);
        if (critRandom <= 26) {
            adversary.subtractHitPoints(random.nextInt(11)+25);
            io.displayText("You found a gap in LARPer's armor and deal MASSIVE damage!! ");
        } else adversary.subtractHitPoints(random.nextInt(11));

        io.displayText(adversary.getName() + " has " + adversary.getHitPoints() + " HP remaining.");

        gameContext.getPlayer().subtractHitPoints(random.nextInt(11));
        io.displayText("You were attacked! You have " + gameContext.getPlayer().getHitPoints() + "hit points left!!");

        if (adversary.getHitPoints() <= 0) {
            var advItem = location.getAdversary().getItem();
            io.displayText(location.getAdversary().getName() + " has been defeated! You found a " + advItem.getName() +
                    " on his dead corpse. You may now pass. #winning");
            gameContext.getPlayer().addItem(advItem);
            location.setAdversary(null);
        }
    }
}
