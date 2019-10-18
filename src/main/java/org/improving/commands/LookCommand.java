package org.improving.commands;

import org.improving.ConsoleInputOutput;
import org.improving.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasCommand {
//    public LookCommand(InputOutput io) {
//        super(io, "look", "l", "see", "check");
//    }

    public LookCommand(InputOutput io) {
        super(io, "look", "l", "see", "check");
    }
}
