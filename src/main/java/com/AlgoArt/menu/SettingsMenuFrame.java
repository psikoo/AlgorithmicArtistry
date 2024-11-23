package com.AlgoArt.menu;

import java.util.Scanner;

import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;

public class SettingsMenuFrame {
    private static boolean closeSettings = false;

    public static void displaySettings() {
        closeSettings = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!closeSettings) {
            // Draw Frame
            UI.standardWindow("Settings", "back")
                .setWindowString(2, 5, "[ Height = "+Settings.getHeight()+" ]")
                .setWindowString(3, 5, "[ Width = "+Settings.getWidth()+" ]")
                //! Add new settings here
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("b")) closeSettings = true;
            Inputs.checkStandardInputs(input);
        }
    }
}
