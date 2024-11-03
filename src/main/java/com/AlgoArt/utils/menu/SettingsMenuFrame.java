package com.AlgoArt.utils.menu;

import java.util.Scanner;

import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.lib.Frame;

public class SettingsMenuFrame {
    private static boolean closeSettings = false;

    public static void displaySettings() {
        closeSettings = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!closeSettings) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw frame
            Frame settingsMenu = new Frame(height, width, Frame.borderBuilder(1));
            settingsMenu.setWindowString(0, true, "[ Settings ]"); 
            settingsMenu.setWindowString(2, 3, "[ Height = "+height+" ]"); 
            settingsMenu.setWindowString(3, 3, "[ Width = "+width+" ]"); 
            //! Add new settings here
            // Bottom menu
            String options = "[ b - back ]";
            String setup = "[ c - Exit ]";
            settingsMenu.setWindowString(height-1, 3, options);
            settingsMenu.setWindowString(height-1, 3+options.length()+4, setup);
            settingsMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("b")) closeSettings = true;
            else if(input.equals("c")) System.exit(0);
        }
    }
}
