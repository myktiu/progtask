package org.example;
/**
 * A {@link TextCommand} which is a child of ReplaceTextCommand. Replace only
 * first appearance of the specific word
 */
public class ReplaceFirstTextCommand extends ReplaceTextCommand {

    public ReplaceFirstTextCommand(String target, String replacement) {
        super(target, replacement);
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.replaceFirst(
                java.util.regex.Pattern.quote(getTarget()),
                getReplacement()
        );
    }
}