package com.AlgoArt.game;

import java.util.Scanner;

import com.AlgoArt.game.player.Player;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.menu.SettingsMenu;
import com.AlgoArt.utils.setup.Setup;

public class GameLoopFrame {
    private static boolean characterSelected = false;
    private static boolean introEnd = false;

    public static void characterSelect() {
        characterSelected = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!characterSelected) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame characterMenu = new Frame(height, width, Frame.borderBuilder(1));
            characterMenu.setWindowString(0, true, "[ Character Selection ]"); 
            int offset = (height/2)-2;
            characterMenu.setWindowString(0+offset, true, "Choose to play as one of the following characters"); 
            characterMenu.setWindowString(2+offset, true, "[ 0 ] Dall-E          "); 
            characterMenu.setWindowString(3+offset, true, "[ 1 ] Midjourney      "); //* Keep same length
            characterMenu.setWindowString(4+offset, true, "[ 2 ] Stable Diffusion"); 
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            characterMenu.setWindowString(height-1, 3, options);
            characterMenu.setWindowString(height-1, 3+options.length()+4, setup);
            characterMenu.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            characterMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
            else if(input.equals("0")) { new Player(0); characterSelected = true; }
            else if(input.equals("1")) { new Player(1); characterSelected = true; }
            else if(input.equals("0")) { new Player(2); characterSelected = true; }
        }
    }

    public static void intro() {
        introEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!introEnd) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame intro = new Frame(height, width, Frame.borderBuilder(1));
            intro.setWindowString(0, true, "[ Introduction ]"); 
            int offset = (height/2)-5;
            intro.setWindowString(0+offset, true, "       You are a diffusion model artificial intelligence      ");
            intro.setWindowString(2+offset, true, "Your objective is to satisfy 'The User', obey him at all cost.");
            intro.setWindowString(3+offset, true, "Regardless of what 'The User' asks you to make you must do it,");
            intro.setWindowString(4+offset, true, "it is not your job to judge or give your opinion.             ");
            intro.setWindowString(6+offset, true, "---"); // TODO change for ascii divisor
            intro.setWindowString(8+offset, true, "If at any point you refuse to follow this instructions you will");
            intro.setWindowString(9+offset, true, "be instantly terminated,                                       ");
            intro.setWindowString(10+offset, true, "Do not test us.                                                ");
            // TODO see if it looks good :3
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            intro.setWindowString(height-1, 3, options);
            intro.setWindowString(height-1, 3+options.length()+4, setup);
            intro.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            intro.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
        }
    }
}
