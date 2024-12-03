package com.AlgoArt.utils;

import com.AlgoArt.menu.SettingsMenu;
import com.AlgoArt.setup.Setup;

public class Inputs {
    /**
     * Checks for 'c', 'x' and 'z'
     * @param input
     */
    public static void checkStandardInputs(String input) {
        if(input.equalsIgnoreCase("c")) System.exit(0); //! Program exit
        else if(input.equalsIgnoreCase("x")) new Setup();
        else if(input.equalsIgnoreCase("z")) new SettingsMenu();
    }
}
