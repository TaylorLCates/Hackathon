package org.improving.MiniGames;

import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class FandomTrivia implements MiniGame {
    InputOutput io;

    public FandomTrivia(InputOutput io) {
        this.io = io;
    }

    public void run(){
        io.displayText("Along your travels you stumble inside of a convention center that is filled with people dressed as their favorite" +
                "\n pop/nerd/geek culture icons. You see a person dressed as Pikachu, plenty of X-men, and even a whole squad of" +
                "\n Stromtroopers! While wide-eyed in wonder, you stumble into a fan girl wearing a Hello Kitty backpack. Taken aback" +
                "\n she says 'If you want to leave this con alive, You'll have to answer me these questions five!'" +
                "\n" +
                "\nYou just gotta get three out of five right. You got this.");
        int score = 0;
        String[] questions =
                {"In the newest Star Wars film, Star Wars: The Force Awakens, what is Finn's Stormtrooper ID?",
                 "Where is the most famous Comic Con held? San Francisco, San Antonio, Santa Monica, San Diego",
                "Which of these superheroes has not been given a Netflix Original TV series? Jessica Jones, Iron Fist, The Flash, Daredevil",
                "What is Wolverine's skeleton reinforced with? Titanium, Adamantium, Vibranium, Uranium, Ouranium, or Thieranium",
                "The \"S\" in Superman's insignia stands for more than just \"Superman.\" In \"Superman: Birthright\" and \"Man of Steel,\" what else does it stand for?"};
        String [] answers =
                {"FN-2187",
                "San Diego",
                "Daredevil",
                "Adamantium",
                "Hope"};
        for (int i = 0; i < questions.length; i++) {
            io.displayText(questions[i]);
            io.displayPrompt("> ");
            String input = io.receiveInput();
            if (input.equalsIgnoreCase(answers[i])) {
                score++;
                io.displayText("That's soooo right!");
            } else io.displayText("Sorry, that's wrong!");

        } if (score >=3) {
            io.displayText("You won the game! Here, have my backpack! This wasn't a weird interaction at all!!");
        } else io.displayText("You lost the game! Fandom-Girl MURDERS YOU.");
    }
}
