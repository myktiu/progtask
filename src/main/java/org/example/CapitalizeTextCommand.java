package org.example;
/**
 * A {@link TextCommand} parent class for all CapitalizeTextCommands. Capitalize
 * first letter in the text
 */
public class CapitalizeTextCommand implements TextCommand {

    @Override
    public String execute(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}