package com.AlgoArt.game.characters.enemy;

import com.AlgoArt.game.characters.Action;
import com.AlgoArt.game.characters.Attack;
import com.AlgoArt.game.characters.Character;

public class Enemy extends Character {
    private static Action genericAction = Action.genericActionBuilder();  
    private String reward = "";

    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHP() { return super.getHP(); }
    public int getMaxHP() { return super.getMaxHP(); }
    public Attack getAttack0() { return super.getAttack0(); }
    public Attack getAttack1() { return super.getAttack1(); }
    public Attack getAttack2() { return super.getAttack2(); }
    public Action getAction0() { return super.getAction0(); }
    public Action getAction1() { return super.getAction1(); }
    public String getReward() { return this.reward; }

    public void setHP(int value) { super.setHP(value); }

    public Enemy(String name, String description, String reward, int maxHP, Attack attack0, Attack attack1, Attack attack2, Action action0, Action action1) {
        super(name, description, maxHP, attack0, attack1, attack2, action0, action1);
        this.reward = reward;
    }

    public static Enemy enemyBuilder(String name) {
        if(name.equalsIgnoreCase("overseer")) return overseer();
        else if(name.equalsIgnoreCase("demonGuardian")) return demonGuardian();
        else if(name.equalsIgnoreCase("muffet")) return muffet();
        else return generic();
    }
    private static Enemy overseer() { // TODO tune damage values
        Attack attack0 = new Attack("Plasma Tetrahedron", "The Overseer blasts a plasma tetrahedron", 10, 0, 0, 0, 0);
        Attack attack1 = new Attack("Staring Eye", "The Overseer's eye looks inside your soul", 20, 10, 2, 20, 0);
        Attack attack2 = new Attack("Recursive Bite", "The Over repeatedly bites with his sharp teeth", 5, 1, 2, 5, 75);
        return new Enemy("Overseer", "The Overseer appears as a Red sphere, With a frown and a one Big sharp teeth.", "FractalKey", 1, attack0, attack1, attack2, genericAction, genericAction); // TODO change HP
    }
    private static Enemy demonGuardian() { // TODO change attack damage info
        Attack attack0 = new Attack("Vault of Secrets", "The Demon Guardian summons a prison locked with 3 keys", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Hellfire Rain", "The Demon Guardian launches several fireballs", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("Shadow Claw Swipe", "The Demon Guardian stabs you with his claws", 1, 0, 0, 0, 0);
        return new Enemy("Demon Guardian", "The Demon Guardian appears to be green with shoulders, large horns and a toothy smile.", "GeometricSky", 100, attack0, attack1, attack2, genericAction, genericAction);
    }
    private static Enemy muffet() { // TODO change attack damage info
        Attack attack0 = new Attack("Spider Dance", "Muffet swiftly dances though her spider webs while attacking you", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("Sugary Venom", "Muffet launches a barrage of venom projectiles", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("Verzik Webs", "Muffet launches a series of green webs", 1, 0, 0, 0, 0);
        return new Enemy("Muffet", "Muffet is an anthropomorphic spider monster with lavender skin, five eyes, six arms, and two legs.", "SpiderWebs", 100, attack0, attack1, attack2, genericAction, genericAction);
    }
    private static Enemy generic() {
        Attack attack0 = new Attack("A0", "A0desc", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("A1", "A1desc", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("A2", "A2desc", 1, 0, 0, 0, 0);
        return new Enemy("GENERIC", "generic description", "GENERIC", 100, attack0, attack1, attack2, genericAction, genericAction);
    }
}
