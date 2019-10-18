package org.improving;

import java.util.Scanner;

public interface InputOutput {

    String receiveInput();
    void displayPrompt(String prompt);
    void displayText(String text);
    int getInteger();
}
