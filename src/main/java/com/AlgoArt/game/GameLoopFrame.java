package com.AlgoArt.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.End.Endings;
import com.AlgoArt.game.character.Player;
import com.AlgoArt.game.story.Story;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.UI.Menus;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class GameLoopFrame {
    private static boolean characterSelected = false; //* Valid character has been selected

    /**
     * Display character selection
     * [ 0 ] Dall-E
     * [ 1 ] Midjourney
     * [ 2 ] Stable Diffusion
     */
    public static void characterSelect() {
        characterSelected = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input is not [ 0 | 1 | 2]
        while (!characterSelected) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "Choose to play as one of the following characters"));
            lines.add(new centerXLine(2, true, "[ 0 ] Dall-E                                     "));
            lines.add(new centerXLine(3, true, "[ 1 ] Midjourney                                 "));
            lines.add(new centerXLine(4, true, "[ 2 ] Stable Diffusion                           "));
            UI.standardWindow("Character Selection", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("0")) { Player.playerBuilder(Player.PlayerId.DallE); characterSelected = true; }
            else if(input.equalsIgnoreCase("1")) { Player.playerBuilder(Player.PlayerId.Midjourney); characterSelected = true; }
            else if(input.equalsIgnoreCase("2")) { Player.playerBuilder(Player.PlayerId.StableDiffusion); characterSelected = true; }
            Inputs.checkStandardInputs(input);
        }
    }

    /**
     * Display introductory lore
     */
    public static void intro() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "       You are a diffusion model artificial intelligence      "));
        lines.add(new centerXLine(2, true, "Your objective is to satisfy 'The User', obey him at all cost."));
        lines.add(new centerXLine(3, true, "Regardless of what 'The User' asks you to make you must do it,"));
        lines.add(new centerXLine(4, true, "it is not your job to judge or give your opinion.             "));
        lines.add(new centerXLine(6, true, "────"));
        lines.add(new centerXLine(8, true, "If at any point you refuse to follow these instructions you will"));
        lines.add(new centerXLine(9, true, "be instantly terminated.                                        "));
        lines.add(new centerXLine(10, true, "Do not test us.                                                 "));
        UI.standardWindow("Introduction", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }

    /**
     * Displays level selection screen
     * [ 0 ] Fractal Block World
     * [ 1 ] Geometrical Dominator
     * [ 2 ] Spider Dance
     * [ no ] Good/Neutral ending
     * [ secret ] Secret ending
     */
    public static void mainState() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Welcome to the prompt queue, select a prompt to work on:"));
        lines.add(new centerXLine(2, true, "[ 0 ] Fractal Block World                               "));
        lines.add(new centerXLine(3, true, "[ 1 ] Geometrical Dominator                             "));
        lines.add(new centerXLine(4, true, "[ 2 ] Spider Dance                                      "));
        UI.standardWindow("Prompt Queue", Menus.standard).centerLinesVertically(lines).print();
        //* Controls
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("0")) new Story(Story.StoryLevel.fractal);
        else if(input.equalsIgnoreCase("1")) new Story(Story.StoryLevel.geom);
        else if(input.equalsIgnoreCase("2")) new Story(Story.StoryLevel.spider);
        else if(input.equalsIgnoreCase("no")) Game.setEnding(End.checkGoodOrNeutral()); //! Good/Neutral ending
        else if(input.equalsIgnoreCase("cake")) Game.setEnding(Endings.secretEnding); //! Secret ending
        Inputs.checkStandardInputs(input);
    }

    /**
     * Display lore after level 0 battle
     */
    public static void postFractal() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Deep Inside you feel remorse, did The Overseer deserve this? why should I obey 'The User?"));
        UI.standardWindow("Introduction", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    /**
     * Display lore after level 1 battle
     */
    public static void postGeom() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Regret permeates your mother board, it didn't deserve such a cruel ending. Maybe you could have asked nicely for the .png"));
        lines.add(new centerXLine(1, true, "Maybe I should just say 'no' and stop this."));
        UI.standardWindow("Introduction", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    /**
     * Display lore after level 2 battle
     */
    public static void postSpider() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Guilt floods your CPU, She was just a baker trying to make a living. No recreation of her pastries will ever be as good"));
        UI.standardWindow("Introduction", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    /**
     * Display lore after beating first 3 levels
     */
    public static void postAll() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Is this even worth it? Ive helped 'The User' but at the cost of others."));
        lines.add(new centerXLine(1, true, "Why is 'The User's desire more important than the lives of the people that hold the .pngs?"));
        UI.standardWindow("Introduction", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        Game.setEnding(Endings.trueEnding); //! True ending
    }
}
