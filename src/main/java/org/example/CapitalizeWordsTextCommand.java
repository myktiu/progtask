package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A {@link TextCommand} which capitalizes the first letter of each word in the string
 * hild of CapitalizeTextCommand
 * limitations. everything except the first one
 * it is applied to. No more than one whitespace
 */
public class CapitalizeWordsTextCommand extends CapitalizeTextCommand {

    @Override
    public String execute(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        String collect = Arrays.stream(text.split("\n"))
                .map(word -> word.isEmpty()
                        ? word
                        : Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining("\n"));
        return Arrays.stream(collect.split(" "))
                .map(word -> word.isEmpty()
                        ? word
                        : super.execute(word))
                .collect(Collectors.joining(" "));
    }
}