package com.AlgoArt.game.battle;

import java.util.Scanner;

import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.menu.SettingsMenu;
import com.AlgoArt.setup.Setup;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.lib.Frame;

public class BattleFrame { // TODO update menu to new standard
    private static boolean battleBattleEnd = false;

    public static void battle(Enemy enemy) {
        battleBattleEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleBattleEnd) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame battle = new Frame(height, width, Frame.borderBuilder(1));
            battle.setWindowString(0, true, "[ "+enemy.getName()+" ]");
            battle.divider(6);
            battle.divider(height-8);
            updateUI(battle, enemy);
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            battle.setWindowString(height-1, 3, options);
            battle.setWindowString(height-1, 3+options.length()+4, setup);
            battle.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            battle.print();
            String input = scanner.nextLine();
            // Controls
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
            else battleBattleEnd = true;
        }
    }

    private static void updateUI(Frame battle, Enemy enemy) {
        battle.setWindowString(2, 3, enemy.getName());
        battle.setWindowString(3, 3, Integer.toString(enemy.getMaxHP()));
    }
}
