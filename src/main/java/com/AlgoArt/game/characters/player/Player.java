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
    public void setCompleteFractal() { completeFractal = true; }
    public void setCompleteGeom() { completeGeom = true; }
    public void setCompleteSpider() { completeSpider = true; }

    public Player(String name, String description, int maxHP, Attack attack0, Attack attack1, Attack attack2, Action action0, Action action1) {
        super(name, description, maxHP, attack0, attack1, attack2, action0, action1);
    }

    public static Player playerBuilder(int option) {
        if(option == PlayerId.DallE.ordinal()) return dallE();
        else if(option == PlayerId.Midjourney.ordinal()) return midjourney();
        else if(option == PlayerId.StableDiffusion.ordinal()) return stableD();
        else return generic();
    }
    private static Player dallE() { // TODO change "Against policy" text to fit a multi heal action instead of scape
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self", 100, 0, 0); // TODO change 100 healing
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup", 10, 60, 0);
        player = new Player("Dall-E", "Dall-E", 1000, attack0, attack1, attack2, action0, action1); // TODO change HP
        return player;
    }
    private static Player midjourney() {
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self", 25, 0, 0);
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup", 10, 60, 0);
        player = new Player("Midjourney", "Midjourney", 100, attack0, attack1, attack2, action0, action1);
        return player;
        //TODO Create unique attacks and change HP
    }
    private static Player stableD() {
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self", 25, 0, 0);
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup", 10, 60, 0);
        player = new Player("Stable Diffusion", "Stable Diffusion", 100, attack0, attack1, attack2, action0, action1);
        return player;
        //TODO Create unique attacks and change HP
    }
    private static Player generic() {
        player = new Player("GenericPlayer", "GenericPlayerDescription", 100, attackG, attackG, attackG, actionG, actionG);
        return player;
    }

    public enum PlayerId {
        DallE,
        Midjourney,
        StableDiffusion,
    }
}


