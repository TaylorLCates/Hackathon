package org.improving.commands;

import org.improving.Game;

public interface Command {
    boolean isValid(String input, Game game);
    void execute(String input, Game game);
}
