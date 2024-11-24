package com.AlgoArt.game.battle;

import java.util.Random;
import java.util.Scanner;

import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.utils.Inputs;

public class Battle {
    private static int turn = 0;
    private static boolean battleEnd = false;

    public Battle(Enemy enemy) {
        BattleFrame.battle(enemy); // Returns the amount of lines available for the combat log
        Random random = new Random();
        turn += random.nextInt(2) + 1;
        while (!battleEnd && turn<99) {
            if(turn%2 == 0) playerTurn();
            else enemyTurn();
            BattleFrame.addLine("a");
            BattleFrame.updateUI();
            turn++;
        } // TODO
    }

    private static void playerTurn() {// TODO add battle logic (follow requirements)
        // Take input
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    private static void enemyTurn() {
        
    }
}
