package org.example;

public class CapitalizeTextCommand implements TextCommand {

    @Override
    public String execute(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}