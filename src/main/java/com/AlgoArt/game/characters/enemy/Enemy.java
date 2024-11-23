package com.AlgoArt.game.characters.enemy;

import com.AlgoArt.game.characters.Attack;

public class Enemy {
    private String name;
    private String description;
    private int HP;
    private int maxHP;
    private Attack attack0;
    private Attack attack1;
    private Attack attack2;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHP() { return HP; }
    public int getMaxHP() { return maxHP; }
    public Attack getAttack0() { return attack0; }
    public Attack getAttack1() { return attack1; }
    public Attack getAttack2() { return attack2; }

    public Enemy(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2) {
        this.name = name;
        this.description = description;
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.attack0 = attack0;
        this.attack1 = attack1;
        this.attack2 = attack2;
    }

    public static Enemy enemyBuilder(String name) {
        if(name.equalsIgnoreCase("overseer")) return overseer();
        else if(name.equalsIgnoreCase("demonGuardian")) return demonGuardian();
        else if(name.equalsIgnoreCase("muffet")) return muffet();
        else return generic();
    }
    private static Enemy overseer() { // TODO change attack damage info
        Attack attack0 = new Attack("Plasma Tetrahedron", "The Overseer blasts a plasma tetrahedron", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Staring Eye", "The Overseer's eye looks inside your soul", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("Recursive Bite", "The Over repeatedly bites with his sharp teeth", 1, 0, 0, 0, 0);
        return new Enemy("Overseer", "The Overseer appears as a Red sphere, With a frown and a one Big sharp teeth.", 100, attack0, attack1, attack2);
    }
    private static Enemy demonGuardian() { // TODO change attack damage info
        Attack attack0 = new Attack("Vault of Secrets", "The Demon Guaridan summons a prison locked with 3 keys", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Hellfire Rain", "The Demon Guardian launches several fireballs", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("Shadow Claw Swipe", "The Demon Guardian stabs you with his claws", 1, 0, 0, 0, 0);
        return new Enemy("Demon Guardian", "The Demon Guardian appears to be green with shoulders, large horns and a toothy smile.", 100, attack0, attack1, attack2);
    }
    private static Enemy muffet() { // TODO change attack damage info
        Attack attack0 = new Attack("Spider Dance", "Muffet swiftly dances though her spider webs while attacking you", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Sugary Venom", "Muffet launches a barrage of venom projectiles", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("Verzik Webs", "Muffet launches a series of green webs", 1, 0, 0, 0, 0);
        return new Enemy("Muffet", "Muffet is an anthropomorphic spider monster with lavender skin, five eyes, six arms, and two legs.", 100, attack0, attack1, attack2);
    }
    private static Enemy generic() {
        Attack attack0 = new Attack("A0", "A0desc", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("A1", "A1desc", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("A2", "A2desc", 1, 0, 0, 0, 0);
        return new Enemy("GENERIC", "generic description", 100, attack0, attack1, attack2);
    }
}
