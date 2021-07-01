package app.core;

import app.data.GameState;

/**
 * @author harrison
 */
public class ConsolePrinter implements Printer {
    @Override
    public void print(GameState state) {
        System.out.println();
    }
}
