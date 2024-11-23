package com.AlgoArt.game.story;

public class Story {
    public Story(int storyLevel) {
        if(storyLevel == StoryLevel.fractal.ordinal()) fractal();
        else if(storyLevel == StoryLevel.geom.ordinal()) geom();
        else if(storyLevel == StoryLevel.spider.ordinal()) spider();
    } 

    private void fractal() {
        StoryFrame.fractal();
    }
    private void geom() {
        StoryFrame.geom();
    }
    private void spider() {
        StoryFrame.spider();
    }



    public enum StoryLevel {
        fractal,
        geom,
        spider,
    }
}
