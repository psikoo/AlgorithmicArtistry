package com.AlgoArt.game.story;

public class Story {
    /**
     * Starts the given story level
     * @param storyLevel
     */
    public Story(StoryLevel storyLevel) {
        if(storyLevel == StoryLevel.fractal) StoryFrame.fractal();
        else if(storyLevel == StoryLevel.geom) StoryFrame.geom();
        else if(storyLevel == StoryLevel.spider) StoryFrame.spider();
    } 

    /**
     * Levels
     */
    public enum StoryLevel {
        fractal,
        geom,
        spider,
    }
}
