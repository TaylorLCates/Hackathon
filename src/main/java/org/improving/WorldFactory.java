package org.improving;

import org.improving.domain.Adversary;
import org.improving.domain.AttackType;
import org.improving.domain.Exit;
import org.improving.domain.Location;
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

        cc.setAdversary(new Adversary("Fan Girl", AttackType.Trivia));
        gs.setAdversary(new Adversary("Not Tim", AttackType.RollRice));
        mb.setAdversary(new Adversary("Bearded Basement Dweller", AttackType.CheatCode));
        mf.setAdversary(new Adversary("Han Incredibly Solo", AttackType.MadLib));
        cp.setAdversary(new Adversary("LARPer", AttackType.Attack));
        fd.setAdversary(new Adversary("The Master Hand", AttackType.OrderItems));

        // This is the starting location of the player.
        return cc;
    }
}
