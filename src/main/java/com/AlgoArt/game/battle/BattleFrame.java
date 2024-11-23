package com.AlgoArt.game.battle;

import java.util.Scanner;

import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;

public class BattleFrame {
    private static boolean battleBattleEnd = false;

    public static void battle(Enemy enemy) {
        battleBattleEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!battleBattleEnd) {
            // Draw Frame
            Frame frame = UI.standardWindow(enemy.getName())
                .divider(6)
                .divider(Settings.getHeight()-8)
                .print();
            updateUI(frame, enemy);
            // Controls
            String input = scanner.nextLine();
            Inputs.checkStandardInputs(input);
            battleBattleEnd = true;
        }
    }

    private static void updateUI(Frame frame, Enemy enemy) {
        frame.setWindowString(2, 3, enemy.getName());
        frame.setWindowString(3, 3, Integer.toString(enemy.getMaxHP()));
        frame.print();
    }
}
