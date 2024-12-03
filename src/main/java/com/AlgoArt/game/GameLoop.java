package com.AlgoArt.game;

import com.AlgoArt.game.character.Player;

public class GameLoop {
    private boolean fractalSeen = false; //* Seen the post lore of level 0
    private boolean geomSeen = false;    //* Seen the post lore of level 1
    private boolean spiderSeen = false;  //* Seen the post lore of level 2

    /**
     * Displays character selection and the introduction
     */
    public GameLoop() {
        //* Initial sequence
        GameLoopFrame.characterSelect();
        GameLoopFrame.intro();
    }

    /**
     * Checks if the there is a winning state or if post battle lore should be showed,
     * After it displays the mainState
     */
    public void gameTick() { 
        if(Player.player.getCompleteFractal() && !fractalSeen) { GameLoopFrame.postFractal(); fractalSeen = true; }
        else if(Player.player.getCompleteGeom() && !geomSeen) { GameLoopFrame.postGeom(); geomSeen = true; }
        else if(Player.player.getCompleteSpider() && !spiderSeen) { GameLoopFrame.postSpider(); spiderSeen = true; }
        else if(checkTrueEnding()) GameLoopFrame.postAll();
        else GameLoopFrame.mainState();
    }

    /**
     * Checks if the player has bitten level 0, 1 and 2
     * @return trueEnding
     */
    private boolean checkTrueEnding() {
        //? PLayer has completed level 0, 1 and 2
        return (Player.player.getCompleteFractal() && Player.player.getCompleteGeom() && Player.player.getCompleteSpider());
    }
}
