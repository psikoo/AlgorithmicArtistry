package com.AlgoArt.game.battle;

import java.util.Random;
import java.util.Scanner;

import com.AlgoArt.game.character.Heal;
import com.AlgoArt.game.character.Action;
import com.AlgoArt.game.character.Attack;
import com.AlgoArt.game.character.Character;
import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.game.character.Player;
import com.AlgoArt.utils.Inputs;

public class Battle {
    private static Random random = new Random();
    private static Player player;
    private static Enemy enemy;
    private static int turn;
    private static boolean battleEnd;

    public Battle(Enemy enemyB) {
        player = Player.player;
        enemy = enemyB;
        battleEnd = false;
        BattleFrame.battle(enemy);
        processTurn(Heal.fullHeal(), player, false);
        turn = 0 + random.nextInt(2) + 1; // 1 | 2
        while (!battleEnd && turn<99) {
            if((player.getHP() <= 0) || (enemy.getHP() <= 0)) { battleEnd(); battleEnd = true; }
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
            if(input.equals("0")) { processTurn(player.getAttack0(), player, true); validInput = true; }
            else if(input.equals("1")) { processTurn(player.getAttack1(), player, true); validInput = true; }
            else if(input.equals("2")) { processTurn(player.getAttack2(), player, true); validInput = true; }
            else if(input.equals("3")) { processTurn(player.getAction0(), player, true); validInput = true; }
            else if(input.equals("4")) { processTurn(player.getAction1(), player, true); validInput = true; }
            else BattleFrame.updateUI();
            Inputs.checkStandardInputs(input);
        }
        input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    private static void enemyTurn() {
        int attack = random.nextInt(3); // 0 | 1 | 2
        if(attack == 0) processTurn(enemy.getAttack0(), enemy, true);
        else if(attack == 1) processTurn(enemy.getAttack1(), enemy, true);
        else if(attack == 2) processTurn(enemy.getAttack2(), enemy, true);
    }

    private static void processTurn(Action action, Character character, boolean showText) {
        int HPChange = action.getHPChange();
        // Multi hit
        int multiCounter = 1;
        boolean multiChainEnd = false;
        while(!multiChainEnd) {
            if(action.getMultiChance() >= random.nextInt(100)+1) { HPChange *= 2; multiCounter++; } // 1 - 100 inclusive
            else multiChainEnd = true;
        }
        String multiString = (multiCounter>1)?  "[ "+multiCounter+" times ]":"[ "+multiCounter+" time ]";
        // Crit
        String critString = "";
        if(action.getCritChance() >= random.nextInt(100)+1) { HPChange *= action.getCritMulti(); critString = "[ Critical Hit ] "; } // 1 - 100 inclusive
        // Miss + apply HPChange
        if(showText) {
            if(action.getMissChance() >= random.nextInt(100)+1) { 
                HPChange = 0; BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" and misses."); // 1 - 100 inclusive
            } else { 
                if(action instanceof Heal) {
                    BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" "+multiString+" healing "+HPChange+" HP."); 
                    if(character instanceof Player)  {
                        if(player.getHP()+HPChange >= player.getMaxHP()) player.setHP(player.getMaxHP());
                        else player.setHP(player.getHP()+HPChange);
                    } else if(character instanceof Enemy) {
                        if(enemy.getHP()+HPChange >= enemy.getMaxHP()) enemy.setHP(enemy.getMaxHP());
                        else enemy.setHP(enemy.getHP()+HPChange);
                    }
                } else if(action instanceof Attack) {
                    BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" "+critString+multiString+" dealing "+HPChange+" damage."); 
                    if(character instanceof Player) { enemy.setHP(enemy.getHP()-HPChange); BattleFrame.updateUI(); }
                    else if(character instanceof Enemy) { player.setHP(player.getHP()-HPChange); BattleFrame.updateUI(); }
                }
            }
        }
        BattleFrame.updateUI(); 
    }

    private void battleEnd() {
        if(player.getHP() <= 0) BattleFrame.playerLost();
        else if(enemy.getHP() <= 0) BattleFrame.enemyLost();
    }
}
