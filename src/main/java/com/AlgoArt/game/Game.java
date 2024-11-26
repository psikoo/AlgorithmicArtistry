package com.AlgoArt.game;

public class Game {
    private static String ending = "";

    public static void setEnding(String string) { Game.ending = string; }

    public Game() {
        GameLoop gameLoop = new GameLoop();
        while (ending.equals("")) { gameLoop.gameTick(); }
        new End(ending);
    }
}
