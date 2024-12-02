package com.AlgoArt.game.character;

public class Attack extends Action {
    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHPChange() { return super.getHPChange(); }
    public int getMissChance() { return super.getMissChance(); }
    public int getMultiChance() { return super.getMultiChance(); }
    public int getCritChance() { return super.getCritChance(); }
    public int getCritMultiplier() { return super.getCritMulti(); }

    public Attack(String name, String description, int HPChange, int critChance, int critMulti, int missChance, int multiChance) {
        super(name, description, HPChange, multiChance, missChance, critChance, critMulti);
    }

    public static Attack genericAttackBuilder() {
        return new Attack("GenericAttack", "GenericAttackDesc", 0, 0, 0, 0, 0);
    }
}
