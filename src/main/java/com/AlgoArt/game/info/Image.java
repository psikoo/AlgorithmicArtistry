package com.AlgoArt.game.info;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.AlgoArt.game.characters.enemy.Enemy;

public class Image extends JFrame{
    public Image(Enemy enemy) { //opens img in a new window
        //Setup basic JFrame
        JFrame frame = new JFrame ();
        frame.setTitle(enemy.getName());
        frame.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/AlgoArt.ico")).getImage());
        frame.setSize(500,500);
        frame.setResizable(false);
        JLabel image = new JLabel(new ImageIcon(getClass().getResource("/img/enemy/"+enemy.getName()+".png")));
        image.setIcon(new ImageIcon(getClass().getResource("/img/enemy/"+enemy.getName()+".png")));
        frame.add(image);
        frame.setVisible(true);
    }
}

