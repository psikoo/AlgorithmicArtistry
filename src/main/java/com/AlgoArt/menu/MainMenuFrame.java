package com.AlgoArt.menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.Game;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class MainMenuFrame {
    private static boolean menuValidAction = false;
    private static boolean splashValidKey = false;

    public static void splash() {
        splashValidKey = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!splashValidKey) {
            // Draw Frame
            // https://patorjk.com/software/taag/#p=display&f=Colossal&t=AlgoArt
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true,  "         d8888 888                         d8888         888    "));
            lines.add(new centerXLine(1, true,  "        d88888 888                        d88888         888    "));
            lines.add(new centerXLine(2, true,  "       d88P888 888                       d88P888         888    "));
            lines.add(new centerXLine(3, true,  "      d88P 888 888  .d88b.   .d88b.     d88P 888 888d888 888888 "));
            lines.add(new centerXLine(4, true,  "     d88P  888 888 d88P'88b d88''88b   d88P  888 888P'   888    "));
            lines.add(new centerXLine(5, true,  "    d88P   888 888 888  888 888  888  d88P   888 888     888    "));
            lines.add(new centerXLine(6, true,  "   d8888888888 888 Y88b 888 Y88..88P d8888888888 888     Y88b.  "));
            lines.add(new centerXLine(7, true,  "  d88P     888 888  'Y88888  'Y88P' d88P     888 888      'Y888 "));
            lines.add(new centerXLine(8, true,  "                        888                                     "));
            lines.add(new centerXLine(9, true,  "                   Y8b d88P                                     "));
            lines.add(new centerXLine(10, true, "                    'Y88P'                                      "));
            lines.add(new centerXLine(12, true, "  By Hugo Hernandez                                         v1.0"));
            lines.add(new centerXLine(13, true, "  Input a valid key and press enter to continue...              "));
            UI.standardWindow("AlgoArt").centerLinesVertically(lines).print();
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
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
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
