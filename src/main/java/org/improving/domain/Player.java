package org.improving.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int hitPoints = 100;
    private List<Item> inventory = new ArrayList<>();
    private Location location;

    public Player(Location location){
        this.location = location;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
