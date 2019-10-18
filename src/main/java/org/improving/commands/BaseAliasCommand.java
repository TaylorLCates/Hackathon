package org.improving.commands;

import org.improving.Game;
import org.improving.GameContext;
import org.improving.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAliasCommand implements Command {
    protected final InputOutput io;
    private List<String> alias = new ArrayList<>();

    public BaseAliasCommand(InputOutput io, String ...alias) {
        this.io = io;
        this.alias.addAll(Arrays.asList(alias));
    }

    @Override
    public boolean isValid(String input, GameContext gameContext) {
        try {
            return alias.stream().anyMatch(input.trim()::equalsIgnoreCase);
        } catch (UnsupportedOperationException e) {
            return false;
        }
    }

    @Override
    public void execute(String input, GameContext gameContext) {
        io.displayText("Command has been executed: " + input);
    }
}
