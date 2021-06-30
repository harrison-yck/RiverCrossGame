package app;

import java.util.Scanner;

/**
 * @author harrison
 */
public class RiverCrossingGameApp {
    public void start() {
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Which character(s) you would like to choose?");
            System.out.println(scanner.nextLine());
        }
    }
}
