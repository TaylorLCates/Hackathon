package org.improving;

import org.improving.commands.Command;
import org.improving.commands.LookCommand;
import org.springframework.stereotype.Component;

@Component
public class Game {

    InputOutput io;
    Command lookCommand;

    public Game(ConsoleInputOutput io, Command lookCommand) {
        this.io = io;
        this.lookCommand = lookCommand;
    }

    public void run() {
        while (true) {
            io.displayPrompt("> ");
            var input = io.receiveInput();

            if (lookCommand.isValid(input, this)) {
                lookCommand.execute(input, this);
            } else {
                io.displayText(input + " doesn't appear to be a valid command.");
            }


        }
    }
}
