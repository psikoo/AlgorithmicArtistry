package com.AlgoArt.game.character;

public abstract class Character {
    private String name;
    private String description;
    private int HP;
    private int maxHP;
    private Attack attack0;
    private Attack attack1;
    private Attack attack2;
    private Action action0;
    private Action action1;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public Attack getAttack0() { return attack0; }
    public Attack getAttack1() { return attack1; }
    public Attack getAttack2() { return attack2; }
    public Action getAction0() { return action0; }
    public Action getAction1() { return action1; }

    public void setHP(int value) { this.HP = value; }

    public Character(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2, Action action0, Action action1) {
        this.name = name;
        this.description = description;
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.attack0 = attack0;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.action0 = action0;
        this.action1 = action1;
    }
}
