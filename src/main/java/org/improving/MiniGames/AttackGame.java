package org.improving.MiniGames;

import org.improving.InputOutput;
import org.improving.domain.Adversary;
import org.improving.domain.Location;

public class AttackGame implements MiniGame {

    Location location;
    InputOutput io;

    public AttackGame(Location location, InputOutput io) {
        this.location = location;
        this.io = io;
    }

    @Override
    public void run() {
        var adversary = location.getAdversary();
        adversary.subtractHitPoints(10);
        io.displayText(adversary.getName() + " has " + adversary.getHitPoints() + " HP remaining.");

        if (adversary.getHitPoints() <= 0) {
            io.displayText(adversary.getName() + " has been defeated! You may now pass.");
            location.setAdversary(null);
        }
    }
}
