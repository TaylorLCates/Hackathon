package org.improving.domain;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private String description;
    Exit exit;
    Adversary adversary;

    public Location(String name, Exit exit) {
        this.name = name;
        this.exit = exit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exit getExits() {
        return exit;
    }

    public void setExits(Exit exit) {
        this.exit = exit;
    }

    public Adversary getAdversary() {
        return adversary;
    }



    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }
}
