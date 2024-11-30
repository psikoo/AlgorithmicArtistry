package com.AlgoArt.game.story;

public class Story {
    public Story(StoryLevel storyLevel) {
        if(storyLevel == StoryLevel.fractal) StoryFrame.fractal();
        else if(storyLevel == StoryLevel.geom) StoryFrame.geom();
        else if(storyLevel == StoryLevel.spider) StoryFrame.spider();
    } 

    public enum StoryLevel {
        fractal,
        geom,
        spider,
    }
}
