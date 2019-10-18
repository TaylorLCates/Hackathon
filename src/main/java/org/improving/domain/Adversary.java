package org.improving.domain;

public class Adversary {
    private String name;
    private int hitPoints;
    private int attackDamage;
    private AttackType attackType;
    private Item item;

    public Adversary(String name, AttackType attackType, Item item) {
        this.name = name;
        this.hitPoints = 100;
        this.attackDamage = 15;
        this.attackType = attackType;
        this.item = item;
    }

    public Adversary(String name, AttackType attackType) {
        this.name = name;
        this.hitPoints = 100;
        this.attackDamage = 15;
        this.attackType = attackType;
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

    public AttackType getAttackType() {
        return attackType;
    }

    public Item getItem() {
        return item;
    }
}
