package com.AlgoArt.game.characters.player;

import com.AlgoArt.game.characters.Action;
import com.AlgoArt.game.characters.Attack;
import com.AlgoArt.game.characters.Character;

public class Player extends Character {
    public static Player player;
    private static Attack attack0;
    private static Attack attack1;
    private static Attack attack2;
    private static Action action0;
    private static Action action1;
    private static Attack attackG = Attack.genericAttackBuilder();
    private static Action actionG = Action.genericActionBuilder();
    private static boolean completeFractal = false;
    private static boolean completeGeom = false;
    private static boolean completeSpider = false;

    public String getName() { return super.getName(); }
    public String getDescription() { return super.getDescription(); }
    public int getHP() { return super.getHP(); }
    public int getMaxHP() { return super.getMaxHP(); }
    public Attack getAttack0() { return super.getAttack0(); }
    public Attack getAttack1() { return super.getAttack1(); }
    public Attack getAttack2() { return super.getAttack2(); }
    public Action getAction0() { return super.getAction0(); }
    public Action getAction1() { return super.getAction1(); }
    public boolean getCompleteFractal() { return completeFractal; }
    public boolean getCompleteGeom() { return completeGeom; }
    public boolean getCompleteSpider() { return completeSpider; }

    public void setHP(int value) { super.setHP(value); }
    public void setCompleteFractal(boolean bool) { completeFractal = bool; }
    public void setCompleteGeom(boolean bool) { completeGeom = bool; }
    public void setCompleteSpider(boolean bool) { completeSpider = bool; }

    public Player(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2, Action action0, Action action1) {
        super(name, description, maxHP, attack0, attack1, attack2, action0, action1);
    }

    public static Player playerBuilder(PlayerId option) {
        if(option == PlayerId.DallE) return dallE();
        else if(option == PlayerId.Midjourney) return midjourney();
        else if(option == PlayerId.StableDiffusion) return stableD();
        else return generic();
    }
    private static Player dallE() { // Easy mode
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response damaging the opponent", 20, 5, 2, 30, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self", 20, 0, 0);
        action1 = new Action("Firewall Scan", "The AI executes a series of scans healing it self", 10, 75, 0);
        return player = new Player("Dall-E", "Dall-E", 10000, attack0, attack1, attack2, action0, action1);
    }
    private static Player midjourney() { // Normal mode
        attack0 = new Attack("Reality Distortion", "The AI bends reality damaging the opponent", 20, 5, 10, 0, 0);
        attack1 = new Attack("Neural Hack", "The AI hacks into the opponent's mind damaging the opponent", 2, 0, 0, 5, 90);
        attack2 = new Attack("Generated Strike", "The AI generates a weapon to strike the opponent", 50, 0, 0, 40, 0);
        action0 = new Action("Holographic Decoy", "The AI creates a decoy and heals amongst the distraction", 25, 0, 10);
        action1 = new Action("Adaptive Shielding", "The AIcreates a series of shields", 10, 60, 0);
        return player = new Player("Midjourney", "Midjourney", 80, attack0, attack1, attack2, action0, action1);
    }
    private static Player stableD() { // Gamble mode
        attack0 = new Attack("Critical Data", "Gamble on a 5% chance to crit", 1, 5, 100, 10, 0);
        attack1 = new Attack("Targeted Data", "Gamble on a 10% chance of not missing", 60, 0, 0, 90, 0);
        attack2 = new Attack("Recursive Data", "Gamble that the attack will hit several times", 5, 0, 0, 0, 80);
        action0 = new Action("Two in Three", "There is a 33% chance of this damaging you", 66, 0, 33);
        action1 = new Action("Coin Flip", "The AI either you heals to full HP or dies", 10000, 0, 50);
        return player = new Player("Stable Diffusion", "Stable Diffusion", 100, attack0, attack1, attack2, action0, action1);
    }
    private static Player generic() {
        return player = new Player("GenericPlayer", "GenericPlayerDescription", 100, attackG, attackG, attackG, actionG, actionG);
    }

    public enum PlayerId {
        DallE,
        Midjourney,
        StableDiffusion,
    }
}


