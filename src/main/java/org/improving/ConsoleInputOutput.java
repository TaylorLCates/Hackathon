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

    @Override
    public int getInteger() {
        System.out.print("> ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer.");
            System.out.print("> ");
            scanner.nextLine();
        }
        int num = scanner.nextInt();
        return num;
    }
}
