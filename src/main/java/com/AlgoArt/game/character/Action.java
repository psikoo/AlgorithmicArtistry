package com.AlgoArt.game.character;

public abstract class Action {
    private String name;        //* Action name
    private String description; //* Action description
    private int HPChange;       //* Amount to change HP by
    private int multiChance;    //* Chance to proc multiple times
    private int missChance;     //* Chance to miss the action
    private int critChance;     //* Chance to crit the action
    private int critMulti;      //* Amount to multiply critical hits by

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHPChange() { return HPChange; }
    public int getMultiChance() { return multiChance; }
    public int getMissChance() { return missChance; }
    public int getCritChance() { return critChance; }
    public int getCritMulti() { return critMulti; }

    /**
     * Creates a "Action" object
     * @param name
     * @param description
     * @param HPChange
     * @param multiChance
     * @param missChance
     */
    public Action(String name, String description, int HPChange, int multiChance, int missChance) {
        this.name = name;
        this.description = description; 
        this.HPChange = HPChange;
        this.multiChance = multiChance;
        this.missChance = missChance;
    } 
    /**
     * Creates a "Action" object with crit
     * @param name
     * @param description
     * @param HPChange
     * @param multiChance
     * @param missChance
     * @param critChance
     * @param critMulti
     */
    public Action(String name, String description, int HPChange, int multiChance, int missChance, int critChance, int critMulti) {
        this(name, description, HPChange, multiChance, missChance);
        this.critChance = critChance;
        this.critMulti = critMulti; 
    }
}
