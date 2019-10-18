package org.improving.MiniGames;

import org.improving.commands.AttackCommand;
import org.improving.domain.Adversary;
import org.improving.domain.AttackType;
import org.springframework.stereotype.Component;

@Component
public class BattleLARPer {
    Adversary lARPER = new Adversary("LARPer", AttackType.Attack);
    public void run(){
    }
}
