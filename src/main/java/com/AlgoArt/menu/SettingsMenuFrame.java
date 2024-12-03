package com.AlgoArt.menu;

import java.util.Scanner;

import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.UI.Menus;

public class SettingsMenuFrame {
    private static boolean closeSettings = false; //* Menu wants to be closed

    /**
     * Displays settings menu
     */
    public static void displaySettings() {
        closeSettings = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? input is not 'b'
        while (!closeSettings) {
            //* Draw Frame
            UI.standardWindow("Settings", Menus.back)
                .setWindowString(5, 2, "[ Height = "+Settings.getHeight()+" ]")
                .setWindowString(5, 3, "[ Width = "+Settings.getWidth()+" ]")
                //! Add new settings here
                .print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("b")) closeSettings = true;
            Inputs.checkStandardInputs(input);
        }
    }
}
