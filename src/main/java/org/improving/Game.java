package org.improving;

import org.improving.commands.Command;
import org.improving.commands.LookCommand;
import org.improving.commands.MoveCommand;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Game {

    GameContext gameContext;
    InputOutput io;
    LookCommand lookCommand;
    MoveCommand moveCommand;
    Command[] commands;

    public Game(ConsoleInputOutput io, GameContext gameContext, Command[] commands) {
        this.io = io;
        this.gameContext = gameContext;
        this.commands = commands;
    }

    public void run() {
        while (true) {
            io.displayPrompt("> ");
            var input = io.receiveInput();
            Command validCommand = getValidCommand(input);

            if (validCommand != null) {
                validCommand.execute(input, gameContext);
            } else {
                io.displayText(input + " doesn't appear to be a valid command.");
            }


        }
    }

    public Command getValidCommand(String input) {
        return Stream.of(commands)
                .filter(c -> c.isValid(input, gameContext))
                .findFirst()
                .orElse(null);
    }
}
