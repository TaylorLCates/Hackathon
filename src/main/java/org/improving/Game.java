package org.improving;

import org.improving.commands.Command;
import org.improving.commands.LookCommand;
import org.improving.commands.MoveCommand;
import org.springframework.stereotype.Component;

@Component
public class Game {

    GameContext gameContext;
    InputOutput io;
    LookCommand lookCommand;
    MoveCommand moveCommand;

    public Game(ConsoleInputOutput io, LookCommand lookCommand, GameContext gameContext, MoveCommand moveCommand) {
        this.io = io;
        this.lookCommand = lookCommand;
        this.gameContext = gameContext;
        this.moveCommand = moveCommand;
    }

    public void run() {
        while (true) {
            io.displayPrompt("> ");
            var input = io.receiveInput();

            if (lookCommand.isValid(input, gameContext)) {
                lookCommand.execute(input, gameContext);
            } else if (moveCommand.isValid(input, gameContext)) {
                moveCommand.execute(input, gameContext);
            } else {
                io.displayText(input + " doesn't appear to be a valid command.");
            }


        }
    }
}
