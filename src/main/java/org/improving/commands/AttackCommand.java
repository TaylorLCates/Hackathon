package org.improving.commands;

import javafx.animation.FadeTransition;
import org.improving.GameContext;
import org.improving.InputOutput;
import org.improving.MiniGames.*;
import org.improving.domain.AttackType;
import org.springframework.stereotype.Component;

@Component
public class AttackCommand extends BaseAliasCommand {
    public AttackCommand(InputOutput io) {
        super(io, "attack", "a", "jab", "punch");
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        var location = gameContext.getPlayer().getLocation();
        if (location.getAdversary() == null) {
            io.displayText("Attack what?");
        } else {

            MiniGame challenge;
            switch (location.getAdversary().getAttackType()) {
                case Trivia:
                    challenge = new FandomTrivia(io);
                    break;
                case RollRice:
                    challenge = new RollDice(io);
                    break;
                case CheatCode:
                    challenge = new GuessCheatCode(io);
                    break;
                case MadLib:
                    challenge = new StarWarsMadLibs(io);
                    break;
                case Attack:
                    challenge = new AppeaseMasterHand(io);
                    break;
                case OrderItems:
                    io.displayText("Not implemented yet");
                    challenge = new RollDice(io);
                    break;
                default:
                    challenge = new AttackGame(location, io, gameContext);
                    break;
            }
            challenge.run();
            if (location.getAdversary() != null && location.getAdversary().getAttackType() != AttackType.Attack) {
                var advItem = location.getAdversary().getItem();
                io.displayText(location.getAdversary().getName() + " has been appeased! You found a " + advItem.getName() + " while no one was looking. You may now pass.");
                gameContext.getPlayer().addItem(advItem);
                location.setAdversary(null);
            }

        }




    }
}
