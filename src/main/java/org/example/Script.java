package org.example;

import java.util.List;

public class Script implements TextCommand {

    private final List<TextCommand> commands;

    public Script(List<TextCommand> commands) {
        if (commands == null) {
            throw new IllegalArgumentException("Command list cannot be null");
        }
        this.commands = commands;
    }

    @Override
    public String execute(String text) {
        String result = text;

        for (TextCommand command : commands) {
            result = command.execute(result);
        }

        return result;
    }
}

