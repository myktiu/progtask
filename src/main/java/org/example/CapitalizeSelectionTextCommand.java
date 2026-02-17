package org.example;
/**
 * A {@link TextCommand} child of CapitalizeTextCommand which capitalize specific word
 */
public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {

    private final String selection;

    public CapitalizeSelectionTextCommand(String selection) {
        if (selection == null || selection.isEmpty()) {
            throw new IllegalArgumentException("Selection cannot be null or empty");
        }
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        String capitalized =
                Character.toUpperCase(selection.charAt(0)) + selection.substring(1);

        return text.replace(selection, capitalized);
    }
}