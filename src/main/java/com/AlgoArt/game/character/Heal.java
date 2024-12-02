package com.AlgoArt.game.character;

public class Heal extends Action {
    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHPChange() { return super.getHPChange(); }
    public int getMultiChance() { return super.getMultiChance(); }
    public int getMissChance() { return super.getMissChance(); }

    public Heal(String name, String description, int HPChange, int multipleChance, int missChance) {
        super(name, description, HPChange, multipleChance, missChance);
    }

    public static Heal genericActionBuilder() {
        return new Heal("GenericAction", "GenericActionDesc", 0, 0, 0);
    }
    public static Heal fullHeal() {
        return new Heal("Heal", "Heal", 1000, 0, 0);
    }
}
