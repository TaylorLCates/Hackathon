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
            io.displayText(input);

        }
    }
}
