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
        io.displayText("You awaken dazed and confused on the floor of a small Comic Con in some no-name city. The world as you know it" +
                "\nis no more. Outside of the glass doors of the civic center, you see the wind whipping the desert sand of the wasteland." +
                "\n " +
                "\nYou can look around where you are with 'look'. You have to press 'a' to interact with people near you. 'move' \n" +
                "or something close to it will let you progress. Good luck. You'll need it, this is the \n" +
                "Dark Souls of console games written in Java in a day.");
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
