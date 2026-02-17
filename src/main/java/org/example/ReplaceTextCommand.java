package org.example;

/**
 * A {@link TextCommand} parent class for replacing text commands. Ressopnsible
 * for replacing each appearance of specific word in the text with new words
 */
public class ReplaceTextCommand implements TextCommand {

    private final String target;
    private final String replacement;

    public ReplaceTextCommand(String target, String replacement) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException("Target cannot be null or empty");
        }
        if (replacement == null) {
            throw new IllegalArgumentException("Replacement cannot be null");
        }
        this.target = target;
        this.replacement = replacement;
    }

    public String getTarget() {
        return target;
    }

    public String getReplacement() {
        return replacement;
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.replace(target, replacement);
    }
}
