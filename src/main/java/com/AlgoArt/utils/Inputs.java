package com.AlgoArt.utils;

import com.AlgoArt.game.Game;
import com.AlgoArt.menu.SettingsMenu;
import com.AlgoArt.setup.Setup;

public class Inputs {
    public static void checkStandardInputs(String input) {
        if(input.equals("c")) System.exit(0);
        else if(input.equals("x")) new Setup();
        else if(input.equals("z")) new SettingsMenu();
        else if(input.equals("cake")) Game.setEnding("secret");;
    }
}
