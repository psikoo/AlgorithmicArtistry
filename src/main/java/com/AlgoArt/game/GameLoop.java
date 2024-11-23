package com.AlgoArt.game;

import java.util.Scanner;

public class GameLoop {
    public GameLoop() {
        // Initial sequence
        GameLoopFrame.characterSelect();
        GameLoopFrame.intro();
    }

    public void gameTick() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        GameLoopFrame.mainState();
        // TODO add lore with if checks
        // TODO check if game is finished
        scanner.nextLine();
    }
}
