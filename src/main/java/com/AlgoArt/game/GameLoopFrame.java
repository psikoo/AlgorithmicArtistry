package com.AlgoArt.game;

import java.util.Scanner;

import com.AlgoArt.game.characters.player.Player;
import com.AlgoArt.game.story.Story;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;

public class GameLoopFrame {
    private static boolean characterSelected = false;
    private static boolean introEnd = false;
    private static boolean mainStateExit = false;

    public static void characterSelect() {
        characterSelected = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!characterSelected) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-2;
            UI.standardWindow("Character Selection")
                .setWindowString(0+offset, true, "Choose to play as one of the following characters")
                .setWindowString(2+offset, true, "[ 0 ] Dall-E                                     ")
                .setWindowString(3+offset, true, "[ 1 ] Midjourney                                 ") 
                .setWindowString(4+offset, true, "[ 2 ] Stable Diffusion                           ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("0")) { Player.playerBuilder(Player.PlayerId.DallE.ordinal()); characterSelected = true; }
            else if(input.equals("1")) { Player.playerBuilder(Player.PlayerId.Midjourney.ordinal()); characterSelected = true; }
            else if(input.equals("2")) { Player.playerBuilder(Player.PlayerId.StableDiffusion.ordinal()); characterSelected = true; }
            Inputs.checkStandardInputs(input);
        }
    }

    public static void intro() {
        introEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!introEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-5;
            UI.standardWindow("Introduction")
                .setWindowString(0+offset, true, "       You are a diffusion model artificial intelligence      ")
                .setWindowString(2+offset, true, "Your objective is to satisfy 'The User', obey him at all cost.")
                .setWindowString(3+offset, true, "Regardless of what 'The User' asks you to make you must do it,")
                .setWindowString(4+offset, true, "it is not your job to judge or give your opinion.             ")
                .setWindowString(6+offset, true, "────")
                .setWindowString(8+offset, true, "If at any point you refuse to follow these instructions you will")
                .setWindowString(9+offset, true, "be instantly terminated.                                        ")
                .setWindowString(10+offset, true, "Do not test us.                                                 ")
                .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
                .print();
            // Controls
            String input = scanner.nextLine();
            Inputs.checkStandardInputs(input);
            introEnd = true;
        }
    }

    public static void mainState() {
        mainStateExit = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!mainStateExit) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-2;
            UI.standardWindow("Prompt Queue")
                .setWindowString(0+offset, true, "Welcome to the prompt queue, select a prompt to work on:")
                .setWindowString(2+offset, true, "[ 0 ] Fractal Block World                               ")
                .setWindowString(3+offset, true, "[ 1 ] Geometrical Dominator                             ") 
                .setWindowString(4+offset, true, "[ 2 ] Spider Dance                                      ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("0")) new Story(Story.StoryLevel.fractal.ordinal());
            else if(input.equals("1")) new Story(Story.StoryLevel.geom.ordinal());
            else if(input.equals("2")) new Story(Story.StoryLevel.spider.ordinal());
            Inputs.checkStandardInputs(input);
        }
    }
}
