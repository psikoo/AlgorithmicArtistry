package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.utils.Image;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.UI.Menus;

public class Info {
    private static boolean closeInfo = false; //* Close info


    /**
     * Display information for the given enemy
     * @param enemy
     */
    public Info(Enemy enemy) {
        closeInfo = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        //? Input is not 'b'
        while (!closeInfo) {
            //* Draw Frame
            UI.standardWindow(enemy.getName(), Menus.back)
                .setWindowString(5, 2, enemy.getDescription())
                .setWindowString(5, 3, "[ p ] Open image of the "+enemy.getName())
                .setWindowString(5, 5, "> Max HP: "+enemy.getMaxHP())
                .setWindowString(5, 6, "> Attacks: "+enemy.getAttack0().getName()+" - "+ enemy.getAttack0().getDescription())
                .setWindowString(5, 7, "           "+enemy.getAttack1().getName()+" - "+ enemy.getAttack1().getDescription())
                .setWindowString(5, 8, "           "+enemy.getAttack2().getName()+" - "+ enemy.getAttack2().getDescription())
                .print();
            //* Controls
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("b")) closeInfo = true;
            else if(input.equalsIgnoreCase("p")) new Image("enemy", enemy.getName());
            Inputs.checkStandardInputs(input);
        }
    }
}
