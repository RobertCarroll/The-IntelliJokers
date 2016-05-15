package io.intellijokers;

import java.util.Scanner;

public class UserInputHandler {

    public static Scanner input = new Scanner(System.in);

    public static String promptTheUserForAString(String msg) {
        promptUser(msg);
        return input.nextLine();
    }

    public static int promptTheUserForAnInteger(String msg) {
        promptUser(msg);
        return input.nextInt();
    }

    public static void promptUser(String msg) {
        System.out.println(msg);
    }

}
