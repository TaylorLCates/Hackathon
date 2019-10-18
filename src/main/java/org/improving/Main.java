package org.improving;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();

        var context = new AnnotationConfigApplicationContext(SpringContext.class);

        io.displayPrompt("> ");
        var input = io.receiveInput();
        io.displayText(input);
    }
}
