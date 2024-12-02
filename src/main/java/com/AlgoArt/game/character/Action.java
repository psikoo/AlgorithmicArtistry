package com.AlgoArt.game.character;

public abstract class Action {
    private String name;
    private String description;
    private int HPChange;
    private int multiChance;
    private int missChance;
    private int critChance;
    private int critMulti;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHPChange() { return HPChange; }
    public int getMultiChance() { return multiChance; }
    public int getMissChance() { return missChance; }
    public int getCritChance() { return critChance; }
    public int getCritMulti() { return critMulti; }

    public Action(String name, String description, int HPChange, int multiChance, int missChance) {
        this.name = name;
        this.description = description; 
        this.HPChange = HPChange;
        this.multiChance = multiChance;
        this.missChance = missChance;
    } public Action(String name, String description, int HPChange, int multiChance, int missChance, int critChance, int critMulti) {
        this(name, description, HPChange, multiChance, missChance);
        this.critChance = critChance;
        this.critMulti = critMulti; 
    }
}
