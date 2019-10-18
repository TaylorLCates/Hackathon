package org.improving.domain;

public class Adversary {
    private String name;
    private int hitPoints;
    private int attackDamage;

    public Adversary(String name) {
        this.name = name;
        this.hitPoints = 100;
        this.attackDamage = 15;
    }

    public void subtractHitPoints(int damageTaken) {
        this.hitPoints = this.hitPoints - damageTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
