package com.AlgoArt.game;

import com.AlgoArt.game.End.Endings;

public class Game {
    private static Endings ending = Endings.noEnding;

    public static void setEnding(Endings ending) { Game.ending = ending; }

    public Game() {
        GameLoop gameLoop = new GameLoop();
        while (ending == Endings.noEnding) { gameLoop.gameTick(); }
        new End(ending);
    }
}
