package org.improving;

import org.improving.domain.*;
import org.springframework.stereotype.Component;

@Component
public class WorldFactory {
    public Location buildWorld() {

        var fd = new Location("Final Destination", null);
        var cp = new Location("Generic City Park", new Exit("Final Destination", fd, "exit"));
        var mf = new Location("To-Scale Millenium Falcon Replica", new Exit("Generic City Park", cp, "exit"));
        var mb = new Location("Mom's Basement", new Exit("To-Scale Millenium Falcon Replica", mf, "exit"));
        var gs = new Location("Game Shop", new Exit("Mom's Basement", mb, "exit"));
        var cc = new Location("Comic Con", new Exit("Game Shop", gs, "gs", "exit"));

        cc.setAdversary(new Adversary("Fan Girl", AttackType.Trivia, Item.HELLO_KITTY_BACK_PACK));
        gs.setAdversary(new Adversary("Not Tim", AttackType.RollRice, Item.A_D20));
        mb.setAdversary(new Adversary("Bearded Basement Dweller", AttackType.CheatCode, Item.CAN_OF_MOUNTAIN_DEW));
        mf.setAdversary(new Adversary("Han Incredibly Solo", AttackType.MadLib, Item.HOKEY_RELIGION));
        cp.setAdversary(new Adversary("LARPer", AttackType.Attack, Item.REPLICA_ARMOR));
        fd.setAdversary(new Adversary("The Master Hand", AttackType.OrderItems, Item.THUMPS_UP));

        // This is the starting location of the player.
        return cc;
    }
}
