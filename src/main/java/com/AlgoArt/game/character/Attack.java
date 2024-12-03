package com.AlgoArt.game.character;

public class Attack extends Action {
    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHPChange() { return super.getHPChange(); }
    public int getMissChance() { return super.getMissChance(); }
    public int getMultiChance() { return super.getMultiChance(); }
    public int getCritChance() { return super.getCritChance(); }
    public int getCritMultiplier() { return super.getCritMulti(); }

    /**
     * Creates an "Attack" object with the given parameters
     * @param name 
     * @param description
     * @param HPChange
     * @param critChance
     * @param critMulti
     * @param missChance
     * @param multiChance
     */
    public Attack(String name, String description, int HPChange, int critChance, int critMulti, int missChance, int multiChance) {
        super(name, description, HPChange, multiChance, missChance, critChance, critMulti);
    }

    /**
     * Generic attack
     * @return genericAttack
     */
    public static Attack genericAttack() {
        return new Attack("GenericAttack", "GenericAttackDesc", 0, 0, 0, 0, 0);
    }
}
