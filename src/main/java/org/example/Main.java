package org.example;

import java.util.List;
/**
 Limitations Capitalize need to be executed before wrapping
 */
public class Main {
    public static void main(String[] args) {
        String text = """
                hello world
                this is a selection test
                another world appears here
                final selection line
                """;

        Script script = new Script(List.of(
                new ReplaceTextCommand("world", "java"),
                new ReplaceFirstTextCommand("selection", "TARGET"),
                new CapitalizeTextCommand(),
                new CapitalizeWordsTextCommand(),
                new CapitalizeSelectionTextCommand("java"),
                new WrapLinesTextCommand("[", "]"),
                new WrapSelectionTextCommand("<b>", "</b>", "TARGET"),
                new WrapTextCommand("<<<START>>>\n", "\n<<<END>>>")
        ));

        String result = script.execute(text);

        System.out.println("FINAL RESULT:\n");
        System.out.println(result);
    }
}