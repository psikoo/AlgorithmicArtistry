package com.AlgoArt.game.story;

import com.AlgoArt.game.battle.Battle;
import com.AlgoArt.game.characters.enemy.Enemy;

public class Story {
    public Story(int storyLevel) {
        if(storyLevel == StoryLevel.fractal.ordinal()) fractal();
        else if(storyLevel == StoryLevel.geom.ordinal()) geom();
        else if(storyLevel == StoryLevel.spider.ordinal()) spider();
    } 

    private void fractal() {
        StoryFrame.fractal();
        new Battle(Enemy.enemyBuilder("overseer"));
    }
    private void geom() {
        StoryFrame.geom();
        // TODO Add battle
    }
    private void spider() {
        StoryFrame.spider();
        // TODO Add battle
    }



    public enum StoryLevel {
        fractal,
        geom,
        spider,
    }
}
