package com.AlgoArt.game.story;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.battle.Battle;
import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.UI.Menus;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class StoryFrame {
    private static boolean fractalEnd = false; //* Has level 0 been beaten
    private static boolean geomEnd = false;    //* Has level 1 been beaten
    private static boolean spiderEnd = false;  //* Has level 2 been beaten

    /**
     * Display pre-battle lore
     */
    public static void fractal() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Prompt: My friend K is trapped in a fractal world. He told me the only way   "));
        lines.add(new centerXLine(1, true, "        to free him is to find a Key to the Universe, it is not a traditional"));
        lines.add(new centerXLine(2, true, "        key but a piece of art.                                              "));
        lines.add(new centerXLine(4, true, "- PROCESSING PROMPT -"));
        lines.add(new centerXLine(6, true, "        > 'The User' is requesting FractalKey.png aka Key to the Universe.   "));
        lines.add(new centerXLine(7, true, "        > FractalKey.png is warded by the Overseer in the 'Ying World'.      "));
        lines.add(new centerXLine(9, true, "You will be transported to 'Ying World' in a few seconds"));
        UI.standardWindow("Fractal Block World", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        fractal2();
    }
    /**
     * Display battle options
     * [ f ] Fight
     * [ i ] Information
     * [ b ] Leave
     */
    private static void fractal2() {
        fractalEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input is not [ f | i | b ]
        while (!fractalEnd) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "Welcome to the 'Ying World'!"));
            lines.add(new centerXLine(2, true, "You will need to fight the Overseer in order to obtain FractalKey.png"));
            lines.add(new centerXLine(4, true, "[ f ] Fight the Overseer                                             "));
            lines.add(new centerXLine(5, true, "[ i ] Information about the Overseer                                 "));
            lines.add(new centerXLine(6, true, "[ b ] Leave the 'Ying World'                                         "));
            UI.standardWindow("Fractal Block World", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("f")) { new Battle(Enemy.enemyBuilder("overseer")); fractalEnd = true; }
            if(input.equalsIgnoreCase("i")) new Info(Enemy.enemyBuilder("overseer"));
            if(input.equalsIgnoreCase("b")) fractalEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }

    /**
     * Display pre-battle lore
     */
    public static void geom() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Prompt: I cannot stay here any longer, you must find a way to release me.    "));
        lines.add(new centerXLine(1, true, "        All I want is to see the sky, i can barely remember how it looks     "));
        lines.add(new centerXLine(3, true, "- PROCESSING PROMPT -"));
        lines.add(new centerXLine(5, true, "        > 'The User' is requesting GeometricSky.png                          "));
        lines.add(new centerXLine(6, true, "        > GeometricSky.png is guarded by the Demon Guardian in 'The Basement'"));
        lines.add(new centerXLine(8, true, "You will be transported to 'The Basement' in a few seconds"));
        UI.standardWindow("Geometrical Dominator", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        geom2();
    }
    /**
     * Display battle options
     * [ f ] Fight
     * [ i ] Information
     * [ b ] Leave
     */
    private static void geom2() {
        geomEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input is not [ f | i | b ]
        while (!geomEnd) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "Welcome to 'The Basement'!"));
            lines.add(new centerXLine(2, true, "You will need to fight the Demon Guardian in order to obtain GeometricSky.png"));
            lines.add(new centerXLine(4, true, "[ f ] Fight the Demon Guardian                                               "));
            lines.add(new centerXLine(5, true, "[ i ] Information about the Demon Guardian                                   "));
            lines.add(new centerXLine(6, true, "[ b ] Leave 'The Basement'                                                   "));
            UI.standardWindow("Geometrical Dominator", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("f")) { new Battle(Enemy.enemyBuilder("demonGuardian")); geomEnd = true; }
            if(input.equalsIgnoreCase("i")) new Info(Enemy.enemyBuilder("demonGuardian"));
            if(input.equalsIgnoreCase("b")) geomEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }

    /**
     * Display pre-battle lore
     */
    public static void spider() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Prompt: I need help opening a new bakery, Ive heard Muffet's pastries are the  "));
        lines.add(new centerXLine(1, true, "        best pastries in all the underground. I need to find what her secret is"));
        lines.add(new centerXLine(3, true, "- PROCESSING PROMPT -"));
        lines.add(new centerXLine(5, true, "        > 'The User' is requesting SpiderWebs.png                              "));
        lines.add(new centerXLine(6, true, "        > SpiderWebs.png can be located in the 'The Underground'               "));
        lines.add(new centerXLine(8, true, "You will be transported to 'The Underground' in a few seconds"));
        UI.standardWindow("Spider Dance", Menus.standard).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to continue...").print();
        //* Controls
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
        spider2();
    }
    /**
     * Display battle options
     * [ f ] Fight
     * [ i ] Information
     * [ b ] Leave
     */
    private static void spider2() {
        spiderEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input is not [ f | i | b ]
        while (!spiderEnd) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "Welcome to the 'The Underground'"));
            lines.add(new centerXLine(2, true, "You will need to fight Muffet in order to obtain SpiderWebs.png"));
            lines.add(new centerXLine(4, true, "[ f ] Fight Muffet                                             "));
            lines.add(new centerXLine(5, true, "[ i ] Information about Muffet                                 "));
            lines.add(new centerXLine(6, true, "[ b ] Leave the 'The Underground'                              "));
            UI.standardWindow("Spider Dance", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("f")) { new Battle(Enemy.enemyBuilder("muffet")); spiderEnd = true; }
            if(input.equalsIgnoreCase("i")) new Info(Enemy.enemyBuilder("muffet"));
            if(input.equalsIgnoreCase("b")) spiderEnd = true;
            Inputs.checkStandardInputs(input);
        }
    }
}
