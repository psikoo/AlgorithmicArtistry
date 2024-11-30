package com.AlgoArt.game;

import com.AlgoArt.game.character.Player;

public class GameLoop {
    private boolean fractalSeen = false;
    private boolean geomSeen = false;
    private boolean spiderSeen = false;

    public GameLoop() {
        // Initial sequence
        GameLoopFrame.characterSelect();
        GameLoopFrame.intro();
    }

    public void gameTick() { 
        if(Player.player.getCompleteFractal() && !fractalSeen) { GameLoopFrame.postFractal(); fractalSeen = true; }
        if(Player.player.getCompleteGeom() && !geomSeen) { GameLoopFrame.postGeom(); geomSeen = true; }
        if(Player.player.getCompleteSpider() && !spiderSeen) { GameLoopFrame.postSpider(); spiderSeen = true; }
        if(checkTrueEnding()) { GameLoopFrame.postAll(); Game.setEnding("true"); }
        if(!checkTrueEnding()) GameLoopFrame.mainState();
    }

    private boolean checkTrueEnding() {
        return (Player.player.getCompleteFractal() && Player.player.getCompleteGeom() && Player.player.getCompleteSpider());
    }
}
