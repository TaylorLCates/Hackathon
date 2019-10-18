package org.improving;

import org.improving.MiniGames.RollDice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();

        var context = new AnnotationConfigApplicationContext(SpringContext.class);

        io.displayText("Welcome to Revenge of the Nerds");
        io.displayText("");
        io.displayText("");

        io.displayText("What would you like to play?");
        io.displayText("     Play the whole game: press 1");
        io.displayText("     Play Roll Rice Trivia: press 2");
        io.displayText("");
//        io.displayText("Play Fandom Trivia: press 3");
//        io.displayText("Play Star Wars Mad Libs: press 4");
//        io.displayText("Guess the Prime: 5");

        String input = io.receiveInput();

        switch(input){

            case "1" :
                var game = context.getBean(Game.class);
                game.run();

            case"2" :
                boolean beatNotTim = false;

                while (beatNotTim == false) {
                    RollDice rollDice = new RollDice();
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
}
