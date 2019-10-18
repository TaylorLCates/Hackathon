package org.improving.domain;

public enum Item {
    CAN_OF_MOUNTAIN_DEW("A can of Mountain Dew"),
    HELLO_KITTY_BACK_PACK("A Hello Kitty backpack that contains a warm 24 oz. can of Natty Ice"),
    A_D20("A twenty sided dice"),
    HOKEY_RELIGION("A hokey religion. No match for a blaster at your side, even with an ancient weapon."),
    REPLICA_ARMOR("Authentic 13th century replica armor");

    private String name;
    Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
