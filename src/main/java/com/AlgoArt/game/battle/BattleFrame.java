package com.AlgoArt.game.battle;

import java.util.Scanner;

import com.AlgoArt.game.Game;
import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.game.characters.player.Player;
import com.AlgoArt.game.info.Image;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;

public class BattleFrame {
    private static Frame frame;
    private static Player player;
    private static Enemy enemy;
    private static int lines;
    private static int currentLine;
    private static boolean battleEndScreenEnd;

    public static void battle(Enemy enemyB) {
        player = Player.player;
        enemy = enemyB;
        lines = 0;
        currentLine = 0;
        frame = UI.standardWindow(enemy.getName())
            .divider(5)
            .setWindowString(Settings.getHeight()-13, 5, "Press enter to continue...")
            .divider(Settings.getHeight()-12)
            .print();
        updateUI();
        lines = Settings.getHeight()-6-13;
    }

    public static void addLine(String string) {
        if(currentLine == lines) {
            currentLine = 0;
            for(int i = 0; i < lines; i++) { frame.empty(i+6); }
        }
        frame.setWindowString(6+currentLine, 5, "> "+string);
        currentLine++;
        updateUI();
    }

    public static void updateUI() {
        frame.setWindowString(2, true, enemy.getName());
        frame.empty(3);
        frame.setWindowString(3, true, "HP "+enemy.getHP());
        frame.setWindowString(Settings.getHeight()-10, true, player.getName());
        frame.empty(Settings.getHeight()-9);
        frame.setWindowString(Settings.getHeight()-9, true, "HP "+player.getHP());
        frame.setWindowString(Settings.getHeight()-7, 5, "[ 0 ] "+player.getAttack0().getName()+" - "+player.getAttack0().getDescription());
        frame.setWindowString(Settings.getHeight()-6, 5, "[ 1 ] "+player.getAttack1().getName()+" - "+player.getAttack1().getDescription());
        frame.setWindowString(Settings.getHeight()-5, 5, "[ 2 ] "+player.getAttack2().getName()+" - "+player.getAttack2().getDescription());
        frame.setWindowString(Settings.getHeight()-4, 5, "[ 3 ] "+player.getAction0().getName()+" - "+player.getAction0().getDescription());
        frame.setWindowString(Settings.getHeight()-3, 5, "[ 4 ] "+player.getAction1().getName()+" - "+player.getAction1().getDescription());
        frame.print();
    }

    public static void playerLost() {
        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleEndScreenEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-2;
            UI.standardWindow("Defeat")
                .setWindowString(0+offset, true, "You were defeated by "+enemy.getName()+"!")
                .setWindowString(2+offset, true, "You feel the power slowly draining away from your components")
                .setWindowString(4+offset, true, "[ e ] Go to end screen                                      ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("e")) battleEndScreenEnd = true;
            Inputs.checkStandardInputs(input);
        }
        Game.setEnding("bad");
    }

    public static void enemyLost() {
        if(enemy.getName().equals("Overseer")) player.setCompleteFractal(true);
        else if(enemy.getName().equals("Demon Guardian")) player.setCompleteGeom(true);
        else if(enemy.getName().equals("Muffet")) player.setCompleteFractal(true);

        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleEndScreenEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-3;
            UI.standardWindow("Victory")
                .setWindowString(Settings.getHeight()-3, 5, "Press enter to continue...")
                .setWindowString(0+offset, true, "You were defeated by "+enemy.getName()+"!")
                .setWindowString(2+offset, true,       "Behind "+enemy.getName()+" you found a .png")
                .setWindowString(4+offset, true, "[ p ] Open .png                            ")
                .setWindowString(5+offset, true, "[ e ] Go to end screen                     ")
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("e")) battleEndScreenEnd = true;
            else if(input.equals("p")) new Image("reward", enemy.getReward());
            Inputs.checkStandardInputs(input);
        }
    }
}
