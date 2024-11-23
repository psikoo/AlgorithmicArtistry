package com.AlgoArt.game.characters.enemy;

import com.AlgoArt.game.characters.Attack;

public class Enemy {
    private String name;
    private int HP;
    private int maxHP;
    private Attack attack0;
    private Attack attack1;
    private Attack attack2;

    public String getName() { return name; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public Attack getAttack0() { return attack0; }
    public Attack getAttack1() { return attack1; }
    public Attack getAttack2() { return attack2; }

    public Enemy(String name, int maxHP, Attack attack0, Attack attack1, Attack attack2) {
        this.name = name;
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.attack0 = attack0;
        this.attack1 = attack1;
        this.attack2 = attack2;
    }

    public static Enemy enemyBuilder(String name) {
        if(name.equals("overseer")) return overseer();       // TODO add enemies for all levels
        else if(name.equals("TODO")) return generic();  // TODO add enemies for all levels
        else if(name.equals("TODO")) return generic();  // TODO add enemies for all levels
        else return generic();
    }
    private static Enemy overseer() {
        Attack attack0 = new Attack("Staring eye", "A0desc", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Plasma tetrahedron", "A1desc", 1, 0, 0, 0, 0); // TODO change descriptions and damages
        Attack attack2 = new Attack("Recursive Bite", "A2desc", 1, 0, 0, 0, 0);
        return new Enemy("Overseer", 100, attack0, attack1, attack2);
    }
    private static Enemy generic() {
        Attack attack0 = new Attack("A0", "A0desc", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("A1", "A1desc", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("A2", "A2desc", 1, 0, 0, 0, 0);
        return new Enemy("GENERIC", 100, attack0, attack1, attack2);
    }
}
