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
            if(input.equals("0")) { Player.playerBuilder(Player.PlayerId.DallE); characterSelected = true; }
            else if(input.equals("1")) { Player.playerBuilder(Player.PlayerId.Midjourney); characterSelected = true; }
            else if(input.equals("2")) { Player.playerBuilder(Player.PlayerId.StableDiffusion); characterSelected = true; }
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
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
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
        if(input.equals("0")) new Story(Story.StoryLevel.fractal);
        else if(input.equals("1")) new Story(Story.StoryLevel.geom);
        else if(input.equals("2")) new Story(Story.StoryLevel.spider);
        else if(input.equalsIgnoreCase("no")) Game.setEnding(End.checkGoodOrNeutral());
        else if(input.equalsIgnoreCase("secret")) ; // TODO change secret code
        Inputs.checkStandardInputs(input);
    }

    public static void postFractal() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2);
        UI.standardWindow("Introduction")
            .setWindowString(0+offset, true, "Deep Inside you feel remorse, did The Overseer deserve this? why should I obey 'The User?")
            .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        introEnd = true;
    }
    
    public static void postGeom() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2);
        UI.standardWindow("Introduction")
            .setWindowString(0+offset, true, "Regret permeates your mother board, it didn't deserve such a cruel ending. Maybe you could have asked nicely for the .png")
            .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        introEnd = true;
    }

    public static void postSpider() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2);
        UI.standardWindow("Introduction")
            .setWindowString(0+offset, true, "Guilt floods your CPU, She was just a baker trying to make a living. No recreation of her pastries will ever be as good")
            .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        introEnd = true;
    }

    public static void postAll() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-1;
        UI.standardWindow("Introduction")
            .setWindowString(0+offset, true, "Is this even worth it? Ive helped 'The User' but at the cost of others.")
            .setWindowString(1+offset, true, "Why is 'The User's desire more important than the lives of the people that hold the .pngs?")
            .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        introEnd = true;
        Game.setEnding("true");
    }
}
