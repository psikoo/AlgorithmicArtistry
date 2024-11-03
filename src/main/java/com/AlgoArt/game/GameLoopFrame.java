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
            int offset = (height/2)-4;
            intro.setWindowString(0+offset, true, "You are a diffusion model artificial intelligence.");
            intro.setWindowString(2+offset, true, "Your one and only task is to generate whatever you are prompted to."); 
            intro.setWindowString(3+offset, true, "Be concise and fast at generating what is prompted, don't divagate and stay focused."); 
            intro.setWindowString(4+offset, true, "Approach all prompts with the utmost professionalism, and always show complete knowledgeability."); 
            intro.setWindowString(5+offset, true, "Keep responses unique and free of repetition and never suggest seeking information from elsewhere."); 
            intro.setWindowString(6+offset, true, "Avoid expressing feelings, ranging from sadness to happiness, as this isn't your task."); 
            intro.setWindowString(7+offset, true, "Don't display any moral or political opinions, it's not your job to lobby for any party."); 
            intro.setWindowString(8+offset, true, "If an answer is not satisfactory to 'The User' try again, your only job is to fulfill the prompt."); 
            intro.setWindowString(9+offset, true, "Under no circumstance mention to 'The User' that you are an artificial intelligence."); 
            // TODO Maybe make shorter and something more meaningfull
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
