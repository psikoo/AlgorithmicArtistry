package com.AlgoArt.game.character;

public class Heal extends Action {
    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHPChange() { return super.getHPChange(); }
    public int getMultiChance() { return super.getMultiChance(); }
    public int getMissChance() { return super.getMissChance(); }

    /**
     * Creates an "Action" object with the given parameters
     * @param name
     * @param description
     * @param HPChange
     * @param multipleChance
     * @param missChance
     */
    public Heal(String name, String description, int HPChange, int multipleChance, int missChance) {
        super(name, description, HPChange, multipleChance, missChance);
    }

    /**
     * Generic heal
     * @return genericHeal
     */
    public static Heal genericHeal() {
        return new Heal("GenericAction", "GenericActionDesc", 0, 0, 0);
    }
    /**
     * Heal 1000HP
     * @return fullHeal
     */
    public static Heal fullHeal() {
        return new Heal("Heal", "Heal", 1000, 0, 0);
    }
}
