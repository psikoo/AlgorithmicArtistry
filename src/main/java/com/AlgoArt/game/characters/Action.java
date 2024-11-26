package com.AlgoArt.game.characters;

public class Action {
    private String name;
    private String description;
    private int HPChange;
    private int multipleChance;
    private int backFire;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHPChange() { return HPChange; }
    public int getMultipleChance() { return multipleChance; }
    public int getBackFire() { return backFire; }

    public Action(String name, String description, int HPChange, int multipleChance, int backFire) {
        this.name = name;
        this.description = description; 
        this.HPChange = HPChange;
        this.multipleChance = multipleChance;
        this.backFire = backFire;
    }

    public static Action genericActionBuilder() {
        return new Action("GenericAction", "GenericActionDesc", 0, 0, 0);
    }
}
