package org.improving;

import org.improving.domain.Location;
import org.improving.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class GameContext {
    private Player player;
    private Location startingLocation;

    public GameContext(WorldFactory worldFactory, Player player) {
        this.player = player;
        this.startingLocation = worldFactory.buildWorld();
        player.setLocation(startingLocation);
    }

    public Player getPlayer() {
        return player;
    }
}
