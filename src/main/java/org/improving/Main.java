package org.improving;

import org.improving.MiniGames.RollDice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringContext.class);
        ConsoleInputOutput io = new ConsoleInputOutput();

        io.displayText("Welcome to Revenge of the Nerds");
        io.displayText("");
        io.displayText("");

        io.displayText("What would you like to play?");
        io.displayText("     Play the whole game: press 1");
        io.displayText("     Play Roll Dice Trivia: press 2");
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
                var rollDice = context.getBean(RollDice.class);
                rollDice.run();

        }









    }
}
