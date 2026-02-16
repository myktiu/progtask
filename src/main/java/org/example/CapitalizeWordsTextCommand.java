package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {

    @Override
    public String execute(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return Arrays.stream(text.split(" "))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}