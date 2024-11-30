package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.game.character.Enemy;
import com.AlgoArt.utils.Image;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.UI;

public class Info {
    private static boolean closeInfo = false;

    public Info(Enemy enemy) {
        closeInfo = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!closeInfo) {
            // Draw Frame
            UI.standardWindow(enemy.getName(), "back")
                .setWindowString(2, 5, enemy.getDescription())
                .setWindowString(3, 5, "[ p ] Open image of the "+enemy.getName())
                .setWindowString(5, 5, "> Max HP: "+enemy.getMaxHP())
                .setWindowString(6, 5, "> Attacks: "+enemy.getAttack0().getName()+" - "+ enemy.getAttack0().getDescription())
                .setWindowString(7, 5, "           "+enemy.getAttack1().getName()+" - "+ enemy.getAttack1().getDescription())
                .setWindowString(8, 5, "           "+enemy.getAttack2().getName()+" - "+ enemy.getAttack2().getDescription())
                .print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("b")) closeInfo = true;
            else if(input.equals("p")) new Image("enemy", enemy.getName());
            Inputs.checkStandardInputs(input);
        }
    }
}
