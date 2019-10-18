package org.improving;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();

        var context = new AnnotationConfigApplicationContext(SpringContext.class);
        var game = context.getBean(Game.class);
        game.run();

    }
}
