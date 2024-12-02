package com.AlgoArt.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.Game;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class MainMenuFrame {
    private static boolean menuValidAction = false;
    private static boolean splashValidKey = false;

    public static void splash() {
        splashValidKey = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!splashValidKey) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame mainMenu = new Frame(height, width, Frame.borderBuilder(1));
            // https://patorjk.com/software/taag/#p=display&f=Colossal&t=AlgoArt
            int offset = (height/2)-7;
            mainMenu.setWindowString(0+offset, true,  "         d8888 888                         d8888         888    ");
            mainMenu.setWindowString(1+offset, true,  "        d88888 888                        d88888         888    ");
            mainMenu.setWindowString(2+offset, true,  "       d88P888 888                       d88P888         888    ");
            mainMenu.setWindowString(3+offset, true,  "      d88P 888 888  .d88b.   .d88b.     d88P 888 888d888 888888 ");
            mainMenu.setWindowString(4+offset, true,  "     d88P  888 888 d88P'88b d88''88b   d88P  888 888P'   888    ");
            mainMenu.setWindowString(5+offset, true,  "    d88P   888 888 888  888 888  888  d88P   888 888     888    ");
            mainMenu.setWindowString(6+offset, true,  "   d8888888888 888 Y88b 888 Y88..88P d8888888888 888     Y88b.  ");
            mainMenu.setWindowString(7+offset, true,  "  d88P     888 888  'Y88888  'Y88P' d88P     888 888      'Y888 ");
            mainMenu.setWindowString(8+offset, true,  "                        888                                     ");
            mainMenu.setWindowString(9+offset, true,  "                   Y8b d88P                                     ");
            mainMenu.setWindowString(10+offset, true, "                    'Y88P'                                      ");
            mainMenu.setWindowString(12+offset, true, "  By Hugo Hernandez                                         v1.0");
            mainMenu.setWindowString(13+offset, true, "  Input a valid key and press enter to continue...              ").print();
            // Controls
            String input = scanner.nextLine();
            boolean valid = input.equals("jugones") || input.equals("0") || input.equals("a");
            if(valid) splashValidKey = true;
        }
    }

    public static void mainMenu() {
        menuValidAction = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!menuValidAction) {
            // Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>(); // TODO set all to new standard
            lines.add(new centerXLine(0, true, "Welcome to AlgoArt select one of the options below"));
            lines.add(new centerXLine(2, true, "[ 0 ] Start new game                              "));
            UI.standardWindow("AlgoArt").centerLinesVertically(lines).print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("0")) new Game();
            Inputs.checkStandardInputs(input);
        }
    }
}
