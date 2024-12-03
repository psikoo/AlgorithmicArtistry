package com.AlgoArt.game.character;

public abstract class Character {
    private String name;        //* Character name
    private String description; //* Character description
    private int HP;             //* Current HP
    private int maxHP;          //* Max HP
    private Attack attack0;     //* Attack 0
    private Attack attack1;     //* Attack 1
    private Attack attack2;     //* Attack 2
    private Heal heal0;         //* Heal 0
    private Heal heal1;         //* Heal 1

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public Attack getAttack0() { return attack0; }
    public Attack getAttack1() { return attack1; }
    public Attack getAttack2() { return attack2; }
    public Heal getHeal0() { return heal0; }
    public Heal getHeal1() { return heal1; }

    public void setHP(int value) { this.HP = value; }

    /**
     * Creates a "Character" object
     * @param name
     * @param description
     * @param maxHP
     * @param attack0
     * @param attack1
     * @param attack2
     * @param heal0
     * @param heal1
     */
    public Character(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2, Heal heal0, Heal heal1) {
        this.name = name;
        this.description = description;
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.attack0 = attack0;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.heal0 = heal0;
        this.heal1 = heal1;
    }
}
