package org.improving;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInputOutput implements InputOutput {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String receiveInput() {
        return scanner.nextLine();
    }

    @Override
    public void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

    @Override
    public void displayText(String text) {
        System.out.println(text);
    }
}
