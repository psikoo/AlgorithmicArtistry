package com.AlgoArt.game.story;

public class Story {
    public Story(StoryLevel storyLevel) {
        if(storyLevel == StoryLevel.fractal) fractal();
        else if(storyLevel == StoryLevel.geom) geom();
        else if(storyLevel == StoryLevel.spider) spider();
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
