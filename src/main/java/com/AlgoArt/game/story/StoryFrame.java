package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.game.battle.Battle;
import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;

public class StoryFrame {
    private static boolean fractalEnd = false;
    private static boolean geomEnd = false;
    private static boolean spiderEnd = false;

    public static void fractal() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-5;
        UI.standardWindow("Fractal Block World")
            .setWindowString(0+offset, true, "Prompt: My friend K is trapped in a fractal world. He told me the only way   ")
            .setWindowString(1+offset, true, "        to free him is to find a Key to the Universe, it is not a traditional")
            .setWindowString(2+offset, true, "        key but a piece of art.                                              ")
            .setWindowString(4+offset, true, "- PROCESSING PROMPT -")
            .setWindowString(6+offset, true, "        > 'The User' is requesting FractalKey.png aka Key to the Universe.   ")
            .setWindowString(7+offset, true, "        > FractalKey.png is warded by the Overseer in the 'Ying World'.      ")
            .setWindowString(9+offset, true, "You will be transported to 'Ying World' in a few seconds")
            .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        fractal2();
    }
    private static void fractal2() {
        fractalEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!fractalEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-3;
            UI.standardWindow("Fractal Block World")
                .setWindowString(0+offset, true, "Welcome to the 'Ying World'!")
                .setWindowString(2+offset, true, "You will need to fight the Overseer in order to obtain FractalKey.png")
                .setWindowString(4+offset, true, "[ f ] Fight the Overseer                                             ")
                .setWindowString(5+offset, true, "[ i ] Information about the Overseer                                 ")
                .setWindowString(6+offset, true, "[ b ] Leave the 'Ying World'                                         ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("f")) { new Battle(Enemy.enemyBuilder("overseer")); fractalEnd = true; }
            if(input.equals("i")) new Info(Enemy.enemyBuilder("overseer"));
            if(input.equals("b")) fractalEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }

    public static void geom() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-4;
        UI.standardWindow("Geometrical Dominator")
            .setWindowString(0+offset, true, "Prompt: I cannot stay here any longer, you must find a way to release me.    ")
            .setWindowString(1+offset, true, "        All I want is to see the sky, i can barely remember how it looks     ")
            .setWindowString(3+offset, true, "- PROCESSING PROMPT -")
            .setWindowString(5+offset, true, "        > 'The User' is requesting GeometricSky.png                          ")
            .setWindowString(6+offset, true, "        > GeometricSky.png is guarded by the Demon Guardian in 'The Basement'")
            .setWindowString(8+offset, true, "You will be transported to 'The Basement' in a few seconds")
            .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        geom2();
    }
    private static void geom2() {
        geomEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!geomEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-3;
            UI.standardWindow("Geometrical Dominator")
                .setWindowString(0+offset, true, "Welcome to 'The Basement'!")
                .setWindowString(2+offset, true, "You will need to fight the Demon Guardian in order to obtain GeometricSky.png")
                .setWindowString(4+offset, true, "[ f ] Fight the Demon Guardian                                               ")
                .setWindowString(5+offset, true, "[ i ] Information about the Demon Guardian                                   ")
                .setWindowString(6+offset, true, "[ b ] Leave 'The Basement'                                                   ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("f")) { new Battle(Enemy.enemyBuilder("demonGuardian")); geomEnd = true; }
            if(input.equals("i")) new Info(Enemy.enemyBuilder("demonGuardian"));
            if(input.equals("b")) geomEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }

    public static void spider() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-4;
        UI.standardWindow("Spider Dance")
            .setWindowString(0+offset, true, "Prompt: I need help opening a new bakery, Ive heard Muffet's pastries are the  ")
            .setWindowString(1+offset, true, "        best pastries in all the underground. I need to find what her secret is")
            .setWindowString(3+offset, true, "- PROCESSING PROMPT -")
            .setWindowString(5+offset, true, "        > 'The User' is requesting SpiderWebs.png                              ")
            .setWindowString(6+offset, true, "        > SpiderWebs.png can be located in the 'The Underground'               ")
            .setWindowString(8+offset, true, "You will be transported to 'The Underground' in a few seconds")
            .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...")
            .print();
        // Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        spider2();
    }
    private static void spider2() {
        spiderEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!spiderEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-3;
            UI.standardWindow("Spider Dance")
                .setWindowString(0+offset, true, "Welcome to the 'The Underground'")
                .setWindowString(2+offset, true, "You will need to fight Muffet in order to obtain SpiderWebs.png")
                .setWindowString(4+offset, true, "[ f ] Fight Muffet                                             ")
                .setWindowString(5+offset, true, "[ i ] Information about Muffet                                 ")
                .setWindowString(6+offset, true, "[ b ] Leave the 'The Underground'                              ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("f")) { new Battle(Enemy.enemyBuilder("muffet")); spiderEnd = true; }
            if(input.equals("i")) new Info(Enemy.enemyBuilder("muffet"));
            if(input.equals("b")) spiderEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }
}
