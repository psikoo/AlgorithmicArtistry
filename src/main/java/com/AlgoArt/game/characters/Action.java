package com.AlgoArt.game.characters;

public class Action {
    private String name;
    private String description;

    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String name) { this.name = description; }

    public Action(String name, String description) {
        this.name = name;
        this.description = description; 
    }
}
