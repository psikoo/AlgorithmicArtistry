package com.AlgoArt.game.characters.player;

import com.AlgoArt.game.characters.Action;
import com.AlgoArt.game.characters.Attack;

public class Player { // TODO add flags for level completion
    private String name;
    private Attack attack0;
    private Attack attack1;
    private Attack attack2;
    private Action action0;
    private Action action1;

    public String getName() { return name; }
    public Attack getAttack0() { return attack0; }
    public Attack getAttack1() { return attack1; }
    public Attack getAttack2() { return attack2; }
    public Action getAction0() { return action0; }
    public Action getAction1() { return action1; }

    public Player(int option) {
        if(option == PlayerId.DallE.ordinal()) dallE();
        else if(option == PlayerId.Midjourney.ordinal()) midjourney();
        else if(option == PlayerId.StableDiffusion.ordinal()) stableD();
    }

    private void dallE() {
        name = "Dall-E";
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self");
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup");
    }
    private void midjourney() {
        name = "Midjourney";
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self");
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup");
        //TODO Create unique attacks
    }
    private void stableD() {
        name = "Stable Diffusion";
        attack0 = new Attack("Data Overload", "The AI floods the opponent screen with information", 10, 10, 4, 10, 0);
        attack1 = new Attack("Chain Reaction", "The AI fires a series of responses damaging the opponent", 5, 0, 1, 5, 50);
        attack2 = new Attack("Misunderstand Prompt", "The AI sends a confusing response stunning the opponent", 0, 0, 0, 10, 0);
        action0 = new Action("Dynamic Scaling", "The AI spins up a new system healing it self");
        action1 = new Action("Against our policy", "The AI runs away hiding behind a popup");
        //TODO Create unique attacks
    }

    private enum PlayerId {
        DallE,
        Midjourney,
        StableDiffusion,
    }
}

