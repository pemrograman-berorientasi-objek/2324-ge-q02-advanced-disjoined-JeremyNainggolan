package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String input() {
        String data = scanner.nextLine();
        return data;
    }
}
