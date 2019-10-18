package org.improving.MiniGames;

import org.improving.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RollDice {

    private Random d20 = new Random();
    private Integer notTimResult;
    private Integer playerResults;
    private Integer[] rollResults = {0,0};
    private Boolean didPlayerWin = false;

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

}
