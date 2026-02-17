package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScriptTest {

    @Test
    void testConstructorRejectsNullList() {
        assertThrows(IllegalArgumentException.class,
                () -> new Script(null));
    }

    @Test
    void testExecuteWithEmptyCommandListReturnsOriginalText() {
        Script script = new Script(Collections.emptyList());
        assertEquals("hello", script.execute("hello"));
    }

    @Test
    void testSingleCommandExecution() {
        TextCommand upper = String::toUpperCase;
        Script script = new Script(List.of(upper));

        assertEquals("HELLO", script.execute("hello"));
    }

    @Test
    void testMultipleCommandsExecutedInOrder() {
        TextCommand addA = text -> text + "A";
        TextCommand addB = text -> text + "B";
        TextCommand wrap = text -> "[" + text + "]";

        Script script = new Script(List.of(addA, addB, wrap));

        assertEquals("[helloAB]", script.execute("hello"));
    }

    @Test
    void testCommandListCanContainLambdas() {
        Script script = new Script(List.of(
                text -> text.trim(),
                text -> text.toUpperCase()
        ));

        assertEquals("HELLO", script.execute("  hello  "));
    }
}
