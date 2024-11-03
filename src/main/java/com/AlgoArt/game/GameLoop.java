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
        //GameLoopFrame.mainState();
        // TODO
        scanner.nextLine();
    }
}
