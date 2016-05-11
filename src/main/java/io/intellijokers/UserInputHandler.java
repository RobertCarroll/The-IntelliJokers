package io.intellijokers;

import java.util.Scanner;

public class UserInputHandler {

    Scanner input = new Scanner(System.in);

    public void promptTheUserForAString(String msg) {
        promptUser(msg);
    }

    public void promptUser(String msg) {
        System.out.println(msg);
    }
}
