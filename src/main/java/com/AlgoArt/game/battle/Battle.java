package com.AlgoArt.game.battle;

import java.util.Random;
import java.util.Scanner;

import com.AlgoArt.game.characters.Action;
import com.AlgoArt.game.characters.Attack;
import com.AlgoArt.game.characters.Character;
import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.game.characters.player.Player;
import com.AlgoArt.utils.Inputs;

public class Battle {
    private static Random random = new Random();
    private static Player player;
    private static Enemy enemy;
    private static int turn;
    private static boolean battleEnd = false;

    public Battle(Enemy enemyB) {
        player = Player.player;
        enemy = enemyB;
        BattleFrame.battle(enemy);
        turn = 0 + random.nextInt(2) + 1; // 1 | 2
        while (!battleEnd && turn<99) {
            if((player.getHP() <= 0) || (enemy.getHP() <= 0)) battleEnd = true; // TODO add battle end screen
            else if(turn%2 == 0) playerTurn();
            else enemyTurn();
            turn++;
        }
    }

    private static void playerTurn() {
        // Take input
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String input = "";
        while (!validInput) {
            input = scanner.nextLine();
            if(input.equals("0")) { processAttack(player.getAttack0(), player); validInput = true; }
            else if(input.equals("1")) { processAttack(player.getAttack1(), player); validInput = true; }
            else if(input.equals("2")) { processAttack(player.getAttack2(), player); validInput = true; }
            else if(input.equals("3")) { processAction(player.getAction0(), player); validInput = true; }
            else if(input.equals("4")) { processAction(player.getAction1(), player); validInput = true; }
            else BattleFrame.updateUI();
            Inputs.checkStandardInputs(input);
        }
        input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    private static void enemyTurn() {
        int attack = random.nextInt(3); // 0 | 1 | 2
        if(attack == 0) processAttack(enemy.getAttack0(), enemy);
        else if(attack == 1) processAttack(enemy.getAttack1(), enemy);
        else if(attack == 2) processAttack(enemy.getAttack2(), enemy);
    }

    private static void processAttack(Attack attack, Character character) {
        // Base damage
        int damage = attack.getDamage();
        // Crit
        String critString = "";
        int critNumber = random.nextInt(100)+1; // 1 - 100 inclusive
        if(attack.getCritChance() >= critNumber) { damage *= attack.getCritMultiplier(); critString = "[ Critical Hit ] "; }
        // Multi hit
        int multiCounter = 1;
        boolean multiChainEnd = false;
        while(!multiChainEnd) {
            int multiNumber = random.nextInt(100)+1; // 1 - 100 inclusive
            if(attack.getMultipleChance() >= multiNumber) { damage *= 2; multiCounter++; }
            else multiChainEnd = true;
        }
        String multiString = "[ "+multiCounter+" Hits ]";
        // Miss
        int missNumber = random.nextInt(100)+1; // 1 - 100 inclusive
        if(attack.getMissChance() >= missNumber) { damage = 0; BattleFrame.addLine(character.getName()+" - Uses "+attack.getName()+" and misses."); }
        else BattleFrame.addLine(character.getName()+" - Uses "+attack.getName()+" "+critString+multiString+" dealing "+damage+" damage."); 
        // Apply damage
        if(character instanceof Player) { enemy.setHP(enemy.getHP()-damage); BattleFrame.updateUI(); }
        else if(character instanceof Enemy) { player.setHP(player.getHP()-damage); BattleFrame.updateUI(); }
    }

    private static void processAction(Action action, Character character) {
        // Base HPchange
        int HPChange = action.getHPChange();
        // Multi Chance
        int multiCounter = 1;
        boolean multiChainEnd = false;
        while(!multiChainEnd) {
            int multiNumber = random.nextInt(100)+1; // 1 - 100 inclusive
            if(action.getMultipleChance() >= multiNumber) { HPChange *= 2; multiCounter++; }
            else multiChainEnd = true;
        }
        String multiString = "[ "+multiCounter+" Heals ]";
        // backFire
        int missNumber = random.nextInt(100)+1; // 1 - 100 inclusive
        if(action.getBackFire() >= missNumber) { BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" but fails getting hit for"+HPChange+"."); HPChange *= -1; }
        else BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" "+multiString+" healing "+HPChange+"."); 
        // Apply HPChange
        if(character instanceof Player) { 
            if(player.getHP()+HPChange >= player.getMaxHP()) player.setHP(player.getMaxHP());
            else player.setHP(player.getHP()+HPChange); 
            BattleFrame.updateUI(); 
        }
        else if(character instanceof Enemy) { 
            if(enemy.getHP()+HPChange >= enemy.getMaxHP()) enemy.setHP(enemy.getMaxHP());
            else enemy.setHP(enemy.getHP()+HPChange); 
            BattleFrame.updateUI(); 
        }
    }
}
