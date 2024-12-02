package com.AlgoArt.game.battle;

import java.util.ArrayList;
import java.util.Scanner;

import com.AlgoArt.game.End.Endings;
import com.AlgoArt.game.Game;
import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.game.character.Player;
import com.AlgoArt.utils.Image;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.lib.Frame.centerXLine;

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
            .setWindowString(5, Settings.getHeight()-13, "Press enter to continue...")
            .divider(Settings.getHeight()-12);
        updateUI();
        lines = Settings.getHeight()-6-13;
    }

    public static void addLine(String string) {
        if(currentLine == lines) {
            currentLine = 0;
            for(int i = 0; i < lines; i++) { frame.empty(i+6); }
        }
        frame.setWindowString(5, 6+currentLine, "> "+string);
        currentLine++;
    }

    public static void updateUI() {
        frame.setWindowString(2, true, enemy.getName())
            .empty(3)
            .setWindowString(3, true, "HP "+enemy.getHP())
            .setWindowString(Settings.getHeight()-10, true, player.getName())
            .empty(Settings.getHeight()-9)
            .setWindowString(Settings.getHeight()-9, true, "HP "+player.getHP())
            .setWindowString(5, Settings.getHeight()-7, "[ 0 ] "+player.getAttack0().getName()+" - "+player.getAttack0().getDescription())
            .setWindowString(5, Settings.getHeight()-6, "[ 1 ] "+player.getAttack1().getName()+" - "+player.getAttack1().getDescription())
            .setWindowString(5, Settings.getHeight()-5, "[ 2 ] "+player.getAttack2().getName()+" - "+player.getAttack2().getDescription())
            .setWindowString(5, Settings.getHeight()-4, "[ 3 ] "+player.getAction0().getName()+" - "+player.getAction0().getDescription())
            .setWindowString(5, Settings.getHeight()-3, "[ 4 ] "+player.getAction1().getName()+" - "+player.getAction1().getDescription())
            .print();
    }

    public static void playerLost() {
        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleEndScreenEnd) {
            // Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "You were defeated by "+enemy.getName()+"!"));
            lines.add(new centerXLine(2, true, "You feel the power slowly draining away from your components"));
            lines.add(new centerXLine(4, true, "[ e ] Go to end screen                                      "));
            UI.standardWindow("Defeat").centerLinesVertically(lines).print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("e")) battleEndScreenEnd = true;
            Inputs.checkStandardInputs(input);
        }
        Game.setEnding(Endings.badEnding);
    }

    public static void enemyLost() {
        if(enemy.getName().equals("Overseer")) player.setCompleteFractal(true);
        else if(enemy.getName().equals("Demon Guardian")) player.setCompleteGeom(true);
        else if(enemy.getName().equals("Muffet")) player.setCompleteSpider(true);

        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleEndScreenEnd) {
            // Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "You were defeated by "+enemy.getName()+"!"));
            lines.add(new centerXLine(2, true, "Behind "+enemy.getName()+" you found a .png"));
            lines.add(new centerXLine(4, true, "[ p ] Open .png                            "));
            lines.add(new centerXLine(5, true, "[ e ] Exit to prompt queue                 "));
            UI.standardWindow("Victory").centerLinesVertically(lines).print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("e")) battleEndScreenEnd = true;
            else if(input.equals("p")) new Image("reward", enemy.getReward());
            Inputs.checkStandardInputs(input);
        }
    }
}
