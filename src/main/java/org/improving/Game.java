package org.improving;

import org.springframework.stereotype.Component;

@Component
public class Game {

    InputOutput io;

    public Game(ConsoleInputOutput io) {
        this.io = io;
    }

    public void run() {
        while (true) {
            io.displayPrompt("> ");
            var input = io.receiveInput();
            io.displayText(input);

        }
    }
}
