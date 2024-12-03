package com.AlgoArt.game;

import com.AlgoArt.game.End.Endings;

public class Game {
    private static Endings ending = Endings.noEnding; //* Ending reason

    public static void setEnding(Endings ending) { Game.ending = ending; }

    /**
     * Initializes the game
     */
    public Game() {
        GameLoop gameLoop = new GameLoop(); //* Character selection and intro
        //? Ending is equal to noEnding
        while (ending == Endings.noEnding) { gameLoop.gameTick(); } //* Main state
        new End(ending); //! Endings
    }
}
