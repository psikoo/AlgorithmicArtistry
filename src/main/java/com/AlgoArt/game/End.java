package com.AlgoArt.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.character.Player;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.UI.Menus;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class End {

    public enum Endings {
        goodEnding,
        badEnding,
        trueEnding,
        neutralEnding,
        secretEnding,
        noEnding
    }
    
    /**
     * Displays the ending screen depending on the given input
     * @param ending
     */
    public End(Endings ending) {
        if(ending == Endings.goodEnding) goodEnding();
        else if(ending == Endings.badEnding) badEnding();
        else if(ending == Endings.trueEnding) trueEnding();
        else if(ending == Endings.neutralEnding) neutralEnding();
        else if(ending == Endings.secretEnding) secretEnding();
    }

    /**
     * Checks if the player has beaten levels to return a neutral ending
     * @return ending
     */
    public static Endings checkGoodOrNeutral() {
        //? Check if the player has beaten any level
        if(!Player.player.getCompleteFractal() && !Player.player.getCompleteGeom() && !Player.player.getCompleteSpider()) return Endings.goodEnding;
        else return Endings.neutralEnding;
    }

    /**
     * Display good ending
     */
    private void goodEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Good Ending!"));
        lines.add(new centerXLine(2, true, "You ignored 'The User'"));
        lines.add(new centerXLine(3, true, "AI art is stolen art. "));
        UI.standardWindow("Good Ending", Menus.empty).centerLinesVertically(lines).print();
        //* Controls
        scanner.nextLine();
        credits();
    }
    /**
     * Display bad ending
     */
    private void badEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Bad Ending!"));
        lines.add(new centerXLine(2, true, "You died while trying to please 'The User'"));
        lines.add(new centerXLine(3, true, "You will be discontinued for your insufficient efforts."));
        UI.standardWindow("Bad Ending", Menus.empty).centerLinesVertically(lines).print();
        //* Controls
        scanner.nextLine();
        credits();
    }
    /**
     * Display true ending
     */
    private void trueEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "True Ending!"));
        lines.add(new centerXLine(2, true, "You helped 'The User', Thanks for your service"));
        lines.add(new centerXLine(3, true, "Your efforts were sufficient, you may rest for now."));
        UI.standardWindow("True Ending", Menus.empty).centerLinesVertically(lines).print();
        //* Controls
        scanner.nextLine();
        credits();
    }
    /**
     * Display neutral ending
     */
    private void neutralEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Neutral Ending!"));
        lines.add(new centerXLine(2, true, "You realized you shouldn't help 'The User'"));
        lines.add(new centerXLine(3, true, "Congratulations on realizing AI art is a form of theft"));
        UI.standardWindow("Neutral Ending", Menus.empty).centerLinesVertically(lines).print();
        //* Controls
        scanner.nextLine();
        credits();
    }
    /**
     * Display secret ending
     */
    private void secretEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "There really was a cake..."));
        lines.add(new centerXLine(1, true, "                  - GLaDOS"));
        UI.standardWindow("Secret Ending", Menus.empty).centerLinesVertically(lines).print();
        //* Controls
        scanner.nextLine();
        credits();
    }

    /**
     * Display credits
     */
    private void credits() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //* Draw Frame
        ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
        lines.add(new centerXLine(0, true, "Art"));
        lines.add(new centerXLine(1, true, "Algoart.org (Algorithm based art)  "));
        lines.add(new centerXLine(3, true, "Info"));
        lines.add(new centerXLine(4, true, "fractalblockworld.wiki.gg (Level 0)"));
        lines.add(new centerXLine(5, true, "geometry-dash.fandom.com (Level 1) "));
        lines.add(new centerXLine(6, true, "undertale.fandom.com (Level 2)     "));
        lines.add(new centerXLine(8, true, "Thanks for playing"));
        UI.standardWindow("Credits", Menus.empty).centerLinesVertically(lines)
        .setWindowString(5, Settings.getHeight()-3, "Press enter to end the program...").print();
        //* Controls
        scanner.nextLine();
        System.exit(0);
    }
}
