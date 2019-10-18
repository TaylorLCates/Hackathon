package org.improving;

import org.improving.domain.Location;
import org.springframework.stereotype.Component;

@Component
public class GameContext {
    private Location startingLocation;

    public GameContext(WorldFactory worldFactory) {
        this.startingLocation = worldFactory.buildWorld();
    }
}
