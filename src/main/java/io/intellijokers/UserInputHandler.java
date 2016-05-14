package io.intellijokers;
/**
 * Created by michaelcane on 5/11/16.
 */
import java.util.Scanner;

public class UserInputHandler {

    Scanner input = new Scanner(System.in);

    public String promptTheUserForAString(String msg) {
        promptUser(msg);
        return input.nextLine();
    }

    public int promptTheUserForAnInteger(String msg) {
        promptUser(msg);
        return input.nextInt();
    }

    public void promptUser(String msg) {
        System.out.println(msg);
    }
}
