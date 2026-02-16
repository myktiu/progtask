package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WrapLinesTextCommand extends WrapTextCommand {

    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        return Arrays.stream(text.split("\n", -1))
                .map(line -> getOpening() + line + getEnd())
                .collect(Collectors.joining("\n"));
    }
}
