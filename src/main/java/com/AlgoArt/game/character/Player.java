package com.AlgoArt.game.character;

public class Player extends Character {
    public static Player player;                                   //* Holds the player object for static referencing
    private static Attack attackG = Attack.genericAttack();        //* Generic attack
    private static Heal actionG = Heal.genericHeal();              //* Generic heal
    private static boolean completeFractal = false;                //* Has beaten level 0
    private static boolean completeGeom = false;                   //* Has beaten level 1
    private static boolean completeSpider = false;                 //* Has beaten level 2

    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHP() { return super.getHP(); }
    public int getMaxHP() { return super.getMaxHP(); }
    public Attack getAttack0() { return super.getAttack0(); }
    public Attack getAttack1() { return super.getAttack1(); }
    public Attack getAttack2() { return super.getAttack2(); }
    public Heal getHeal0() { return super.getHeal0(); }
    public Heal getHeal1() { return super.getHeal1(); }
    public boolean getCompleteFractal() { return completeFractal; }
    public boolean getCompleteGeom() { return completeGeom; }
    public boolean getCompleteSpider() { return completeSpider; }

    public void setHP(int value) { super.setHP(value); }
    public void setCompleteFractal(boolean bool) { completeFractal = bool; }
    public void setCompleteGeom(boolean bool) { completeGeom = bool; }
    public void setCompleteSpider(boolean bool) { completeSpider = bool; }

    /**
     * Creates a "Character" object with the given parameters
     * @param name
     * @param description
     * @param maxHP
     * @param attack0
     * @param attack1
     * @param attack2
     * @param action0
     * @param action1
     */
    public Player(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2, Heal action0, Heal action1) {
        super(name, description, maxHP, attack0, attack1, attack2, action0, action1);
    }

    /**
     * Creates "Player" object from the given presets
     * @param option
     * @return player
     */
    public static Player playerBuilder(PlayerId option) {
        if(option == PlayerId.DallE) return dallE();
        else if(option == PlayerId.Midjourney) return midjourney();
        else if(option == PlayerId.StableDiffusion) return stableD();
        else return generic();
    }
    private static Player dallE() { //* Easy mode
        Attack attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        Attack attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        Attack attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response damaging the opponent", 20, 5, 2, 30, 0);
        Heal heal0 = new Heal("Dynamic Scaling", "The AI spins up a new system healing it self", 20, 0, 0);
        Heal  heal1 = new Heal("Firewall Scan", "The AI executes a series of scans healing it self", 10, 75, 0);
        return player = new Player("Dall-E", "Dall-E", 10000, attack0, attack1, attack2, heal0, heal1);
    }
    private static Player midjourney() { //* Normal mode
        Attack attack0 = new Attack("Reality Distortion", "The AI bends reality damaging the opponent", 20, 5, 10, 0, 0);
        Attack attack1 = new Attack("Neural Hack", "The AI hacks into the opponent's mind damaging the opponent", 2, 0, 0, 5, 90);
        Attack attack2 = new Attack("Generated Strike", "The AI generates a weapon to strike the opponent", 50, 0, 0, 40, 0);
        Heal heal0 = new Heal("Holographic Decoy", "The AI creates a decoy and heals amongst the distraction", 25, 0, 10);
        Heal heal1 = new Heal("Adaptive Shielding", "The AIcreates a series of shields", 10, 60, 0);
        return player = new Player("Midjourney", "Midjourney", 80, attack0, attack1, attack2, heal0, heal1);
    }
    private static Player stableD() { //* Gamble mode
        Attack attack0 = new Attack("Critical Data", "Gamble on a 5% chance to crit", 1, 5, 100, 10, 0);
        Attack attack1 = new Attack("Targeted Data", "Gamble on a 10% chance of not missing", 60, 0, 0, 90, 0);
        Attack attack2 = new Attack("Recursive Data", "Gamble that the attack will hit several times", 5, 0, 0, 0, 80);
        Heal heal0 = new Heal("Two in Three", "There is a 33% chance of this damaging you", 66, 0, 33);
        Heal heal1 = new Heal("Coin Flip", "The AI either you heals to full HP or dies", 10000, 0, 50);
        return player = new Player("Stable Diffusion", "Stable Diffusion", 100, attack0, attack1, attack2, heal0, heal1);
    }
    private static Player generic() { //* Generic player
        return player = new Player("GenericPlayer", "GenericPlayerDescription", 100, attackG, attackG, attackG, actionG, actionG);
    }

    public enum PlayerId {
        DallE,
        Midjourney,
        StableDiffusion,
    }
}


