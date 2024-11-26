package com.AlgoArt.game;

import com.AlgoArt.game.characters.player.Player;

public class GameLoop {
    public GameLoop() {
        // Initial sequence
        GameLoopFrame.characterSelect();
        GameLoopFrame.intro();
    }

    public void gameTick() {
        GameLoopFrame.mainState(); // TODO THIS IS NEVER REACHED vvv why?
        if(Player.player.getCompleteFractal() && Player.player.getCompleteGeom() && Player.player.getCompleteSpider()) Game.setEnding("true");
    }
}
