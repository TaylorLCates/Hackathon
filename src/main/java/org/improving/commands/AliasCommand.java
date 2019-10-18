package org.improving.commands;

import org.improving.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AliasCommand implements Command {
    private List<String> alias = new ArrayList<>();
    protected final InputOutput io;

    public AliasCommand(InputOutput io, String ...alias) {
        this.io = io;
        this.alias.addAll(Arrays.asList(alias));
    }
}
