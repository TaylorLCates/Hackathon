package org.improving.MiniGames;

import org.improving.ConsoleInputOutput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class GuessCheatCode {

    private ConsoleInputOutput io;
    private ArrayList<Integer> range = new ArrayList<>();
    private static final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    private Random rand = new Random();

    GuessCheatCode(ConsoleInputOutput io) {
        this.io = io;
    }

    public Integer getPrime(ArrayList<Integer> range) {

        boolean primePrimeInRange = false;
        Integer primeIndex = null;

        while (primePrimeInRange ==false) {
            primeIndex = rand.nextInt(100000) % 25;
            if (primes[primeIndex] >= range.get(0) &&
                    primes[primeIndex] <= range.get(1)) {
                primePrimeInRange = true;
            }
        }
        return primes[primeIndex];
    }

    public ArrayList<Integer> getRange() {
        Integer[] rangeLowerBounds = {0, 20, 40, 60, 80};
        Integer rangeMin = rangeLowerBounds[rand.nextInt(100000) % 5];
        Integer rangeMax = rangeMin + 20;
        range.add(rangeMin);
        range.add(rangeMax);
        return range;
    }

    public void run() {

        boolean cheatCodeGuessed = false;

            GuessCheatCode guessCheatCode = new GuessCheatCode(io);
            ArrayList<Integer> miniGameRange = guessCheatCode.getRange();
            Integer prime = guessCheatCode.getPrime(miniGameRange);


            io.displayText("I need help finding the cheat code for my game.");
            io.displayText("I know it's a prime number between "+ miniGameRange.get(0)
                    + " and " + miniGameRange.get(1) + ".");
            io.displayPrompt("What's your guess?");

             while (cheatCodeGuessed == false) {

                String input = io.receiveInput();
                 io.displayText("");

                if (Integer.parseInt(input) == prime){
                    io.displayText("");
                    io.displayText("It worked! The cheat code was " + input +". Thanks for helping me find the cheat code.");
                    cheatCodeGuessed = true;
                }
                else {
                    io.displayText("");
                    io.displayPrompt("You guessed wrong. Try another number prime number between "+ miniGameRange.get(0)
                            + " and " + miniGameRange.get(1) + ".");
                    io.displayText("");
                }


        }
    }
}

