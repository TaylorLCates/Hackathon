package org.improving;

import org.improving.domain.Adversary;
import org.improving.domain.Exit;
import org.improving.domain.Location;
import org.springframework.stereotype.Component;

@Component
public class WorldFactory {
    public Location buildWorld() {

        var fd = new Location("Final Destination", null);
        var cp = new Location("Generic City Park", new Exit("Final Destination", fd));
        var mf = new Location("To-Scale Millenium Falcon Replica", new Exit("Generic City Park", cp));
        var mb = new Location("Mom's Basement", new Exit("To-Scale Millenium Falcon Replica", mf));
        var gs = new Location("Game Shop", new Exit("Mom's Basement", mb));
        var cc = new Location("Comic Con", new Exit("Comic Con", gs));

        cc.setAdversary(new Adversary("Fan Girl"));
        gs.setAdversary(new Adversary("Not Tim"));
        mb.setAdversary(new Adversary("Bearded Basement Dweller"));
        mf.setAdversary(new Adversary("Han Incredibly Solo"));
        cp.setAdversary(new Adversary("LARPer"));
        fd.setAdversary(new Adversary("The Master Hand"));

        // This is the starting location of the player.
        return cc;
    }
}
