package org.improving.commands;

import org.improving.Game;
import org.improving.GameContext;

public interface Command {
    boolean isValid(String input, GameContext gameContext);
    void execute(String input, GameContext gameContext);
}
