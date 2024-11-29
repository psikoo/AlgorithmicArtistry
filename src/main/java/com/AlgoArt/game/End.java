package com.AlgoArt.game;

import java.util.Scanner;

import com.AlgoArt.game.characters.player.Player;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;

public class End {
    
    public End(String ending) {
        if(ending.equalsIgnoreCase("good")) goodEnding();
        else if(ending.equalsIgnoreCase("bad")) badEnding();
        else if(ending.equalsIgnoreCase("true")) trueEnding();
        else if(ending.equalsIgnoreCase("neutral")) neutralEnding();
        else if(ending.equalsIgnoreCase("secret")) secretEnding();
    }

    public static String checkGoodOrNeutral() {
        if(!Player.player.getCompleteFractal() && !Player.player.getCompleteGeom() && !Player.player.getCompleteSpider()) return "good";
        else return "neutral";
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
        // TODO add credits
        System.exit(0);
    }
}
