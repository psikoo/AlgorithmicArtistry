package com.AlgoArt.game.characters;

public class Attack {
    private String name;
    private String description;
    private int damage;
    private int critChance;
    private int critMultiplier;
    private int missChance;
    private int multipleChance;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getDamage() { return damage; }
    public int getCritChance() { return critChance; }
    public int getCritMultiplier() { return critMultiplier; }
    public int getMissChance() { return missChance; }
    public int getMultipleChance() { return multipleChance; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String name) { this.name = description; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setCritChance(int critChance) { this.critChance = critChance; }
    public void setCritMultiplier(int critMultiplier) { this.critMultiplier = critMultiplier; }
    public void setMissChance(int missChance) { this.missChance = missChance; }
    public void setMultipleChance(int multipleChance) { this.multipleChance = multipleChance; }

    public Attack(String name, String description, int damage, int critChance, int critMultiplier, int missChance, int multipleChance) {
        this.name = name;
        this.description = description; 
        this.damage = damage;
        this.critChance = critChance;
        this.critMultiplier = critMultiplier;
        this.missChance = missChance;
        this.multipleChance = multipleChance;
    }

    public static Attack genericAttackBuilder() {
        return new Attack("GenericAttack", "GenericAttackDesc", 0, 0, 0, 0, 0);
    }
}
