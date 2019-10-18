package org.improving.MiniGames;

import org.improving.InputOutput;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RollDice implements MiniGame {

    private Random d20 = new Random();
    private Integer notTimResult;
    private Integer playerResults;
    private Integer[] rollResults = {0,0};
    private Boolean didPlayerWin = false;
    private InputOutput io;

    public RollDice(InputOutput io){
        this.io = io;
    }

    public Integer[] rollDice() {
        notTimResult = d20.nextInt(100000)%20+1;
        playerResults = d20.nextInt(100000)%20+1;

        rollResults[0]=notTimResult;
        rollResults[1]=playerResults;

        return rollResults;
    }

    public Boolean didPlayerWin(Integer[] rollResults){
        if (rollResults[1]>rollResults[0]){
            didPlayerWin = true;
        }
        return didPlayerWin;

    }

    public void run() {

        boolean beatNotTim = false;

        while (beatNotTim == false) {

            RollDice rollDice = new RollDice(io);
            Integer[] rollResult = rollDice.rollDice();

            io.displayText("You rolled a " + rollResult[1]);
            io.displayText("NotTim rolled a " + rollResult[0]);
            io.displayText("");
            if (rollDice.didPlayerWin(rollResult)) {
                io.displayText("You won!");
                beatNotTim = true;
            }
            else {
                io.displayPrompt("You lost! Press Enter to roll again");
                io.receiveInput();
                io.displayText("");
            }
        }

    }
}
