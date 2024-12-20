package com.AlgoArt.game.character;

public class Enemy extends Character {
    private static Heal genericHeal = Heal.genericHeal(); //* Generic heal
    private String reward = "";                           //* Png name given by the enemy

    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHP() { return super.getHP(); }
    public int getMaxHP() { return super.getMaxHP(); }
    public Attack getAttack0() { return super.getAttack0(); }
    public Attack getAttack1() { return super.getAttack1(); }
    public Attack getAttack2() { return super.getAttack2(); }
    public Heal getHeal0() { return super.getHeal0(); }
    public Heal getHeal1() { return super.getHeal1(); }
    public String getReward() { return this.reward; }

    public void setHP(int value) { super.setHP(value); }

    /**
     * Creates a "Character" object with the given parameters
     * @param name
     * @param description
     * @param reward
     * @param maxHP
     * @param attack0
     * @param attack1
     * @param attack2
     * @param action0
     * @param action1
     */
    public Enemy(String name, String description, String reward, int maxHP, Attack attack0, Attack attack1, Attack attack2, Heal action0, Heal action1) {
        super(name, description, maxHP, attack0, attack1, attack2, action0, action1);
        this.reward = reward;
    }

    /**
     * Creates "Enemy" object from the given presets
     * @param name
     * @return enemy
     */
    public static Enemy enemyBuilder(String name) {
        if(name.equalsIgnoreCase("overseer")) return overseer();
        else if(name.equalsIgnoreCase("demonGuardian")) return demonGuardian();
        else if(name.equalsIgnoreCase("muffet")) return muffet();
        else return generic();
    }
    private static Enemy overseer() { //* Level 0
        Attack attack0 = new Attack("Plasma Tetrahedron", "The Overseer blasts a plasma tetrahedron", 10, 0, 0, 0, 0);
        Attack attack1 = new Attack("Staring Eye", "The Overseer's eye looks inside your soul", 25, 10, 2, 50, 0);
        Attack attack2 = new Attack("Recursive Bite", "The Over repeatedly bites with his sharp teeth", 5, 1, 2, 5, 75);
        return new Enemy("Overseer", "The Overseer appears as a Red sphere, With a frown and a one Big sharp teeth.", "FractalKey", 100, attack0, attack1, attack2, genericHeal, genericHeal);
    }
    private static Enemy demonGuardian() { //* Level 1
        Attack attack0 = new Attack("Vault of Secrets", "The Demon Guardian summons a prison locked with 3 keys", 10, 1, 5, 10, 0);
        Attack attack1 = new Attack("Hellfire Rain", "The Demon Guardian launches several fireballs", 5, 0, 0, 10, 60);
        Attack attack2 = new Attack("Shadow Claw Swipe", "The Demon Guardian stabs you with his claws", 8, 10, 2, 10, 33);
        return new Enemy("Demon Guardian", "The Demon Guardian appears to be green with shoulders, large horns and a toothy smile.", "GeometricSky", 150, attack0, attack1, attack2, genericHeal, genericHeal);
    }
    private static Enemy muffet() { //* Level 2
        Attack attack0 = new Attack("Spider Dance", "Muffet swiftly dances though her spider webs while attacking you", 20, 0, 0, 0, 10);
        Attack attack1 = new Attack("Sugary Venom", "Muffet launches a barrage of venom projectiles", 15, 30, 2, 10, 0);
        Attack attack2 = new Attack("Verzik Webs", "Muffet launches a series of green webs", 5, 0, 0, 10, 70);
        return new Enemy("Muffet", "Muffet is an anthropomorphic spider monster with lavender skin, five eyes, six arms, and two legs.", "SpiderWebs", 200, attack0, attack1, attack2, genericHeal, genericHeal);
    }
    private static Enemy generic() { //* Generic enemy
        Attack attack0 = new Attack("A0", "A0desc", 1, 0, 0, 0, 0);
        Attack attack1 = new Attack("A1", "A1desc", 1, 0, 0, 0, 0);
        Attack attack2 = new Attack("A2", "A2desc", 1, 0, 0, 0, 0);
        return new Enemy("GENERIC", "generic description", "GENERIC", 100, attack0, attack1, attack2, genericHeal, genericHeal);
    }
}
