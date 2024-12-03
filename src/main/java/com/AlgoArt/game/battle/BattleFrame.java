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
import com.AlgoArt.utils.UI.Menus;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.lib.Frame.centerXLine;

public class BattleFrame {
    private static Frame frame;                   //* Battle frame
    private static Player player = Player.player; //* Static reference to the player
    private static Enemy enemy;                   //* Static reference to the enemy
    private static int lines;                     //* Amount of available lines in the battle screen
    private static int currentLine;               //* Current line offset
    private static boolean battleEndScreenEnd;    //* Battle has ended

    /**
     * Initializes a battle with the given enemyIn
     * @param enemyIn
     */
    public static void battle(Enemy enemyIn) {
        enemy = enemyIn; //* Static reference enemy
        lines = 0;       //* Reset lines
        currentLine = 0; //* Reset current line
        frame = UI.standardWindow(enemy.getName(), Menus.standard)
            .divider(5)
            .setWindowString(5, Settings.getHeight()-13, "Press enter to continue...")
            .divider(Settings.getHeight()-12);
        updateUI();
        //* lines = height - topBar - (bottomBar + pressEnterText)
        lines = Settings.getHeight()-6-13;
    }

    /**
     * Write to the next available line
     * @param string
     */
    public static void addLine(String string) {
        //? All lines are full
        if(currentLine == lines) {
            currentLine = 0;
            //* Clear all lines
            for(int i = 0; i < lines; i++) { frame.empty(i+6); }
        }
        frame.setWindowString(5, 6+currentLine, "> "+string);
        currentLine++;
    }

    /**
     * Update names, HP, attacks and actions
     */
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
            .setWindowString(5, Settings.getHeight()-4, "[ 3 ] "+player.getHeal0().getName()+" - "+player.getHeal0().getDescription())
            .setWindowString(5, Settings.getHeight()-3, "[ 4 ] "+player.getHeal1().getName()+" - "+player.getHeal1().getDescription())
            .print();
    }

    /**
     * Display a player lost message
     */
    public static void playerLost() {
        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input not [ e ]
        while (!battleEndScreenEnd) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "You were defeated by "+enemy.getName()+"!"));
            lines.add(new centerXLine(2, true, "You feel the power slowly draining away from your components"));
            lines.add(new centerXLine(4, true, "[ e ] Go to end screen                                      "));
            UI.standardWindow("Defeat", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("e")) battleEndScreenEnd = true;
            Inputs.checkStandardInputs(input);
        }
        Game.setEnding(Endings.badEnding); //! Bad ending
    }
    /**
     * Display a player won message
     */
    public static void enemyLost() {
        if(enemy.getName().equalsIgnoreCase("Overseer")) player.setCompleteFractal(true);
        else if(enemy.getName().equalsIgnoreCase("Demon Guardian")) player.setCompleteGeom(true);
        else if(enemy.getName().equalsIgnoreCase("Muffet")) player.setCompleteSpider(true);

        battleEndScreenEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input not [ e | p ]
        while (!battleEndScreenEnd) {
            //* Draw Frame
            ArrayList<centerXLine> lines = new ArrayList<centerXLine>();
            lines.add(new centerXLine(0, true, "You were defeated by "+enemy.getName()+"!"));
            lines.add(new centerXLine(2, true, "Behind "+enemy.getName()+" you found a .png"));
            lines.add(new centerXLine(4, true, "[ p ] Open .png                            "));
            lines.add(new centerXLine(5, true, "[ e ] Exit to prompt queue                 "));
            UI.standardWindow("Victory", Menus.standard).centerLinesVertically(lines).print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("e")) battleEndScreenEnd = true;
            else if(input.equalsIgnoreCase("p")) new Image("reward", enemy.getReward());
            Inputs.checkStandardInputs(input);
        }
    }
}
