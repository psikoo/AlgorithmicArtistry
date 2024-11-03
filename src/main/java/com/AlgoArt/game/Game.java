package com.AlgoArt.game;

public class Game {
    private static boolean stopGame = false;
    public static void setStopGame(boolean stopGame) { Game.stopGame = stopGame; }
    public Game() {
        stopGame = false;
        GameLoop gameLoop = new GameLoop();
        while (!stopGame) { gameLoop.gameTick(); }
        // TODO add end screen?
    }
}
