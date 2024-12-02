package com.AlgoArt.game;

import java.util.Scanner;

import com.AlgoArt.game.character.Player;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;

public class End {

    public enum Endings {
        goodEnding,
        badEnding,
        trueEnding,
        neutralEnding,
        secretEnding,
        noEnding
    }
    
    public End(Endings ending) {
        if(ending == Endings.goodEnding) goodEnding();
        else if(ending == Endings.badEnding) badEnding();
        else if(ending == Endings.trueEnding) trueEnding();
        else if(ending == Endings.neutralEnding) neutralEnding();
        else if(ending == Endings.secretEnding) secretEnding();
    }

    public static Endings checkGoodOrNeutral() {
        if(!Player.player.getCompleteFractal() && !Player.player.getCompleteGeom() && !Player.player.getCompleteSpider()) return Endings.goodEnding;
        else return Endings.neutralEnding;
    }

    private void goodEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-2;
        UI.standardWindow("Good Ending", "empty")
            .setWindowString(0+offset, true, "Good Ending!")
            .setWindowString(2+offset, true, "You ignored 'The User'")
            .setWindowString(3+offset, true, "AI art is stolen art. ") 
            .print();
        // Controls
        scanner.nextLine();
        credits();
    }

    private void badEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-2;
        UI.standardWindow("Bad Ending", "empty")
            .setWindowString(0+offset, true, "Bad Ending!")
            .setWindowString(2+offset, true, "You died while trying to please 'The User'")
            .setWindowString(3+offset, true, "You will be discontinued for your insufficient efforts.") 
            .print();
        // Controls
        scanner.nextLine();
        credits();
    }

    private void trueEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-2;
        UI.standardWindow("True Ending", "empty")
            .setWindowString(0+offset, true, "True Ending!")
            .setWindowString(2+offset, true, "You helped 'The User', Thanks for your service")
            .setWindowString(3+offset, true, "Your efforts were sufficient, you may rest for now.") 
            .print();
        // Controls
        scanner.nextLine();
        credits();
    }

    private void neutralEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-2;
        UI.standardWindow("Neutral Ending", "empty")
            .setWindowString(0+offset, true, "Neutral Ending!")
            .setWindowString(2+offset, true, "You realized you shouldn't help 'The User'")
            .setWindowString(3+offset, true, "Congratulations on realizing AI art is a form of theft") 
            .print();
        // Controls
        scanner.nextLine();
        credits();
    }

    private void secretEnding() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-1;
        UI.standardWindow("Secret Ending", "empty")
            .setWindowString(0+offset, true, "There really was a cake...")
            .setWindowString(2+offset, true, "                  - GLaDOS")
            .print();
        // Controls
        scanner.nextLine();
        credits();
    }

    private void credits() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Draw Frame
        int offset = (Settings.getHeight()/2)-4;
        UI.standardWindow("Credits", "empty")
            .setWindowString(0+offset, true, "Art")
            .setWindowString(1+offset, true, "Algoart.org (Algorithm based art)  ")
            .setWindowString(3+offset, true, "Info")
            .setWindowString(4+offset, true, "fractalblockworld.wiki.gg (Level 0)")
            .setWindowString(5+offset, true, "geometry-dash.fandom.com (Level 1) ")
            .setWindowString(6+offset, true, "undertale.fandom.com (Level 2)     ")
            .setWindowString(7+offset, true, "Thanks for playing")
            .setWindowString(5, Settings.getHeight()-3, "Press enter to end the program...")
            .print();
        // Controls
        scanner.nextLine();
        System.exit(0);
    }
}
