package org.improving;

import org.improving.MiniGames.GuessCheatCode;
import org.improving.MiniGames.RollDice;
import org.improving.MiniGames.StarWarsMadLibs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringContext.class);
        ConsoleInputOutput io = new ConsoleInputOutput();
        StarWarsMadLibs starWarsMadLibs = new StarWarsMadLibs();

        io.displayText("Welcome to Revenge of the Nerds");
        io.displayText("");
        io.displayText("");

        io.displayText("What would you like to play?");
        io.displayText("     Play the whole game: press 1");
        io.displayText("     Play Roll Dice Trivia: press 2");
        io.displayText("     Play Guess Cheat Code: press 3");
        io.displayText("     Play Star Wars Mad Libs: press 4");
        io.displayText("");
//        io.displayText("Play Fandom Trivia: press 5");
//        io.displayText("Guess the Prime: 6");

        String input = io.receiveInput();

        switch(input){

            case "1" :
                var game = context.getBean(Game.class);
                game.run();

            case"2" :
                var rollDice = context.getBean(RollDice.class);
                rollDice.run();

            case"3" :
                var guessCheatCode = context.getBean(GuessCheatCode.class);
                guessCheatCode.run();

            case"4" :
                starWarsMadLibs.run();
        }

    }
}
