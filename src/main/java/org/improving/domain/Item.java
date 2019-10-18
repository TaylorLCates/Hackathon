package org.improving.domain;

public enum Item {
    CAN_OF_MOUNTAIN_DEW("A can of Mountain Dew"),
    HELLO_KITTY_BACK_PACK("A Hello Kitty backpack"),
    A_D20("A twenty sided dice"),
    HOKEY_RELIGION("A hokey religion"),
    REPLICA_ARMOR("Authentic 13th century replica armor"),
    THUMPS_UP("A well sought after approval from the Master Hand");

    private String name;
    Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
