package org.improving;

import org.improving.commands.Command;
import org.improving.commands.LookCommand;
import org.springframework.stereotype.Component;

@Component
public class Game {

    GameContext gameContext;
    InputOutput io;
    Command lookCommand;

    public Game(ConsoleInputOutput io, Command lookCommand, GameContext gameContext) {
        this.io = io;
        this.lookCommand = lookCommand;
        this.gameContext = gameContext;
    }

    public void run() {
        while (true) {
            io.displayPrompt("> ");
            var input = io.receiveInput();

            if (lookCommand.isValid(input, gameContext)) {
                lookCommand.execute(input, gameContext);
            } else {
                io.displayText(input + " doesn't appear to be a valid command.");
            }


        }
    }
}
