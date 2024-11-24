package com.AlgoArt.game.battle;

import com.AlgoArt.game.characters.enemy.Enemy;
import com.AlgoArt.game.characters.player.Player;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;

public class BattleFrame {
    private static Frame frame;
    private static Enemy enemy;
    private static int lines = 0;
    private static int currentLine = 0;

    public static void battle(Enemy enemyB) {
        enemy = enemyB;
        frame = UI.standardWindow(enemy.getName())
            .divider(5)
            .setWindowString(Settings.getHeight()-13, 5, "Press enter to continue...")
            .divider(Settings.getHeight()-12)
            .print();
        updateUI();
        lines = Settings.getHeight()-6-13;
    }

    public static void addLine(String string) {
        if(currentLine == lines) {
            currentLine = 0;
            for(int i = 0; i <= lines; i++) { frame.setWindowEmptyString(6+i, 1, 20); }
        } // TODO
        frame.setWindowString(6+currentLine, 5, string);
        currentLine++;
        updateUI();
    }

    public static void updateUI() {
        frame.setWindowString(2, true, enemy.getName());
        frame.setWindowString(3, true, "HP "+enemy.getHP());
        frame.setWindowString(Settings.getHeight()-10, true, Player.getName());
        frame.setWindowString(Settings.getHeight()-9, true, "HP "+Player.getHP());
        frame.setWindowString(Settings.getHeight()-7, 5, "[ 0 ] "+Player.getAttack0().getName()+" - "+Player.getAttack0().getDescription());
        frame.setWindowString(Settings.getHeight()-6, 5, "[ 1 ] "+Player.getAttack1().getName()+" - "+Player.getAttack1().getDescription());
        frame.setWindowString(Settings.getHeight()-5, 5, "[ 2 ] "+Player.getAttack2().getName()+" - "+Player.getAttack2().getDescription());
        frame.setWindowString(Settings.getHeight()-4, 5, "[ 3 ] "+Player.getAction0().getName()+" - "+Player.getAction0().getDescription());
        frame.setWindowString(Settings.getHeight()-3, 5, "[ 4 ] "+Player.getAction1().getName()+" - "+Player.getAction1().getDescription());
        frame.print();
    }
}
