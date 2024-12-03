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
    private static Random random = new Random();  //* Random object
    private static Player player = Player.player; //* Static reference to the player
    private static Enemy enemy;                   //* Static reference to the enemy
    private static int turn;                      //* Current turn
    private static boolean battleEnd;             //* Has the battle ended

    /**
     * Initializes a battle with the given enemy
     * @param enemyIn
     */
    public Battle(Enemy enemyIn) {
        enemy = enemyIn;
        battleEnd = false;
        BattleFrame.battle(enemy);
        //* Heal player to full HP
        processTurn(Heal.fullHeal(), player, false);
        //* Turn counter is increased by 1 or 2
        turn = 0 + random.nextInt(2) + 1; // 1 | 2
        //? Battle has not ended and it less than turn 99
        while (!battleEnd && turn<99) {
            //? If the player or enemy have died
            if((player.getHP() <= 0) || (enemy.getHP() <= 0)) { battleEnd(); battleEnd = true; }
            //? If the turn counter is even
            else if(turn%2 == 0) playerTurn();
            else enemyTurn();
            turn++;
        }
    }

    /**
     * Process player turn
     */
    private static void playerTurn() {
        //* Take input
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        String input = "";
        while (!validInput) {
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("0")) { processTurn(player.getAttack0(), player, true); validInput = true; }
            else if(input.equalsIgnoreCase("1")) { processTurn(player.getAttack1(), player, true); validInput = true; }
            else if(input.equalsIgnoreCase("2")) { processTurn(player.getAttack2(), player, true); validInput = true; }
            else if(input.equalsIgnoreCase("3")) { processTurn(player.getHeal0(), player, true); validInput = true; }
            else if(input.equalsIgnoreCase("4")) { processTurn(player.getHeal1(), player, true); validInput = true; }
            else BattleFrame.updateUI();
            Inputs.checkStandardInputs(input);
        }
        input = scanner.nextLine();
        Inputs.checkStandardInputs(input);
    }
    /**
     * Process player turn
     */
    private static void enemyTurn() {
        int attack = random.nextInt(3); // 0 | 1 | 2
        if(attack == 0) processTurn(enemy.getAttack0(), enemy, true);
        else if(attack == 1) processTurn(enemy.getAttack1(), enemy, true);
        else if(attack == 2) processTurn(enemy.getAttack2(), enemy, true);
    }

    /**
     * Process an Action towards a Character
     * @param action
     * @param character
     * @param showText
     */
    private static void processTurn(Action action, Character character, boolean showText) {
        int HPChange = action.getHPChange();
        //* Multi hit
        int multiCounter = 1;
        boolean multiChainEnd = false;
        while(!multiChainEnd) {
            //? Random number > multiChance
            if(action.getMultiChance() >= random.nextInt(100)+1) { HPChange *= 2; multiCounter++; } // 1 - 100 inclusive
            else multiChainEnd = true;
        }
        String multiString = (multiCounter>1)?  "[ "+multiCounter+" times ]":"[ "+multiCounter+" time ]";
        //* Crit
        String critString = "";
        //? Random number > critChance
        if(action.getCritChance() >= random.nextInt(100)+1) { HPChange *= action.getCritMulti(); critString = "[ Critical Hit ] "; } // 1 - 100 inclusive
        // Miss + apply HPChange
        if(showText) {
            //? Random number > missChance
            if(action.getMissChance() >= random.nextInt(100)+1) { 
                HPChange = 0; BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" and misses."); // 1 - 100 inclusive
            } else { 
                //? Action is Heal
                if(action instanceof Heal) {
                    BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" "+multiString+" healing "+HPChange+" HP."); 
                    //? Character is Player
                    if(character instanceof Player) {
                        if(player.getHP()+HPChange >= player.getMaxHP()) player.setHP(player.getMaxHP());
                        else player.setHP(player.getHP()+HPChange);
                    //? Character is Enemy
                    } else if(character instanceof Enemy) {
                        if(enemy.getHP()+HPChange >= enemy.getMaxHP()) enemy.setHP(enemy.getMaxHP());
                        else enemy.setHP(enemy.getHP()+HPChange);
                    }
                //? Action is Attack
                } else if(action instanceof Attack) {
                    BattleFrame.addLine(character.getName()+" - Uses "+action.getName()+" "+critString+multiString+" dealing "+HPChange+" damage."); 
                    //? Character is Player
                    if(character instanceof Player) { enemy.setHP(enemy.getHP()-HPChange); BattleFrame.updateUI(); }
                    //? Character is Enemy
                    else if(character instanceof Enemy) { player.setHP(player.getHP()-HPChange); BattleFrame.updateUI(); }
                }
            }
        }
        BattleFrame.updateUI(); 
    }

    /**
     * Checks who lost the fight
     */
    private void battleEnd() {
        if(player.getHP() <= 0) BattleFrame.playerLost();
        else if(enemy.getHP() <= 0) BattleFrame.enemyLost();
    }
}
